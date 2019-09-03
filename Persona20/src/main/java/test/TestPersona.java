package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

import com.jribero.dao.HibernateUtil;
import com.jribero.model.Persona;

public class TestPersona {

	//private static EntityManager manager;
	
	//private static EntityManagerFactory emf;
	
	public static void main(String[]args) {
	
		
		Session manager = HibernateUtil.getSessionFactory().openSession();	
		
		Persona p = new Persona("39500508","joaquin","ribero","23","mail@falso.com");
		
		manager.getTransaction().begin();
		manager.persist(p);
		manager.getTransaction().commit();
	
		imprimirTodo();
	}
	
	private static void imprimirTodo() {
		Session manager = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Persona> per = (List<Persona>) manager.createQuery("FROM Persona").getResultList();
		System.out.println("En esta base hay "+ per.size() + " personas cargadas.");
		for (Persona p:per) {
			System.out.println(p.toString());
		}
	}
}
