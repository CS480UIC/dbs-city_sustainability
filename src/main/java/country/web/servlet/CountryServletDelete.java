package country.web.servlet;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

//import javax.jws.WebService;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import country.dao.CountryDao;
import country.domain.Country;
//import country.service.CountryException;
//import country.service.CountryService;
/**
 * Servlet implementation class UserServlet
 */

public class CountryServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryServletDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		CountryDao countrydao = new CountryDao();
		Country country = null;
		if(method.equals("search"))
		{
			try {
//				countrydao to CountryDao
				country = CountryDao.findById(Integer.parseInt(request.getParameter("id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			CountryService countryservice = new CountryService();		
			if(country.getId()!=null){
						System.out.println(country);
						request.setAttribute("country", country);
						request.getRequestDispatcher("/jsps/country/country_delete_output.jsp").forward(request, response);
					
				}
				else{
				request.setAttribute("msg", "Country not found");
				request.getRequestDispatcher("/jsps/country/country_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				countrydao.delete(request.getParameter("id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/country/country_read_output.jsp").forward(request, response);
		}
	}
}



