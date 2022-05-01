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
//import entity1.service.CompanyService;

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
//
		String method = request.getParameter("method");
		CompanyDao companydao = new CompanyDao();
		Company company = null;
		
		if(method.equals("search"))
		{
			try {
				company = companydao.findCompanyId(Integer.parseInt(request.getParameter("id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			CompanyService companyService = new CompanyService();		
			if(company.getCompany_name()!=null){
				System.out.println("11");

						//System.out.println(company);
						request.setAttribute("company", company);
						request.getRequestDispatcher("/jsps/company/company_update_output.jsp").forward(request, response);
					
				}
				else{
					
				request.setAttribute("msg", "Company not found");
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
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));
			
			form.setId(Integer.parseInt(info.get(1)));
			form.setIndustry_id(Integer.parseInt(info.get(2)));
			form.setCompany_name(info.get(3));
			form.setCompany_emission(Float.parseFloat(info.get(4)));

			try {
				companydao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Company Updated");
			request.getRequestDispatcher("/jsps/company/company_read_output.jsp").forward(request, response);
		}
	}
}



