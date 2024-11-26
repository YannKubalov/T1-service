package t1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t1.data.UserProduct;
import t1.service.UserProductService;

import java.util.List;

@RestController
public class UserProductController {

    private final UserProductService userProductService;

    public UserProductController(UserProductService userProductService) {
        this.userProductService = userProductService;
    }

    @GetMapping("/user/{id}/getAllProducts")
    public ResponseEntity<List<UserProduct>> getAllProducts(@PathVariable Long id) {
        List<UserProduct> products = userProductService.getAllProducts(id);
        if (products.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/getProduct")
    public ResponseEntity<UserProduct> getProductById(@RequestParam Long id) {
        UserProduct product = userProductService.getProductById(id);
        if (product == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(product);
    }
}
