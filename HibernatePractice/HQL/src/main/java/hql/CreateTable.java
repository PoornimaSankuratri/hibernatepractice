package hql;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CreateTable {
	public static void main(String args[]) {

		Configuration config = new Configuration().configure().addAnnotatedClass(Students.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Random r = new Random();

		for (int i = 1; i <= 50; i++) {

			Students s = new Students();
			s.setId(i);
			s.setName("Name" + i);
			s.setMarks(r.nextInt(100));
			session.save(s);
		}

		tx.commit();
		session.close();
	}
}
