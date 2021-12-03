package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.Laptop;
import model.Student;

public class Main {

	public static void main(String args[]) {
		
		Student s1 = new Student(1,"Poornima",null);
		Student s2 = new Student(2,"Rajendra",null);
		Student s3 = new Student(3,"Deepika",null);
		Student s4 = new Student(4,"Prassana",null);
		
		Laptop l1 = new Laptop(101,"Dell",s1);
		s1.setLaptop(l1);
		Laptop l2 = new Laptop(102,"Lenovo",s2);
		s2.setLaptop(l2);
		Laptop l3 = new Laptop(103,"Asus",s3);
		s3.setLaptop(l3);
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        
        SessionFactory sf = config.buildSessionFactory(reg.build());
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        
        session.save(l1);
        session.save(l2);
        session.save(l3);
        
        tx.commit();
        
        session.close();
        
	}
}
