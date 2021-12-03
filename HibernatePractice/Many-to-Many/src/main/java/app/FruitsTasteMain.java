package app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import FruitsTaste.Fruits;
import FruitsTaste.Taste;

public class FruitsTasteMain {

	public static void main(String args[]) {
		
		Fruits f1 = new Fruits(1,"Lemon",null);
		Fruits f2 = new Fruits(2,"Orange",null);
		Fruits f3 = new Fruits(3,"Apple",null);
		Fruits f4 = new Fruits(4,"Banana",null);
		Fruits f5 = new Fruits(5,"Grapes",null);
		Fruits f6 = new Fruits(6,"Watermelon",null);
		
		Taste t1 = new Taste(101,"Sweet",null);
		Taste t2 = new Taste(102,"Sour",null);
		
		List<Fruits> fl1 = new ArrayList<Fruits>();
		fl1.add(f1);
		fl1.add(f2);
		fl1.add(f3);
		fl1.add(f5);
		
		List<Fruits> fl2 = new ArrayList<Fruits>();
		fl2.add(f3);
		fl2.add(f5);
		fl2.add(f6);
		fl2.add(f4);
		
		List<Taste> tl1 = new ArrayList<Taste>();
		tl1.add(t1);
		tl1.add(t2);
		
		List<Taste> tl2 = new ArrayList<Taste>();
		tl2.add(t2);
		
		List<Taste> tl3 = new ArrayList<Taste>();
		tl3.add(t1);
		
		t1.setFruit(fl2);
		t2.setFruit(fl1);
		
		f1.setT(tl2);
		f2.setT(tl2);
		f3.setT(tl1);
		f4.setT(tl3);
		f5.setT(tl1);
		f6.setT(tl3);
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Taste.class)
				.addAnnotatedClass(Fruits.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(f1);
		session.save(f2);
		session.save(f3);
		session.save(f4);
		session.save(f5);
		session.save(f6);
		
		session.save(t1);
		session.save(t2);

		tx.commit();

		session.close();
	}
}
