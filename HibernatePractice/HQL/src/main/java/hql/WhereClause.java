package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class WhereClause {
	public static void main(String args[]) {

		Configuration config = new Configuration().configure().addAnnotatedClass(Students.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from Students where marks > 50");
		List<Students> student = q.list();

		for (Students s : student) {

			System.out.println(s);

		}
		
		Query q1 = session.createQuery("from Students where marks < 50");
		List<Students> student1 = q1.list();

		for (Students s1 : student1) {

			System.out.println(s1);

		}
		tx.commit();
		session.close();
	}

}
