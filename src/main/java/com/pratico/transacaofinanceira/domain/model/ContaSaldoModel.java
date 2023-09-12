package com.pratico.transacaofinanceira.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ContaSaldoModel {
    private Long conta;
    private BigDecimal saldo;
}
