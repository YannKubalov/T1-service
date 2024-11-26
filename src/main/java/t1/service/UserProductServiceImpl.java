package t1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import t1.data.UserProduct;
import t1.repository.UserProductDao;

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
}
