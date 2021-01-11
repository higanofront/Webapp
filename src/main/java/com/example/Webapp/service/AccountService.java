package com.example.Webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Webapp.entity.Account;
import com.example.Webapp.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public List<Account> findAll() {
		return accountRepository.findAll();
	};
}
