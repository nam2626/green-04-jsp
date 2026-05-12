package vo;

import java.util.Objects;

/**
 * 학생 한 명의 정보를 담는 바구니(객체) 역할을 하는 클래스입니다.
 * 이를 VO(Value Object) 또는 DTO(Data Transfer Object)라고 부릅니다.
 */
public class StudentVO {
	// 학생의 속성들 (데이터)
	private final String no;    // 학번 (한 번 정해지면 바뀌지 않도록 처리)
	private String name;        // 이름
	private String majorName;   // 학과명
	private double score;       // 평점

	/**
	 * 학생 객체를 처음 만들 때 사용하는 생성자입니다.
	 */
	public StudentVO(String no, String name, String majorName, double score) {
		this.no = no;
		this.name = name;
		this.majorName = majorName;
		this.score = score;
	}
	
	/**
	 * 학번을 제외한 나머지 정보를 한꺼번에 수정할 때 사용합니다.
	 */
	public void updateStudentVO(String name, String majorName, double score) {
		this.name = name;
		this.majorName = majorName;
		this.score = score;
	}
	
	/**
	 * 학생의 정보를 콘솔창에 한 줄로 예쁘게 출력해봅니다.
	 */
	public void printInfo() {
		System.out.println(no + " " + name + " " + majorName + " " + score);
	}
	
	// 각 데이터에 접근하거나 값을 넣기 위한 Getter와 Setter들입니다.
	
	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * 객체를 구분하기 위한 고유한 번호(해시코드)를 학번 기준으로 만듭니다.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(no);
	}

	/**
	 * 두 학생 객체가 "같은 학생"인지 비교할 때 학번을 기준으로 판단하도록 설정합니다.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StudentVO))
			return false;
		StudentVO temp = (StudentVO) obj;
		return no.equals(temp.no);
	}
}




