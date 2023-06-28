package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {
	
	public Integer save(String sname,Integer sage,String saddress);
	
	public Student findById(Integer sid);
	
	public String updateStudent(Student student);

	public String delete(Integer sid);
	
}
