package com.teste.meuapp.controller;

import com.teste.meuapp.model.Agency;
import com.teste.meuapp.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/agencies")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @PostMapping
    public Agency createAgency(@RequestBody Agency agency) {
        return agencyService.createAgency(agency.getCode(), agency.getName(), agency.getAddress(), agency.getBank().getId());
    }

    @GetMapping
    public List<Agency> getAllAgencies() {
        return agencyService.getAllAgencies();
    }

    @GetMapping("/bank/{bankId}")
    public List<Agency> getAgenciesByBank(@PathVariable UUID bankId) {
        return agencyService.getAgenciesByBank(bankId);
    }

    @GetMapping("/{id}")
    public Agency getAgencyById(@PathVariable UUID id) {
        return agencyService.getAgencyById(id);
    }

    @PutMapping("/{id}")
    public Agency updateAgency(@PathVariable UUID id, @RequestBody Agency agency) {
        return agencyService.updateAgency(id, agency.getCode(), agency.getName(), agency.getAddress());
    }

    @DeleteMapping("/{id}")
    public void deleteAgency(@PathVariable UUID id) {
        agencyService.deleteAgency(id);
    }
}

