package controller;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BoardService;
import view.ModelAndView;

/**
 * 댓글의 '좋아요' 또는 '싫어요' 기능을 처리하는 컨트롤러입니다.
 * AJAX 통신으로 호출되며, 처리 결과를 JSON 형태로 응답합니다.
 */
public class BoardCommentLikeHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트가 보낸 댓글 번호(cno)와 모드(like/hate)를 받습니다.
		int cno = Integer.parseInt(request.getParameter("cno"));
		String mode = request.getParameter("mode");
		
		// 2. 현재 로그인한 사용자의 정보를 세션에서 확인합니다.
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("user");

		// 3. 처리 결과를 담을 Map을 생성합니다.
		HashMap<String, Object> map = new HashMap<String, Object>();

		if (member == null) {
			// 4-1. 로그인하지 않은 경우 에러 메시지를 설정합니다.
			map.put("resultCode", 1);
			map.put("msg", "로그인 하셔야 이용하실 수 있습니다.");
		} else {
			// 4-2. 로그인한 경우 좋아요/싫어요 처리를 진행합니다.
			map.put("resultCode", 0);
			try {
				// 좋아요/싫어요 등록을 시도합니다. (중복이면 Exception 발생)
				BoardService.getInstance()
					.insertBoardCommentLikeHate(member.getNo(), cno, mode);
				if(mode.equals("like")) {
					map.put("msg", "해당 댓글에 좋아요를 하셨습니다");
				}else {
					map.put("msg", "해당 댓글에 싫어요를 하셨습니다");
				}
			} catch (Exception e) {
				// 이미 클릭한 상태면 취소 처리를 진행합니다.
				BoardService.getInstance()
				.deleteBoardCommentLikeHate(member.getNo(), cno, mode);
				if(mode.equals("like")) {
					map.put("msg", "해당 댓글에 좋아요를 취소 하셨습니다");
				}else {
					map.put("msg", "해당 댓글에 싫어요를 취소 하셨습니다");
				}
			}
			// 처리 후 최신 좋아요/싫어요 개수를 다시 조회하여 화면에 반영할 수 있게 합니다.
			int count = BoardService.getInstance().selectBoardCommentLikeHateCount(cno,mode);
			map.put("count", count); 
		}

		// 5. 결과 데이터를 JSON 객체로 변환하여 응답 본문에 씁니다.
		JSONObject json = new JSONObject(map);
		response.getWriter().println(json);

		// AJAX 요청이므로 페이지 이동 정보(ModelAndView)는 null을 반환합니다.
		return null;
	}

}
