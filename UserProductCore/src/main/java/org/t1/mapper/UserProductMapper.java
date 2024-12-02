package org.t1.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.t1.data.UserProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProductMapper implements RowMapper<UserProduct> {

    @Override
    public UserProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        var userProduct = new UserProduct();
        userProduct.setId(rs.getLong("id"));
        userProduct.setAccountNumber(rs.getString("account_number"));
        userProduct.setBalance(rs.getBigDecimal("balance"));
        userProduct.setProductType(rs.getString("product_type"));
        userProduct.setUserId(rs.getLong("user_id"));
        return userProduct;
    }
}
