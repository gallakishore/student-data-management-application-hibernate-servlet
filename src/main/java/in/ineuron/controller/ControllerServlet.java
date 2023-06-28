package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.hibernateUtil.HibernateUtil;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

@WebServlet(urlPatterns = "/controller/*", loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		HibernateUtil.startUp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(request.getRequestURI());

		if (request.getRequestURI().endsWith("insert")) {

			String sname = request.getParameter("studentname");
			String sage = request.getParameter("studentage");
			String saddress = request.getParameter("studentaddress");
			Integer status = null;

			IStudentService studentService = StudentServiceFactory.getStudentService();
			if (studentService != null) {
				status = studentService.save(sname, Integer.parseInt(sage), saddress);
			}

			request.setAttribute("status", status);

			try {
				RequestDispatcher rd = request.getRequestDispatcher("../insertionStatus.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		} else if (request.getRequestURI().endsWith("search")) {

			String sid = request.getParameter("sid");
			Student student = null;
			IStudentService studentService = StudentServiceFactory.getStudentService();
			if (studentService != null) {
				student = studentService.findById(Integer.parseInt(sid));
			}

			System.out.println(student);
			request.setAttribute("student", student);

			try {
				RequestDispatcher rd = request.getRequestDispatcher("../searchStatus.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		} else if (request.getRequestURI().endsWith("edit")) {

			String sid = request.getParameter("sid");
			Student student = null;
			IStudentService studentService = StudentServiceFactory.getStudentService();
			if (studentService != null) {
				student = studentService.findById(Integer.parseInt(sid));
			}

			request.setAttribute("student", student);

			try {
				RequestDispatcher rd = request.getRequestDispatcher("../updateForm.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

		else if (request.getRequestURI().endsWith("update")) {

			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddress");

			Student student = new Student();
			student.setSid(Integer.parseInt(sid));
			student.setSaddress(saddress);
			student.setSage(Integer.parseInt(sage));
			student.setSname(sname);

			String status = null;
			IStudentService studentService = StudentServiceFactory.getStudentService();
			if (studentService != null) {
				status = studentService.updateStudent(student);
			}

			request.setAttribute("status", status);
			try {
				RequestDispatcher rd = request.getRequestDispatcher("../../updateStatus.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

		else if (request.getRequestURI().endsWith("delete")) {

			String sid = request.getParameter("sid");
			String status = null;
			IStudentService studentService = StudentServiceFactory.getStudentService();
			if (studentService != null) {
				status = studentService.delete(Integer.parseInt(sid));

			}

			request.setAttribute("status", status);

			try {
				RequestDispatcher rd = request.getRequestDispatcher("../deleteStatus.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		}

	}

}
