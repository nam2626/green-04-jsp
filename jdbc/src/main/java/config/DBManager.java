package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * [DBManager]
 * 역할: 데이터베이스(DB) 연결을 관리하는 '통로 보관소'입니다.
 * 특징: 싱글톤(Singleton) 패턴을 사용하여 프로그램 전체에서 단 하나의 연결 객체만 유지합니다.
 */
public class DBManager {
	// 1. 자기 자신을 미리 하나 만들어 둡니다. (싱글톤의 핵심)
	private static DBManager instance = new DBManager();
	
	// DB와 대화하기 위한 '전화선' 같은 객체입니다.
	private Connection conn;
	
	// 2. 생성자를 private으로 막아서 외부에서 'new DBManager()'를 못하게 합니다.
	private DBManager() {
		try {
			// [접속 시도] DriverManager를 통해 DB 마을에 있는 특정 주소로 전화를 겁니다.
			// jdbc:mysql://주소:포트/데이터베이스명, 사용자아이디, 비밀번호
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db",
					"root","12345678");
		} catch (SQLException e) {
			// 접속에 실패하면 왜 실패했는지 알려줍니다.
			e.printStackTrace();
		}
	}
	
	/**
	 * 이미 연결된 '전화선(Connection)'을 가져가는 메서드입니다.
	 */
	public Connection getConn() {
		return conn;
	}
	
	/**
	 * [싱글톤 객체 가져오기]
	 * 어디서든 DBManager.getInstance()를 호출하면 똑같은 하나의 관리자를 만날 수 있습니다.
	 */
	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		return instance;
	}
	
	
}
