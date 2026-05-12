package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.StudentVO;

/**
 * 학생 데이터를 관리(저장, 검색)하는 핵심 서비스 클래스입니다.
 * 싱글톤 패턴을 적용하여 프로그램 전체에서 동일한 데이터 저장소(list)를 공유합니다.
 * 실제 데이터베이스 대신 메모리(ArrayList)에 학생 정보를 저장하고 관리합니다.
 */
public class StudentService {
	// 자기 자신의 인스턴스를 하나만 생성하여 유지합니다 (싱글톤)
	private static StudentService instance = new StudentService();
	
	// 학생 정보를 저장할 리스트 (메모리 상의 데이터베이스 역할)
	private ArrayList<StudentVO> list;
	
	/**
	 * 외부에서 직접 객체 생성을 못하도록 생성자를 private으로 설정합니다.
	 * 처음 객체가 생성될 때 초기 샘플 데이터를 넣습니다.
	 */
	private StudentService() {
		list = new ArrayList<StudentVO>();
		// 리스트에 샘플 데이터 초기화 (처음 실행 시 보여줄 기본 데이터들)
		list.add(new StudentVO("20230001", "홍길동", "컴퓨터공학과", 4.5));
		list.add( new StudentVO("20230002", "김철수", "경영학과", 3.8));
		list.add(new StudentVO("20230003", "이영희", "심리학과", 3.2));
		list.add(new StudentVO("20230004", "박영수", "생활체육학과", 4.0));
		list.add(new StudentVO("20230005", "최민수", "전자공학과", 3.5));
	}

	/**
	 * 프로그램 어디서든 동일한 서비스 객체를 가져가서 쓸 수 있도록 합니다.
	 */
	public static StudentService getInstance() {
		if (instance == null)
			instance = new StudentService();
		return instance;
	}
	
	/**
	 * 저장된 전체 학생 리스트를 가져옵니다.
	 */
	public ArrayList<StudentVO> getList() {
		return list;
	}

	/**
	 * 학번을 입력받아 리스트에서 해당 학생이 몇 번째 칸(인덱스)에 있는지 찾습니다.
	 * @param no 검색할 학번
	 * @return 찾으면 해당 인덱스(0, 1, 2...), 못 찾으면 -1
	 */
	public int searchStudentVO(String no) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo().equals(no))
				return i;
		}
		return -1;
	}

	/**
	 * 학번이 이미 존재하는지 확인합니다. (똑같은 학번의 학생이 두 명이면 안되니까요!)
	 * @param no 체크할 학번
	 * @return 이미 있으면 true, 없으면 false
	 */
	public boolean checkDuplicateStudent(String no) {
		return list.stream().filter(t -> t.getNo().equals(no)).count() != 0;
	}
	
	/**
	 * 학번을 기준으로 학생 객체 자체를 찾아옵니다.
	 */
	public StudentVO searchStudentVO2(String no) {
		int i = list.indexOf(new StudentVO(no, null, null, 0));
		return list.get(i);
	}

	/**
	 * 새로운 학생 정보를 리스트에 등록합니다.
	 * @param vo 사용자가 입력한 새로운 학생 정보
	 * @return 등록 성공하면 true, 중복된 학번이라 실패하면 false
	 */
	public boolean appendStudentVO(StudentVO vo) {
		// 학번이 중복되는지 먼저 검사합니다.
		if(checkDuplicateStudent(vo.getNo()))
			return false;
		return list.add(vo);
	}

	/**
	 * 학번을 입력받아 해당 학생을 리스트에서 지웁니다.
	 * @param no 삭제할 학생의 학번
	 * @return 성공하면 true, 해당 학생이 없으면 false
	 */
	public boolean deleteStudentVO(String no) {
		// 삭제할 학생이 리스트에 있는지 먼저 확인합니다.
		int i = StudentService.getInstance().searchStudentVO(no);

		if (i == -1) 
			return false;
		
		return list.remove(i) != null;
	}

	/**
	 * 학생 이름(또는 일부 검색어)을 입력받아 해당 학생을 찾습니다.
	 * @param name 검색할 이름
	 * @return 찾은 학생 객체 (없으면 null)
	 */
	public StudentVO searchStudentVOForName(String name) {
		for (int i = 0; i < list.size(); i++) {
			// 입력한 이름이 학생 이름에 포함되어 있는지 확인합니다.
			if (list.get(i).getName().indexOf(name) != -1) {
				return list.get(i);
			}
		}
		return null;
	}
}






