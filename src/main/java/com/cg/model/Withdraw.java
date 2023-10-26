package com.cg.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Withdraw {
    private Long id;
    private Customer customer;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Withdraw() {
    }

    public Withdraw(Long id, Customer customer, BigDecimal amount, LocalDateTime dateTime, Boolean deleted) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.dateTime = dateTime;
        this.deleted = deleted;
    }

    public Withdraw(Customer customer) {
        this.customer = customer;
    }
}
