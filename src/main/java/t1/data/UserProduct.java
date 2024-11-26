package t1.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserProduct {

    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private String productType;

}
