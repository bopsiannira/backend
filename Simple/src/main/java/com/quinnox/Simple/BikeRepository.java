package com.quinnox.Simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BikeRepository {

	
	//fetch
	public List<Bike> getallBikes() throws SQLException, ClassNotFoundException
	{
		Connection con = ConnectionFactory.getConnection();
		List<Bike> bike = new ArrayList<Bike>();
		String sql = "select * from bike";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) 
			{
				Bike b = new Bike();
				b.setBname(rs.getString(1));
				b.setModel(rs.getInt(2));
				b.setId(rs.getInt(3));

				bike.add(b);

			}
		
		return bike;
	}

	
	  public List<Bike> GetBikeonid(int id) throws ClassNotFoundException,
	  SQLException {
		  Connection con = ConnectionFactory.getConnection();
	  
	  String sql = "select * from bike WHERE id=" + id;
	  
	  
	  Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql);
	  List<Bike> bike = new ArrayList<Bike>(); while (rs.next()) {
	  
	  Bike str = new Bike();
	  
	  str.setBname(rs.getString("Bname")); str.setId(rs.getInt("id"));
	  str.setModel(rs.getInt("model"));
	  
	  } return bike;
	  
	  }
	 



	
	public void insertBike(Bike bike) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionFactory.getConnection();
	//	PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement("insert into fashion(id,type,item_name,item_price)values(?,?,?,?)");
	String sql = "INSERT INTO bike VALUES(?,?,?)";

		PreparedStatement preparedStmt = con.prepareStatement(sql);

		preparedStmt.setString(1, bike.getBname());
		preparedStmt.setInt(2, bike.getModel());
		preparedStmt.setInt(3, bike.getId());

		preparedStmt.executeUpdate();

	}
	
		
		
		  public void updateBike(Bike bike) throws Exception{
		  Connection con = ConnectionFactory.getConnection();
		  java.sql.PreparedStatement preparedStmt = con.prepareStatement("update bike set bname = ? where Id =? ");
//		  String sql = ("update Bike set bname =? where id=?");
//		  PreparedStatement preparedStmt = con.prepareStatement(sql);
		  preparedStmt.setString(1, bike.getBname()); 
//		  preparedStmt.setInt(2,bike.getModel());
		  preparedStmt.setInt(2, bike.getId());
//		  preparedStmt.executeUpdate();
		  int count = preparedStmt.executeUpdate();
		  System.out.print("updated count:"+count);
		  }
		  
			
		  	public void deletebike(int id) throws Exception { 
			  Connection con = ConnectionFactory.getConnection(); 
			  java.sql.PreparedStatement ps =con.prepareStatement("delete from bike where id = ? "); // String
			 // queryUpdate = "delete from bike where id = " + id;
			  // PreparedStatement ps  =con.prepareStatement(queryUpdate); 
			  ps.setInt(1, id); 
			  int count=ps.executeUpdate(); 
			  System.out.print("updated count:" +count); 
			  }		  
}
		 
	 

   

