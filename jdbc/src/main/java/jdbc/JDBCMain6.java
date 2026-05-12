package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import config.DBManager;

/**
 * [JDBCMain6]
 * 역할: 사용자로부터 입력을 받아 실시간으로 원하는 데이터를 검색(동적 쿼리)합니다.
 */
public class JDBCMain6 {

	public static void main(String[] args) {
		// 1. [사용자 입력 받기] - 키보드로 검색어를 입력받습니다.
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름 일부를 입력하세요: ");
		String name = sc.nextLine();

		// 2. [SQL문 작성] - concat을 사용하여 입력받은 이름이 포함된(%...%) 데이터를 찾습니다.
		String sql = "select * from students where name like concat('%', ? , '%')";

		// 3. [PreparedStatement 실행]
		try (PreparedStatement pstmt = 
				DBManager.getInstance().getConn().prepareStatement(sql)) {
			
			// 4. [파라미터 설정] - 사용자가 입력한 이름을 '?' 자리에 넣습니다.
			pstmt.setString(1, name);
			
			// 5. [결과 확인]
			try (ResultSet rs = pstmt.executeQuery()) {
				System.out.println("--- 검색 결과 ---");
				while (rs.next()) {
					System.out.println(
							rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getDouble(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close(); // 스캐너를 다 썼으면 닫아줍니다.
		}
	}

}
