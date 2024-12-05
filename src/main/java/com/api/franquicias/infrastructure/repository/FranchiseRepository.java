package com.api.franquicias.infrastructure.repository;

import com.api.franquicias.domain.entity.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Long> { }
