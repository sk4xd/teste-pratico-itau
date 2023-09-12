package com.pratico.transacaofinanceira.domain.repository;

import com.pratico.transacaofinanceira.infrastructure.persistence.ContasSaldosTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

public interface ContasSaldosRepository extends JpaRepository<ContasSaldosTable, Long> {

    ContasSaldosTable findByConta(Long conta);

    @Modifying
    @Transactional
    @Query("update ContasSaldosTable c set c.saldo = :saldo where c.conta = :conta")
    void updateSaldoByConta(Long conta, BigDecimal saldo);

}
