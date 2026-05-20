package controller;

import java.io.IOException;

import dto.BoardCommentDTO;
import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

/**
 * 댓글 등록 요청을 처리하는 컨트롤러입니다.
 * 사용자가 입력한 댓글 내용을 DB에 저장하고 해당 게시글 상세 페이지로 돌아갑니다.
 */
public class BoardCommentInsertController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int mno = 0;
		ModelAndView view = null;
		try {
			// 1. 세션에서 현재 로그인한 사용자의 번호를 가져옵니다.
			// 로그인이 안 되어 있으면 NullPointerException이 발생할 수 있습니다.
			mno = ((MemberDTO)request.getSession().getAttribute("user")).getNo();
			
			// 2. 파라미터로 넘어온 게시글 번호(bno)와 댓글 내용(content)을 받습니다.
			int bno = Integer.parseInt(request.getParameter("bno"));
			String content = request.getParameter("content");
			
			// 3. 댓글 정보를 DTO 객체에 담습니다.
			BoardCommentDTO comment = new BoardCommentDTO();
			comment.setBno(bno);;
			comment.setContent(content);
			comment.setMno(mno);
			
			// 4. 서비스를 통해 DB에 댓글을 저장합니다.
			BoardService.getInstance().insertBoardComment(comment);
			
			// 5. 저장이 완료되면 다시 보던 게시글 상세 페이지로 리다이렉트합니다.
			view = new ModelAndView("./boardView.do?bno="+bno, true);
			
		}catch (NullPointerException e) {
			// 6. 로그인 세션이 만료되었거나 로그인을 안 한 경우 알림을 띄우고 로그인 화면으로 보냅니다.
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>");
			response.getWriter().println("alert('로그인 하셔야 이용하실 수 있습니다.');");
			response.getWriter().println("location.href='./loginView.do';");
			response.getWriter().println("</script>");			
		}
		
		return view;
	}

}




