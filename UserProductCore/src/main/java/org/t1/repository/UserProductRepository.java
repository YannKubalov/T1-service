package org.t1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.t1.data.UserProduct;
import java.util.List;

@Repository
public interface UserProductRepository extends JpaRepository<UserProduct, Long> {

    List<UserProduct> findAllByUserId(Long userId);

    UserProduct findByAccountNumber(String accountNumber);
}

