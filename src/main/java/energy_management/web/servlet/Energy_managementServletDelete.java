package energy_management.web.servlet;

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

import energy_management.dao.Energy_managementDao;
import energy_management.domain.Energy_management;
//import energy_management.service.Energy_managementException;
//import energy_management.service.Energy_managementService;
/**
 * Servlet implementation class UserServlet
 */

public class Energy_managementServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Energy_managementServletDelete() {
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
		Energy_managementDao energy_managementdao = new Energy_managementDao();
		Energy_management energy_management = null;
		if(method.equals("search"))
		{
			try {
//				energy_managementdao to Energy_managementDao
				energy_management = Energy_managementDao.findById(Integer.parseInt(request.getParameter("em_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			Energy_managementService energy_managementservice = new Energy_managementService();		
			if(energy_management.getEm_id()!=null){
						System.out.println(energy_management);
						request.setAttribute("energy_management", energy_management);
						request.getRequestDispatcher("/jsps/energy_management/energy_management_delete_output.jsp").forward(request, response);
					
				}
				else{
				request.setAttribute("msg", "Energy_management not found");
				request.getRequestDispatcher("/jsps/energy_management/energy_management_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				energy_managementdao.delete(request.getParameter("em_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/energy_management/energy_management_read_output.jsp").forward(request, response);
		}
	}
}



