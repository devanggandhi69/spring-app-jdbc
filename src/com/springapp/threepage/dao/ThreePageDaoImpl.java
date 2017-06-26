package com.springapp.threepage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springapp.threepage.vo.Bank;
import com.springapp.threepage.vo.Contact;
import com.springapp.threepage.vo.ThreePageVO;
import com.springapp.threepage.vo.User;

@Repository
public class ThreePageDaoImpl implements ThreePageDao {

	@Autowired
	DBConnection DBconn;

	@Override
	public void registerUser(User user, Contact contact, Bank bank) throws Exception {

		try {
			Connection con = DBconn.getconnection();

			String sql = "insert into three_page_jdbc_template(firstname,middlename,lastname,address,city,state,country,phone,bankname,accountno,ssn) values('"
					+ user.getFirstname() + "','" + user.getMiddlename() + "','" + user.getLastname() + "','"
					+ contact.getAddress() + "','" + contact.getCity() + "','" + contact.getState() + "','"
					+ contact.getCountry() + "','" + contact.getPhone() + "','" + bank.getBankname() + "','"
					+ bank.getAccountno() + "','" + bank.getSsn() + "')";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			con.close();

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

	@Override
	public List<ThreePageVO> listAllUser() {
		List<ThreePageVO> list = null;
		try {

			Connection con = DBconn.getconnection();
			String sql = "select * from three_page_jdbc_template";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThreePageVO threePageVO = new ThreePageVO();
				threePageVO.setId(rs.getInt(1));
				threePageVO.setFirstname(rs.getString(2));
				threePageVO.setMiddlename(rs.getString(3));
				threePageVO.setLastname(rs.getString(4));
				threePageVO.setAddress(rs.getString(5));
				threePageVO.setCity(rs.getString(6));
				threePageVO.setState(rs.getString(7));
				threePageVO.setCountry(rs.getString(8));
				threePageVO.setPhone(rs.getString(9));
				threePageVO.setBankname(rs.getString(10));
				threePageVO.setAccountno(rs.getString(11));
				threePageVO.setSsn(rs.getString(12));
				list.add(threePageVO);

			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return list;
	}

	@Override
	public void deleteUser(int id) {
		try {
			Connection con = DBconn.getconnection();

			PreparedStatement ps = con.prepareStatement("delete from three_page_info where id = '" + id + "' ");
			ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	@Override
	public void updateUser(ThreePageVO threePageVO) {
		try {
			Connection con = DBconn.getconnection();

			PreparedStatement ps = con.prepareStatement("update three_page_jdbc_template set firstname = '"
					+ threePageVO.getFirstname() + "',middlename = '" + threePageVO.getMiddlename() + "',lastname ='"
					+ threePageVO.getLastname() + "',address='" + threePageVO.getAddress() + "',city ='"
					+ threePageVO.getCity() + "',state='" + threePageVO.getState() + "',country ='"
					+ threePageVO.getCountry() + "',phone='" + threePageVO.getPhone() + "',bankname ='"
					+ threePageVO.getBankname() + "',accountno ='" + threePageVO.getAccountno() + "',ssn ='"
					+ threePageVO.getSsn() + "' where id = '" + threePageVO.getId() + "' ");
			ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	@Override
	public ThreePageVO findById(int id) {
		ThreePageVO threePageVO = new ThreePageVO();
		try {
			Connection con = DBconn.getconnection();

			PreparedStatement ps = con
					.prepareStatement("select * from three_page_jdbc_template where id = '" + id + "'");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				threePageVO.setId(rs.getInt(1));
				threePageVO.setFirstname(rs.getString(2));
				threePageVO.setMiddlename(rs.getString(3));
				threePageVO.setLastname(rs.getString(4));
				threePageVO.setAddress(rs.getString(5));
				threePageVO.setCity(rs.getString(6));
				threePageVO.setState(rs.getString(7));
				threePageVO.setCountry(rs.getString(8));
				threePageVO.setPhone(rs.getString(10));
				threePageVO.setBankname(rs.getString(11));
				threePageVO.setAccountno(rs.getString(12));
				threePageVO.setSsn(rs.getString(13));
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return threePageVO;
	}

}
