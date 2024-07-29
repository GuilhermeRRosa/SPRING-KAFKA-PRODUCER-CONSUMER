package gg.code.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;

}
