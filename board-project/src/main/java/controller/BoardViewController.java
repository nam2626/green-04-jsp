package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.BoardFileDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BoardService;
import view.ModelAndView;

/**
 * 특정 게시글의 상세 내용을 보여주기 위한 컨트롤러입니다.
 * 목록에서 게시글을 클릭하면 이 컨트롤러가 실행되어 글 내용을 조회합니다.
 */
public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 조회할 게시글 글번호(bno)를 받아옵니다.
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 2. 글번호에 해당하는 게시글의 상세 정보(제목, 내용, 작성자 등)를 DB에서 받아옵니다.
		BoardDTO board = BoardService.getInstance().selectBoard(bno);
		
		// 3. 해당 게시글에 첨부된 파일 목록을 DB에서 받아옵니다.
		List<BoardFileDTO> flist = BoardService.getInstance().selectFileList(bno);
		
		// 4. 해당 게시글에 달린 댓글 목록을 받아옵니다.
		// (기본적으로 첫 페이지에 해당하는 댓글 5개만 먼저 읽어옵니다.)
		List<BoardCommentDTO> clist = 
				BoardService.getInstance().selectBoardCommentList(bno);
		
		
		// 5. 뷰(JSP) 화면에서 사용할 수 있도록 request 영역에 데이터를 저장합니다.
		request.setAttribute("board", board);
		request.setAttribute("flist", flist);
		request.setAttribute("clist", clist);
		
		System.out.println(clist);
		// 6. 조회수 증가 처리 (새로고침 시 조회수가 계속 오르는 것을 방지하기 위한 로직)
		HttpSession session = request.getSession();
		// 사용자가 어떤 글들을 읽었는지 기록하는 세트(HashSet: 중복을 허용하지 않음)를 가져옵니다.
		HashSet<Integer> set = (HashSet<Integer>) session.getAttribute("history");
		
		if(set == null) {
			// 처음 글을 읽는 경우라면 세트를 새로 만들어 세션에 저장합니다.
			set = new HashSet<Integer>();
			session.setAttribute("history", set);
		}
		
		// 세트에 현재 글번호를 추가해 봅니다. 
		// set.add(bno)는 처음 추가되는 값이면 true, 이미 있던 값이면 false를 반환합니다.
		if(set.add(bno)) {
			// 처음 읽는 글이라면 DB에서 조회수를 1 증가시킵니다.
			BoardService.getInstance().updateBoardCount(bno);
		}
		
		// 7. 조회한 데이터를 가지고 'board_view.jsp' 화면으로 이동(Forward)합니다.
		return new ModelAndView("board_view", false);
	}

}



