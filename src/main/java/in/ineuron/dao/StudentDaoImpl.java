package in.ineuron.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.dto.Student;
import in.ineuron.hibernateUtil.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {

	private Session session = null;

	@Override
	public Integer save(String sname, Integer sage, String saddress) {

		Transaction transaction = null;
		boolean flag = false;
		Integer sid = null;
		try {
			session = HibernateUtil.getSession();
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Student student = new Student();

				student.setSname(sname);
				student.setSage(sage);
				student.setSaddress(saddress);

				System.out.println(student);
				sid = (Integer) session.save(student);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			} else {
				transaction.rollback();
			}
		}

		return sid;
	}

	@Override
	public Student findById(Integer sid) {

		session = HibernateUtil.getSession();
		Student student = null;

		if (session != null)
			student = session.get(Student.class, sid);

		return student;
	}

	@Override
	public String updateStudent(Student student) {

		session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean flag = false;
		String status = "";

		System.out.println("In dao layer" + student);
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				session.merge(student);
				flag = true;
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				status = "success";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}

		return status;
	}

	@Override
	public String delete(Integer sid) {

		session = HibernateUtil.getSession();
		Student student = session.get(Student.class, sid);
		Transaction transaction = null;
		Boolean flag = false;
		String status = null;

		if (student != null) {
			try {
				if (session != null)
					transaction = session.beginTransaction();
				if (transaction != null) {
					session.delete(student);
					flag = true;
				}
			}

			catch (HibernateException he) {
				he.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (flag) {
					transaction.commit();
					status = "success";
				} else {
					transaction.rollback();
					status = "failure";
				}
			}
		} else {
			status = "record notfound";
		}
		return status;
	}

}
