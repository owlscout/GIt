package com.mvc.myboard.ordhistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class ordhisController {
	
	@Autowired
	private ordhisBiz biz;
	
	@RequestMapping("/ordhis.do")
	public String ordhis() {
		
		return "ordhistory";
	}
	@RequestMapping(value="/ordhisname.do", method=RequestMethod.POST, produces="text/plain; charset=UTF-8")
	@ResponseBody
	public String alllist(@RequestBody String username) {
		System.out.println("username : " + username);
		
		List<ordhisDto> list = biz.alllist(username);
		
		String json = new Gson().toJson(list);

		System.out.println(json);
		
		return json;
	}
	
	@RequestMapping("/hislist.do")
	public String list(String delno, Model model) {
		
		model.addAttribute("list", biz.list(delno));
		
		return null;
	}
	
	@RequestMapping("/hisupdate.do")
	public String insert(ordhisDto dto) {
		
		biz.update(dto);
		
		return null;
	}
	
}
