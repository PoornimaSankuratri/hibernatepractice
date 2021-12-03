package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PrintValues {
	public static void main(String args[]) {

		Configuration config = new Configuration().configure().addAnnotatedClass(Students.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from Students");
		List<Students> student = q.list();

		for (Students s : student) {

			System.out.println(s);

		}
		tx.commit();
		session.close();
	}
}
