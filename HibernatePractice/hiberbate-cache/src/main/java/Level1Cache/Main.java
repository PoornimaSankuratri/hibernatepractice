package Level1Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String args[]) {
		
		Students s = null;
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Students.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		s = (Students)session.get(Students.class,1);
		
		System.out.println(s);	
		
		s = (Students)session.get(Students.class,2);
		
		System.out.println(s);	
				
		s = (Students)session.get(Students.class,1);
		
		System.out.println(s);
				
		tx.commit();

		session.close();
	}
}
