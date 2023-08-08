package com.catalisa.contabancaria.service;

import com.catalisa.contabancaria.dto.ContaBancariaDTO;
import com.catalisa.contabancaria.model.ContaBancaria;
import com.catalisa.contabancaria.model.TipoServico;
import com.catalisa.contabancaria.repository.ContaBancariaRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaBancariaService {

    private final ContaBancariaRepository repository;

    public ContaBancariaService(ContaBancariaRepository contaBancariaRepository) {
        this.repository = contaBancariaRepository;
    }

    public List<ContaBancariaDTO> getAll() {
        return repository.findAll().stream()
                .map(ContaBancariaDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<ContaBancariaDTO> getContaById(Long id) {
        return repository.findById(id).map(ContaBancariaDTO::new);
    }

    public ContaBancariaDTO createConta(@NotNull ContaBancariaDTO contaDTO) {
        ContaBancaria savedContaBancaria = repository.save(contaDTO.toContaBancaria());
        return new ContaBancariaDTO(savedContaBancaria);
    }

    public ContaBancariaDTO updateValor(Long id, BigDecimal valor, TipoServico tipoServico) {
        if (repository.findById(id).isPresent()) {
            ContaBancaria conta = repository.findById(id).get();
            switch (tipoServico) {
                case SAQUE, DEPOSITO -> {
                    conta.setValorAtual(valor);
                    ContaBancaria contaAtualizada = repository.save(conta);
                    return new ContaBancariaDTO(contaAtualizada);
                }
            }
        }
        return null;
    }

    public void deleteConta(Long id) {
        if (!repository.existsById(id)) throw new NotFoundException("Conta não encontrada");
        repository.deleteById(id);
    }

    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }
}
