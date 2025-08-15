package jdbcmysql;
import java.sql.*;
public class Student{

	    public static void main(String[] args)
	    {
	        // Database URL, username, and password
	 
	        // Replace with your database name
	        String url
	            = "jdbc:mysql://localhost:3306/java_selenium";
	 
	        // Replace with your MySQL username
	        String username = "root";
	 
	        // Replace with your MySQL password
	        String password = "Shabnam@2002";
	 
	        String creatTableqry="CREATE TABLE student (id INT, name VARCHAR(50))";
	        // Updated query syntax for modern databases
	        String query = "INSERT INTO student VALUES(1001, 'ABC'),(1002, 'DEF'),(1003, 'ZXY')";   
	        // Establish JDBC Connection
	        try {

	        	// Load MySQL Type-4 driver class
	            Class.forName("com.mysql.cj.jdbc.Driver");
	 
	            // Establish connection
	            Connection c = DriverManager.getConnection(url, username, password);
	 
	            // Create a statement
	            Statement st = c.createStatement();
	 
	            //CReate the table
	            st.executeUpdate(creatTableqry);
	            System.out.println("Table has been created successfully...");
	            // Execute the query
	            int count = st.executeUpdate(query);
	            System.out.println(
	                "Number of rows affected by this query: "
	                + count);
	            //Displaying thr student records
	            String selqry="select * from student";
	            ResultSet rs = st.executeQuery(selqry);
	            try {
	            		while(rs.next()) {
	            			System.out.println(rs.getInt("id")+","+rs.getString("name"));
	            		}
	            	}catch(SQLException ex) {
	            		ex.printStackTrace();
	            	}
	            // Close the connection
	            st.close();
	            c.close();
	            System.out.println("Connection closed.");
	        }
	        catch (ClassNotFoundException e) {
	            System.err.println("JDBC Driver not found: "
	                               + e.getMessage());
	        }
	        catch (SQLException e) {
	            System.err.println("SQL Error: "
	                               + e.getMessage());
	        }
	    }
	
}
