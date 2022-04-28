package city.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import city.dao.CityDao;
import city.domain.City;
//import entity1.service.CityService;

/**
 * Servlet implementation class UserServlet
 */

public class CityServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServletUpdate() {
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
//
		String method = request.getParameter("method");
		CityDao citydao = new CityDao();
		City city = null;
		
		if(method.equals("search"))
		{
			try {
				city = citydao.findCityId(Integer.parseInt(request.getParameter("id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			CityService cityService = new CityService();		
			if(city.getCity_name()!=null){
				System.out.println("11");

						//System.out.println(city);
						request.setAttribute("city", city);
						request.getRequestDispatcher("/jsps/city/city_update_output.jsp").forward(request, response);
					
				}
				else{
					
				request.setAttribute("msg", "City not found");
				request.getRequestDispatcher("/jsps/city/city_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			City form = new City();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(name + ": " + Arrays.toString(values));
			}
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));
			
			form.setId(Integer.parseInt(info.get(1)));
			form.setCountry_id(Integer.parseInt(info.get(1)));
			form.setCity_name(info.get(2));
			form.setCity_population(Float.parseFloat(info.get(3)));
			form.setCity_density(Float.parseFloat(info.get(4)));	

			try {
				citydao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "City Updated");
			request.getRequestDispatcher("/jsps/city/city_read_output.jsp").forward(request, response);
		}
	}
}



