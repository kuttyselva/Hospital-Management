package global.coda.hospital.update;

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
 * Servlet implementation class UpdateServlet
 */

@WebServlet(name = "UpdateServlet", urlPatterns = { "update" }, loadOnStartup = 1)
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientSqlDAO patientDao;
	private PatientRecord record;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			record = patientDao.getPatientRecord((String) session.getAttribute("username"));
			request.setAttribute("record", record);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} else {
			out.print("Session Expired");
			response.sendRedirect("index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			response.setContentType("text/html");
			String name = request.getParameter("name");
			String location = request.getParameter("location");
			String disease = request.getParameter("disease");
			int age = Integer.parseInt(request.getParameter("age"));
			String phone = request.getParameter("phone");
			record.setAge(age);
			record.setLocation(location);
			record.setName(name);
			record.setPhone(phone);
			record.setDisease(disease);
			patientDao.updatePatient(record);
			out.print("updated \n");
			out.print(record.toString());
			out.print("<br /><a href=\"logout\"> logout </a>");
		} else {
			out.print("expired");
		}

	}

}
