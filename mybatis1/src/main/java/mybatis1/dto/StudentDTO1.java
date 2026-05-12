package mybatis1.dto;

public class StudentDTO1 {
	private String student_id;
	private String name;
	private String department;
	private double gpa;

	public StudentDTO1() {	}

	public StudentDTO1(String student_id, String name, String department, double gpa) {
		this.student_id = student_id;
		this.name = name;
		this.department = department;
		this.gpa = gpa;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "StudentDTO1 [student_id=" + student_id + ", name=" + name + ", department=" + department + ", gpa="
				+ gpa + "]";
	}
	
	
	
	
	
}
