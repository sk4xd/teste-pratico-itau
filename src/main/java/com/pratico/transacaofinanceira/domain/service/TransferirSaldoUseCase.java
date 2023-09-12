package com.pratico.transacaofinanceira.domain.service;

import com.pratico.transacaofinanceira.domain.mapper.ContasSaldosMapper;
import com.pratico.transacaofinanceira.domain.model.ContaSaldoModel;
import com.pratico.transacaofinanceira.domain.model.TransacaoModel;
import com.pratico.transacaofinanceira.domain.repository.ContasSaldosRepository;
import com.pratico.transacaofinanceira.infrastructure.persistence.ContasSaldosTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransferirSaldoUseCase {

    private final ContasSaldosRepository contasSaldosRepository;

    private final ContasSaldosMapper contasSaldosMapper;

    private final static String SUM = "SUM";

    private final static String SUB = "SUB";

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferirSaldoUseCase.class);

    @Autowired
    public TransferirSaldoUseCase (ContasSaldosRepository contasSaldosRepository, ContasSaldosMapper contasSaldosMapper) {
        this.contasSaldosRepository = contasSaldosRepository;
        this.contasSaldosMapper = contasSaldosMapper;
    }

    public void transferir(TransacaoModel transacao)
    {
        ContaSaldoModel conta_saldo_origem = contasSaldosMapper.toContaSaldoModel(contasSaldosRepository.findByConta(transacao.getConta_origem()));
        if (conta_saldo_origem.getSaldo().compareTo(transacao.getValor()) <= 0)
        {
            LOGGER.info("Transacao numero " + transacao.getCorrelation_id() +" foi cancelada por falta de saldo");
        }
        else
        {
            ContaSaldoModel conta_saldo_destino = contasSaldosMapper.toContaSaldoModel(contasSaldosRepository.findByConta(transacao.getConta_destino()));
            atualizaSaldoConta(conta_saldo_origem, transacao.getValor(), SUB, transacao.getCorrelation_id());
            atualizaSaldoConta(conta_saldo_destino, transacao.getValor(), SUM, transacao.getCorrelation_id());
            LOGGER.info("Transacao numero " +  transacao.getCorrelation_id() + " foi efetivada com sucesso! Novos saldos: Conta Origem: " + transacao.getConta_origem() +" Saldo: " + conta_saldo_origem.getSaldo().subtract(transacao.getValor()) +  " | Conta Destino: "+ transacao.getConta_destino() + " Saldo: " + conta_saldo_destino.getSaldo().add(transacao.getValor()));
        }
    }

    private void atualizaSaldoConta(ContaSaldoModel conta, BigDecimal valor, String operacao, String correlation_id) {
        switch (operacao){
            case SUB -> contasSaldosRepository.updateSaldoByConta(conta.getConta(), conta.getSaldo().subtract(valor));
            case SUM -> contasSaldosRepository.updateSaldoByConta(conta.getConta(), conta.getSaldo().add(valor));
        }
    }

    public void transferencia() {
        List<TransacaoModel> TRANSACOES = new ArrayList<>();
        TRANSACOES.add(new TransacaoModel(null, "1", LocalDateTime.now().plusHours(1), 2147483649L, 210385733L, BigDecimal.valueOf(149)));
        TRANSACOES.add(new TransacaoModel(null, "2", LocalDateTime.now().plusHours(2), 347586970L, 238596054L, BigDecimal.valueOf(1100)));
        TRANSACOES.add(new TransacaoModel(null, "3", LocalDateTime.now().plusHours(3), 675869708L, 210385733L, BigDecimal.valueOf(5300)));
        TRANSACOES.add(new TransacaoModel(null, "4", LocalDateTime.now().plusHours(4), 238596054L, 674038564L, BigDecimal.valueOf(1489)));
        TRANSACOES.add(new TransacaoModel(null, "5", LocalDateTime.now().plusHours(5), 573659065L, 563856300L, BigDecimal.valueOf(49)));
        TRANSACOES.add(new TransacaoModel(null, "6", LocalDateTime.now().plusHours(6), 938485762L, 2147483649L, BigDecimal.valueOf(44)));
        TRANSACOES.add(new TransacaoModel(null, "7", LocalDateTime.now().plusHours(7), 573659065L, 675869708L, BigDecimal.valueOf(150)));

        TRANSACOES.parallelStream().forEach(item -> {
            transferir(item);
        });
    }
}
