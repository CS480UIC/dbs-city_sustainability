package transportation.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import transportation.dao.TransportationDao;
import transportation.domain.Transportation;
//import entity1.service.TransportationService;

/**
 * Servlet implementation class UserServlet
 */

public class TransportationServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransportationServletUpdate() {
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
		TransportationDao transportationdao = new TransportationDao();
		Transportation transportation = null;
		
		if(method.equals("search"))
		{
			try {
				transportation = transportationdao.findById(Integer.parseInt(request.getParameter("idtransportation_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			TransportationService transportationService = new TransportationService();		
			if(transportation.getIdtransportation_id()!=null){
				System.out.println("11");

						//System.out.println(transportation);
						request.setAttribute("transportation", transportation);
						request.getRequestDispatcher("/jsps/transportation/transportation_update_output.jsp").forward(request, response);
					
				}
				else{
					
				request.setAttribute("msg", "Transportation not found");
				request.getRequestDispatcher("/jsps/transportation/transportation_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Transportation form = new Transportation();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(name + ": " + Arrays.toString(values));
			}
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));
			
			form.setIdtransportation_id(Integer.parseInt(info.get(1)));
			form.setTarget_id(Integer.parseInt(info.get(2)));
			form.setCar_population(Float.parseFloat(info.get(3)));	
			form.setCar_emission(Float.parseFloat(info.get(4)));
			form.setPublic_usage(Float.parseFloat(info.get(5)));	
			form.setPublic_emission(Float.parseFloat(info.get(6)));

			try {
				transportationdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Transportation Updated");
			request.getRequestDispatcher("/jsps/transportation/transportation_read_output.jsp").forward(request, response);
		}
	}
}



