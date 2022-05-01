package energy_management.web.servlet;

import java.io.IOException;


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

public class Energy_managementServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Energy_managementServletRead() {
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
		Energy_management energy_management = null;
		Energy_managementDao energy_managementDao = new Energy_managementDao();
		try {
			energy_management = Energy_managementDao.findById(Integer.parseInt(request.getParameter("em_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		if(energy_management.getEm_id()	!=	null){
			//System.out.println(energy_management);
			System.out.println("EM_ID: " + energy_management.getEm_id());
			request.setAttribute("energy_management", energy_management);
			request.getRequestDispatcher("/jsps/energy_management/energy_management_read_output.jsp").forward(request, response);
			}
		else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/energy_management/energy_management_read_output.jsp").forward(request, response);
		}
	}
}



