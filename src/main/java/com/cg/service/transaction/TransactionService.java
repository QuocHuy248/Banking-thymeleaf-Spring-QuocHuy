package com.cg.service.transaction;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Transaction;
import com.cg.service.customer.CustomerServiceImpl;
import com.cg.service.customer.ICustomerService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionService implements ITransactionService {
    private static final List<Transaction> transactions = new ArrayList<>();
    private static long id = 1L;
    private ICustomerService customerService = new CustomerServiceImpl();

    @Override
    public List<Transaction> findAll() {
        return transactions;
    }

    @Override
    public List<Transaction> findAllExceptSender(Long aLong) {
        return null;
    }

    @Override
    public Transaction findById(Long aLong) {
        return null;
    }

    @Override
    public void create(Transaction transaction) {
        Customer sender = transaction.getSender();
        Customer recipient = transaction.getRecipient();
        transaction.setId(id++);
        transaction.setDateTime(LocalDateTime.now());
        sender.setBalance(sender.getBalance().subtract(transaction.getTransactionAmount()));
        recipient.setBalance(recipient.getBalance().add(transaction.getTransferAmount()));
        customerService.update(sender.getId(), sender);
        customerService.update(recipient.getId(), recipient);
        transactions.add(transaction);
    }

    @Override
    public void update(Long aLong, Transaction transaction) {
        transaction.setFee(Long.parseLong("10"));
        Long fee = transaction.getFee();
        BigDecimal feeAM = BigDecimal.valueOf(fee).
                multiply(transaction.getTransferAmount()).divide(BigDecimal.valueOf(100));
        transaction.setFeeAmount(feeAM);
        transaction.setTransactionAmount(feeAM.add(transaction.getTransferAmount()));
        Customer receiver = customerService.findById(aLong);
        transaction.setRecipient(receiver);
    }

    @Override
    public void removeById(Long aLong) {

    }


}
