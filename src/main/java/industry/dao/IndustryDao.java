package industry.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import industry.domain.Industry;
//import user.domain.User;

/**
 * DDL functions performed in database
 */
public class IndustryDao {

	public static Industry findIndustryId(Integer id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Industry industry = new Industry();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
		    String sql = "select * from industry where id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    //System.out.println("ID CONTENT: " + id);
		    preparestatement.setInt(1,id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    System.out.println("RESULTSET CONTENTS: " + resultSet);
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	Integer id_ = Integer.parseInt(resultSet.getString("id"));
		    	if(id_ == id) {
		    		industry.setId(id_);
		    		industry.setCountry_id(Integer.parseInt(resultSet.getString("country_id")));
		    		industry.setIndustry_type(resultSet.getString("industry_type"));
		    		industry.setIndustry_emission(Float.parseFloat(resultSet.getString("industry_emission")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
			
		}
		return industry;
	}	
	
	/**
	 * insert Industry
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Industry form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "insert into industry (id, country_id, industry_type, industry_emission) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getId());
		    preparestatement.setInt(2,form.getCountry_id());
		    preparestatement.setString(3,form.getIndustry_type());
		    preparestatement.setFloat(4,form.getIndustry_emission());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Industry form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "UPDATE industry SET country_id = ?, industry_type = ?, industry_emission = ? where id = ?;";
			System.out.println("Update Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setInt(1,form.getCountry_id());
		    preparestatement.setString(2,form.getIndustry_type());
			preparestatement.setFloat(3,form.getIndustry_emission());
		    preparestatement.setInt(4,form.getId());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findindustry() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			String sql = "select * from industry";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();		
			while(resultSet.next()){
				Industry industry = new Industry();
				industry.setId(Integer.parseInt(resultSet.getString("id")));
				industry.setCountry_id(Integer.parseInt(resultSet.getString("country_id")));
	    		industry.setIndustry_type(resultSet.getString("industry_type"));
	    		industry.setIndustry_emission(Float.parseFloat(resultSet.getString("industry_emission")));
	    		list.add(industry);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public void delete(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to delete");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "delete from industry where id = ?";
//			System.out.println(id);
//			System.out.println("Delete Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, Integer.parseInt(id));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
