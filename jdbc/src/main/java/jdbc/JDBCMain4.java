package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * [JDBCMain4]
 * 역할: 여러 개의 '?' 파라미터를 사용하고 범위 검색(BETWEEN)을 수행합니다.
 */
public class JDBCMain4 {
	public static final String DB_USER = "root";
	public static final String DB_PASSWD = "12345678";
	
	public static void main(String[] args) {
		try {
			// 1. [DB 접속] - Connection 생성
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/car_db?" 
					+ "user="+DB_USER+"&password="+DB_PASSWD);
			System.out.println("DB 접속 완료");
			
			// 2. [SQL문 작성] - 연식(year)이 특정 범위 사이에 있는 데이터를 찾습니다.
			// 구멍(?)이 두 개이므로 나중에 값을 두 번 채워줘야 합니다.
			String sql ="select * from cars where year between ? and ?";
			
			// 3. [PreparedStatement 생성]
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				
				// 4. [값 채우기] - 순서대로 1번, 2번 '?'에 값을 넣습니다.
				pstmt.setInt(1, 2022); // 시작 연도
				pstmt.setInt(2, 2024); // 종료 연도
				
				// 5. [SQL 실행]
				try(ResultSet rs = pstmt.executeQuery()){
					// 6. [데이터 확인]
					while(rs.next()) {
						System.out.println("조회 결과: " + rs.getInt(1) 
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







