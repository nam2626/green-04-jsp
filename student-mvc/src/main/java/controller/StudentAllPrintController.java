package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;
import vo.StudentVO;

/**
 * 모든 학생의 정보를 리스트로 가져와서 보여주는 역할을 하는 담당자(컨트롤러)입니다.
 */
public class StudentAllPrintController implements Controller {
	/**
	 * 학생 목록을 가져와서 화면에 전달하는 실제 일을 수행합니다.
	 */
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. 서비스 객체를 통해 전체 학생 목록 데이터를 가져옵니다.
		ArrayList<StudentVO> list = StudentService.getInstance().getList();
		
		// 2. 가져온 데이터를 'list'라는 이름으로 짐꾸러미(request)에 담습니다. 
		// 이렇게 담아둬야 나중에 JSP 페이지에서 꺼내 쓸 수 있습니다.
		request.setAttribute("list", list);
		
		// 3. 어디로 갈지(main.jsp), 어떤 방식(forward)으로 갈지 결정하여 보고합니다.
		// false는 forward 방식을 의미하며, "main"은 WEB-INF/views/main.jsp를 뜻하도록 설계되어 있습니다.
		ModelAndView view = new ModelAndView("main", false);		

		return view;
	}
}





