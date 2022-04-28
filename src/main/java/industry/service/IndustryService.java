package industry.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import industry.dao.IndustryDao;
import industry.domain.Industry;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class IndustryService {
	private IndustryDao industryDao = new IndustryDao();
	
	/**
	 * register a Industry
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Industry form) throws IndustryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Industry
		System.out.println("form.getId CONTENTS: " + form);
		Industry industry = IndustryDao.findIndustryId(form.getId());
		if(industry.getId()!=null && industry.getId().equals(form.getId())) throw new IndustryException("This industry has been registered!");
		industryDao.add(form);
	}
	
	public List<Object> findindustry() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return industryDao.findindustry();
		
	}
	

}
