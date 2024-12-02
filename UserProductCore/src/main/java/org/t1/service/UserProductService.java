package org.t1.service;

import org.t1.data.UserProduct;

import java.math.BigDecimal;
import java.util.List;

public interface UserProductService {

    List<UserProduct> getAllProducts(Long userId);
    UserProduct getProductById(Long id);
    UserProduct processPayment(String accountNumber,BigDecimal newBalance);
}
