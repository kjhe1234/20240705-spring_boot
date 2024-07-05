package com.kjhe1234.member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.kjhe1234.member.dao.MemberDao;
import com.kjhe1234.member.dto.MemberDto;

@SpringBootTest
@TestPropertySource(locations = "classpath:application2.properties")
public class SqlTest {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	@DisplayName("모든 회원 목록 불러오기 테스트")
	public void memberList() {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		ArrayList<MemberDto> memberDtos = memberDao.memberListDao();
		
		for(MemberDto memberDto:memberDtos) {
			System.out.print(memberDto.getMid()+ "/"); // 아이디
			System.out.print(memberDto.getMpw()+ "/"); // 비밀번호
			System.out.print(memberDto.getMname()+ "/"); // 이름
			System.out.print(memberDto.getMemail()+ "/"); // 이메일
			System.out.print(memberDto.getMdate()+ "/ \n"); // 가입일
			System.out.print("-------------------------\n");
		}
		
	}
	
	@Test
	@DisplayName("회원 삭제 테스트")
	public void delete() {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		memberDao.deleteDao("tiger");
		
		memberList();
		
	}
	
	
	
	
	
	
	
	
}
