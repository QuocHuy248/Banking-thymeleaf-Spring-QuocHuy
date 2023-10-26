package com.cg.service.deposit;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Withdraw;
import com.cg.service.customer.CustomerServiceImpl;
import com.cg.service.customer.ICustomerService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepositService implements IDepositService {
    private static final List<Deposit> deposits = new ArrayList<>();
    private static long id = 1L;
    private ICustomerService customerService = new CustomerServiceImpl();


    @Override
    public List<Deposit> findAll() {
        return null;
    }

    @Override
    public List<Deposit> findAllExceptSender(Long aLong) {
        return null;
    }

    @Override
    public Deposit findById(Long aLong) {
        return null;
    }

    @Override
    public void create(Deposit deposit) {
        Customer customer = customerService.findById(deposit.getCustomer().getId());
        deposit.setCustomer(customer);
        deposit.setId(id++);
        deposit.setDateTime(LocalDateTime.now());
        customer.setBalance(customer.getBalance().add(deposit.getAmount()));
        customerService.update(customer.getId(),customer);
        deposits.add(deposit);
    }

    @Override
    public void update(Long aLong, Deposit deposit) {

    }

    @Override
    public void removeById(Long aLong) {

    }
}
