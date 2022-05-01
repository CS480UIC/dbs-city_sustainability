package energy_management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import energy_management.domain.Energy_management;
//import user.domain.User;

/**
 * DDL functions performed in database
 */
public class Energy_managementDao {

	public static Energy_management findById(Integer em_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Energy_management energy_management = new Energy_management();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
		    String sql = "select * from energy_management where em_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    System.out.println("ID CONTENT: " + em_id);
		    preparestatement.setInt(1,em_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    System.out.println("RESULTSET CONTENTS: " + resultSet);
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	Integer id_ = Integer.parseInt(resultSet.getString("em_id"));
		    	if(id_ == em_id) {
		    		energy_management.setEm_id(id_);
		    		energy_management.setCity_id(Integer.parseInt(resultSet.getString("em_city_id")));
		    		energy_management.setEnergy_production(Float.parseFloat(resultSet.getString("energy_production")));
		    		energy_management.setEnergy_consumption(Float.parseFloat(resultSet.getString("energy_consumption")));
		    		energy_management.setEnergy_management(Float.parseFloat(resultSet.getString("energy_management")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return energy_management;
	}	
	
	/**
	 * insert Energy_management
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Energy_management form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "insert into energy_management (em_id, em_city_id, energy_production, energy_consumption, energy_management) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getEm_id());
		    preparestatement.setInt(2,form.getCity_id());
		    preparestatement.setFloat(3,form.getEnergy_production());
		    preparestatement.setFloat(4,form.getEnergy_consumption());
		    preparestatement.setFloat(5,form.getEnergy_management());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Energy_management form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "UPDATE energy_management SET em_city_id = ?, energy_production = ?, energy_consumption = ?, energy_management = ? where em_id = ?;";
			System.out.println("Update Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getCity_id());
		    preparestatement.setFloat(2,form.getEnergy_production());
		    preparestatement.setFloat(3,form.getEnergy_consumption());
		    preparestatement.setFloat(4,form.getEnergy_management());
		    preparestatement.setInt(5,form.getEm_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Object> findenergy_management() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			String sql = "select * from simple_energy_management";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Energy_management energy_management = new Energy_management();
				energy_management.setEm_id(Integer.parseInt(resultSet.getString("em_id")));
	    		energy_management.setCity_id(Integer.parseInt(resultSet.getString("em_city_id")));
	    		energy_management.setEnergy_production(Float.parseFloat(resultSet.getString("energy_production")));
	    		energy_management.setEnergy_consumption(Float.parseFloat(resultSet.getString("energy_consumption")));
	    		energy_management.setEnergy_management(Float.parseFloat(resultSet.getString("energy_management")));
				list.add(energy_management);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public void delete(String em_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to delete");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "delete from energy_management where em_id = ?";
//			System.out.println(em_id);
//			System.out.println("Delete Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, Integer.parseInt(em_id));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
