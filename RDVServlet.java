package controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RDVDao;
import model.Patient;
import model.RDV;
import java.io.IOException;
/**
 * Servlet implementation class PatientController
 */
@WebServlet(urlPatterns={"/rdvs","/newr","/insertr","/deleter","/updater","/editr"})
public class RDVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RDVDao rdvdao;       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		rdvdao= new RDVDao();
    }
    public RDVServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getServletPath();
		 try {
	            switch (action) {
	                case "/newr":
	                    showNewForm(request, response);
	                    break;
	                case "/insertr":
	                    insertRDV(request, response);
	                    break;
	                case "/deleter":
	                    deleteRDV(request, response);
	                    break;
	                case "/editr":
	                    showEditForm(request, response);
	                    break;
	                case "/updater":
	                    updateRDV(request, response);
	                    break;
	                default:
	                    listRDV(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	
	
	private void listRDV(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < RDV > listRDV = rdvdao.selectAllRDV();
		        request.setAttribute("listRDV", listRDV);
		        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/rdv-list.jsp");
		        dispatcher.forward(request, response);
		    }
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/rdv-form .jsp");
		        dispatcher.forward(request, response);
		    }

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String Id = request.getParameter("Id");
		        RDV existingrdv = rdvdao.selectRDV(Id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/rdv-form .jsp");
		        request.setAttribute("rdv", existingrdv);
		        dispatcher.forward(request, response);

		    }
	private void insertRDV(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
				String id=request.getParameter("id");
		        String DateRDV = request.getParameter("DateRDV");
		        String HeureRDV = request.getParameter("HeureRDV");
		        String CINPatient = request.getParameter("CINPatient");
		        RDV r = new RDV(id,DateRDV,HeureRDV,CINPatient);
		        rdvdao.insertRDV(r);
		        response.sendRedirect("rdvs");
		        
		    }
	
	 private void updateRDV(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			       String id=request.getParameter("id");
			        String DateRDV = request.getParameter("DateRDV");
			        String HeureRDV = request.getParameter("HeureRDV");
			         String CINPatient =request.getParameter("CINPatient");
			        RDV r = new RDV(id,DateRDV,HeureRDV,CINPatient);
			        rdvdao.updateRDV(r);
			        response.sendRedirect("rdvs");
			    }
	 
	 
	 private void deleteRDV(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String id = request.getParameter("id");
			        rdvdao.deleteRDV(id);
			        response.sendRedirect("rdvs");

			    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}