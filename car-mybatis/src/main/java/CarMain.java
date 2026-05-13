import java.util.List;

import dto.CarDTO;
import service.CarService;

public class CarMain {

	public static void main(String[] args) {
		CarService service = CarService.getInstance();
		//자동차 전체 조회
		List<CarDTO> list = service.selectAllCar();
		list.forEach(item -> System.out.println(item));
		//자동차 데이터 추가
		
		//자동차 데이터 삭제
		
		//자동차 데이터 수정
		
		//자동차 제조사명으로 검색
		
		//제조사별 자동차 모델 개수
		
		//2022~2025 자동차 데이터 조회
		
	}

}
