package jdbcmysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementExample {

	static Connection con=null;
	public static void main(String[] args) throws Exception{
		try {
			String url="jdbc:mysql://localhost:3306/java_selenium";
			String username="root";
			String password="Shabnam@2002";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
	         // Establish connection
	         con = DriverManager.getConnection(url, username, password);

	         CallableStatement cstmt=con.prepareCall("{call myProcedure(?,?,?)}");
	         cstmt.setString(1, "Harry");
	         cstmt.setInt(2, 2000);
	         cstmt.setInt(3, 101);
	    
	         cstmt.setString(3,"Tom");
	         cstmt.setInt(1, 6000);
	         cstmt.setInt(3, 102);
	    
	         cstmt.setString(2, "Potter");
	         cstmt.setInt(1, 1000);
	         cstmt.setInt(3, 103);
	    
	         cstmt.execute();
	         System.out.println("Rows inserted ....");



			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
