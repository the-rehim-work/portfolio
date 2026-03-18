package com.qwasar.portfolio.repository;

import com.qwasar.portfolio.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Integer> {
}