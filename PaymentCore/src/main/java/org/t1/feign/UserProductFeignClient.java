package org.t1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.t1.data.ProductResponseDto;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "user-product-service", url = "http://localhost:8080")
public interface UserProductFeignClient {

    @GetMapping("/user/{id}/getAllProducts")
    List<ProductResponseDto> getProductsByUserId(@PathVariable("id") Long id);

    @PostMapping("/product/processPayment")
    void processPayment(@RequestParam("accountNumber") String accountNumber, @RequestBody BigDecimal newBalance);

}
