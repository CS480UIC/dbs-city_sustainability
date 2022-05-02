package carbon_emission_target.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

public class Carbon_emission_targetServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carbon_emission_targetServletUpdate() {
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
		Carbon_emission_targetDao carbon_emission_targetdao = new Carbon_emission_targetDao();
		Carbon_emission_target carbon_emission_target = null;
		
		if(method.equals("search"))
		{
			try {
				carbon_emission_target = carbon_emission_targetdao.findCarbon_emission_targetId(Integer.parseInt(request.getParameter("id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			Carbon_emission_targetService carbon_emission_targetService = new Carbon_emission_targetService();		
			if(carbon_emission_target.getCet_id()!=null){
				System.out.println("11");

						//System.out.println(carbon_emission_target);
						request.setAttribute("carbon_emission_target", carbon_emission_target);
						request.getRequestDispatcher("/jsps/carbon_emission_target/carbon_emission_target_update_output.jsp").forward(request, response);
					
				}
				else{
					
				request.setAttribute("msg", "Carbon_emission_target not found");
				request.getRequestDispatcher("/jsps/carbon_emission_target/carbon_emission_target_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Carbon_emission_target form = new Carbon_emission_target();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(name + ": " + Arrays.toString(values));
			}
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));
			
			form.setCet_id(Integer.parseInt(info.get(1)));
			form.setCity_id(Integer.parseInt(info.get(2)));
			form.setBase_year(Integer.parseInt(info.get(3)));
			form.setBase_emission(Float.parseFloat(info.get(4)));
			form.setTarget_year(Integer.parseInt(info.get(5)));
			form.setBase_emission(Float.parseFloat(info.get(6)));

			try {
				carbon_emission_targetdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Carbon_emission_target Updated");
			request.getRequestDispatcher("/jsps/carbon_emission_target/carbon_emission_target_read_output.jsp").forward(request, response);
		}
	}
}



