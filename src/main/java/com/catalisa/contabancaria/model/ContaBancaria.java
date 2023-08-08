package com.catalisa.contabancaria.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroConta;

    @Column(nullable = false)
    private String agencia;

    @Column
    private String nomeUsuario;

    @Column(nullable = false)
    private BigDecimal valorAtual;

    @Column(nullable = false)
    private BigDecimal valorFinal;

    @Column
    private BigDecimal valorTransacao; // Valor para saque ou depósito

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico; // Saque ou depósito

}
