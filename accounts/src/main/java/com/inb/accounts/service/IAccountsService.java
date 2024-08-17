package com.inb.accounts.service;

import com.inb.accounts.dto.CustomerDto;

public interface IAccountsService {
    void createAccount(CustomerDto customerDto);
}
