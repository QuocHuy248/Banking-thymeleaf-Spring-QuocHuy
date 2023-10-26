package com.cg.service.withdraw;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Withdraw;
import com.cg.service.IGeneralService;
import com.cg.service.customer.CustomerServiceImpl;
import com.cg.service.customer.ICustomerService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WithdrawService implements IWithdrawService {
    private static final List<Withdraw> withdraws = new ArrayList<>();
    private static long id = 1L;
    private ICustomerService customerService = new CustomerServiceImpl();


    @Override
    public List<Withdraw> findAll() {
        return null;
    }

    @Override
    public List<Withdraw> findAllExceptSender(Long aLong) {
        return null;
    }

    @Override
    public Withdraw findById(Long aLong) {
        return null;
    }

    @Override
    public void create(Withdraw withdraw) {
        Customer customer = customerService.findById(withdraw.getCustomer().getId());
        withdraw.setId(id++);
        withdraw.setDateTime(LocalDateTime.now());
        customer.setBalance(customer.getBalance().subtract(withdraw.getAmount()));
        customerService.update(customer.getId(),customer);
        withdraws.add(withdraw);
    }

    @Override
    public void update(Long aLong, Withdraw withdraw) {

    }

    @Override
    public void removeById(Long aLong) {

    }
}
