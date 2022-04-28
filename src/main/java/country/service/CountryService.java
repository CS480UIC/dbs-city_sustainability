package country.service;


import country.dao.CountryDao;
import country.domain.Country;

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
	public void create(Country form) throws CountryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Country
		System.out.println("form.getId CONTENTS: " + form);
		Country country = CountryDao.findById(form.getId());
		if(country.getId()!=null && country.getId().equals(form.getId())) throw new CountryException("This country has been registered!");
		countryDao.add(form);
	}
}
