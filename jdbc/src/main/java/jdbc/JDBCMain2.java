package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * [JDBCMain2]
 * 역할: DB에 새로운 데이터를 추가(INSERT)하는 방법을 배웁니다.
 * 조회(SELECT)와는 달리 '몇 줄이 추가되었는지' 숫자로 결과를 받습니다.
 */
public class JDBCMain2 {
	public static final String DB_USER = "root";
	public static final String DB_PASSWD = "12345678";
	
	public static void main(String[] args) {
		try {
			// 1. [DB 접속] - Connection 통로를 열어줍니다.
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/car_db?" 
					+ "user="+DB_USER+"&password="+DB_PASSWD);
			System.out.println("DB 접속 완료");
			
			// 2. [심부름꾼(Statement) 생성] - SQL을 전달할 객체를 만듭니다.
			try(Statement stmt = conn.createStatement()){
				// 3. [SQL문 작성] - "cars 테이블에 소렌토 정보를 한 줄 추가해줘"라는 명령입니다.
				String sql = "insert into cars(brand,model,year,mileage,price,registered_at) "
						+ "values('현대','소렌토',2023,15000,25000000,'2026-01-01 00:00:00')";
				
				// 4. [SQL 실행] - executeUpdate는 '수정, 삭제, 추가'를 할 때 사용합니다.
				// 결과값(rows)은 DB에서 실제로 영향(추가)을 받은 줄의 개수입니다.
				int rows = stmt.executeUpdate(sql);
				System.out.println("성공! 총 " + rows + "건의 자동차 정보가 등록되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}







