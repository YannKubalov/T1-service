package org.t1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.t1.data.UserProduct;
import org.t1.repository.UserProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProductServiceImpl implements UserProductService{

    private final UserProductRepository userProductRepository;

    @Override
    public List<UserProduct> getAllProducts(Long userId) {
        return userProductRepository.findAllByUserId(userId);
    }

    @Override
    public UserProduct getProductById(Long id) {
        return userProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Продукт не найден"));
    }

    @Override
    public UserProduct processPayment(String accountNumber, BigDecimal newBalance) {;
        var product = userProductRepository.findByAccountNumber(accountNumber);
        product.setBalance(newBalance);
        userProductRepository.save(product);
        return product;
    }
}
