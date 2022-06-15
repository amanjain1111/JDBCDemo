package com.atcs.jdbcdemo;

import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class jdbcdemo {
	
	public static void main(String[] args) {
		// load the jdbc class file
		// add the jar files which contain all the file
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create a class for connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atcs2","root","root");
			if(con!=null) {
				System.out.println("Connected to Database");
				
				Statement st=con.createStatement();
				String query="select * from employee";
				String insertqueryString="Insert into employee values(4,'Akshit',25000,23)";
				String deletequery="delete from employee where id=3";
				String Updatequery="update employee set salary=25000 where id=1";
				st.execute(insertqueryString);
				st.execute(Updatequery);
				st.execute(deletequery);
				ResultSet rs=   st.executeQuery(query);
//				String query1="Insert into employee values(4,'Akshit',25000,23)";
//				ResultSet rs1=st.executeQuery(query1);
				
				while(rs.next()) {
					System.out.println("ID "+rs.getInt(1) +" name "+rs.getString(2)+ " salary "+rs.getString(3)+ " age "+rs.getInt(4));
				}
			}
			else {
				System.out.println("Not Connected !");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
