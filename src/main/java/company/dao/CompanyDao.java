package company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import company.domain.Company;
//import user.domain.Company;

/**
 * DDL functions performed in database
 */
public class CompanyDao {

	public static Company findCompanyId(Integer id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Company company = new Company();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
		    String sql = "select * from company where id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    //System.out.println("ID CONTENT: " + id);
		    preparestatement.setInt(1,id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    System.out.println("RESULTSET CONTENTS: " + resultSet);
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	Integer id_ = Integer.parseInt(resultSet.getString("id"));
		    	if(id_ == id) {
		    		company.setId(id_);
		    		company.setIndustry_id(Integer.parseInt(resultSet.getString("industry_id")));
		    		company.setCompany_name(resultSet.getString("company_name"));
		    		company.setCompany_emission(Float.parseFloat(resultSet.getString("company_emission")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return company;
	}	
	
	/**
	 * insert Country
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Company form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("We are here");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "insert into company (id, industry_id, company_name, company_emission) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getId());
		    preparestatement.setInt(2,form.getIndustry_id());
		    preparestatement.setString(3,form.getCompany_name());
		    preparestatement.setFloat(4,form.getCompany_emission());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Company form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Now going to update");
		System.out.println(form);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			
			String sql = "UPDATE company SET industry_id = ?, company_name = ?, company_emission = ? where id = ?;";
			System.out.println("Update Executed");
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1,form.getIndustry_id());
		    preparestatement.setString(2,form.getCompany_name());
			preparestatement.setFloat(3,form.getCompany_emission());
		    preparestatement.setInt(4,form.getId());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findcompany() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/city_sustainability", "city_sustainability", "Cps42973351");
			String sql = "select * from simple_company";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Company company = new Company();
				company.setId(Integer.parseInt(resultSet.getString("id")));
				company.setIndustry_id(Integer.parseInt(resultSet.getString("industry_id")));
	    		company.setCompany_name(resultSet.getString("company_name"));
	    		company.setCompany_emission(Float.parseFloat(resultSet.getString("company_emission")));
	    		list.add(company);
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
			
			String sql = "delete from company where id = ?";
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
