package com.springapp.threepage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.threepage.dao.ThreePageDao;
import com.springapp.threepage.vo.Bank;
import com.springapp.threepage.vo.Contact;
import com.springapp.threepage.vo.User;

@Service
public class ThreePageServiceImpl implements ThreePageService {

	@Autowired
	ThreePageDao threepagedao;


	@Override
	public void registerUser(User user, Contact contact, Bank bank) throws Exception {

		threepagedao.registerUser(user, contact, bank);

	}

}
