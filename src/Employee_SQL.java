import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee_SQL {
	
	static Connection getConnection() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver Registered");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ employee_project","root","abc123");
	System.out.println("Connection Successfully");
	return con;
	}
	
	static int insertData(int Id,String Name,String Salary) throws ClassNotFoundException, SQLException
	{
		Connection con=Employee_SQL.getConnection();
		Statement st=con.createStatement();
	int a=st.executeUpdate("INSERT INTO  employee_project.table VALUES("+Id+",'"+Name+"','"+Salary+"')");
	con.close();
	return a;
}
	// SHOW DATA ................
	
	static String show() throws ClassNotFoundException, SQLException
	{
		String record="";
		Connection con=Employee_SQL.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM employee_project.table ");
		while (rs.next()) 
		{
		record+=rs.getInt(1)+"\n";
		record+=rs.getString(2)+"\n";
		record+=rs.getString(3)+"\n";
		}
		con.close();
		return record; 
	}	
}
