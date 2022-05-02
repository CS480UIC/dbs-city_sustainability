package waste_management.web.servlet;

import java.io.IOException;


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

public class Waste_managementServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Waste_managementServletRead() {
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
		Waste_management waste_management = null;
		Waste_managementDao waste_managementDao = new Waste_managementDao();
		try {
			waste_management = Waste_managementDao.findById(Integer.parseInt(request.getParameter("wm_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		if(waste_management.getWm_id()	!=	null){
			//System.out.println(waste_management);
			//System.out.println("EM_ID: " + waste_management.getWm_id());
			request.setAttribute("waste_management", waste_management);
			request.getRequestDispatcher("/jsps/waste_management/waste_management_read_output.jsp").forward(request, response);
			}
		else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/waste_management/waste_management_read_output.jsp").forward(request, response);
		}
	}
}



