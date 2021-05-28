package Project;

import java.sql.*;

public class ConnectionProvider {
	public static Connection getcon()
	{
		try
		{

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Ankush","10080");
			
			return con;
		}
		catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

}
