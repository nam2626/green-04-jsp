package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * [JDBCMain1]
 * 역할: JDBC를 사용하여 DB의 데이터를 처음으로 조회(SELECT)해보는 예제입니다.
 * 과정: 접속 -> 심부름꾼 생성 -> 질문지 작성 -> 결과 받기 -> 확인
 */
public class JDBCMain1 {
	// DB에 접속하기 위한 열쇠(ID, PW)입니다.
	public static final String DB_USER = "root";
	public static final String DB_PASSWD = "12345678";
	
	public static void main(String[] args) {
		try {
			// 1. [DB 접속] - DriverManager라는 안내원을 통해 DB와 연결되는 통로(Connection)를 만듭니다.
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/car_db?" 
					+ "user="+DB_USER+"&password="+DB_PASSWD);
			System.out.println("DB 접속 완료! 이제 데이터를 주고받을 수 있습니다.");
			
			// 2. [심부름꾼(Statement) 생성] - SQL이라는 편지를 DB에 전달해줄 심부름꾼 객체를 만듭니다.
			try(Statement stmt = conn.createStatement()){
				// 3. [SQL문 작성] - "자동차 테이블(cars)의 모든 데이터를 보여줘"라는 내용의 편지를 씁니다.
				String sql = "select * from cars";
				
				// 4. [SQL 실행 및 결과 담기] - 심부름꾼이 DB에 다녀온 결과를 ResultSet(결과 주머니)에 담아옵니다.
				// executeQuery는 주로 데이터를 '조회'할 때 사용합니다.
				try(ResultSet rs = stmt.executeQuery(sql)){
					
					// 5. [데이터 확인] - 결과 주머니에서 한 줄씩 꺼내서 확인합니다.
					// rs.next()는 다음 줄이 있으면 true를 반환하고, 그 줄로 커서를 옮깁니다.
					while(rs.next()) {
						// 컬럼 이름("car_id", "model")을 말해서 값을 꺼내옵니다.
						System.out.println("ID: " + rs.getInt("car_id") 
								+ ", 모델명: " + rs.getString("model"));
					}
				}
			}
		} catch (SQLException e) {
			// 문제가 생기면(오타, 접속 불가 등) 에러 내용을 출력합니다.
			e.printStackTrace();
		}
	}

}







