package company.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.dao.CompanyDao;
import company.domain.Company;
//import entity1.service.Entity1Service;


/**
 * Servlet implementation class UserServlet
 */

public class CompanyServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyServletRead() {
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
		Company entity1 = null;
		try {
			entity1 = CompanyDao.findByCompanyID(Integer.parseInt(request.getParameter("id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(entity1.getCompanyID()!=null){
					System.out.println(entity1);
					request.setAttribute("entity1", entity1);
					request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
				
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
		}
	}
}


