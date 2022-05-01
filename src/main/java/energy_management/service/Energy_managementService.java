package energy_management.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import energy_management.dao.Energy_managementDao;
import energy_management.domain.Energy_management;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class Energy_managementService {
	private Energy_managementDao energy_managementDao = new Energy_managementDao();
	
	/**
	 * register a Energy_management
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Energy_management form) throws Energy_managementException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Energy_management
		System.out.println("form.getId CONTENTS: " + form);
		Energy_management energy_management = Energy_managementDao.findById(form.getEm_id());
		if(energy_management.getEm_id()!=null && energy_management.getEm_id().equals(form.getEm_id())) throw new Energy_managementException("This energy_management has been registered!");
		energy_managementDao.add(form);
	}
	
	public List<Object> findenergy_management() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return energy_managementDao.findenergy_management();
		
	}
	

}
