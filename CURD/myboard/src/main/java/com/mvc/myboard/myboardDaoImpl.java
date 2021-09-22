package com.mvc.myboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class myboardDaoImpl implements myboardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<myboardDto> selectList() {
		List<myboardDto> list = new ArrayList<myboardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public myboardDto selectOne(int myno) {
		myboardDto dto = null;

		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public int insert(myboardDto dto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int update(myboardDto dto) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int readcount(int myno) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "readcount", myno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public List<myboardDto> searchtitle(String mytitle) {
		List<myboardDto> list = new ArrayList<myboardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "searchtitle", mytitle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<myboardDto> searchcontent(String mycontent) {
		List<myboardDto> list = new ArrayList<myboardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "searchcontent", mycontent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<myboardDto> searchname(String myname) {
		List<myboardDto> list = new ArrayList<myboardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "searchname", myname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int insertafter(String myname) {
		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "insertafter", myname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int listCnt() {
		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "listCnt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public List<myboardDto> listpaging(pagingDto dto) {
		List<myboardDto> list = new ArrayList<myboardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "listPage", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int titleCnt(String mytitle) {
		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "titleCnt", mytitle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int contentCnt(String mycontent) {
		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "contentCnt", mycontent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int nameCnt(String myname) {
		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "nameCnt", myname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}
	
	@Override
	public myboardDto pwChk(myboardDto dto) {
		myboardDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "pwChk", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return res;
	}
	
	@Override
	public List<myboardDto> pagingtitle(searchtitleDto dto){
		List<myboardDto> list = new ArrayList<myboardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "pagingtitle", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<myboardDto> pagingcontent(searchcontentDto dto){
		List<myboardDto> list = new ArrayList<myboardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "pagingcontent", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<myboardDto> pagingname(searchnameDto dto){
		List<myboardDto> list = new ArrayList<myboardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "pagingname", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
}
