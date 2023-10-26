package com.cg.service.customer;

import com.cg.model.Customer;
import com.cg.service.IGeneralService;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer, Long> {
    public default List<Customer> findAllBanned(){
        return null;
    }
    public default void unBanByID(Long id){
    }

}
