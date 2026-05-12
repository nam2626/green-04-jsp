package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.StudentDAO;
import vo.StudentVO;

/**
 * 학생 데이터를 관리(저장, 검색)하는 핵심 서비스 클래스 싱글톤 패턴을 적용하여 프로그램 전체에서 동일한 데이터 저장소(arr)를 공유함
 */
public class StudentService {
	// 자기 자신의 인스턴스를 하나만 생성하여 유지함 (싱글톤)
	private static StudentService instance = new StudentService();
	
	private StudentDAO dao;
	
	/**
	 * 외부에서 직접 객체 생성을 못하도록 생성자를 private으로 설정
	 */
	private StudentService() {
		dao = StudentDAO.getInstance();
	}

	/**
	 * 어디서든 동일한 서비스 객체에 접근할 수 있도록 인스턴스를 반환하는 메서드
	 */
	public static StudentService getInstance() {
		if (instance == null)
			instance = new StudentService();
		return instance;
	}
		
	public StudentVO searchStudentVO2(String no) {
		return dao.selectStudent(no);
	}

	public boolean appendStudentVO(StudentVO vo) {
		return dao.insertStudent(vo) != 0;
	}

	/**
	 * 학번을 기준으로 학생 정보를 삭제하는 메서드
	 * @param no 삭제할 학번
	 * @return 삭제 성공 여부
	 */
	public boolean deleteStudentVO(String no) {
		return dao.deleteStudent(no) != 0;
	}

	/**
	 * 학생 이름을 키워드로 검색하여 일치하는 첫 번째 객체를 반환함
	 * (부분 일치 검색 지원)
	 * @param name 검색할 이름 (또는 키워드)
	 * @return 찾으면 StudentVO 객체, 못 찾으면 null
	 */
	public StudentVO searchStudentVOForName(String name) {
	
		return null;
	}

	public ArrayList<StudentVO> selectAllStudent() {
		return dao.selectAllStudent();
	}

	public void updateStudent(StudentVO studentVO) {
		dao.updateStudent(studentVO);		
	}
}






