package controller;

/**
 * 사용자의 메뉴 선택(no)에 따라 적절한 컨트롤러 객체를 생성하여 반환하는 클래스 싱글톤 패턴으로 구현되어 프로그램 전체에서 하나의 매핑
 * 정보만 관리함
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		if (instance == null)
			instance = new HandlerMapping();
		return instance;
	}

	public Controller createController(String command) {
		Controller controller = null;
		switch (command) {
		case "main.do":
			controller = new MainController();
			break;
		case "registerView.do":
			controller = new MemberRegisterViewController();
			break;
		case "checkId.do":
			controller = new CheckIdController();
			break;
		case "register.do":
			controller = new RegisterController();
			break;
		case "login.do":
			controller = new LoginController();
			break;
		}
		return controller;
	}
}









