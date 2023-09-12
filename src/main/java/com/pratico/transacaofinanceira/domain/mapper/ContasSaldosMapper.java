package com.pratico.transacaofinanceira.domain.mapper;

import com.pratico.transacaofinanceira.domain.model.ContaSaldoModel;
import com.pratico.transacaofinanceira.infrastructure.persistence.ContasSaldosTable;
import org.springframework.stereotype.Component;

@Component
public class ContasSaldosMapper {

    public ContaSaldoModel toContaSaldoModel(ContasSaldosTable contasSaldosTable) {
        return ContaSaldoModel.builder()
                .conta(contasSaldosTable.getConta())
                .saldo(contasSaldosTable.getSaldo())
                .build();
    }
}
