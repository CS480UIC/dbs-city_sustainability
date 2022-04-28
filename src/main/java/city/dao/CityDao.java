package city.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import city.domain.City;
//import user.domain.City;

/**
 * DDL functions performed in database
 */
public class CityDao {

	public static City findCityId(Integer id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		City city = new City();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
		    String sql = "select * from city where id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    //System.out.println("ID CONTENT: " + id);
		    preparestatement.setInt(1,id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    System.out.println("RESULTSET CONTENTS: " + resultSet);
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	Integer id_ = Integer.parseInt(resultSet.getString("id"));
		    	if(id_ == id) {
		    		city.setId(id_);
		    		city.setCountry_id(Integer.parseInt(resultSet.getString("country_id")));
		    		city.setCity_name(resultSet.getString("city_name"));
		    		city.setCity_population(Float.parseFloat(resultSet.getString("city_population")));
		    		city.setCity_density(Float.parseFloat(resultSet.getString("city_density")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return city;
	}	
	
	/**
	 * insert Country
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(City form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "insert into city (id, country_id, city_name, city_population, city_density) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getId());
		    preparestatement.setInt(2,form.getCountry_id());
		    preparestatement.setString(3,form.getCity_name());
		    preparestatement.setFloat(4,form.getCity_population());
		    preparestatement.setFloat(5,form.getCity_density());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(City form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "UPDATE city SET city_name = ?, city_population = ?, city_density = ? where id = ?;";
			System.out.println("Update Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCity_name());
			preparestatement.setFloat(2,form.getCity_population());
			preparestatement.setFloat(3,form.getCity_density());
		    preparestatement.setInt(4,form.getId());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findcity() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			String sql = "select * from simple_city";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				City city = new City();
				city.setId(Integer.parseInt(resultSet.getString("id")));
				city.setCountry_id(Integer.parseInt(resultSet.getString("country_id")));
	    		city.setCity_name(resultSet.getString("city_name"));
	    		city.setCity_population(Float.parseFloat(resultSet.getString("city_population")));
	    		city.setCity_density(Float.parseFloat(resultSet.getString("city_density")));
	    		list.add(city);
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
			
			String sql = "delete from city where id = ?";
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
