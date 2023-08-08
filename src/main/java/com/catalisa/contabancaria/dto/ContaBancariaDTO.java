package com.catalisa.contabancaria.dto;

import com.catalisa.contabancaria.model.ContaBancaria;
import com.catalisa.contabancaria.model.TipoServico;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public record ContaBancariaDTO(
        Long id,
        String numeroConta,
        String agencia,
        String nomeUsuario,
        BigDecimal valorAtual,
        BigDecimal valorFinal,
        BigDecimal valorTransacao,
        TipoServico tipoServico
)
implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public ContaBancariaDTO(@NotNull ContaBancaria contaBancaria) {
        this(contaBancaria.getId(),
                contaBancaria.getNumeroConta(),
                contaBancaria.getAgencia(),
                contaBancaria.getNomeUsuario(),
                contaBancaria.getValorAtual(),
                contaBancaria.getValorFinal(),
                contaBancaria.getValorTransacao(),
                contaBancaria.getTipoServico()
        );
    }

    @Contract(" -> new")
    public @NotNull ContaBancaria toContaBancaria() {
        return new ContaBancaria(
                id,
                numeroConta,
                agencia,
                nomeUsuario,
                valorAtual,
                valorFinal,
                valorTransacao,
                tipoServico);
    }
}
