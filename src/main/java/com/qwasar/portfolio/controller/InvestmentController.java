package com.qwasar.portfolio.controller;

import com.qwasar.portfolio.service.InvestmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InvestmentController {

    private final InvestmentService service;

    public InvestmentController(InvestmentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(@RequestParam(required = false) String sort, Model model) {
        model.addAttribute("investments", service.getAll(sort));
        model.addAttribute("remaining", service.getRemaining());
        model.addAttribute("sort", sort);
        return "home";
    }

    @GetMapping("/investment/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("investment", service.getById(id));
        return "detail";
    }

    @PostMapping("/investment/create")
    public String create(@RequestParam String name, @RequestParam int amount) {
        service.create(name, amount);
        return "redirect:/?newInvestment=true";
    }

    @PostMapping("/investment/{id}/update")
    public String updateName(@PathVariable int id, @RequestParam String name) {
        service.updateName(id, name);
        return "redirect:/investment/" + id;
    }

    @PostMapping("/fund/add")
    public String addFund(@RequestParam int amount) {
        service.addFund(amount);
        return "redirect:/";
    }
}