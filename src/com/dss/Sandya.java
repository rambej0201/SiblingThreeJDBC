package com.dss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sandya {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//this program is about storing data of my third sibling, her husband & her daughters
		//I use oracle database and Java application to perform these operations
		
		//Step-1 loading the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Loading the driver");
		System.out.println("---------------------------");
		
		//Step-2 connecting with the database through connection object & DriverManager.getConnection()
		Connection axn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","R@m123");
		System.out.println("Application connected with the database");
		System.out.println("---------------------------");
		
		//Step-3 declaring/writing the queries 
		String n0 = "create table ONERAM.Sandya1(Name varchar2(40),Relation varchar2(40), SerialNumber number)";
		String n1 = "insert into ONERAM.Sandya1 values('Sandya Rani Bejjanki','Herself my third sister',1010)";
		String n2 = "insert into ONERAM.Sandya1 values('Gourishankar Timmaya Gari','her loving husband',2020)";
		String n3 = "insert into ONERAM.Sandya1 values('Sreeja Timmaya Gari','her first daughter',3030)";
		String n4 = "insert into ONERAM.Sandya1 values('Anvitha Timmaya Gari','her second daughter',4040)";
		String n5 = "select * from ONERAM.Sandya1";
		
		//step-4 executing the queries with Statement object and predefined execution methods
		Statement ment = axn.createStatement();
		
		int c0 = ment.executeUpdate(n0);
		int c1 = ment.executeUpdate(n1);
		int c2 = ment.executeUpdate(n2);
		int c3 = ment.executeUpdate(n3);
		int c4 = ment.executeUpdate(n4);
		
		ResultSet et = ment.executeQuery(n5);
		
		while (et.next()) {
			System.out.println(et.getString(1)+" is "+et.getString(2)+" and "+et.getString(3)+" is number");
		}
		//Step-5 closing the database connection
		axn.close();

	}

}
