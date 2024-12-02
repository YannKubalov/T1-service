package org.t1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.t1.data.PaymentRequestDto;
import org.t1.data.ProductResponseDto;
import org.t1.service.PaymentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Operation(summary = "Получить все продукты", description = "Возвращает список всех продуктов пользователя.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Продукты успешно получены"),
            @ApiResponse(responseCode = "404", description = "Информация по объекту не найдена")
    })
    @PostMapping("/getAllProducts")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(@RequestBody Long id) {
        List<ProductResponseDto> products = paymentService.getAllProducts(id);
        if (products.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Обработка платежа", description = "Обрабатывает платеж")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Платеж успешно прошел"),
            @ApiResponse(responseCode = "404", description = "Не найден платеж либо не хватает средств")
    })
    @PostMapping
    public ResponseEntity<String> makePayment(@RequestBody PaymentRequestDto request) {
        try {
            paymentService.processPayment(request);
            return ResponseEntity.ok("Платеж успешно прошел");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
