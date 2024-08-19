package com.inb.accounts.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.inb.accounts.constants.AccountsConstants;
import com.inb.accounts.dto.CustomerDto;
import com.inb.accounts.entity.Accounts;
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
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer){
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L + new Random().nextInt(90000000);

        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }

}
