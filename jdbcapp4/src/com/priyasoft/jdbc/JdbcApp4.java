package com.priyasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp4 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner scanner=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			st = con.createStatement();
			scanner = new Scanner(System.in);
			System.out.println("Bonus Amount :");
			int bonus=scanner.nextInt();
			System.out.println("Salary Range: ");
			float salRange = scanner.nextFloat();
			int rowCount=st.executeUpdate("Update emp1 set ESAL=ESAL+" +bonus+ "where ESAL <"+salRange);
			System.out.println("Employee Updated :"+rowCount);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
				scanner.close();
				st.close();
				con.close();
			}catch(Exception e)
			{
				 e.printStackTrace();
			}
		}

	}

}
