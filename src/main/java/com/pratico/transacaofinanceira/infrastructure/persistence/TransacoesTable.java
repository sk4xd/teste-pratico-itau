package com.pratico.transacaofinanceira.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRANSACOES")
public class TransacoesTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "correlation_id")
    private String correlation_id;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @Column(name = "conta_origem")
    private Long conta_origem;

    @Column(name = "conta_destino")
    private Long conta_destino;

    @Column(name = "valor")
    private BigDecimal valor;
}
