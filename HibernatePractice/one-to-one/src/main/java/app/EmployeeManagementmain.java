package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import EmployeeManagement.Designation;
import EmployeeManagement.Employee;

public class EmployeeManagementmain {

	public static void main(String args[]) {

		Employee e1 = new Employee(1, "Poornima", null);
		Employee e2 = new Employee(2, "Deepu", null);
		Employee e3 = new Employee(3, "Rajendra", null);
		Employee e4 = new Employee(4, "Prasana", null);

		Designation d1 = new Designation(101, "PA", e1);
		e1.setD(d1);
		Designation d2 = new Designation(102, "PAT", e2);
		e2.setD(d2);
		Designation d3 = new Designation(103, "SA", e3);
		e3.setD(d3);
		Designation d4 = new Designation(104, "A", e4);
		e4.setD(d4);

		Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Designation.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);

		session.save(d1);
		session.save(d2);
		session.save(d3);
		session.save(d4);

		tx.commit();

		session.close();

	}
}
