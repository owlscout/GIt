package com.mvc.myboard;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.myboard.address.addressBiz;
import com.mvc.myboard.address.addressDto;

@Controller
public class userController {
	
	@Autowired
	private userBiz biz;
	@Autowired
	private addressBiz abiz;
	
	@RequestMapping("/signup.do")
	public String signup() {
		
		return "signup";
	}
	
	@RequestMapping(value="/signupres.do", method=RequestMethod.POST)
	public String singupres(userDto dto) {
		System.out.println(dto.getAddno());
		addressDto adto = new addressDto();
		adto.setAddname("기본 주소");
		adto.setUsername(dto.getUsername());
		adto.setAddress_1(dto.getAddress_1());
		adto.setAddress_2(dto.getAddress_2());
		adto.setAddno(dto.getAddno());
		adto.setMainaddr('Y');
		System.out.println(adto.getAddno());
		if(biz.signup(dto) > 0) {
			abiz.insert(adto);
			return "redirect:login.do";
		}
		
		return "redirect:signup.do";
		
	}
	
	@RequestMapping("/login.do")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxlogin(HttpSession session, @RequestBody userDto dto) {
		
		userDto res = biz.login(dto);
		boolean check = false;
	
		if(res != null) {
			session.setAttribute("login", res);
			session.setAttribute("username", res.getUsername());
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/home.do")
	public String home() {
		return "redirect:/";
	}
	
	@RequestMapping(value="/ajaxidChk.do", method=RequestMethod.POST)
	@ResponseBody
	public String ajaxidChk(@RequestBody String userid){
		System.out.println("userid : " + userid);
		String res = biz.idCheck(userid);
		String check = "false";
		if (res != null) {
			check = "true";
		} 
		return check;
	}
	
}
