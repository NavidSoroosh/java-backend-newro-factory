package persistence;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectMySQL {
	
	private static final ConnectMySQL INSTANCE = new ConnectMySQL();
	private final MysqlDataSource mysqlDS = new MysqlDataSource();

    private ConnectMySQL() {
    	String url = "jdbc:mysql://localhost:3306/newro-factory-db?characterEncoding=utf8";
    	String userName = "root";
    	String password = "standingHere";
    	
    	mysqlDS.setURL(url);
		mysqlDS.setUser(userName);
		mysqlDS.setPassword(password);
    }

    public static ConnectMySQL getInstance() {
        return INSTANCE;
    }

    Connection getConnection() throws SQLException {
        return mysqlDS.getConnection();
    }

}