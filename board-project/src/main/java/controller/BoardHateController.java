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
 * 게시글의 '싫어요' 기능을 처리하는 컨트롤러입니다.
 * AJAX 통신으로 호출되며, 처리 결과를 JSON 형태로 응답합니다.
 */
public class BoardHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 처리 결과를 담을 Map을 만듭니다.
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		// 2. 파라미터로 넘어온 게시글 번호(bno)를 받습니다.
		int bno = Integer.parseInt(request.getParameter("bno"));
		int mno = 0;
		
		try {
			// 3. 현재 로그인한 사용자의 정보를 세션에서 가져옵니다.
			mno = ((MemberDTO)request.getSession().getAttribute("user")).getNo();
			map.put("resultCode", 0);
			try {
				// 4. 싫어요 등록을 시도합니다. (중복이면 Exception 발생)
				BoardService.getInstance().insertBoardHate(mno, bno);
				map.put("msg", "해당 게시글에 싫어요를 하셨습니다");
			} catch (Exception e) {
				// 5. 이미 싫어요를 한 상태면 취소 처리합니다.
				BoardService.getInstance().deleteBoardHate(mno, bno);
				map.put("msg", "해당 게시글에 싫어요를 취소 하셨습니다");
			}
			// 6. 처리 후 최신 싫어요 총 개수를 조회하여 응답에 포함합니다.
			int count = BoardService.getInstance().selectBoardHateCount(bno);
			map.put("count", count);
			
		}catch (Exception e) {
			// 7. 로그인하지 않은 상태면 에러 메시지를 설정합니다.
			map.put("resultCode", 1);
			map.put("msg", "로그인 하셔야 이용하실 수 있습니다.");
		}
		
		// 8. Map 데이터를 JSON으로 변환하여 클라이언트로 보냅니다.
		JSONObject json = new JSONObject(map);
		response.getWriter().println(json);

		// AJAX 요청이므로 null을 반환합니다.
		return null;
	}

}
