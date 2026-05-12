package mybatis1.mapper;

import java.util.List;

import mybatis1.dto.StudentDTO1;

public interface StudentMapper {
	public List<StudentDTO1> selectAllStudent();
}
