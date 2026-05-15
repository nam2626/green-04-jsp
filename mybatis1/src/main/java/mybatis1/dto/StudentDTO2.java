package mybatis1.dto;

public class StudentDTO2 {
	private String no;
	private String name;
	private String majorName;
	private double score;

	public StudentDTO2() {
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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

	@Override
	public String toString() {
		return "StudentDTO2 [no=" + no + ", name=" + name + ", majorName=" + majorName + ", score=" + score + "]";
	}
	
}
