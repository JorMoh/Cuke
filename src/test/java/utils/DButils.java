package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DButils {

	private static String dbHostName = DataReader.getData("dbhosturl");
	private static String username = DataReader.getData("dbusername");
	private static String password = DataReader.getData("dbpassword");
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	private ResultSetMetaData rsmd;
	
	// this function accepts an sql query and gets the record.
	public List<String> selectArecord(String query){
		List<String> list = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(dbHostName, username, password);
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			rsmd = resultset.getMetaData();
			if(resultset.next()==true) {
		    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
		    	list.add(resultset.getString(i));
			}}
		    connection.close();
		} catch (SQLException e) {
			System.out.println("DB connection Not established.");
			e.printStackTrace();
		}
		return list;
 	}
	
	// This function accepts and inserts an SQL query and inserts a record.
	public void insertRecord(String insertQuery) {
		try {
			connection = DriverManager.getConnection(dbHostName, username, password);
			System.out.println("DB connection established.");
			statement = connection.createStatement();
			statement.executeUpdate(insertQuery);
			connection.close();
		} catch (SQLException e) {
			System.out.println("DB connection Not established.");
			e.printStackTrace();
		}
	}
	
	// This function accepts and updates n SQL query and updates it.
	public void updateRecord(String updateQuery) {
		try {
			connection = DriverManager.getConnection(dbHostName, username, password);
			System.out.println("DB connection established.");
			statement = connection.createStatement();
			statement.executeUpdate(updateQuery);
			connection.close();
		} catch (SQLException e) {
			System.out.println("DB connection Not established.");
			e.printStackTrace();
		}
	}
	
	// this function accepts a delete sql query and deletes it.
	public void deleteRecord(String deleteQuery) {
		try {
			connection = DriverManager.getConnection(dbHostName, username, password);
			System.out.println("DB connection established.");
			statement = connection.createStatement();
			statement.executeUpdate(deleteQuery);
			connection.close();
		} catch (SQLException e) {
			System.out.println("DB connection Not established.");
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) {
//		String query = "SELECT id, name, email, phone FROM customers where name='John Smith'";
//		try {
//			Connection connect = DriverManager.getConnection(dbHostName, username, password);
//			System.out.println("Connection is successful:");
//			Statement statement = connect.createStatement();
//			ResultSet resultset = statement.executeQuery(query);
//			ResultSetMetaData rsmd = resultset.getMetaData();
//			
//			resultset.next();
//			
//			System.out.println("First index is id: " + resultset.getString(1));
//			System.out.println("Column name for 3rd column is: " + rsmd.getColumnName(3));
//			
//			
//			System.out.println("Column count is: " + rsmd.getColumnCount());
//			
//			List<String> johnsmith = new ArrayList<>();
//			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//				johnsmith.add(resultset.getString(i));
//			}
//			
//			for (String str : johnsmith) {
//				System.out.println(str);
//			}
//			connect.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}










}
