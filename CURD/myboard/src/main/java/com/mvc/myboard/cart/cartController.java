package com.mvc.myboard.cart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.myboard.product.productBiz;
import com.mvc.myboard.product.productDto;



@Controller
public class cartController {
	
	@Autowired
	private cartBiz biz;
	
	@Autowired
	private productBiz pbiz;
	
	@RequestMapping("/cartlist.do")
	public String list(Model model, HttpSession session){
		String username = (String) session.getAttribute("username");
		List<cartDto> nmlist = (ArrayList) session.getAttribute("nclist");
		if(nmlist == null) {
			List<cartDto> list = biz.selectList(username);
			model.addAttribute("list", list);
		} else {
			model.addAttribute("list", nmlist);
		} 
		System.out.println(username);
		 
		
		return "cartlist";
	}
	
	@RequestMapping("/cartinsert.do")
	public String insert(cartDto dto) {
		
		int count = biz.count(dto);
		System.out.println(count);
		if(count == 0) {
			biz.insert(dto);
		} else {
			biz.update(dto);
		}
		return "redirect:cartlist.do?username="+dto.getUsername();

	}
	
	@RequestMapping("/cartupdate.do")
	public String update(cartDto dto) {
		
		biz.update(dto);
		
		return "redirect:cartlist.do?username="+dto.getUsername();
	}
	
	@RequestMapping("/cartdelete.do")
	public String delete(int cartno, String username) {

		biz.delete(cartno);
		
		return "redirect:cartlist.do?username="+username;
	}
	
	@RequestMapping("/mulinsert.do")
	public String mulinsert(String[] chk, String username) {
		
		for(int i = 0; i < chk.length; i++) {
			productDto pdto = pbiz.selectOne(Integer.parseInt(chk[i]));
			String title = pdto.getProtitle();
			String kate_1 = pdto.getProkate_1();
			String kate_2 = pdto.getProkate_2();
			String name = pdto.getProname();
			cartDto dto = new cartDto();
			dto.setProno(Integer.parseInt(chk[i]));
			dto.setProname(name);
			dto.setProtitle(title);
			dto.setProkate_1(kate_1);
			dto.setProkate_2(kate_2);
			dto.setUsername(username);
			dto.setAmount(1);
			
			if(biz.count(dto) > 0) {
				
				biz.update(dto);
			} else {
				
				biz.insert(dto);
			}
			
		}
			
		return "redirect:cartlist.do?username="+username;
	}
	
	@RequestMapping("/nonmembercartlist.do")
	public String nonmemberlist() {
		
		return "nonmembercartlist";
	}
	
	@RequestMapping("/nonmembercartinsert.do")
	public String nonmemberinsert(cartDto dto, HttpSession session) {
		List<cartDto> nclist = new ArrayList<cartDto>();
		
		nclist = (ArrayList<cartDto>) session.getAttribute("nclist");
		
		
		if(nclist == null) {
			nclist = new ArrayList<cartDto>();
		}
		
		boolean check = true;
		
		
		for(int i = 0; i < nclist.size(); i++) {
			
			if (nclist.get(i).getProno() == dto.getProno()) {
					
					
					int amount = nclist.get(i).getAmount() + dto.getAmount();
					System.out.println(amount);
					cartDto cdto = new cartDto();
						
					cdto.setProkate_1(nclist.get(i).getProkate_1());
					cdto.setProkate_2(nclist.get(i).getProkate_2());
					cdto.setProname(nclist.get(i).getProname());
					cdto.setProno(nclist.get(i).getProno());
					cdto.setProtitle(nclist.get(i).getProtitle());
					cdto.setAmount(amount);
					nclist.set(i, cdto);
					check = false;
				} 
			
		}
		if(check == true) {
			nclist.add(dto);
			
		}
		
		session.setAttribute("nclist", nclist);
		
		nclist = (ArrayList) session.getAttribute("nclist");
		
		
		return "nmcartlist";
	}
	
	
}