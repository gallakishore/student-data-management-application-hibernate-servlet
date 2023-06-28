package in.ineuron.daofactory;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static StudentDaoImpl studentDao = null;

	private StudentDaoFactory() {
	}

	public static IStudentDao getStudentDao() {
		if (studentDao == null) {
			studentDao = new StudentDaoImpl();
		}

		return studentDao;
	}
}
