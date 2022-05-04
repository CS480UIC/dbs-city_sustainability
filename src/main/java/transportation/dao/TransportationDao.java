package transportation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import transportation.domain.Transportation;
//import user.domain.User;

/**
 * DDL functions performed in database
 */
public class TransportationDao {

	public static Transportation findById(Integer idtransportation_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Transportation transportation = new Transportation();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
		    String sql = "select * from transportation where idtransportation_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    System.out.println("ID CONTENT: " + idtransportation_id);
		    preparestatement.setInt(1,idtransportation_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //System.out.println("RESULTSET CONTENTS: " + resultSet);
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	Integer id_ = Integer.parseInt(resultSet.getString("idtransportation_id"));
		    	if(id_ == idtransportation_id) {
		    		transportation.setIdtransportation_id(id_);
		    		transportation.setTarget_id(Integer.parseInt(resultSet.getString("target_id")));
		    		transportation.setCar_population(Float.parseFloat(resultSet.getString("car_population")));
		    		transportation.setCar_emission(Float.parseFloat(resultSet.getString("car_emission")));
		    		transportation.setPublic_usage(Float.parseFloat(resultSet.getString("public_usage")));
		    		transportation.setPublic_emission(Float.parseFloat(resultSet.getString("public_emission")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return transportation;
	}	
	
	/**
	 * insert Transportation
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Transportation form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "insert into transportation (idtransportation_id, target_id, car_population, car_emission, public_usage, public_emission) values(?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getIdtransportation_id());
		    preparestatement.setInt(2,form.getTarget_id());
		    preparestatement.setFloat(3,form.getCar_population());
		    preparestatement.setFloat(4,form.getCar_emission());
		    preparestatement.setFloat(5,form.getPublic_usage());
		    preparestatement.setFloat(6,form.getPublic_emission());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Transportation form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "UPDATE transportation SET target_id = ?, car_population = ?, car_emission = ?, public_usage = ?, public_emission = ? where idtransportation_id = ?;";
			System.out.println("Update Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getTarget_id());
		    preparestatement.setFloat(2,form.getCar_population());
		    preparestatement.setFloat(3,form.getCar_emission());
		    preparestatement.setFloat(4,form.getPublic_usage());
		    preparestatement.setFloat(5,form.getPublic_emission());
		    preparestatement.setInt(6,form.getIdtransportation_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Object> findtransportation() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			String sql = "select * from transportation";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Transportation transportation = new Transportation();
	    		transportation.setIdtransportation_id(Integer.parseInt(resultSet.getString("idtransportation_id")));
	    		transportation.setTarget_id(Integer.parseInt(resultSet.getString("target_id")));
	    		transportation.setCar_population(Float.parseFloat(resultSet.getString("car_population")));
	    		transportation.setCar_emission(Float.parseFloat(resultSet.getString("car_emission")));
	    		transportation.setPublic_usage(Float.parseFloat(resultSet.getString("public_usage")));
	    		transportation.setPublic_emission(Float.parseFloat(resultSet.getString("public_emission")));
				list.add(transportation);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public void delete(String idtransportation_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to delete");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "delete from transportation where idtransportation_id = ?";
//			System.out.println(idtransportation_id);
//			System.out.println("Delete Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, Integer.parseInt(idtransportation_id));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
