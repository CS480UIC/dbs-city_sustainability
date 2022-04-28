package country.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import country.dao.CountryDao;
import country.domain.City;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class CountryService {
	private CountryDao countryDao = new CountryDao();
	
	/**
	 * register a Country
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(City form) throws CountryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Country
		System.out.println("form.getId CONTENTS: " + form);
		City country = CountryDao.findById(form.getId());
		if(country.getId()!=null && country.getId().equals(form.getId())) throw new CountryException("This country has been registered!");
		countryDao.add(form);
	}
	
	public List<Object> findcountry() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return countryDao.findcountry();
		
	}
	

}
