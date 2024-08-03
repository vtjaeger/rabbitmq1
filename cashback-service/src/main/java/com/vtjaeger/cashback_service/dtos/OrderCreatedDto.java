package com.vtjaeger.cashback_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedDto {
    private Long id;
    private BigDecimal value = BigDecimal.ZERO;
}
