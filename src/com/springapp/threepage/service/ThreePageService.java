package com.springapp.threepage.service;

import java.util.List;

import com.springapp.threepage.vo.Bank;
import com.springapp.threepage.vo.Contact;
import com.springapp.threepage.vo.ThreePageVO;
import com.springapp.threepage.vo.User;

public interface ThreePageService {
	
public void registerUser(User user, Contact contact, Bank bank) throws Exception;
	
	public List<ThreePageVO> listAllUser();
	
	public void deleteUser(int id);
	
	public void updateUser(ThreePageVO threePageVO);
	
	public ThreePageVO findById(int id);
	

}
