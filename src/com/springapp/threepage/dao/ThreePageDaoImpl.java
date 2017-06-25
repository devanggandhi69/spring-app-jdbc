package com.springapp.threepage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springapp.threepage.vo.Bank;
import com.springapp.threepage.vo.Contact;
import com.springapp.threepage.vo.User;

@Repository
public class ThreePageDaoImpl implements ThreePageDao {

	@Autowired
	DBConnection DBconn;

	@Override
	public void registerUser(User user, Contact contact, Bank bank) throws Exception {

		try {
			Connection con = DBconn.getconnection();

		//	java.sql.Statement st = con.createStatement();
			String sql = "insert into three_page_jdbc_template(firstname,middlename,lastname,address,city,state,country,phone,bankname,accountno,ssn) values('"
					+ user.getFirstname() + "','" + user.getMiddlename() + "','" + user.getLastname() + "','"
					+ contact.getAddress() + "','" + contact.getCity() + "','" + contact.getState() + "','"
					+ contact.getCountry() + "','" + contact.getPhone() + "','" + bank.getBankname() + "','"
					+ bank.getAccountno() + "','" + bank.getSsn() + "')";
			 PreparedStatement ps = con.prepareStatement(sql);
		//	st.executeUpdate(sql);
			ps.executeUpdate();
			con.close();

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

}
