package country.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import country.domain.Country;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class CountryDao {

	public static Country findById(Integer id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Country country = new Country();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
		    String sql = "select * from country where id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    System.out.println("ID CONTENT: " + id);
		    preparestatement.setInt(1,id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    System.out.println("RESULTSET CONTENTS: " + resultSet);
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	Integer id_ = Integer.parseInt(resultSet.getString("id"));
		    	if(id_ == id) {
		    		country.setId(id_);
		    		country.setCountry_name(resultSet.getString("country_name"));
		    		country.setCountry_population(Float.parseFloat(resultSet.getString("country_population")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return country;
	}	
	
	/**
	 * insert Country
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Country form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "insert into country (id, country_name, country_population) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getId());
		    preparestatement.setString(2,form.getCountry_name());
		    preparestatement.setFloat(3,form.getCountry_population());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Country form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "UPDATE country SET country_name = ?, country_population = ? where id = ?;";
			System.out.println("Update Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCountry_name());
			preparestatement.setFloat(2,form.getCountry_population());
		    preparestatement.setInt(3,form.getId());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Object> findcountry() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			String sql = "select * from simple_country";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Country country = new Country();
				country.setId(Integer.parseInt(resultSet.getString("id")));
	    		country.setCountry_name(resultSet.getString("country_name"));
	    		country.setCountry_population(Float.parseFloat(resultSet.getString("country_population")));
	    		list.add(country);
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
			
			String sql = "delete from country where id = ?";
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
