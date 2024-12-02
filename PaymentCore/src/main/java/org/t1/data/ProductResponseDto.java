package org.t1.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseDto {

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("balance")
    private BigDecimal balance;
}
