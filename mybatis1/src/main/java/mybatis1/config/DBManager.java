package mybatis1.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager {
	private static DBManager instance = new DBManager();

	private SqlSessionFactory sqlSessionFactory;
	
	private DBManager() {
		String resource = "org/mybatis/example/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		return instance;
	}
	
}
