package com.springapp.threepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springapp.threepage.service.ThreePageService;
import com.springapp.threepage.vo.Bank;
import com.springapp.threepage.vo.Contact;
import com.springapp.threepage.vo.ThreePageVO;
import com.springapp.threepage.vo.User;

@Controller
public class ThreePageController {

	@Autowired
	ThreePageService threePageService;

//	@RequestMapping("/displayall")
//	public List<ThreePageVO> list(@ModelAttribute("threePageBean") ThreePageVO threePageVO, HttpSession session) {
//
//		List<ThreePageVO> list = threePageService.listAllUser();
//		session.setAttribute("threePageBean", list);
//		
//		return list;
//	}

	@RequestMapping("/")
	public String user(@ModelAttribute("userBean") User user, HttpSession session) {
		return "user";
	}

	@RequestMapping("/contactinfo.do")
	public String contactUser(@ModelAttribute("contactBean") Contact contact, @ModelAttribute("userBean") User user,
			HttpSession session) {
		session.setAttribute("userBean", user);
		return "contact";
	}

	@RequestMapping("/bankinfo.do")
	public String bankUser(@ModelAttribute("bankBean") Bank bank, @ModelAttribute("contactBean") Contact contact,
			HttpSession session) {
		session.setAttribute("contactBean", contact);
		return "bank";
	}

	@RequestMapping("/display.do")
	public String registerUser(@ModelAttribute("bankBean") Bank bank, HttpServletRequest request, HttpSession session)
			throws Exception {

		session.setAttribute("bankBean", bank);
		System.out.println("UserController : registerUser -- Start");

		User user = (User) request.getSession().getAttribute("userBean");
		Contact contact = (Contact) request.getSession().getAttribute("contactBean");
		bank = (Bank) request.getSession().getAttribute("bankBean");

		System.out.println(user.getFirstname());
		System.out.println(bank.getBankname());
		System.out.println(contact.getAddress());

		threePageService.registerUser(user, contact, bank);

		System.out.println("UserController : registerUser -- end");
		return "display";
	}
}
