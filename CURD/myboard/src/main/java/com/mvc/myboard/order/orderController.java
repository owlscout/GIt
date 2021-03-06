package com.mvc.myboard.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mvc.myboard.address.addressBiz;
import com.mvc.myboard.address.addressDto;
import com.mvc.myboard.cart.cartBiz;
import com.mvc.myboard.cart.cartDto;
import com.mvc.myboard.delivery.deliveryBiz;
import com.mvc.myboard.delivery.deliveryDto;
import com.mvc.myboard.ordhistory.ordhisBiz;
import com.mvc.myboard.ordhistory.ordhisDto;
import com.mvc.myboard.product.productBiz;
import com.mvc.myboard.product.productDto;

@Controller
public class orderController {

	@Autowired
	private orderBiz biz;
	@Autowired
	private productBiz pbiz;
	@Autowired
	private cartBiz cbiz;
	@Autowired
	private deliveryBiz dbiz;
	@Autowired
	private ordhisBiz hbiz;
	@Autowired
	private addressBiz abiz;
	
	@RequestMapping("/mulorder.do")
	public String mulorder(String[] chk, HttpSession session, Model model, HttpServletResponse response) throws IOException {
		String username = (String) session.getAttribute("username");
		
		session.setAttribute("chk", chk); 
		
		if(username == null) {
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인을 해야 구매 가능합니다'); </script>");
			out.flush();

			return "login";
		}
		
		model.addAttribute("list", abiz.selectList(username));
		model.addAttribute("dto", abiz.main(username));
		
		
		return "myaddress";
	}
	
	@RequestMapping(value="/addrfind.do", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String kategori(@RequestBody int addrno, HttpServletResponse response, HttpSession session){
		
		String username = (String) session.getAttribute("username");
		System.out.println("addrno : " + addrno);
		
		
		addressDto adto = abiz.find(addrno);
		System.out.println(adto);
		
		String json = new Gson().toJson(adto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		return json;
	}
	
	@RequestMapping("/mulorderres.do")
	public String mulorderres(addressDto adto ,HttpSession session, Model model) {
		String[] chk = (String[]) session.getAttribute("chk");
		String username = (String) session.getAttribute("username");
		
		int length = chk.length - 1;
		int total = 0;
		String ctitle = null;
		
		for(int i = 0; i < chk.length; i++) {
		
		 	 productDto pdto = new productDto();
		 	 pdto = pbiz.selectOne(Integer.parseInt(chk[i]));
		
		 	 int ordprice = pdto.getOrdprice();
		 	System.out.println("3");
		 	 cartDto cdto = new cartDto();
		 	 cdto.setUsername(username);
		 	 cdto.setProno(Integer.parseInt(chk[i]));
		 	 
		 	 cartDto ccdto = cbiz.find(cdto);
		 	 int am = ccdto.getAmount();
		 	 
		 	 ctitle = ccdto.getProtitle();
		 	 
		 	 total += (ordprice * am);
		}
		
		
		deliveryDto ddto = new deliveryDto();
		ddto.setProtitle(ctitle);
		ddto.setProamout(length);
		ddto.setTotal(total);
		ddto.setUsername(username);
		ddto.setAddress_1(adto.getAddress_1());
		ddto.setAddress_2(adto.getAddress_2());
		dbiz.insert(ddto);
		
		for(int i = 0; i < chk.length; i++) {
			deliveryDto delno = dbiz.find(username);
			cartDto cdto = new cartDto();
		 	cdto.setUsername(username);
		 	cdto.setProno(Integer.parseInt(chk[i]));
		 	System.out.println("5");
			productDto pdto = pbiz.selectOne(Integer.parseInt(chk[i]));
			String title = pdto.getProtitle();
			String name = pdto.getProname();
			int ordprice = pdto.getOrdprice();
			int principal = pdto.getPrincipal();
			int tax = pdto.getTax();
			
			cartDto cardto = new cartDto();
			cardto.setUsername(username);
		 	cardto.setProno(Integer.parseInt(chk[i]));
	
		 	cartDto amountdto = cbiz.find(cardto);
		 	int amount = amountdto.getAmount();
	
			orderDto dto = new orderDto();
			dto.setDelno(delno.getDelno());
			dto.setProno(Integer.parseInt(chk[i]));
			dto.setProname(name);
			dto.setProtitle(title);
			dto.setAmout(amount);
			dto.setUsername(username);
			dto.setOrdprice(ordprice);
			dto.setPrincipal(principal);
			dto.setTax(tax);
			
			
			if(biz.insert(dto) > 0) {
				
				cbiz.delete(amountdto.getCartno());
			}
			
			
		}
		char mainaddr = adto.getMainaddr();
		char yes = 'Y';
		char no = 'N';
		addressDto mainDto = abiz.main(username);
		
		addressDto namefind = abiz.namefind(adto.getAddname());
		if(namefind != null && Character.compare(mainaddr, yes) == 0) {
			int mainno = mainDto.getAddrno();
			addressDto mainup = new addressDto();
			mainup.setAddrno(mainno);
			mainup.setMainaddr(no);
			
			abiz.mainupdate(mainup);
			
		} else if (namefind == null && Character.compare(mainaddr, yes) == 0) {
			int mainno = mainDto.getAddrno();
			addressDto mainup = new addressDto();
			mainup.setAddrno(mainno);
			mainup.setMainaddr(no);
			
			abiz.mainupdate(mainup);
			abiz.insert(adto);
		} else if (namefind == null && Character.compare(mainaddr, yes) != 0) {
			abiz.insert(adto);
		} else {
			System.out.println("주소 추가, 수정 실패");
		}
		
		
		deliveryDto del = dbiz.find(username);
		
		String content = del.getProtitle() + "외" + (del.getProamout() - 1) + "개의 상품을 주문하셨습니다.";
		System.out.println(content);
		ordhisDto hdto = new ordhisDto();
		hdto.setUsername(username);
		hdto.setDelno(del.getDelno());
		hdto.setReason(content);
		
		model.addAttribute("list", dbiz.list(username));
		
		return "dellist";
	}
	
	@RequestMapping("/ordlist.do")
	public String ordlist(String delno, Model model) {
		
		
		model.addAttribute("list", biz.selectList(delno));
		
		return "orderlist";
	}
	
	@RequestMapping("/jusochange.do")
	public String juso(Model model, HttpSession session) {
		
		String username = (String) session.getAttribute("username");
		
		model.addAttribute("list", abiz.selectList(username));
		
		return "jusochange";
	}
	
}
