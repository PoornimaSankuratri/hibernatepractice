package app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import QuestionAnswers.Answers;
import QuestionAnswers.Questions;

public class QuestionAnswersMain {

	public static void main(String args[]) {
		
		Questions q1 = new Questions(1,"What is java",null);
		Questions q2 = new Questions(2,"What is sql",null);
		
		Answers a1 = new Answers(101,"java is a programming language",null);
		Answers a2 = new Answers(102,"java is a platform",null);
		Answers a3 = new Answers(103,"Structured query language",null);
		Answers a4 = new Answers(104,"data retrieval language",null);

		
		List<Answers> al1 = new ArrayList<Answers>();
		al1.add(a1);
		al1.add(a2);
		
		List<Answers> al2 = new ArrayList<Answers>();
		al2.add(a3);
		al2.add(a3);
		
		q1.setAnswers(al1);
		q2.setAnswers(al2);
			
		a1.setQuestion(q1);
		a2.setQuestion(q1);
		a3.setQuestion(q2);
		a4.setQuestion(q2);

		Configuration config = new Configuration().configure().addAnnotatedClass(Questions.class)
				.addAnnotatedClass(Answers.class);
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

		SessionFactory sf = config.buildSessionFactory(reg.build());

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		session.save(q1);
		session.save(q2);
		
		session.save(a1);
		session.save(a2);
		session.save(a3);
		session.save(a4);
		
		tx.commit();
		
		session.close();
	}
}
