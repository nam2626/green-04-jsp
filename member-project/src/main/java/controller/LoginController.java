package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		MemberDTO member = MemberService.getInstance().login(id, passwd);
		
		if(member == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('로그인 실패 하셨습니다.\\n아이디와 비밀번호를 확인해 주세요');");
			pw.println("history.back();");
			pw.println("</script>");
			
			return null;
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			return new ModelAndView("./main.do", true);
		}
	}

}




