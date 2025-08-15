package jdbcmysql;

import java.sql.*;

public class StudentJDBC {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/java_selenium";
		
		String username="root";
		String password="Shabnam@2002";
		
		try(Connection con= DriverManager.getConnection(url, username, password);
				Statement st=con.createStatement()) {
					
			String createTable = """
				    CREATE TABLE Student2 (
				        id INT,
				        name VARCHAR(50),
				        age INT,
				        gender VARCHAR(10),
				        email VARCHAR(100),
				        phno VARCHAR(15),
				        address VARCHAR(100),
				        course VARCHAR(50)
				    )
				""";

			
			st.executeUpdate(createTable);
			System.out.println("Student Table Created Successfully");
			
			String insertData = """
				    INSERT INTO STUDENT2 (id, name, age, gender, email, phno, address, course)
				    VALUES
				    (1, 'Adam', 23, 'Male', 'adam@gmail.com', '987654325', 'New York', 'CS'),
				    (2, 'Scott', 24, 'Male', 'scott@gmail.com', '2365765736', 'USA', 'CS'),
				    (3, 'Allen', 22, 'Male', 'allen@gmail.com', '2222222222', 'India', 'IT'),
				    (4, 'Martin', 25, 'Male', 'martin@gmail.com', '5437895435', 'Denmark', 'CS'),
				    (5, 'Turner', 26, 'Male', 'turner@gmail.com', '2654846478', 'Bangalore', 'IT'),
				    (6, 'Steve', 23, 'Male', 'steve@gmail.com', '5677849488', 'New York', 'IT'),
				    (7, 'Jerry', 24, 'Male', 'jerry@gmail.com', '4567834567', 'Chennai', 'CS'),
				    (8, 'King', 22, 'Male', 'king@gmail.com', '9876523457', 'Israel', 'IT'),
				    (9, 'Bob', 25, 'Male', 'bob@gmail.com', '3456789765', 'India', 'CS'),
				    (10, 'Alice', 23, 'Female', 'alice@gmail.com', '3467890768', 'USA', 'IT')
				""";

			st.executeUpdate(insertData);
			System.out.println("10 records inserted in table student");
			
			String delete = "DELETE FROM STUDENT2 WHERE id IN (2,4)";
			st.executeUpdate(delete);
			System.out.println("Deleted records with id 2 and 4.");
			
			String update="UPDATE student2 SET name ='Tom ',address= 'England' WHERE id=5";
			st.executeUpdate(update);
			System.out.println("After updating record 5");
			
			
				}catch(SQLException e) {
					e.printStackTrace();
				}
	}

}
