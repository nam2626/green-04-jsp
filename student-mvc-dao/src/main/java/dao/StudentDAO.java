package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import vo.StudentVO;

// 데이터베이스에 데이터를 조작하는 클래스
public class StudentDAO {
	private static StudentDAO instance = new StudentDAO();

	private StudentDAO() {
	}

	public static StudentDAO getInstance() {
		if (instance == null)
			instance = new StudentDAO();
		return instance;
	}

	// 전체 학생정보 조회는 메서드
	public ArrayList<StudentVO> selectAllStudent() {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();

		// 1. SQL문작성
		String sql = "select * from students";
		// 2. PreparedStatement 생성
		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			// 3. SQL 실행
			try (ResultSet rs = pstmt.executeQuery()) {
				// 4. 결과를 list에 저장
				while (rs.next()) {
					String no = rs.getString(1);
					String name = rs.getString(2);
					String majorName = rs.getString(3);
					double score = rs.getDouble(4);
					list.add(new StudentVO(no, name, majorName, score));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int insertStudent(StudentVO vo) {
		int result = 0;

		String sql = "insert into students(student_id,name,department,gpa) " + "values(?,?,?,?)";

		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			// SQL에 데이터 셋팅
			pstmt.setString(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getMajorName());
			pstmt.setDouble(4, vo.getScore());
			// SQL 실행
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int deleteStudent(String no) {
		int result = 0;

		String sql = "delete from students where student_id = ?";

		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			// SQL에 데이터 셋팅
			pstmt.setString(1, no);
			// SQL 실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 학생정보 조회 - 학번
	public StudentVO selectStudent(String no) {
		StudentVO vo = null;

		String sql = "select * from students where student_id = ?";
		try (PreparedStatement pstmt = 
				DBManager.getInstance().getConn().prepareStatement(sql)) {
			pstmt.setString(1, no);
			try (ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					String name = rs.getString(2);
					String majorName = rs.getString(3);
					double score = rs.getDouble(4);
					vo = new StudentVO(no, name, majorName, score);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}
	
	//학생 정보 수정
	public int updateStudent(StudentVO vo) {
		int result = 0;

		String sql = "update students set name=?, department=?, gpa=? "
				+ "where student_id = ?";

		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			// SQL에 데이터 셋팅
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMajorName());
			pstmt.setDouble(3, vo.getScore());
			pstmt.setString(4, vo.getNo());
			// SQL 실행
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<StudentVO> selectForNameStudent(String name) {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();

		// 1. SQL문작성
		String sql = "select * from students where name like concat('%',?,'%')";
		// 2. PreparedStatement 생성
		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			pstmt.setString(1, name);
			// 3. SQL 실행
			try (ResultSet rs = pstmt.executeQuery()) {
				// 4. 결과를 list에 저장
				while (rs.next()) {
					String no = rs.getString(1);
					String sname = rs.getString(2);
					String majorName = rs.getString(3);
					double score = rs.getDouble(4);
					list.add(new StudentVO(no, sname, majorName, score));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}








