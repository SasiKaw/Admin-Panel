package skiLEarnHUB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminDB {
	
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	public AdminDB() {
		this.url = "jdbc:mysql://localhost:3306/skillearn_hub";
		this.username = "root";
		this.password = "";
	}
	
	public Connection connectDB() {
		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to the MYSQL server successfully");
			return connect;
			
			
		}catch(SQLException e) {
			System.out.println("Faild to connect to the MYSQL server" + e.getMessage());
			return null;
		}
	}
	
	public static void main(String[] args) {
		AdminDB db = new AdminDB();
		db.connectDB();
	}

}
