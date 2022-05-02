package carbon_emission_target.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

//import java.util.ArrayList;
//import java.util.List;

import carbon_emission_target.domain.Carbon_emission_target;
//import user.domain.Carbon_emission_target;

/**
 * DDL functions performed in database
 */
public class Carbon_emission_targetDao {
	  
	public static Carbon_emission_target findCarbon_emission_targetId(Integer cet_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Carbon_emission_target carbon_emission_target = new Carbon_emission_target();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
		    String sql = "select * from carbon_emission_target where cet_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    //System.out.println("ID CONTENT: " + id);
		    preparestatement.setInt(1,cet_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    System.out.println("RESULTSET CONTENTS: " + resultSet);
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	Integer id_ = Integer.parseInt(resultSet.getString("cet_id"));
		    	if(id_ == cet_id) {
		    		carbon_emission_target.setCet_id(id_);
		    		carbon_emission_target.setCity_id(Integer.parseInt(resultSet.getString("cet_city_id")));
		    		carbon_emission_target.setBase_year(Integer.parseInt(resultSet.getString("base_year")));
		    		carbon_emission_target.setBase_emission(Float.parseFloat(resultSet.getString("base_emission")));
		    		carbon_emission_target.setTarget_year(Integer.parseInt(resultSet.getString("target_year")));
		    		carbon_emission_target.setTarget_emission(Float.parseFloat(resultSet.getString("target_emission")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return carbon_emission_target;
	}	
	
	/**
	 * insert Country
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Carbon_emission_target form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "insert into carbon_emission_target (cet_id, cet_city_id, base_year, base_emission, target_year, target_emission) values(?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getCet_id());
		    preparestatement.setInt(2,form.getCity_id());
		    preparestatement.setInt(3,form.getBase_year());
		    preparestatement.setFloat(4,form.getBase_emission());
		    preparestatement.setInt(5,form.getTarget_year());
		    preparestatement.setFloat(6,form.getTarget_emission());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Carbon_emission_target form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "UPDATE carbon_emission_target SET cet_city_id = ?, base_year = ?, base_emission = ?, target_year = ?, target_emission = ? where cet_id = ?;";
			System.out.println("Update Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql);
		    preparestatement.setInt(1,form.getCity_id());
		    preparestatement.setInt(2,form.getBase_year());
		    preparestatement.setFloat(3,form.getBase_emission());
		    preparestatement.setInt(4,form.getTarget_year());
		    preparestatement.setFloat(5,form.getTarget_emission());
		    preparestatement.setInt(6,form.getCet_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findcarbon_emission_target() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			String sql = "select * from carbon_emission_target";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Carbon_emission_target carbon_emission_target = new Carbon_emission_target();
	    		carbon_emission_target.setCet_id(Integer.parseInt(resultSet.getString("cet_id")));
	    		carbon_emission_target.setCity_id(Integer.parseInt(resultSet.getString("cet_city_id")));
	    		carbon_emission_target.setBase_year(Integer.parseInt(resultSet.getString("base_year")));
	    		carbon_emission_target.setBase_emission(Float.parseFloat(resultSet.getString("base_emission")));
	    		carbon_emission_target.setTarget_year(Integer.parseInt(resultSet.getString("target_year")));
	    		carbon_emission_target.setTarget_emission(Float.parseFloat(resultSet.getString("target_emission")));
				list.add(carbon_emission_target);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public void delete(String cet_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to delete");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "delete from carbon_emission_target where cet_id = ?";
//			System.out.println(id);
//			System.out.println("Delete Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, Integer.parseInt(cet_id));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
