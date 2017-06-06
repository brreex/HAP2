package cs544.hap2_b;

import org.hibernate.SessionFactory;

public class StudentDAO {
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public StudentDAO() {
	}

	public Student load(long studentid) {
		return sf.getCurrentSession().get(Student.class, studentid);
	}
	
	public void create(Student student){
		sf.getCurrentSession().persist(student);
	}
	
	public void update (Student student){
		sf.getCurrentSession().merge(student);
	}
	
	public void delete(Student student){
		sf.getCurrentSession().delete(student);
	}
}
