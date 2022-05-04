package transportation.web.servlet;

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

import transportation.dao.TransportationDao;
import transportation.domain.Transportation;
//import transportation.service.TransportationException;
//import transportation.service.TransportationService;
/**
 * Servlet implementation class UserServlet
 */

public class TransportationServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransportationServletDelete() {
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
		TransportationDao transportationdao = new TransportationDao();
		Transportation transportation = null;
		if(method.equals("search"))
		{
			try {
//				transportationdao to TransportationDao
				transportation = TransportationDao.findById(Integer.parseInt(request.getParameter("idtransportation_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			TransportationService transportationservice = new TransportationService();		
			if(transportation.getIdtransportation_id()!=null){
						System.out.println(transportation);
						request.setAttribute("transportation", transportation);
						request.getRequestDispatcher("/jsps/transportation/transportation_delete_output.jsp").forward(request, response);
					
				}
				else{
				request.setAttribute("msg", "Transportation not found");
				request.getRequestDispatcher("/jsps/transportation/transportation_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				transportationdao.delete(request.getParameter("idtransportation_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/transportation/transportation_read_output.jsp").forward(request, response);
		}
	}
}



