package lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Customer {
//	public static final String URL = "jdbc:mysql://rerun.it.uts.edu.au/sd03";
	public static final String URL = "jdbc:mysql://localhost:3306/persons?serverTimezone=UTC";

    public static final String USER = "root";
    public static final String PASSWORD = "password";
//    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
   	
    public static void main(String[] args) {
				// TODO Auto-generated method stub
//		try {
//	        Class.forName("com.mysql.jdbc.Driver");
//	    } catch (ClassNotFoundException e) {
//	        e.printStackTrace();
//	        System.exit(1);
//	    }
	    try
	    {
	    	Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );
	    	System.out.println("Connected!");
	    	Statement statement = connection.createStatement();
	       	ResultSet results = statement.executeQuery("SELECT * FROM students");
	    	int id =0;
	    	String ln="";
	    	String fn="";
	    	String address="";
	    	String city="";
	    	
	    	System.out.println("Id\tLastName\tFirstName\tAddress\tCity");
	    	while(results.next())
	    	{
	    		id = results.getInt("Id");
	    		ln = results.getString("LastName");
	    		fn = results.getString("FirstName");
	    		address = results.getString("Address");
	    		city = results.getString("City");

	    		System.out.println(id+"\t"+ln+"\t"+fn+"\t"+address+"\t"+city);
	       	}
	    	results.close();
	    	statement.close();
	    	connection.close();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    	
	    

	}

}
