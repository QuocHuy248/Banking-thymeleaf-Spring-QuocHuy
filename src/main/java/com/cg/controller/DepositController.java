package com.cg.controller;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.service.customer.CustomerServiceImpl;
import com.cg.service.customer.ICustomerService;
import com.cg.service.deposit.DepositService;
import com.cg.service.deposit.IDepositService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deposit")
public class DepositController {
    private ICustomerService customerService = new CustomerServiceImpl();
    private IDepositService depositService = new DepositService();

    @GetMapping("/create/{id}")
    public String showDeposit(Model model, @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("deposit", new Deposit(customer));
        return "deposit/create";
    }
    @PostMapping("/create/{id}")
    public String deposit(Model model, @PathVariable Long id, @ModelAttribute Deposit deposit) {
        Customer customer = customerService.findById(id);
        deposit.setCustomer(customer);
        depositService.create(deposit);
        model.addAttribute("deposit", new Deposit(customer));
        model.addAttribute("success", true);
        model.addAttribute("message", "Deposit successfully");
        return "deposit/create";
    }
}
