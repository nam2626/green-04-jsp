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
 * 전체 학생 정보를 조회하여 출력하는 기능을 담당하는 컨트롤러
 */
public class StudentAllPrintController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ArrayList<StudentVO> list = StudentService.getInstance().getList();
		
		System.out.println("전체 학생정보를 조회합니다.............");
		
		for (StudentVO vo : list) {
			vo.printInfo();			
		}
	}
}





