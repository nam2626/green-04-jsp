package mybatis1.main;

import java.util.List;

import mybatis1.config.DBManager;
import mybatis1.dto.StudentDTO1;
import mybatis1.mapper.StudentMapper;

public class TestMain {

	public static void main(String[] args) {
		//맵퍼 객체를 생성
		StudentMapper mapper = DBManager.getInstance()
				.getSession().getMapper(StudentMapper.class);
		// 전체 조회
//		List<StudentDTO1> list = mapper.selectAllStudent();
//		
//		for(StudentDTO1 dto : list)
//			System.out.println(dto);
		
//		String name = "재원";
//		List<StudentDTO1> list = mapper.selectForName(name);
//		
//		for(StudentDTO1 dto : list)
//			System.out.println(dto);
		
//		String no = "202299281";
//		//학번으로 학생정보 조회해서 출력
//		StudentDTO1 dto = mapper.selectForNo(no);//결과가 없으면 null
//		System.out.println(dto);
		
		//학생정보 한건 추가
		StudentDTO1 dto = new StudentDTO1("2222222","김철수","물리학과",3.5);
		int count = mapper.insertStudent(dto);
		System.out.println("결과 : " + count);
	}

}

















