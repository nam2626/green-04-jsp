package controller;

import java.io.IOException;

import dto.BoardDTO;
import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import view.ModelAndView;

public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//로그인한 계정의 회원번호 읽어옴
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("user");
		int mno = member.getNo();
		//title, content
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO board = new BoardDTO();
		board.setMno(mno);
		board.setTitle(title);
		board.setContent(content);
		
		System.out.println(board);
		//파일 쓰기 처리
		
		//board, board_file 내용을 등록
		return null;
	}

}
