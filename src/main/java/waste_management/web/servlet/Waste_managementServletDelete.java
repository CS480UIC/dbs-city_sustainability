package waste_management.web.servlet;

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

import waste_management.dao.Waste_managementDao;
import waste_management.domain.Waste_management;
//import waste_management.service.Waste_managementException;
//import waste_management.service.Waste_managementService;
/**
 * Servlet implementation class UserServlet
 */

public class Waste_managementServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Waste_managementServletDelete() {
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
		Waste_managementDao waste_managementdao = new Waste_managementDao();
		Waste_management waste_management = null;
		if(method.equals("search"))
		{
			try {
//				waste_managementdao to Waste_managementDao
				waste_management = Waste_managementDao.findById(Integer.parseInt(request.getParameter("wm_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			Waste_managementService waste_managementservice = new Waste_managementService();		
			if(waste_management.getWm_id()!=null){
						System.out.println(waste_management);
						request.setAttribute("waste_management", waste_management);
						request.getRequestDispatcher("/jsps/waste_management/waste_management_delete_output.jsp").forward(request, response);
					
				}
				else{
				request.setAttribute("msg", "Waste_management not found");
				request.getRequestDispatcher("/jsps/waste_management/waste_management_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				waste_managementdao.delete(request.getParameter("wm_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/waste_management/waste_management_read_output.jsp").forward(request, response);
		}
	}
}



