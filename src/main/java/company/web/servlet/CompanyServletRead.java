package company.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.dao.CompanyDao;
import company.domain.Company;
//import entity1.service.CompanyService;


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
		Company company = null;
		CompanyDao companyDao = new CompanyDao();
		try {
			company = CompanyDao.findCompanyId(Integer.parseInt(request.getParameter("id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(company.getId()!=null){
					//System.out.println(company);
					request.setAttribute("company", company);
					request.getRequestDispatcher("/jsps/company/company_read_output.jsp").forward(request, response);
				
			}
			else{
			request.setAttribute("msg", "Company not found");
			request.getRequestDispatcher("/jsps/company/company_read_output.jsp").forward(request, response);
		}
	}
}



