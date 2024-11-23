package com.teste.meuapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    private String address;

    @JsonBackReference // Garante que o banco não será serializado dentro da agência
    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    public Agency() {
    }

    public Agency(String code, String name, String address, Bank bank) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.bank = bank;
    }
}
