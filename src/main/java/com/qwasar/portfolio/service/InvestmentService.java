package com.qwasar.portfolio.service;

import com.qwasar.portfolio.model.Investment;
import com.qwasar.portfolio.model.Fund;
import com.qwasar.portfolio.repository.InvestmentRepository;
import com.qwasar.portfolio.repository.FundRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final FundRepository fundRepository;

    public InvestmentService(InvestmentRepository investmentRepository, FundRepository fundRepository) {
        this.investmentRepository = investmentRepository;
        this.fundRepository = fundRepository;
    }

    public List<Investment> getAll(String sort) {
        if (sort == null) return investmentRepository.findAll();
        return switch (sort) {
            case "amount_asc" -> investmentRepository.findAll(Sort.by(Sort.Direction.ASC, "amount"));
            case "amount_desc" -> investmentRepository.findAll(Sort.by(Sort.Direction.DESC, "amount"));
            case "name_asc" -> investmentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
            case "name_desc" -> investmentRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
            default -> investmentRepository.findAll();
        };
    }

    public Investment getById(int id) {
        return investmentRepository.findById(id).orElse(null);
    }

    public void create(String name, int amount) {
        Investment inv = new Investment();
        inv.setName(name);
        inv.setAmount(amount);
        inv.setCreatedAt(LocalDateTime.now());
        investmentRepository.save(inv);
    }

    public void updateName(int id, String name) {
        Investment inv = getById(id);
        if (inv == null) return;
        inv.setName(name);
        investmentRepository.save(inv);
    }

    public void addFund(int amount) {
        Fund fund = new Fund();
        fund.setAmount(amount);
        fund.setCreatedAt(LocalDateTime.now());
        fundRepository.save(fund);
    }

    public int getRemaining() {
        int invested = investmentRepository.findAll().stream().mapToInt(Investment::getAmount).sum();
        int added = fundRepository.findAll().stream().mapToInt(Fund::getAmount).sum();
        return 10_000_000 + added - invested;
    }
}