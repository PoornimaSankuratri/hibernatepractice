package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import StudentManagement.Branch;
import StudentManagement.StudentDetails;

public class StudentManagementMain {

	public static void main(String args[]) {
		
		StudentDetails s1 = new StudentDetails(1,"Poornima",null);
		StudentDetails s2 = new StudentDetails(2,"Deepu",null);
		StudentDetails s3 = new StudentDetails(3,"Rajendra",null);
		StudentDetails s4 = new StudentDetails(4,"prassana",null);
		
		Branch b1 = new Branch(101,"CSE",s1);
		s1.setB(b1);
		Branch b2 = new Branch(102,"ECE",s2);
		s2.setB(b2);
		Branch b3 = new Branch(103,"EEE",s3);
		s3.setB(b3);
		Branch b4 = new Branch(104,"IT",s4);
		s4.setB(b4);
		
		Configuration config = new Configuration().configure().addAnnotatedClass(StudentDetails.class).addAnnotatedClass(Branch.class);
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
