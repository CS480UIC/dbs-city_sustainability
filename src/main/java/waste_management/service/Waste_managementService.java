package waste_management.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import waste_management.dao.Waste_managementDao;
import waste_management.domain.Waste_management;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class Waste_managementService {
	private Waste_managementDao waste_managementDao = new Waste_managementDao();
	
	/**
	 * register a Waste_management
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Waste_management form) throws Waste_managementException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Waste_management
		System.out.println("form.getId CONTENTS: " + form);
		Waste_management waste_management = Waste_managementDao.findById(form.getWm_id());
		if(waste_management.getWm_id()!=null && waste_management.getWm_id().equals(form.getWm_id())) throw new Waste_managementException("This waste_management has been registered!");
		waste_managementDao.add(form);
	}
	
	public List<Object> findwaste_management() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return waste_managementDao.findwaste_management();
		
	}
	

}
