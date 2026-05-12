package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * [JDBCMain3]
 * 역할: PreparedStatement를 사용하여 안전하고 효율적으로 검색하는 방법을 배웁니다.
 * 특징: SQL문에 '?'라는 구멍을 뚫어놓고 나중에 값을 채워 넣는 방식입니다.
 */
public class JDBCMain3 {
	public static final String DB_USER = "root";
	public static final String DB_PASSWD = "12345678";
	
	public static void main(String[] args) {
		try {
			// 1. [DB 접속] - Connection 생성
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/car_db?" 
					+ "user="+DB_USER+"&password="+DB_PASSWD);
			System.out.println("DB 접속 완료");
			
			// 2. [SQL문 작성] - 값이 들어갈 자리에 '?'를 넣습니다. (Pre-compile 방식)
			String sql ="select * from cars where brand like ?";
			
			// 3. [PreparedStatement 생성] - '?'가 포함된 SQL을 미리 준비시킨 심부름꾼입니다.
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				
				// 4. [값 채우기] - 첫 번째 '?' 자리에 "현대"라는 값을 넣습니다.
				// 1번부터 시작하며, 자료형에 맞춰 setString, setInt 등을 사용합니다.
				pstmt.setString(1, "현대");
				
				// 5. [SQL 실행] - 실행할 때는 SQL문을 다시 넘겨주지 않습니다. (이미 준비됐기 때문)
				try(ResultSet rs = pstmt.executeQuery()){
					// 6. [결과 확인] - 한 줄씩 읽어오기
					while(rs.next()) {
						System.out.println("결과: " + rs.getInt(1) 
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







