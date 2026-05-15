package mybatis1.mapper;

import java.util.List;

import mybatis1.config.DBManager;
import mybatis1.dto.StudentDTO1;

public class StudentMapper2 {
	private DBManager manager;

	public StudentMapper2() {
		manager = DBManager.getInstance();
	}
	
	public List<StudentDTO1> selectAllStudent(){
		return manager.getSession().selectList("selectAllStudent");
	}
	
	public StudentDTO1 selectForNo(String no) {
		return manager.getSession().selectOne("selectForNo",no);
	}
	
	public int insertStudent(StudentDTO1 dto) {
		return manager.getSession().insert("insertStudent", dto);
	}
}










