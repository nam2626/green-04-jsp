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
		
		List<StudentDTO1> list = mapper.selectAllStudent();
		
		for(StudentDTO1 dto : list)
			System.out.println(dto);
		
	}

}





