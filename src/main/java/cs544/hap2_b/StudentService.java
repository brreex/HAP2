package cs544.hap2_b;

public class StudentService {
	private StudentDAO studentdao = new StudentDAO();
	
	public StudentService() {
		studentdao = new StudentDAO();
	}

	public void addStudent(Student student){
		studentdao.create(student);
	}
	
	public Student getStudent(long studentid) {
		Student student = studentdao.load(studentid);
		return student;
		
	}
}
