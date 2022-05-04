package transportation.web.servlet;

import java.io.IOException;


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

public class TransportationServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransportationServletRead() {
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
		Transportation transportation = null;
		//TransportationDao transportationDao = new TransportationDao();
		try {
			transportation = TransportationDao.findById(Integer.parseInt(request.getParameter("idtransportation_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		if(transportation.getIdtransportation_id()	!=	null){
			//System.out.println(transportation);
			//.out.println("EM_ID: " + transportation.getEm_id());
			request.setAttribute("transportation", transportation);
			request.getRequestDispatcher("/jsps/transportation/transportation_read_output.jsp").forward(request, response);
			}
		else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/transportation/transportation_read_output.jsp").forward(request, response);
		}
	}
}



