package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

import java.io.IOException;

import controller.Controller;
import controller.HandlerMapping;

/**
 * 모든 요청(*.do)을 가장 먼저 받아서 중앙 통제하는 서블릿입니다.
 * 이를 '프론트 컨트롤러(Front Controller)' 패턴이라고 부릅니다.
 * 마치 입구에서 모든 방문객을 맞아 적절한 부서로 안내해주는 안내소와 같습니다.
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	/**
	 * 사용자의 모든 GET/POST 요청이 최종적으로 모이는 곳입니다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자가 어떤 주소로 요청했는지 확인합니다.
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		// 실제 명령어 부분만 추출합니다. (예: /student-mvc/main.do -> main.do)
		String path = uri.substring(contextPath.length()+1);
		
		System.out.println("요청 URI: " + uri);
		System.out.println("컨텍스트 경로: " + contextPath);
		System.out.println("추출된 명령어: " + path);
		
		// 2. HandlerMapping에게 이 요청을 처리할 담당자(컨트롤러)를 물어봅니다.
		Controller controller = HandlerMapping.getInstance().createController(path);
		
		// 3. 담당자가 결정되었다면, 실제로 일을 시킵니다(execute).
		// ModelAndView는 "어떤 데이터"를 가지고 "어느 페이지"로 갈지 정보를 담고 있습니다.
		ModelAndView view = null;
		if(controller != null)
			view = controller.execute(request, response);
		
		// 4. 담당자가 알려준 정보대로 다음 페이지로 이동합니다.
		if(view == null) {
			// 이동 정보가 없으면 메인 페이지로 보냅니다.
			response.sendRedirect(contextPath +"/main.do");
		}else {
			if(view.isRedirect()) {
				// 리다이렉트 방식: 아예 새로운 주소로 다시 접속하라고 사용자에게 시킵니다.
				response.sendRedirect(contextPath +"/" + view.getPath());
			}else {
				// 포워드 방식: 서버 내부에서 페이지를 전환합니다. 사용자는 주소 변화를 못 느낍니다.
				request.getRequestDispatcher(view.getPath()).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식 요청도 동일하게 처리하기 위해 doGet으로 넘깁니다.
		doGet(request, response);
	}

}
