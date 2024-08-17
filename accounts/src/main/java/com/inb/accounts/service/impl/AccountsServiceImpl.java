package com.inb.accounts.service.impl;

import org.springframework.stereotype.Service;

import com.inb.accounts.dto.CustomerDto;
import com.inb.accounts.entity.Customer;
import com.inb.accounts.mapper.CustomerMapper;
import com.inb.accounts.repository.AccountsRepository;
import com.inb.accounts.repository.CustomerRepository;
import com.inb.accounts.service.IAccountsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements  IAccountsService {
    
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Customer savedCustomer = customerRepository.save(customer);
    }

}
