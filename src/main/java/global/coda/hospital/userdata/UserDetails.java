package global.coda.hospital.userdata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.patientdao.PatientSqlDAO;

/**
 * Servlet implementation class UserDetails.
 */
@WebServlet(name = "UserDetails", urlPatterns = { "userdetail" }, loadOnStartup = 1)

public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientSqlDAO patientDao;
	private PatientRecord record;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * initialize objects.
	 */
	public void init() {
		patientDao = new PatientSqlDAO();
		record = new PatientRecord();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @param request  from user.
	 * @param response to user.
	 * @throws ServletException to handle servlet error.
	 * @throws IOException to handle IO error.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			record = patientDao.getPatientRecord((String) session.getAttribute("username"));
			request.setAttribute("record", record);
			request.getRequestDispatcher("userdetails.jsp").forward(request, response);
		} else {
			out.print("Session Expired");
			response.sendRedirect("index.html");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @param request  from user.
	 * @param response to user.
	 * @throws ServletException to handle servlet error.
	 * @throws IOException to handle IO error.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
