package com.mvc.myboard.product;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.mvc.myboard.pagingDto;

@Controller
public class productController {
	
	@Autowired
	private productBiz biz;
	
	@RequestMapping("/prolist.do")
	public String prolist(Model model) {
		
		model.addAttribute("list", biz.selectList());
		return "prolist";
	}
	
	@RequestMapping("/proselect.do")
	public String proselect(Model model, int prono) {
		
		model.addAttribute("dto", biz.selectOne(prono));
		productDto dto = biz.selectOne(prono);
		
		return "proselect";
	}
	
	@RequestMapping("/proinsert.do")
	public String insert(Model model) {
		
		return "proinsert";
	}
	
	@RequestMapping("/proinsertres.do")
	public String insertres(Model model, productDto dto, String nowPage, HttpSession session, MultipartFile fileup) throws IllegalStateException, IOException {
		String realpath = session.getServletContext().getRealPath("/")+ "image/upload/" + dto.getProname();
		String filename = dto.getProtitle();
		File folder = new File(realpath);
		if(!folder.exists()) {
			try {
				folder.mkdir();
				System.out.println("폴더 생성");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getStackTrace();
			}
		}else {
			System.out.println("이미 존재하는 폴더");
		}
		
		if(!fileup.getOriginalFilename().isEmpty()) {
			fileup.transferTo(new File(realpath, filename));
			dto.setThumb(filename);
		}else {
			dto.setThumb("BLANK");
		}
		
		if(biz.insert(dto) > 0) {
			model.addAttribute("nowPage", nowPage);
			return "redirect:prolist.do";
		}
		return "redirect:proinsert.do";
	}
	
	@RequestMapping("/proupdate.do")
	public String update(Model model, int prono) {
		
		model.addAttribute("dto", biz.selectOne(prono));
		
		return "proupdate";
		
	}
	
	@RequestMapping("/proupdateres.do")
	public String updateres(productDto dto) {
		
		if(biz.update(dto) > 0) {
			return "redirect:prolist.do";
		}
		return "redirect:proselect.do?prono="+ dto.getProno();
	}
	
	@RequestMapping("/prodelete.do")
	public String delete(int prono) {
		
		if(biz.delete(prono) > 0) {
			return "redirect:prolist.do";
		}
		return "redirect:proselect.do?prono="+ prono;
	}
	
	
	@RequestMapping("/admin.do")
	public String admin(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "admin";
	}
	
	@RequestMapping("/mulupdate.do")
	public String mulupdate(String[] prono, String[] prokate_1, String[] prokate_2, String[] protitle, String[] proshow, String[] status) {
		
		for(int i = 0; i < prono.length; i++) {
			String sta = status[i];
			int no = Integer.parseInt(prono[i]);
			productDto dto = new productDto();
			dto.setProno(no);
			dto.setProkate_1(prokate_1[i]);
			dto.setProkate_2(prokate_2[i]);
			dto.setProtitle(protitle[i]);
			dto.setProshow(Integer.parseInt(proshow[i]));
			if(sta.equals("수정")) {
				biz.mulupdate(dto);
			} else if(sta.equals("삭제")) {
				biz.delete(no);
			}
			
		}
		
		
		
		return "redirect:admin.do";
	}
	
	@RequestMapping(value="/kate.do", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String kategori(@RequestBody String prokate_1, HttpServletResponse response){
		List<String> list = new ArrayList<String>();
		
		list = biz.katelist(prokate_1);
		
//		List<Object> resultList = new ArrayList<Object>();
//		
//		resultList = list.stream().distinct().collect(Collectors.toList());
		
		List<String> resultList = new ArrayList<String>();
		
		TreeSet<String> distinct = new TreeSet<String>(list);
		
		resultList = new ArrayList<String>(distinct);
		
		String json = new Gson().toJson(resultList);
		
		response.setContentType("text/html; charset=UTF-8");
		
		
		return json;
	}
	
	@RequestMapping(value="/kate2.do", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String kategori2(@RequestBody productDto dto){
		List<productDto> list = new ArrayList<productDto>();
		
		String prokate_1 = dto.getProkate_1();
		String prokate_2 = dto.getProkate_2();
		
		if(prokate_2 == "전체") {
			list = biz.kateall(prokate_1);
		} else {
			list = biz.kateselect(dto);
		}
		
		String json = new Gson().toJson(list);
		System.out.println(json);
		return json;
	}
}
