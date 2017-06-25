package com.springapp.threepage.service;

import com.springapp.threepage.vo.Bank;
import com.springapp.threepage.vo.Contact;
import com.springapp.threepage.vo.User;

public interface ThreePageService {
	
	public void registerUser(User user, Contact contact, Bank bank) throws Exception;
	

}
