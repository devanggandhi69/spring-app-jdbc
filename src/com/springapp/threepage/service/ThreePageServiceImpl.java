package com.springapp.threepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.threepage.dao.ThreePageDao;
import com.springapp.threepage.vo.Bank;
import com.springapp.threepage.vo.Contact;
import com.springapp.threepage.vo.ThreePageVO;
import com.springapp.threepage.vo.User;

@Service
public class ThreePageServiceImpl implements ThreePageService {

	@Autowired
	ThreePageDao threepagedao;

	@Override
	public void registerUser(User user, Contact contact, Bank bank) throws Exception {
		threepagedao.registerUser(user, contact, bank);

	}

	@Override
	public List<ThreePageVO> listAllUser() {
		return threepagedao.listAllUser();
	}

	@Override
	public void deleteUser(int id) {
		threepagedao.deleteUser(id);

	}

	@Override
	public void updateUser(ThreePageVO threePageVO) {
		threepagedao.updateUser(threePageVO);

	}

	@Override
	public ThreePageVO findById(int id) {
		return threepagedao.findById(id);
	}

}
