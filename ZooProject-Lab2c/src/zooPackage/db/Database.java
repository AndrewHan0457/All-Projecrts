package zooPackage.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class Database {

	private Connection con=null;
	private Statement st=null;
	private ResultSet rs=null;

	public Database () {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/ZooManagement?"+"user=sqluser&password=sqluserpw&useSSL=false");
			st=con.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public HashMap<Integer,String> readZooRecords(){
		// we are using a string as second parameter here, but could also use a List<String> if we have to accommodate multiple columns
		HashMap<Integer,String> hMap=new HashMap<Integer,String>();
		try{
			String query="SELECT * FROM ZOOS";
			rs=st.executeQuery(query);
			while(rs.next()){
				hMap.put(rs.getInt("ID"),rs.getString("ZOONAME"));
			}
		}catch(Exception e){
			e.printStackTrace();
			return new HashMap<Integer,String>();
		} 
		return hMap;
	}
}
