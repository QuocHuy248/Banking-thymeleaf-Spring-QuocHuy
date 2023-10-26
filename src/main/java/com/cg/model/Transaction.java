package com.cg.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private Customer sender;
    private Customer recipient;
    private BigDecimal feeAmount;
    private Long fee;
    private BigDecimal transactionAmount;
    private BigDecimal transferAmount;
    private LocalDateTime dateTime;
    private boolean deleted;
    public Transaction(Customer sender) {
        this.sender = sender;
    }

    public Transaction() {
    }

    public Transaction(Long id, Customer sender, Customer recipient, BigDecimal feeAmount, Long fee, BigDecimal transactionAmount, BigDecimal transferAmount, LocalDateTime dateTime, boolean deleted) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.feeAmount = feeAmount;
        this.fee = fee;
        this.transactionAmount = transactionAmount;
        this.transferAmount = transferAmount;
        this.dateTime = dateTime;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getRecipient() {
        return recipient;
    }

    public void setRecipient(Customer recipient) {
        this.recipient = recipient;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
