package waste_management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import waste_management.domain.Waste_management;
//import user.domain.User;

/**
 * DDL functions performed in database
 */
public class Waste_managementDao {

	public static Waste_management findById(Integer wm_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Waste_management waste_management = new Waste_management();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
		    String sql = "select * from waste_management where wm_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    System.out.println("ID CONTENT: " + wm_id);
		    preparestatement.setInt(1,wm_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //System.out.println("RESULTSET CONTENTS: " + resultSet);
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	Integer id_ = Integer.parseInt(resultSet.getString("wm_id"));
		    	if(id_ == wm_id) {
		    		waste_management.setWm_id(id_);
		    		waste_management.setCity_id(Integer.parseInt(resultSet.getString("wm_city_id")));
		    		waste_management.setPollution_rate(Float.parseFloat(resultSet.getString("pollution_rate")));
		    		waste_management.setRecycle_rate(Float.parseFloat(resultSet.getString("recycle_rate")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return waste_management;
	}	
	
	/**
	 * insert Waste_management
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Waste_management form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "insert into waste_management (wm_id, wm_city_id, pollution_rate, recycle_rate) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getWm_id());
		    preparestatement.setInt(2,form.getCity_id());
		    preparestatement.setFloat(3,form.getPollution_rate());
		    preparestatement.setFloat(4,form.getRecycle_rate());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Waste_management form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "UPDATE waste_management SET wm_city_id = ?, pollution_rate = ?, recycle_rate = ? where wm_id = ?;";
			System.out.println("Update Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getCity_id());
		    preparestatement.setFloat(2,form.getPollution_rate());
		    preparestatement.setFloat(3,form.getRecycle_rate());
		    preparestatement.setInt(4,form.getWm_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Object> findwaste_management() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			String sql = "select * from waste_management";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Waste_management waste_management = new Waste_management();
				waste_management.setWm_id(Integer.parseInt(resultSet.getString("wm_id")));
	    		waste_management.setCity_id(Integer.parseInt(resultSet.getString("wm_city_id")));
	    		waste_management.setPollution_rate(Float.parseFloat(resultSet.getString("pollution_rate")));
	    		waste_management.setRecycle_rate(Float.parseFloat(resultSet.getString("recycle_rate")));
				list.add(waste_management);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public void delete(String wm_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to delete");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "delete from waste_management where wm_id = ?";
//			System.out.println(wm_id);
//			System.out.println("Delete Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, Integer.parseInt(wm_id));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
