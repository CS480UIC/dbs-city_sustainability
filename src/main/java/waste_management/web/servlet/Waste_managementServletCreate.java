package waste_management.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import waste_management.domain.Waste_management;
import waste_management.service.Waste_managementException;
import waste_management.service.Waste_managementService;


/**
 * Servlet implementation class UserServlet
 */

public class Waste_managementServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Waste_managementServletCreate() {
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
		Waste_managementService entity1service = new Waste_managementService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Waste_management form = new Waste_management();
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

		form.setWm_id(Integer.parseInt(info.get(0)));

		form.setCity_id(Integer.parseInt(info.get(1)));

		form.setPollution_rate(Float.parseFloat(info.get(2)));
		
		form.setRecycle_rate(Float.parseFloat(info.get(3)));
		
		try {
			System.out.println("3");
			//System.out.println("form CONTENTS: " + form);
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Waste_managementException e) {
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
