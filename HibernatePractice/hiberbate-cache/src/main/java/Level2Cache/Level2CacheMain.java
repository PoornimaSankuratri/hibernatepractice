package Level2Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Level2CacheMain {
public static void main(String args[]) {
		
		Student s = null;
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		s = (Student)session.get(Student.class,1);
		
		System.out.println(s);	
		
		s = (Student)session.get(Student.class,2);
		
		System.out.println(s);
		
		tx.commit();

		session.close();

		Session session1 = sf.openSession();

		Transaction tx1 = session1.beginTransaction();
				
		s = (Student)session1.get(Student.class,1);
		
		System.out.println(s);
				
		tx1.commit();

		session1.close();
	}
}
