package city.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import city.dao.CityDao;
import city.domain.City;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class CityService {
	private CityDao cityDao = new CityDao();
	
	/**
	 * register a Country
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(City form) throws CityException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Country
		System.out.println("form.getId CONTENTS: " + form);
		City city = CityDao.findCityId(form.getId());
		if(city.getId()!=null && city.getId().equals(form.getId())) throw new CityException("This city has been registered!");
		cityDao.add(form);
	}
	
	public List<Object> findcity() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return cityDao.findcity();
		
	}
	

}
