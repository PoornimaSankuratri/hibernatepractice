package Level1Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Level1CacheMain {

	public static void main(String args[]) {
		
		Students s1 = new Students(1,"Poornima",'A');
		Students s2 = new Students(2,"Deepu",'B');
		Students s3 = new Students(3,"Swetha",'C');
		Students s4 = new Students(4,"Chintu",'D');
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Students.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
		tx.commit();

		session.close();
	}
}
