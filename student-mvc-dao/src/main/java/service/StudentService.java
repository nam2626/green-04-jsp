package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.StudentDAO;
import vo.StudentVO;

/**
 * 학생 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
 * 직접 DB를 건드리지 않고, StudentDAO에게 일을 시켜서 데이터를 가져옵니다.
 * "어떤 데이터를 어떻게 처리할지" 결정하는 중간 관리자 역할을 합니다.
 */
public class StudentService {
	// 싱글톤 패턴 적용
	private static StudentService instance = new StudentService();
	
	// 데이터를 실제로 관리할 DAO 객체
	private StudentDAO dao;
	
	private StudentService() {
		dao = StudentDAO.getInstance();
	}

	public static StudentService getInstance() {
		if (instance == null)
			instance = new StudentService();
		return instance;
	}
	
	/**
	 * 학번으로 학생 한 명의 정보를 찾아옵니다.
	 */
	public StudentVO searchStudentVO2(String no) {
		return dao.selectStudent(no);
	}

	/**
	 * 새로운 학생을 등록합니다.
	 */
	public boolean appendStudentVO(StudentVO vo) {
		return dao.insertStudent(vo) != 0;
	}

	/**
	 * 학번을 기준으로 학생을 삭제합니다.
	 */
	public boolean deleteStudentVO(String no) {
		return dao.deleteStudent(no) != 0;
	}

	/**
	 * 이름으로 학생 목록을 검색합니다.
	 */
	public ArrayList<StudentVO> searchStudentVOForName(String name) {
		return dao.selectForNameStudent(name);
	}

	/**
	 * 모든 학생의 목록을 가져옵니다.
	 */
	public ArrayList<StudentVO> selectAllStudent() {
		return dao.selectAllStudent();
	}

	/**
	 * 학생의 정보를 수정합니다.
	 */
	public void updateStudent(StudentVO studentVO) {
		dao.updateStudent(studentVO);		
	}
}






