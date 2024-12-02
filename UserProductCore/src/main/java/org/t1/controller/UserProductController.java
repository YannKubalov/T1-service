package org.t1.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.t1.data.PaymentRequestDto;
import org.t1.data.UserProduct;
import org.t1.service.UserProductService;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class UserProductController {

    private final UserProductService userProductService;

    public UserProductController(UserProductService userProductService) {
        this.userProductService = userProductService;
    }

    @Operation(summary = "Получение всех продуктов пользователя", description = "Возвращает все продукты, которые есть у пользовтаеля")
    @GetMapping("/user/{id}/getAllProducts")
    public ResponseEntity<List<UserProduct>> getAllProducts(@PathVariable(value = "id") Long id) {
        List<UserProduct> products = userProductService.getAllProducts(id);
        if (products.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(products);
    }
    @Operation(summary = "Получение продукта по ID", description = "Возвращает продукт")
    @GetMapping("/product/getProduct")
    public ResponseEntity<UserProduct> getProductById(@RequestParam Long id) {
        UserProduct product = userProductService.getProductById(id);
        if (product == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(product);
    }
    @Operation(summary = "Обработка платежа", description = "Изменяет баланс у определенного продукта")
    @PostMapping("/product/processPayment")
    public ResponseEntity<UserProduct> processPayment(@RequestParam("accountNumber") String accountNumber, @RequestBody BigDecimal newBalance) {
        var userProduct = userProductService.processPayment(accountNumber,newBalance);
        if (userProduct == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(userProduct);
    }
}
