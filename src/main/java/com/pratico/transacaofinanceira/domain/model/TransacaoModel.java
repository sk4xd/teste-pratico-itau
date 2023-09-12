package com.pratico.transacaofinanceira.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class TransacaoModel {
    private Long id;
    private String correlation_id;
    private LocalDateTime datetime;
    private Long conta_origem;
    private Long conta_destino;
    private BigDecimal valor;
}
