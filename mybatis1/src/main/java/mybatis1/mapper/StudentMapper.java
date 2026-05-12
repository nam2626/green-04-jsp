package mybatis1.mapper;

import java.util.List;

import mybatis1.dto.StudentDTO1;

public interface StudentMapper {
	public List<StudentDTO1> selectAllStudent();

	public List<StudentDTO1> selectForName(String name);

	public StudentDTO1 selectForNo(String no);

	public int insertStudent(StudentDTO1 dto);

	public int deleteStudent(String no);

	public int updateStudent(StudentDTO1 dto);
}
