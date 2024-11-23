package com.teste.meuapp.repository;

import com.teste.meuapp.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface AgencyRepository extends JpaRepository<Agency, UUID> {

    Agency findByCode(String code);

    List<Agency> findByBankId(UUID bankId);
}

