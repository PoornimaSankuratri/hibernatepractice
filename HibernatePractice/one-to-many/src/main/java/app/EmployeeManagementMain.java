package app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import EmployeeManagement.Designation;
import EmployeeManagement.Employee;

public class EmployeeManagementMain {

	public static void main(String args[]) {
		
		Employee e1 = new Employee(1,"Poornima",null);
		Employee e2 = new Employee(2,"Deepu",null);
		Employee e3 = new Employee(3,"Rajendra",null);
		Employee e4 = new Employee(4,"Prassana",null);
		Employee e5 = new Employee(5,"Swetha",null);
		Employee e6 = new Employee(6,"Venky",null);
		
		Designation d1 = new Designation(101,"PA",null);
		Designation d2 = new Designation(102,"PAT",null);
		Designation d3 = new Designation(103,"SA",null);
		Designation d4 = new Designation(104,"A",null);
		
		List<Employee> d1employees = new ArrayList<Employee>();
		d1employees.add(e1);
		
		List<Employee> d2employees = new ArrayList<Employee>();
		d2employees.add(e2);
		
		List<Employee> d3employees = new ArrayList<Employee>();
		d3employees.add(e3);
		d3employees.add(e4);
		
		List<Employee> d4employees = new ArrayList<Employee>();
		d4employees.add(e5);
		d4employees.add(e6);
		
		d1.setE(d1employees);
		d2.setE(d2employees);
		d3.setE(d3employees);
		d4.setE(d4employees);
		
		e1.setD(d1);
		e2.setD(d2);
		e3.setD(d3);
		e4.setD(d3);
		e5.setD(d4);
		e6.setD(d4);
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Designation.class)
				.addAnnotatedClass(Employee.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);
		session.save(e6);

		session.save(d1);
		session.save(d2);
		session.save(d3);
		session.save(d4);

		tx.commit();

		session.close();
	}
}
