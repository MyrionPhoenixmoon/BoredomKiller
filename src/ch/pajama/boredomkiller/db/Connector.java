package ch.pajama.boredomkiller.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connector {
	private Connection conn;
	private Properties connectionProps = new Properties();
	private String userName;
	private String password;
	private String ip;
	private int portNumber;
	 
	public Connector(String userName, String password, String ip, int portNumber){
		this.userName = userName;
		this.password = password;
		this.ip = ip;
		this.portNumber = portNumber;
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password); 
	}
	
	public Connection getConnection(){
		try{
			conn = DriverManager.getConnection("jdbc:mysql://" + this.ip + ":" + this.portNumber + "/", connectionProps);
			System.out.println("Connected to database :D");
			return conn;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
