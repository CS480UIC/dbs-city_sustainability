package carbon_emission_target.web.servlet;

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

import carbon_emission_target.dao.Carbon_emission_targetDao;
import carbon_emission_target.domain.Carbon_emission_target;
//import carbon_emission_target.service.Carbon_emission_targetException;
//import carbon_emission_target.service.Carbon_emission_targetService;
/**
 * Servlet implementation class UserServlet
 */

public class Carbon_emission_targetServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carbon_emission_targetServletDelete() {
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
		Carbon_emission_targetDao carbon_emission_targetdao = new Carbon_emission_targetDao();
		Carbon_emission_target carbon_emission_target = null;
		if(method.equals("search"))
		{
			try {
//				carbon_emission_targetdao to Carbon_emission_targetDao
				carbon_emission_target = Carbon_emission_targetDao.findCarbon_emission_targetId(Integer.parseInt(request.getParameter("id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			Carbon_emission_targetService carbon_emission_targetservice = new Carbon_emission_targetService();		
			if(carbon_emission_target.getCet_id()!=null){
						System.out.println(carbon_emission_target);
						request.setAttribute("carbon_emission_target", carbon_emission_target);
						request.getRequestDispatcher("/jsps/carbon_emission_target/carbon_emission_target_delete_output.jsp").forward(request, response);
					
				}
				else{
				request.setAttribute("msg", "Carbon_emission_target not found");
				request.getRequestDispatcher("/jsps/carbon_emission_target/carbon_emission_target_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				carbon_emission_targetdao.delete(request.getParameter("cet_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/carbon_emission_target/carbon_emission_target_read_output.jsp").forward(request, response);
		}
	}
}



