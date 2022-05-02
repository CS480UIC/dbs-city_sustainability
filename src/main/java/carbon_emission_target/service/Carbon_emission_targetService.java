package carbon_emission_target.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import carbon_emission_target.dao.Carbon_emission_targetDao;
import carbon_emission_target.domain.Carbon_emission_target;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class Carbon_emission_targetService {
	private Carbon_emission_targetDao carbon_emission_targetDao = new Carbon_emission_targetDao();
	
	/**
	 * register a Country
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Carbon_emission_target form) throws Carbon_emission_targetException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Country
		System.out.println("form.getId CONTENTS: " + form);
		Carbon_emission_target carbon_emission_target = Carbon_emission_targetDao.findCarbon_emission_targetId(form.getCet_id());
		if(carbon_emission_target.getCet_id()!=null && carbon_emission_target.getCet_id().equals(form.getCet_id())) throw new Carbon_emission_targetException("This carbon_emission_target has been registered!");
		carbon_emission_targetDao.add(form);
	}
	
	public List<Object> findcarbon_emission_target() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return carbon_emission_targetDao.findcarbon_emission_target();
		
	}
	

}
