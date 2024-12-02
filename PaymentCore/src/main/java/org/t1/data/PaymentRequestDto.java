package org.t1.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequestDto {
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("accountNumber")
    private String accountNumber;
}
