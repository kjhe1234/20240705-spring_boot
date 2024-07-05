package com.kjhe1234.member.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kjhe1234.member.dao.MemberDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/test")
	public String teset() {
		return "test";
	}

	@RequestMapping(value = "/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		
		int idCheck = memberDao.checkIdDao(request.getParameter("mid"));//아이디 존재여부->1 or 0
		
		if (idCheck == 0) {
			memberDao.joinDao(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("memail"));
			model.addAttribute("memberName", request.getParameter("mname"));
			return "joinOk";
		} else {
			model.addAttribute("joinFail", "이미 가입된 아이디입니다. 다시 입력해주세요.");
			return "join";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
