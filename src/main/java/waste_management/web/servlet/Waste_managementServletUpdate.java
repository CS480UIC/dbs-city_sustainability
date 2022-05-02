package waste_management.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import waste_management.dao.Waste_managementDao;
import waste_management.domain.Waste_management;
//import entity1.service.Waste_managementService;

/**
 * Servlet implementation class UserServlet
 */

public class Waste_managementServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Waste_managementServletUpdate() {
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
		Waste_managementDao waste_managementdao = new Waste_managementDao();
		Waste_management waste_management = null;
		
		if(method.equals("search"))
		{
			try {
				waste_management = waste_managementdao.findById(Integer.parseInt(request.getParameter("wm_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			Waste_managementService waste_managementService = new Waste_managementService();		
			if(waste_management.getWm_id()!=null){
				System.out.println("11");

						//System.out.println(waste_management);
						request.setAttribute("waste_management", waste_management);
						request.getRequestDispatcher("/jsps/waste_management/waste_management_update_output.jsp").forward(request, response);
					
				}
				else{
					
				request.setAttribute("msg", "Waste_management not found");
				request.getRequestDispatcher("/jsps/waste_management/waste_management_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Waste_management form = new Waste_management();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(name + ": " + Arrays.toString(values));
			}
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));
			
			form.setWm_id(Integer.parseInt(info.get(1)));
			form.setCity_id(Integer.parseInt(info.get(2)));
			form.setPollution_rate(Float.parseFloat(info.get(3)));	
			form.setRecycle_rate(Float.parseFloat(info.get(4)));		

			try {
				waste_managementdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Waste_management Updated");
			request.getRequestDispatcher("/jsps/waste_management/waste_management_read_output.jsp").forward(request, response);
		}
	}
}



