package energy_management.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import energy_management.dao.Energy_managementDao;
import energy_management.domain.Energy_management;
//import entity1.service.Energy_managementService;

/**
 * Servlet implementation class UserServlet
 */

public class Energy_managementServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Energy_managementServletUpdate() {
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
		Energy_managementDao energy_managementdao = new Energy_managementDao();
		Energy_management energy_management = null;
		
		if(method.equals("search"))
		{
			try {
				energy_management = energy_managementdao.findById(Integer.parseInt(request.getParameter("em_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			Energy_managementService energy_managementService = new Energy_managementService();		
			if(energy_management.getEnergy_management()!=null){
				System.out.println("11");

						//System.out.println(energy_management);
						request.setAttribute("energy_management", energy_management);
						request.getRequestDispatcher("/jsps/energy_management/energy_management_update_output.jsp").forward(request, response);
					
				}
				else{
					
				request.setAttribute("msg", "Energy_management not found");
				request.getRequestDispatcher("/jsps/energy_management/energy_management_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Energy_management form = new Energy_management();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(name + ": " + Arrays.toString(values));
			}
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));
			
			form.setEm_id(Integer.parseInt(info.get(1)));
			form.setCity_id(Integer.parseInt(info.get(2)));
			form.setEnergy_production(Float.parseFloat(info.get(3)));	
			form.setEnergy_consumption(Float.parseFloat(info.get(4)));	
			form.setEnergy_management(Float.parseFloat(info.get(5)));	

			try {
				energy_managementdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Energy_management Updated");
			request.getRequestDispatcher("/jsps/energy_management/energy_management_read_output.jsp").forward(request, response);
		}
	}
}



