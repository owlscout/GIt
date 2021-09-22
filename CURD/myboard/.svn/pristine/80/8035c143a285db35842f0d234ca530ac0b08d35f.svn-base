package com.mvc.myboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class commentController {
	
	@Autowired
	private commentBiz biz;
	
	@RequestMapping("/cupdate.do")
	public String update(Model model, commentDto cdto,  String nowPage) {
		int myno = cdto.getMyno();
		model.addAttribute("nowPage", nowPage);
		if(biz.update(cdto) > 0) {
			return "redirect:/select.do?myno="+ myno;
		}
		
		return "redirect:/select.do?myno="+ myno;
	}
	
	@RequestMapping("/cinsert.do")
	public String cinsert(Model model, commentDto cdto,  String nowPage) {
		int myno = cdto.getMyno();
		model.addAttribute("nowPage", nowPage);
		if(biz.insert(cdto) > 0) {
			return "redirect:/select.do?myno="+ myno;
		}
		
		return "redirect:/select.do?myno="+ myno;
	}
	
	@RequestMapping("/cdelete.do")
	public String delete(Model model, commentDto cdto,  String nowPage) {
		int myno = cdto.getMyno();
		model.addAttribute("nowPage", nowPage);
		if(biz.insert(cdto) > 0) {
			return "redirect:/select.do?myno="+ myno;
		}
		
		return "redirect:/select.do?myno="+ myno;
	}
	
	@RequestMapping("/answer.do")
	public String answer(Model model, commentDto cdto,  String nowPage) {
		int myno = cdto.getMyno();
		model.addAttribute("nowPage", nowPage);
		if(biz.answerProc(cdto) > 0) {
			return "redirect:/select.do?myno="+ myno;
		}
		
		return "redirect:/select.do?myno="+ myno;
	}
	
	
}
