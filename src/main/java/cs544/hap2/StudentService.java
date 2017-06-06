package cs544.hap2;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {
	private StudentDAO studentdao = new StudentDAO();
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public StudentService() {
		studentdao = new StudentDAO();
	}

	public void addStudent(Student student){
		Transaction tx = sf.getCurrentSession().beginTransaction();
		studentdao.create(student);
		tx.commit();
	}
	
	public Student getStudent(long studentid) {
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Student student = studentdao.load(studentid);
		
		Hibernate.initialize(student.getCourselist());

		tx.commit();
		return student;
		
	}
}
