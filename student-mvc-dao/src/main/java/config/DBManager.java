package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 데이터베이스(DB)와의 연결을 담당하는 클래스입니다.
 * DB 서버에 접속하기 위한 정보(주소, 아이디, 비밀번호)를 관리하고,
 * 실제 연결 통로(Connection)를 만들어주는 역할을 합니다.
 */
public class DBManager {
	// 싱글톤 패턴: 어디서든 하나의 연결 관리자만 사용하도록 합니다.
	private static DBManager instance = new DBManager();
	private Connection conn;
	
	private DBManager() {
		try {
			// 1. MySQL DB를 사용하기 위한 '드라이버'라는 도구를 로딩합니다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 실제 DB 서버에 접속합니다. (주소: student_db, 아이디: root, 비번: 12345678)
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db",
					"root","12345678");
			System.out.println("데이터베이스 연결에 성공했습니다!");
		} catch (SQLException e) {
			System.out.println("DB 연결 중 오류가 발생했습니다. 주소나 비번을 확인하세요.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}
	
	/**
	 * 만들어진 DB 연결 통로(Connection)를 꺼내주는 메소드입니다.
	 */
	public Connection getConn() {
		return conn;
	}
	
	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		return instance;
	}
}
