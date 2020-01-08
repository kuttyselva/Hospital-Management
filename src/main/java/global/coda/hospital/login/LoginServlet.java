package global.coda.hospital.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.databasedao.AuthenticationDao;
import global.coda.hospital.patientdao.PatientSqlDAO;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(name = "LoginServlet", urlPatterns = { "login" }, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthenticationDao auth = new AuthenticationDao();
	private PatientSqlDAO patientDao;
	private PatientRecord record;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		patientDao = new PatientSqlDAO();
		record = new PatientRecord();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		if (auth.authUser(name, password) != null ) {
			
			
			out.print("login successful <br/>");
			record = patientDao.getPatientRecord(name);
			out.print(record.toString());
			session.setAttribute("username", record.getName());
			response.sendRedirect("userdetail");
		} else {
			out.print("login failed");
			session.invalidate();

		}

	}

}
