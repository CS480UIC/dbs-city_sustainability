package transportation.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transportation.dao.TransportationDao;
import transportation.domain.Transportation;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class TransportationService {
	private TransportationDao transportationDao = new TransportationDao();
	
	/**
	 * register a Transportation
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Transportation form) throws TransportationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Transportation
		System.out.println("form.getId CONTENTS: " + form);
		Transportation transportation = TransportationDao.findById(form.getIdtransportation_id());
		if(transportation.getIdtransportation_id()!=null && transportation.getIdtransportation_id().equals(form.getIdtransportation_id())) throw new TransportationException("This transportation has been registered!");
		transportationDao.add(form);
	}
	
	public List<Object> findtransportation() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return transportationDao.findtransportation();
		
	}
	

}
