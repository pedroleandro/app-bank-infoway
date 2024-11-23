package com.teste.meuapp.service;

import com.teste.meuapp.model.Agency;
import com.teste.meuapp.model.Bank;
import com.teste.meuapp.repository.AgencyRepository;
import com.teste.meuapp.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private BankRepository bankRepository;

    public Agency createAgency(String code, String name, String address, UUID bankId) {

        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Banco não encontrado"));

        Agency agency = new Agency(code, name, address, bank);
        return agencyRepository.save(agency);
    }

    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }

    public List<Agency> getAgenciesByBank(UUID bankId) {
        return agencyRepository.findByBankId(bankId);
    }

    public Agency getAgencyById(UUID id) {
        return agencyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agência não encontrada"));
    }

    public Agency updateAgency(UUID id, String code, String name, String address) {
        Agency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agência não encontrada"));

        agency.setCode(code);
        agency.setName(name);
        agency.setAddress(address);
        return agencyRepository.save(agency);
    }

    public void deleteAgency(UUID id) {
        Agency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agência não encontrada"));
        agencyRepository.delete(agency);
    }
}

