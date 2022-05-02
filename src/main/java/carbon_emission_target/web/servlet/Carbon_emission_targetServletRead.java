package carbon_emission_target.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carbon_emission_target.dao.Carbon_emission_targetDao;
import carbon_emission_target.domain.Carbon_emission_target;
//import entity1.service.Carbon_emission_targetService;


/**
 * Servlet implementation class UserServlet
 */

public class Carbon_emission_targetServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carbon_emission_targetServletRead() {
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
		Carbon_emission_target carbon_emission_target = null;
		Carbon_emission_targetDao carbon_emission_targetDao = new Carbon_emission_targetDao();
		try {
			carbon_emission_target = Carbon_emission_targetDao.findCarbon_emission_targetId(Integer.parseInt(request.getParameter("cet_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(carbon_emission_target.getCet_id()!=null){
					//System.out.println(carbon_emission_target);
					request.setAttribute("carbon_emission_target", carbon_emission_target);
					request.getRequestDispatcher("/jsps/carbon_emission_target/carbon_emission_target_read_output.jsp").forward(request, response);
				
			}
			else{
			request.setAttribute("msg", "Carbon_emission_target not found");
			request.getRequestDispatcher("/jsps/carbon_emission_target/carbon_emission_target_read_output.jsp").forward(request, response);
		}
	}
}



