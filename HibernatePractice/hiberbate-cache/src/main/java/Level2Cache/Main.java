package Level2Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Main {
public static void main(String args[]) {
		
		Student s1 = new Student(1,"Poornima",'A');
		Student s2 = new Student(2,"Deepu",'B');
		Student s3 = new Student(3,"Swetha",'C');
		Student s4 = new Student(4,"Chintu",'D');
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
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
