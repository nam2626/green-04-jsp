package controller;

import java.io.IOException;

import dto.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import view.ModelAndView;

/**
 * 게시글 수정 화면으로 이동하기 위한 컨트롤러입니다.
 * 수정할 게시글의 기존 정보를 DB에서 가져와서 수정 폼에 채워넣는 역할을 합니다.
 */
public class BoardUpdateViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. URL 파라미터에서 수정할 게시글 번호(bno)를 가져옵니다.
		int bno = Integer.parseInt(request.getParameter("bno"));

		// 2. 서비스 클래스를 통해 DB에서 해당 게시글의 정보를 상세히 조회합니다.
		BoardDTO board = BoardService.getInstance().selectBoard(bno);
		
		// 3. 조회된 게시글 정보를 request 영역에 담아서 JSP로 전달합니다.
		request.setAttribute("board", board);
		
		// 4. 게시글 수정 화면(board_update.jsp)으로 포워드 방식으로 이동합니다.
		return new ModelAndView("board_update", false);
	}

}






