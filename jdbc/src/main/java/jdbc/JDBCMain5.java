package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBManager;

/**
 * [JDBCMain5]
 * 역할: 직접 Connection을 만들지 않고, 미리 만들어둔 DBManager를 활용해 코드를 간결하게 만듭니다.
 */
public class JDBCMain5 {

	public static void main(String[] args) {
		// 실행할 SQL문
		String sql = "select * from students";
		
		// 1. [PreparedStatement 생성]
		// DBManager.getInstance().getConn() 을 통해 이미 준비된 통로를 바로 사용합니다.
		try(PreparedStatement pstmt = 
				DBManager.getInstance().getConn().prepareStatement(sql)){
			
			// 2. [SQL 실행]
			try(ResultSet rs = pstmt.executeQuery()){
				// 3. [데이터 확인]
				while(rs.next()) {
					// 학생 정보(학번, 이름, 학과, 평점 등)를 출력합니다.
					System.out.println(rs.getString(1) + "/" + rs.getString(2)
					+ "/" + rs.getString(3) + "/" + rs.getDouble(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}







