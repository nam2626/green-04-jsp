package controller;

import java.io.IOException;
import java.util.Scanner;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;
import vo.StudentVO;

/**
 * 이름을 입력받아 해당 학생 정보를 검색하여 출력하는 기능을 담당하는 컨트롤러
 */
public class StudentSearchForNameController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		
		StudentVO vo = StudentService.getInstance().searchStudentVOForName(name);
		request.setAttribute("vo", vo);
		
		return new ModelAndView("search_result", false);
	}
}






