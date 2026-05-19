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
 * 게시글의 '좋아요' 기능을 처리하는 컨트롤러입니다.
 * 사용자가 좋아요 버튼을 누르면 이 컨트롤러가 실행됩니다.
 * AJAX 통신으로 호출되므로 화면 이동 없이 JSON 데이터만 응답합니다.
 */
public class BoardLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트가 보낸 게시글 번호(bno)를 숫자로 변환해서 받습니다.
		int bno =  Integer.parseInt(request.getParameter("bno"));
		
		// 2. 현재 로그인한 사용자의 정보를 세션에서 가져옵니다.
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("user");
		
		// 3. 처리 결과(메시지, 성공여부 등)를 담을 맵(Map)을 만듭니다.
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if(member == null) {
			// 4-1. 로그인하지 않은 상태면 경고 메시지를 설정합니다.
			map.put("resultCode", 1);
			map.put("msg", "로그인 하셔야 이용하실 수 있습니다.");
		}else {
			// 4-2. 로그인한 상태면 좋아요 처리를 시작합니다.
			map.put("resultCode", 0);
			try {
				// 좋아요 등록을 시도합니다. (DB에 데이터 추가)
				BoardService.getInstance().insertBoardLike(member.getNo(), bno);
				map.put("msg", "해당 게시글에 좋아요를 하셨습니다");
			}catch (Exception e) {
				// 이미 좋아요를 한 상태라 등록 시 오류(중복 에러 등)가 발생하면, 
				// 반대로 좋아요를 취소(삭제)합니다.
				BoardService.getInstance().deleteBoardLike(member.getNo(), bno);
				map.put("msg", "해당 게시글에 좋아요를 취소 하셨습니다");
			}
			// 좋아요 등록 또는 취소 후, 최신 좋아요 총 개수를 다시 조회합니다.
			int count = BoardService.getInstance().selectBoardLikeCount(bno);
			map.put("count", count); // 화면에 표시할 수 있게 맵에 담습니다.
		}
		
		// 5. 만들어진 결과 데이터(Map)를 JSON 형식의 문자열로 바꿉니다.
		JSONObject json = new JSONObject(map);
		
		// 6. 브라우저로 JSON 데이터를 보냅니다.
		response.getWriter().println(json);
		
		// 화면 이동이 없으므로 null을 반환합니다.
		return null;
	}

}
