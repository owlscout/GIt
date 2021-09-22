package com.mvc.myboard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class myboardController {
	
	@Autowired
	private myboardBiz biz;
	
	@Autowired
	private commentBiz cbiz;
	
	@RequestMapping("/select.do")
	public String select(Model model, int myno, String nowPage) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("list", cbiz.commentList(myno));
		biz.readcount(myno);
		
		return "select";
	}
	
	@RequestMapping("/insert.do")
	public String insert(Model model, String nowPage) {
		
		model.addAttribute("nowPage", nowPage);
		return "insert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertres(Model model, myboardDto dto, String nowPage, HttpSession session, MultipartFile fileup) throws IllegalStateException, IOException {
		System.out.println(dto.getMyboardpw());
		String realpath = session.getServletContext().getRealPath("/")+ "WEB-INF/upload/" + dto.getMyname();
		String filename = fileup.getOriginalFilename();
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
			dto.setFileupdown(filename);
		}else {
			dto.setFileupdown("BLANK");
		}
		
		String name = dto.getMyname();
		if(biz.insert(dto) > 0) {
			model.addAttribute("nowPage", nowPage);
			return "redirect:select.do?myno="+ biz.insertafter(name);
		}
		return "listPage.do?nowPage=1&cntPerPage=10";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "update";
		
	}
	
	@RequestMapping("/updateres.do")
	public String updateres(myboardDto dto) {
		
		if(biz.update(dto) > 0) {
			return "redirect:select.do?myno="+dto.getMyno();
		}
		return "redirect:/";
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		
		if(biz.delete(myno) > 0) {
			return "redirect:listPage.do?nowPage=1&cntPerPage=10";
		}
		return "redirect:select.do?myno=" + myno;
	}
	
	@RequestMapping("/search.do")
	public String search(HttpServletResponse response, Model model, searchDto dto) {
		
		String option = dto.getSearchOption();
		String text = dto.getSearchText();
		if(option.equals("mytitle") ) {
			model.addAttribute("list", biz.searchtitle(text));
			model.addAttribute("sdto", dto);
		} else if (option.equals("mycontent")) {
			model.addAttribute("list", biz.searchcontent(text));
			model.addAttribute("sdto", dto);
		} else if (option.equals("myname")) {
			model.addAttribute("list", biz.searchname(text));
			model.addAttribute("sdto", dto);
		}
		
		
		
		return "search";
	}
	
	// 게시물 목록 + 페이징 추가
	@RequestMapping("/listPage.do")
	public String listPage(pagingDto dto, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		int total = biz.listCnt();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		dto = new pagingDto(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", dto);
		model.addAttribute("list", biz.listpaging(dto));
		return "listPage";
	}
	
	@RequestMapping(value="/pwChk.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String , Boolean> pwChk(@RequestBody myboardDto dto){ //@RequestBody가 json으로 온 객체를 java Object로 바꿔준다
		
		myboardDto res = biz.pwChk(dto);
		boolean check = false;
		if (res != null) {
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	@RequestMapping("/download.do")
	@ResponseBody
	public byte[] downlod(HttpServletResponse response, HttpSession session,
		      @RequestParam String filedown, String myname) throws IOException{
		String realpath = session.getServletContext().getRealPath("/")+ "WEB-INF/upload/" + myname;
		
		File file = new File(realpath, filedown);
		
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		
		String fn = new String(file.getName().getBytes(), "iso_8859_1");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");

		response.setContentLength(bytes.length);
		
		return bytes;
	}
	
	@RequestMapping(value="/exceldown.do", method=RequestMethod.POST)
	@ResponseBody
	public void exceldown(HttpServletResponse response, @RequestParam int myno) throws IOException {
		myboardDto dto = biz.selectOne(myno);
		HSSFWorkbook objWorkBook = new HSSFWorkbook();
		HSSFSheet objSheet = null;
		HSSFRow objRow = null;
		HSSFCell objCell = null;

		HSSFFont font = objWorkBook.createFont();
		font.setFontHeightInPoints((short)9);
		font.setFontName("맑은고딕");
		
		HSSFCellStyle styleHd = objWorkBook.createCellStyle();
		styleHd.setFont(font);

		objSheet = objWorkBook.createSheet("첫번째 시트");
		// 1행
		objRow = objSheet.createRow(0);
		objRow.setHeight((short) 0x150);
	
		objCell = objRow.createCell(0);
		objCell.setCellValue("글쓴이");
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(1);
		objCell.setCellValue("제목");
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(2);
		objCell.setCellValue("내용");
		objCell.setCellStyle(styleHd);
		
		// 2행
		objRow = objSheet.createRow(1);
		objRow.setHeight((short) 0x150);
		
		objCell = objRow.createCell(0);
		objCell.setCellValue(dto.getMyname());
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(1);
		objCell.setCellValue(dto.getMytitle());
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(2);
		objCell.setCellValue(dto.getMycontent());
		objCell.setCellStyle(styleHd);
		
		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "ATTachment; Filename="+ URLEncoder.encode(dto.getMytitle() , "UTF-8")+ ".xls");
		
		OutputStream fileOut = response.getOutputStream();
		objWorkBook.write(fileOut);
		fileOut.close();
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}
	@RequestMapping(value="/txtdown.do", method=RequestMethod.POST)
	@ResponseBody
	public void textdown(HttpServletResponse response, @RequestParam int myno) throws IOException {
		myboardDto dto = biz.selectOne(myno);
		
		String txt = "글쓴이 : " + dto.getMyname() + "\n" 
					+ "제목 : " + dto.getMytitle() + "\n"
					+ "내용 : " + dto.getMycontent() + "\n"; 
		
		
		response.setHeader("Content-Disposition", "ATTachment; Filename="+ URLEncoder.encode(dto.getMytitle() , "UTF-8")+ ".txt");
		response.setContentType("text/plain");
		PrintWriter txtPrinter = response.getWriter();

		txtPrinter.print(txt);
		response.flushBuffer();
	}
	
	@RequestMapping("/listexcel")
	public void listexcel(HttpServletResponse response, searchDto dto) throws IOException {
		
		String option = dto.getSearchOption();
		String text = dto.getSearchText();
		List<myboardDto> list = new ArrayList<myboardDto>();
		
		if(option.equals("mytitle") ) {
			list = biz.searchtitle(text);
		} else if (option.equals("mycontent")) {
			list = biz.searchcontent(text);
		} else if (option.equals("myname")) {
			list = biz.searchname(text);
		}
		HSSFWorkbook objWorkBook = new HSSFWorkbook();
		HSSFSheet objSheet = null;
		HSSFRow objRow = null;
		HSSFCell objCell = null;

		HSSFFont font = objWorkBook.createFont();
		font.setFontHeightInPoints((short)9);
		font.setFontName("맑은고딕");
		
		HSSFCellStyle styleHd = objWorkBook.createCellStyle();
		styleHd.setFont(font);

		objSheet = objWorkBook.createSheet("첫번째 시트");
		// 1행
		objRow = objSheet.createRow(0);
		objRow.setHeight((short) 0x150);
	
		objCell = objRow.createCell(0);
		objCell.setCellValue("글번호");
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(1);
		objCell.setCellValue("작성자");
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(2);
		objCell.setCellValue("글제목");
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(3);
		objCell.setCellValue("작성일");
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(4);
		objCell.setCellValue("조회수");
		objCell.setCellStyle(styleHd);
		
		for (int i = 0; i < list.size(); i++) {
		
		objRow = objSheet.createRow(i+1);
		objRow.setHeight((short) 0x150);
		
		objCell = objRow.createCell(0);
		objCell.setCellValue(list.get(i).getMyno());
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(1);
		objCell.setCellValue(list.get(i).getMyname());
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(2);
		objCell.setCellValue(list.get(i).getMytitle());
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(3);
		objCell.setCellValue(list.get(i).getMydate());
		objCell.setCellStyle(styleHd);
		
		objCell = objRow.createCell(4);
		objCell.setCellValue(list.get(i).getReadcount());
		objCell.setCellStyle(styleHd);
		}
		
		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "ATTachment; Filename="+ URLEncoder.encode(dto.getSearchText() , "UTF-8")+ ".xls");
		
		OutputStream fileOut = response.getOutputStream();
		objWorkBook.write(fileOut);
		fileOut.close();
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
		
	}
	
	
	@RequestMapping(value="/listtxt.do")
	@ResponseBody
	public void listtext(HttpServletResponse response, searchDto dto) throws IOException {
		
		String option = dto.getSearchOption();
		String text = dto.getSearchText();
		List<myboardDto> list = new ArrayList<myboardDto>();
		
		if(option.equals("mytitle") ) {
			list = biz.searchtitle(text);
		} else if (option.equals("mycontent")) {
			list = biz.searchcontent(text);
		} else if (option.equals("myname")) {
			list = biz.searchname(text);
		}
		String txt = "";
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
		
			txt += "글번호 : " + list.get(i).getMyno() 
				+ "작성자 : " + list.get(i).getMyname() 
				+ "글제목 : " + list.get(i).getMytitle() 
				+ "작성일 : " + list.get(i).getMydate() 
				+ "조회수 : " + list.get(i).getReadcount() 
				+ "\n";

		}
		
		response.setHeader("Content-Disposition", "ATTachment; Filename="+ URLEncoder.encode(dto.getSearchText() , "UTF-8")+ ".txt");
		response.setContentType("text/plain");
		PrintWriter txtPrinter = response.getWriter();

		txtPrinter.print(txt);
		response.flushBuffer();
	}
	
	
}
