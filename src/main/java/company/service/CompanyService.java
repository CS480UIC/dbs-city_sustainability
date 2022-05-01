package company.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import company.dao.CompanyDao;
import company.domain.Company;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class CompanyService {
	private CompanyDao companyDao = new CompanyDao();
	
	/**
	 * register a Country
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Company form) throws CompanyException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Country
		System.out.println("form.getId CONTENTS: " + form);
		Company company = CompanyDao.findCompanyId(form.getId());
		if(company.getId()!=null && company.getId().equals(form.getId())) throw new CompanyException("This company has been registered!");
		companyDao.add(form);
	}
	
	public List<Object> findcompany() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return companyDao.findcompany();
		
	}
	

}
