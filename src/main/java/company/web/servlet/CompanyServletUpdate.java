package company.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

public class CompanyServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyServletUpdate() {
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
		CompanyDao companyDao = new CompanyDao();
		Company newCompany = null;
		
		if(method.equals("search"))
		{
			try {
				newCompany = CompanyDao.findByCompanyID(Integer.parseInt(request.getParameter("id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			Entity1Service entity1service = new Entity1Service();		
			if(newCompany.getCompanyID()!=null){
				System.out.println("11");

						System.out.println(newCompany);
						request.setAttribute("entity1", newCompany);
						request.getRequestDispatcher("/jsps/company/company_update_output.jsp").forward(request, response);
					
				}
				else{
					
				request.setAttribute("msg", "company not found");
				request.getRequestDispatcher("/jsps/company/company_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Company form = new Company();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(name + ": " + Arrays.toString(values));
			}

			form.setIndustryID(Integer.parseInt(info.get(2)));
//			System.out.println("2");

			form.setCompanyName(info.get(3));		
//			System.out.println("3");
			
			form.setCompanyEmission(Float.parseFloat(info.get(4)));
			
			form.setCompanyID(Integer.parseInt(request.getParameter("id")));

			try {
				companyDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
		}
	}
}



