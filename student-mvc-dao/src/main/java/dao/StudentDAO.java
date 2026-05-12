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

	private StudentDAO() {	}
	
	public static StudentDAO getInstance() {
		if(instance==null)
			instance = new StudentDAO();
		return instance;
	}
	
	// 전체 학생정보 조회는 메서드
	public ArrayList<StudentVO> selectAllStudent(){
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		
		// 1. SQL문작성
		String sql = "select * from students";
		// 2. PreparedStatement 생성
		try(PreparedStatement pstmt = 
				DBManager.getInstance().getConn().prepareStatement(sql)){
			// 3. SQL 실행
			try(ResultSet rs = pstmt.executeQuery()){
				// 4. 결과를 list에 저장
				while(rs.next()) {
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
	
	
}




