package t1.service;

import t1.data.UserProduct;

import java.util.List;

public interface UserProductService {

    List<UserProduct> getAllProducts(Long userId);
    UserProduct getProductById(Long id);
}
