package controller;

/**
 * 사용자의 메뉴 선택(URL)에 따라 어떤 컨트롤러 객체를 사용할지 결정해주는 클래스입니다.
 * 싱글톤 패턴으로 구현되어 프로그램 전체에서 하나의 매핑 정보만 관리합니다.
 * "어떤 요청(주소)이 들어오면 어떤 일을 할 담당자(컨트롤러)를 배정할지" 결정하는 안내데스크 같은 역할을 합니다.
 */
public class HandlerMapping {
	// 자기 자신의 인스턴스를 하나만 생성하여 공유합니다.
	private static HandlerMapping instance = new HandlerMapping();

	// 외부에서 직접 생성하지 못하도록 생성자를 private으로 막아둡니다.
	private HandlerMapping() {
	}

	// 생성된 단 하나의 매핑 객체를 가져오는 메소드입니다.
	public static HandlerMapping getInstance() {
		if (instance == null)
			instance = new HandlerMapping();
		return instance;
	}

	/**
	 * 들어온 명령어(주소)에 맞는 컨트롤러를 찾아서 생성해주는 공장 역할을 합니다.
	 * @param command 사용자가 요청한 주소 (예: main.do, insert.do 등)
	 * @return 해당 요청을 처리할 구체적인 컨트롤러 객체
	 */
	public Controller createController(String command) {
		Controller controller = null;
		switch (command) {
		case "main.do": // 메인 페이지 요청 시
			controller = new StudentAllPrintController();
			break;
		case "insertView.do": // 등록 화면 요청 시
			controller = new StudentInertViewController();
			break;
		case "insert.do": // 실제 등록 처리 요청 시
			controller = new StudentInsertController();
			break;
		case "delete.do": // 삭제 요청 시
			controller = new StudentDeleteController();
			break;
		case "updateView.do": // 수정 화면 요청 시
			controller = new StudentUpdateViewController();
			break;
		case "update.do": // 실제 수정 처리 요청 시
			controller = new StudentUpdateController();
			break;
		case "search.do": // 이름 검색 요청 시
			controller = new StudentSearchForNameController();
			break;
		}
		return controller;
	}
}









