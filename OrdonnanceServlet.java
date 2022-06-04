package controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.OrdonnanceDao;
import model.Ordonnance;
import java.io.IOException;
/**
 * Servlet implementation class PatientController
 */
@WebServlet(urlPatterns={"/ord","/newo","/inserto","/deleteo","/updateo","/edito"})
public class OrdonnanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdonnanceDao orddao;       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		orddao= new OrdonnanceDao();
    }
    public OrdonnanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getServletPath();
		 System.out.println("ord insert	"+action);
		 try {
	            switch (action) {
	                case "/newo":
	                    showNewForm(request, response);
	                    break;
	                case "/inserto":
	                    insertOrd(request, response);
	                    break;
	                case "/deleteo":
	                    deleteOrd(request, response);
	                    break;
	                case "/edito":
	                    showEditForm(request, response);
	                    break;
	                case "/updateo":
	                    updateOrd(request, response);
	                    break;
	                default:
	                    listOrd(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	
	
	
	
	private void listOrd(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		
		        List < Ordonnance > listOrd = OrdonnanceDao.selectAllordonnance();
		        request.setAttribute("listord", listOrd);
		        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/ord-list.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ord-form.jsp");
		        dispatcher.forward(request, response);
		    }

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String numOrd =request.getParameter("numord");
		        Ordonnance existingOrd = orddao.selectOrdonnance(numOrd);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ord-form.jsp");
		        request.setAttribute("ordonnance", existingOrd);
		        dispatcher.forward(request, response);

		    }
	
	private void insertOrd(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
				String numord=request.getParameter("numord");
		        String nompatient =request.getParameter("nompatient");
		        String prenompatient= request.getParameter("prenompatient");
		        String nommedicament = request.getParameter("nommedicament");
		        String dosagemedicament=request.getParameter("dosagemedicament");
		        Ordonnance o = new Ordonnance(numord,nompatient,prenompatient,nommedicament,dosagemedicament);
		        orddao.insertord(o);
		        response.sendRedirect("ord");
		    }
	
	 private void updateOrd(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
		 String numord=request.getParameter("numord");
	        String nompatient =request.getParameter("nompatient");
	        String prenompatient= request.getParameter("prenompatient");
	        String nommedicament = request.getParameter("nommedicament");
	        String dosagemedicament=request.getParameter("dosagemedicament");
			        Ordonnance o = new Ordonnance(numord,nompatient,prenompatient,nommedicament,dosagemedicament);
			        orddao.updateord(o);
			        response.sendRedirect("ord");
			    }
	 
	 
	 private void deleteOrd(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String numOrd = request.getParameter("numord");
			        orddao.deleteord(numOrd);
			        response.sendRedirect("ord");

			    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}