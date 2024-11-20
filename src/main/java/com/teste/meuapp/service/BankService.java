package com.teste.meuapp.service;

import com.teste.meuapp.model.Bank;
import com.teste.meuapp.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public Bank createBank(String name, String code) {
        Bank bank = new Bank(name, code);
        return bankRepository.save(bank);
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public Bank getBankByCode(String code) {
        Bank bank = bankRepository.findByCode(code);
        if (bank == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Banco não encontrado!");
        }
        return bank;
    }

    public Bank updateBank(UUID id, String name, String code) {
        Bank bank = bankRepository.findById(id).orElseThrow(() -> new RuntimeException("Banco não encontrado!"));
        bank.setName(name);
        bank.setCode(code);
        return bankRepository.save(bank);
    }

    public void deleteBank(UUID id) {
        bankRepository.deleteById(id);
    }
}
