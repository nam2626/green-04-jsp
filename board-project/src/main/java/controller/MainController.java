package controller;

import java.io.IOException;
import java.util.List;

import dto.BoardDTO;
import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import service.MemberService;
import view.ModelAndView;
import vo.PaggingVO;

/**
 * 메인 페이지(게시판 목록)를 보여주는 컨트롤러입니다.
 * 사용자가 처음 사이트에 들어오거나 '홈' 버튼을 누를 때 실행됩니다.
 */
public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. URL 파라미터에서 사용자가 요청한 페이지 번호를 읽어옵니다. (예: main.do?page=2)
		String pageNo = request.getParameter("page");
		
		// 2. 만약 페이지 번호가 안 들어왔다면 기본값인 1페이지로 설정합니다.
		int page = pageNo == null ? 1 : Integer.parseInt(pageNo);
		
		// 3. DB에 등록된 전체 게시글의 총 개수를 알아냅니다. (페이징 계산을 위함)
		int total = BoardService.getInstance().selectBoardCount();
		
		// 4. 전체 게시글 수와 현재 페이지 번호를 이용해 페이징 처리를 도와주는 객체를 만듭니다.
		PaggingVO pagging = new PaggingVO(total, page);
		
		// 5. 현재 페이지 번호에 해당하는 게시글 목록(보통 30개씩)만 DB에서 가져옵니다.
		List<BoardDTO> list = BoardService.getInstance().selectBoardList(page);
		
		// 6. 화면(JSP)에서 쓸 수 있도록 게시글 목록과 페이징 정보를 request에 담아둡니다.
		request.setAttribute("list", list);
		request.setAttribute("pagging", pagging);
		
		// 7. 게시판 목록을 보여줄 'main.jsp' 화면으로 이동(Forward)합니다.
		return new ModelAndView("main", false);
	}

}
