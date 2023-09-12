package com.pratico.transacaofinanceira.domain.repository;

import com.pratico.transacaofinanceira.infrastructure.persistence.TransacoesTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacoesRepository extends JpaRepository<TransacoesTable, Long> {
}
