package com.catalisa.contabancaria.controller;

import com.catalisa.contabancaria.dto.ContaBancariaDTO;
import com.catalisa.contabancaria.model.TipoServico;
import com.catalisa.contabancaria.service.ContaBancariaService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaBancariaController {

    private final ContaBancariaService service;

    public ContaBancariaController(ContaBancariaService contaBancariaService) {
        this.service = contaBancariaService;
    }

    @GetMapping
    public ResponseEntity<List<ContaBancariaDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ContaBancariaDTO>> getContaById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getContaById(id));
    }

    @PostMapping
    public ResponseEntity<ContaBancariaDTO> createConta(@Validated @RequestBody ContaBancariaDTO contaDTO) {
        return new ResponseEntity<>(service.createConta(contaDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long id) {
        service.deleteConta(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/deposito")
    public ResponseEntity<ContaBancariaDTO> depositar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return ResponseEntity.ok(service.updateValor(id, valor, TipoServico.DEPOSITO));
    }

    @PutMapping("/{id}/saque")
    public ResponseEntity<ContaBancariaDTO> sacar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return ResponseEntity.ok(service.updateValor(id, valor, TipoServico.SAQUE));
    }

    @ExceptionHandler(ContaBancariaService.NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(ContaBancariaService.@NotNull NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
