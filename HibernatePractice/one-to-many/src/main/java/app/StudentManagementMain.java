package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

import StudentManagement.Branch;
import StudentManagement.Student;

public class StudentManagementMain {
	public static void main(String args[]) {

		Student s1 = new Student(1, "Poornima", null);
		Student s2 = new Student(2, "Deepu", null);
		Student s3 = new Student(3, "Rajendra", null);
		Student s4 = new Student(4, "prassana", null);
		
		Branch b1 = new Branch(101, "CSE", null);
		s1.setB(b1);
		Branch b2 = new Branch(102, "ECE", null);
		s2.setB(b2);
		Branch b3 = new Branch(103, "EEE", null);
		s3.setB(b3);
		Branch b4 = new Branch(104, "IT", null);
		s4.setB(b3);

		List<Student> b1students = new ArrayList();
		b1students.add(s1);

		List<Student> b2students = new ArrayList();
		b2students.add(s2);

		List<Student> b3students = new ArrayList();
		b3students.add(s3);
		b3students.add(s4);
		
		b1.setS(b1students);
		b2.setS(b2students);
		b3.setS(b3students);


		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Branch.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);

		session.save(b1);
		session.save(b2);
		session.save(b3);
		session.save(b4);

		tx.commit();

		session.close();
	}
}
