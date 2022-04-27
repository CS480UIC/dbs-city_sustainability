package company.service;


import company.dao.CompanyDao;
import company.domain.Company;

/**
 * logic functions such as register, login
 * @author Bryan Zbojna
 *
 */
public class CompanyService {
	private CompanyDao companyDao = new CompanyDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Company form) throws CompanyException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Entity1
		Company newCompany = CompanyDao.findByCompanyID(form.getCompanyID());
		if(newCompany.getCompanyID()!=null && newCompany.getCompanyID().equals(form.getCompanyID())) throw new CompanyException("This user name has been registered!");
		companyDao.add(form);
	}
}
