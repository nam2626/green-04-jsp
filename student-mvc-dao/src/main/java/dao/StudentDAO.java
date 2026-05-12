package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import vo.StudentVO;

/**
 * DAO(Data Access Object) 클래스입니다.
 * 실제로 데이터베이스에 접속해서 SQL문을 실행하고 데이터를 가져오거나 넣는 "DB 심부름꾼" 역할을 합니다.
 */
public class StudentDAO {
	// 싱글톤 패턴으로 구현
	private static StudentDAO instance = new StudentDAO();

	private StudentDAO() {
	}

	public static StudentDAO getInstance() {
		if (instance == null)
			instance = new StudentDAO();
		return instance;
	}

	/**
	 * 데이터베이스에서 모든 학생 정보를 가져오는 메소드입니다.
	 * @return 모든 학생 정보가 담긴 리스트
	 */
	public ArrayList<StudentVO> selectAllStudent() {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();

		// 1. 실행할 SQL문을 작성합니다.
		String sql = "select * from students";
		
		// 2. PreparedStatement를 이용해 SQL을 실행할 준비를 합니다.
		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			// 3. 쿼리를 실행하고 결과(ResultSet)를 받습니다.
			try (ResultSet rs = pstmt.executeQuery()) {
				// 4. 결과가 여러 줄일 수 있으므로 while문을 돌며 한 줄씩 읽습니다.
				while (rs.next()) {
					// DB에서 가져온 데이터를 StudentVO 객체에 담습니다.
					String no = rs.getString(1); // 첫 번째 컬럼(학번)
					String name = rs.getString(2); // 두 번째 컬럼(이름)
					String majorName = rs.getString(3); // 세 번째 컬럼(전공)
					double score = rs.getDouble(4); // 네 번째 컬럼(평점)
					list.add(new StudentVO(no, name, majorName, score));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 새로운 학생 정보를 데이터베이스에 저장합니다.
	 * @param vo 사용자가 입력한 학생 정보
	 * @return 저장된 행의 개수 (성공 시 1)
	 */
	public int insertStudent(StudentVO vo) {
		int result = 0;

		// ? 기호는 나중에 데이터를 채워넣을 구멍입니다.
		String sql = "insert into students(student_id,name,department,gpa) " + "values(?,?,?,?)";

		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			// 구멍(?)에 실제 데이터를 순서대로 채워넣습니다.
			pstmt.setString(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getMajorName());
			pstmt.setDouble(4, vo.getScore());
			
			// 쿼리를 실행(executeUpdate)하여 DB에 데이터를 넣습니다.
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 학번을 기준으로 학생 정보를 삭제합니다.
	 */
	public int deleteStudent(String no) {
		int result = 0;

		String sql = "delete from students where student_id = ?";

		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			pstmt.setString(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 학번을 입력받아 한 명의 학생 정보를 찾아옵니다.
	 */
	public StudentVO selectStudent(String no) {
		StudentVO vo = null;

		String sql = "select * from students where student_id = ?";
		try (PreparedStatement pstmt = 
				DBManager.getInstance().getConn().prepareStatement(sql)) {
			pstmt.setString(1, no);
			try (ResultSet rs = pstmt.executeQuery()) {
				// 한 명만 찾으면 되므로 if문을 사용합니다.
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
	
	/**
	 * 기존 학생의 정보를 수정합니다.
	 */
	public int updateStudent(StudentVO vo) {
		int result = 0;

		String sql = "update students set name=?, department=?, gpa=? "
				+ "where student_id = ?";

		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMajorName());
			pstmt.setDouble(3, vo.getScore());
			pstmt.setString(4, vo.getNo());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 이름을 검색어로 하여 학생 목록을 찾아옵니다. (부분 일치 검색)
	 */
	public ArrayList<StudentVO> selectForNameStudent(String name) {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();

		// LIKE 문을 사용해 검색어를 포함하는 이름을 찾습니다.
		String sql = "select * from students where name like concat('%',?,'%')";
		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			pstmt.setString(1, name);
			try (ResultSet rs = pstmt.executeQuery()) {
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








