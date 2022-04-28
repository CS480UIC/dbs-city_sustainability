package industry.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import industry.domain.Industry;
import industry.service.IndustryException;
import industry.service.IndustryService;


/**
 * Servlet implementation class UserServlet
 */

public class IndustryServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndustryServletCreate() {
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
		IndustryService industryservice = new IndustryService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Industry form = new Industry();
		List<String> info = new ArrayList<String>();
		System.out.println(form);
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
//			System.out.println(info.add(values[0]));
		}
		
//		System.out.println("1");
//		System.out.println(info);
		
//		System.out.println("INFO CONTENTS: " + info);

		form.setId(Integer.parseInt(info.get(0)));
		form.setCountry_id(Integer.parseInt(info.get(1)));
		form.setIndustry_type(info.get(2));
		form.setIndustry_emission(Float.parseFloat(info.get(3)));		
		
		
		try {
			System.out.println("3");
			//System.out.println("form CONTENTS: " + form);
			industryservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | IndustryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
