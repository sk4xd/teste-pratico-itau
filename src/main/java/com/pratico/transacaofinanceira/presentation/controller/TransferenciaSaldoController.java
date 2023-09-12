package com.pratico.transacaofinanceira.presentation.controller;

import com.pratico.transacaofinanceira.domain.service.TransferirSaldoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaSaldoController {

    @Autowired
    private TransferirSaldoUseCase transferirSaldoUseCase;

    @GetMapping
    public ResponseEntity<Void> transferencia() {

        transferirSaldoUseCase.transferencia();

        return ResponseEntity.ok().build();
    }
}
