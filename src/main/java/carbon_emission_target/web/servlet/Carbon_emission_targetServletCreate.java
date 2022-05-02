package carbon_emission_target.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carbon_emission_target.domain.Carbon_emission_target;
import carbon_emission_target.service.Carbon_emission_targetException;
import carbon_emission_target.service.Carbon_emission_targetService;


/**
 * Servlet implementation class UserServlet
 */

public class Carbon_emission_targetServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carbon_emission_targetServletCreate() {
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
		Carbon_emission_targetService entity1service = new Carbon_emission_targetService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Carbon_emission_target form = new Carbon_emission_target();
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

		form.setCet_id(Integer.parseInt(info.get(0)));
		
		form.setCity_id(Integer.parseInt(info.get(1)));
		
		form.setBase_year(Integer.parseInt(info.get(2)));

		form.setBase_emission(Float.parseFloat(info.get(3)));		

		form.setTarget_year(Integer.parseInt(info.get(4)));
		
		form.setTarget_emission(Float.parseFloat(info.get(5)));
		
		try {
			//System.out.println("3");
			//System.out.println("form CONTENTS: " + form);
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Carbon_emission_targetException e) {
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
