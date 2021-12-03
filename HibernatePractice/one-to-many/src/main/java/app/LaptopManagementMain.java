package app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import LaptopManagement.Laptop;
import LaptopManagement.StudentDetails;

public class LaptopManagementMain {
	
	public static void main(String args[]) {
		
		StudentDetails s1 = new StudentDetails(1,"Poornima",null);
		StudentDetails s2 = new StudentDetails(2,"Deepu",null);
		StudentDetails s3 = new StudentDetails(3,"Swetha",null);
		StudentDetails s4 = new StudentDetails(4,"Deepu",null);
		
		Laptop l1 = new Laptop(101,"Dell",null);
		Laptop l2 = new Laptop(102,"Lenovo",null);
		Laptop l3 = new Laptop(103,"HP",null);
		Laptop l4 = new Laptop(104,"Asus",null);
		Laptop l5 = new Laptop(105,"Apple",null);
		Laptop l6 = new Laptop(106,"Samsung",null);
		
		List<Laptop> lp1 = new ArrayList<Laptop>();
		lp1.add(l1);
		lp1.add(l2);
		
		List<Laptop> lp2 = new ArrayList<Laptop>();
		lp2.add(l3);
		lp2.add(l4);
		
		List<Laptop> lp3 = new ArrayList<Laptop>();
		lp3.add(l5);
		
		List<Laptop> lp4 = new ArrayList<Laptop>();
		lp4.add(l6);
		
		s1.setList(lp1);
		s2.setList(lp2);
		s3.setList(lp3);
		s4.setList(lp4);
		
		l1.setS(s1);
		l2.setS(s1);
		l3.setS(s2);
		l4.setS(s2);
		l5.setS(s3);
		l6.setS(s4);
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(StudentDetails.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(l1);
		session.save(l2);
		session.save(l3);
		session.save(l4);
		session.save(l5);
		session.save(l6);

		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);

		tx.commit();

		session.close();
	}

}
