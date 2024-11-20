package com.teste.meuapp.controller;

import com.teste.meuapp.model.Bank;
import com.teste.meuapp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping
    public Bank createBank(@RequestBody Bank bank) {
        return bankService.createBank(bank.getName(), bank.getCode());
    }

    @GetMapping
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    @GetMapping("/{code}")
    public Bank getBankByCode(@PathVariable String code) {
        return bankService.getBankByCode(code);
    }

    @PutMapping("/{id}")
    public Bank updateBank(@PathVariable UUID id, @RequestBody Bank bank) {
        return bankService.updateBank(id, bank.getName(), bank.getCode());
    }

    @DeleteMapping("/{id}")
    public void deleteBank(@PathVariable UUID id) {
        bankService.deleteBank(id);
    }

}
