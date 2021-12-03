package hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AggregateOperators {
	public static void main(String args[]) {

		Configuration config = new Configuration().configure().addAnnotatedClass(Students.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q1 = session.createQuery("select COUNT(*) from Students");

		for (Iterator it = q1.iterate(); it.hasNext();) {
			long row = (Long) it.next();
			System.out.print("Number of students Count: " + row);
		}

		Query q2 = session.createQuery("SELECT sum(Marks) from Students ");
		System.out.println("Sum of marks of all Students : " + q2.list().get(0));

		Query q3 = session.createQuery("SELECT min(Marks) from Students ");
		System.out.println("Minimum marks of a Student : " + q3.list().get(0));

		Query q4 = session.createQuery("SELECT max(Marks) from Students ");
		System.out.println("Maximum marks of a Student : " + q4.list().get(0));

		Query q5 = session.createQuery("SELECT avg(Marks) from Students ");
		System.out.println("Average marks of a Student : " + q5.list().get(0));

		Query q6 = session.createQuery("from Students where name is NULL");
		List<Students> s1 = q6.list();
		System.out.println("Students name is not null" +s1);

		Query q7 = session.createQuery("from Students where name is not NULL");
		List<Students> s2 = q7.list();
		System.out.println("Students name is not null" +s2);
		
		Query q8 = session.createQuery("select id from Students where id like '1%' ");
		List<Students> s3 = q8.list();
		System.out.println("Students id starts with 1 : " +s3);

		tx.commit();
		session.close();
	}

}
