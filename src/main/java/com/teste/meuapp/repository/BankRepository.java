package com.teste.meuapp.repository;

import com.teste.meuapp.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {
    Bank findByCode(String code);
}
