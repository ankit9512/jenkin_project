package com.demo3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.demo3.entity.DemoEntity;

public class DemoDao implements DemoDaoInterface {
   private DemoDao(){}
	public static DemoDaoInterface createDaoObject() {
		// TODO Auto-generated method stub
		return new DemoDao();
	}

	@Override
	public int createDaoprofile(DemoEntity de) {
  int i=1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
			PreparedStatement ps=con.prepareStatement("insert into face values(?,?)");
			ps.setString(1, de.getUsername());
			ps.setString(2, de.getPassword());
			i=ps.executeUpdate();
			
		} catch (Exception e) {

		e.printStackTrace();
		
		}
		return i;
	}

}
