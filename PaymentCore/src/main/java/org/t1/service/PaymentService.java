package org.t1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.t1.data.PaymentRequestDto;
import org.t1.data.ProductResponseDto;
import org.t1.feign.UserProductFeignClient;

import java.util.List;

@Service
public class PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
    @Autowired
    private UserProductFeignClient productFeignClient;


    public List<ProductResponseDto> getAllProducts(Long id) {
        return productFeignClient.getProductsByUserId(id);
    }

    public void processPayment(PaymentRequestDto paymentRequest){
        var productList = productFeignClient.getProductsByUserId(paymentRequest.getUserId());
        log.info("Полученный список продуктов {}", productList);
        var userProductOpt = productList.stream()
                .filter(product -> paymentRequest.getAccountNumber().equals(product.getAccountNumber()))
                .findFirst();
        if(userProductOpt.isEmpty()){
            throw new IllegalArgumentException("У пользователя нет такого продукта");
        }
        var userProduct = userProductOpt.get();
        if(userProduct.getBalance().compareTo(paymentRequest.getAmount()) < 0){
            throw new IllegalArgumentException("У пользователя не хватает средств на этом продукте");
        }
        var newBalance = userProduct.getBalance().subtract(paymentRequest.getAmount());
        log.info("Изменение баланса");
        productFeignClient.processPayment(paymentRequest.getAccountNumber(), newBalance);
    }


}

