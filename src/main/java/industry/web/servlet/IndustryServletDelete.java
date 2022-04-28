package industry.web.servlet;

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

import industry.dao.IndustryDao;
import industry.domain.Industry;
//import industry.service.IndustryException;
//import industry.service.IndustryService;
/**
 * Servlet implementation class UserServlet
 */

public class IndustryServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndustryServletDelete() {
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
		IndustryDao industrydao = new IndustryDao();
		Industry industry = null;
		if(method.equals("search"))
		{
			try {
//				industrydao to IndustryDao
				industry = IndustryDao.findIndustryId(Integer.parseInt(request.getParameter("id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			IndustryService industryservice = new IndustryService();		
			if(industry.getId()!=null){
						System.out.println(industry);
						request.setAttribute("industry", industry);
						request.getRequestDispatcher("/jsps/industry/industry_delete_output.jsp").forward(request, response);
					
				}
				else{
				request.setAttribute("msg", "Industry not found");
				request.getRequestDispatcher("/jsps/industry/industry_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				industrydao.delete(request.getParameter("id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/industry/industry_read_output.jsp").forward(request, response);
		}
	}
}



