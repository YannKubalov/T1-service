package t1.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import t1.data.UserProduct;

import java.util.List;

import t1.mapper.UserProductMapper;

@Repository
public class UserProductDao {

    private final JdbcTemplate jdbcTemplate;

    public UserProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserProduct> getAllProductsByUserId(Long userId) {
        String sql = "SELECT * FROM user_products WHERE user_id = ?";
        return jdbcTemplate.query(sql, new UserProductMapper(), userId);
    }

    public UserProduct getProductById(Long id) {
        String sql = "SELECT * FROM user_products WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UserProductMapper(), id);
    }
}
