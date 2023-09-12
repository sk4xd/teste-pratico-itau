package com.pratico.transacaofinanceira.domain.service;

import com.pratico.transacaofinanceira.domain.mapper.ContasSaldosMapper;
import com.pratico.transacaofinanceira.domain.model.ContaSaldoModel;
import com.pratico.transacaofinanceira.domain.repository.ContasSaldosRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;


@SpringBootTest
public class TransferirSaldoUseCaseTest {

    @Autowired
    private TransferirSaldoUseCase transferirSaldoUseCase;

    @Autowired
    private ContasSaldosMapper contasSaldosMapper;

    @Autowired
    private ContasSaldosRepository contasSaldosRepository = mock(ContasSaldosRepository.class);

    @Test
    public void deveRealizarTransferenciasSemErro() {
        transferirSaldoUseCase.transferencia();
    }
}
