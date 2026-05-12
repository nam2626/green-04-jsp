package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

/**
 * 모든 컨트롤러 클래스들이 반드시 구현해야 하는 인터페이스입니다.
 * 이 인터페이스를 구현함으로써 모든 컨트롤러가 동일한 형태(execute 메소드)를 갖게 되어,
 * 일관된 방식으로 실행할 수 있게 도와줍니다.
 */
public interface Controller {
	/**
	 * 사용자의 요청을 실제로 처리하는 메소드입니다.
	 * @param request 사용자가 보낸 요청 정보가 담긴 객체
	 * @param response 서버가 사용자에게 보낼 응답 정보가 담길 객체
	 * @return 처리가 끝난 후 어디로 이동할지와 데이터를 담은 ModelAndView 객체
	 * @throws IOException 입출력 관련 오류 발생 시 예외 처리
	 */
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
