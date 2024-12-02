package org.t1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.t1.data.UserProduct;
import org.t1.repository.UserProductDao;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProductServiceImpl implements UserProductService{

    private final UserProductDao userProductDao;

    @Override
    public List<UserProduct> getAllProducts(Long userId) {
        return userProductDao.getAllProductsByUserId(userId);
    }

    @Override
    public UserProduct getProductById(Long id) {
        return userProductDao.getProductById(id);
    }

    @Override
    public UserProduct processPayment(String accountNumber, BigDecimal newBalance) {;
        userProductDao.updateBalanceByAccountNumber(accountNumber, newBalance);
        return userProductDao.getProductByAccountNumber(accountNumber);
    }
}
