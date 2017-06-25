package com.springapp.threepage.dao;

import com.springapp.threepage.vo.Bank;
import com.springapp.threepage.vo.Contact;
import com.springapp.threepage.vo.User;

public interface ThreePageDao {
	
	public void registerUser(User user, Contact contact, Bank bank) throws Exception;
	

}
