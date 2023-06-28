package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao studentDao;

	@Override
	public Integer save(String sname, Integer sage, String saddress) {

		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.save(sname, sage, saddress);
	}

	@Override
	public Student findById(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.findById(sid);
	}

	@Override
	public String updateStudent(Student student) {

		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateStudent(student);
	}

	@Override
	public String delete(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.delete(sid);
	}

}
