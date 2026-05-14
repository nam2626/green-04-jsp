package controller;

import java.io.IOException;

import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import view.ModelAndView;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
		
		//서비스 클래스로 전달
		int result = MemberService.getInstance().insertMember(
				new MemberDTO(0, id, passwd, name, nick));
		//결과를 받아서 페이지 이동
		if(result == 0) {
			//실패하면 이전페이지
			
			return null;
		}else {
			//성공하면 메인페이지
			return new ModelAndView("./main.do", true);
		}
	}

}
