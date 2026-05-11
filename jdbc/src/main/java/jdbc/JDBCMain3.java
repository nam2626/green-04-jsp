package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMain3 {
	public static final String DB_USER = "root";
	public static final String DB_PASSWD = "12345678";
	
	public static void main(String[] args) {
		try {
			// 1. DB 접속 - 접속 정보는 Connection으로 관리됨
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/car_db?" 
					+ "user="+DB_USER+"&password="+DB_PASSWD);
			System.out.println("DB 접속 완료");
			
			// 2. SQL문 생성
			String sql ="select * from cars where brand like ?";
			// 3. SQL을 실행할 객체 Statement 생성
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				// 4. SQL문에 데이터 셋팅
				pstmt.setString(1, "현대");
				// 5. SQL문 실행
				try(ResultSet rs = pstmt.executeQuery()){
					// 6. 데이터 확인
					while(rs.next()) {
						System.out.println(rs.getInt(1) 
								+ "," + rs.getString(2)
								+ "," + rs.getString(3)
								+ "," + rs.getInt(4)
								+ "," + rs.getInt(5)
								+ "," + rs.getInt(6)
								+ "," + rs.getString(7));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}







