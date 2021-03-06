package com.mvc.myboard.delivery;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.myboard.order.orderBiz;
import com.mvc.myboard.ordhistory.ordhisBiz;
import com.mvc.myboard.ordhistory.ordhisDto;



@Controller
public class deliveryController {

	@Autowired
	private deliveryBiz biz;
	@Autowired
	private ordhisBiz hbiz;
	
	@RequestMapping("/dellist.do") 
	public String list(Model model, HttpSession session){
		String username = (String) session.getAttribute("username");
		model.addAttribute("list", biz.list(username));
		model.addAttribute("count", biz.count(username));
		model.addAttribute("total", biz.total(username));

		
		
		return "dellist";
	}
	
	
	@RequestMapping("/delupdate.do")
	public String update(deliveryDto dto) {
		biz.update(dto);
		
		return "redirect:dellist.do";
	}
	
	@RequestMapping("/delcancel.do")
	public String cancel(String delno, Model model) {
		
		model.addAttribute("delno", delno);
		
		return "cancel";
	}
	
	@RequestMapping("/delcancelres.do")
	public String cancelres(String delno, String reason, HttpSession session) {
		String username = (String) session.getAttribute("username");
		System.out.println(delno);
		biz.cancel(delno);
		
		ordhisDto dto = new ordhisDto();
		dto.setDelno(delno);
		dto.setReason(reason);
		dto.setUsername(username);
		
		hbiz.insert(dto);
		
		return "redirect:dellist.do";
	}
	
}
