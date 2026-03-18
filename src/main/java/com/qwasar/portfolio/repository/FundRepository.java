package com.qwasar.portfolio.repository;

import com.qwasar.portfolio.model.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<Fund, Integer> {
}