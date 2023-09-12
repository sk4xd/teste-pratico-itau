package com.pratico.transacaofinanceira.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TABELA_SALDOS")
public class ContasSaldosTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conta")
    private Long conta;

    @Column(name = "saldo")
    private BigDecimal saldo;
}
