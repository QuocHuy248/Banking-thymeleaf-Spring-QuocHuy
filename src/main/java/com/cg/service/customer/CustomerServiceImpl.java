package com.cg.service.customer;

import com.cg.model.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements ICustomerService {

    private static final List<Customer> customers = new ArrayList<>();
    private static long id = 1L;

    static {
        customers.add(new Customer(id++, "NVA", "nva@co.cc", "2345", "28 Nguyễn Tri Phương", BigDecimal.ZERO, false));
    }

    @Override
    public List<Customer> findAll() {
        return customers.stream().filter(cus -> !cus.getDeleted()).collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllBanned() {
        return customers.stream().filter(cus -> cus.getDeleted()).collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllExceptSender(Long aLong) {
        return findAll().stream().filter(customer -> !(customer.getId().equals(aLong))).collect(Collectors.toList());
    }

    @Override
    public Customer findById(Long aLong) {
        return customers.stream().filter(customer -> customer.getId() == aLong).findFirst().orElseThrow(null);
    }

    @Override
    public void create(Customer customer) {
        customer.setId(id++);
        customer.setBalance(BigDecimal.ZERO);
        customer.setDeleted(false);
        customers.add(customer);
    }

    @Override
    public void update(Long aLong, Customer customer) {
        Customer customer1 = findById(aLong);
        customer.setBalance(customer1.getBalance());
        Long index = (long) customers.indexOf(findById(aLong));
        customers.set(Math.toIntExact(index), customer);
    }

    @Override
    public void removeById(Long aLong) {
        customers.stream().filter(customer -> customer.getId() == aLong).findFirst().orElseThrow(null).setDeleted(true);
    }

    @Override
    public void unBanByID(Long id) {
        customers.stream().filter(customer -> customer.getId() == id).findFirst().orElseThrow(null).setDeleted(false);
    }
}
