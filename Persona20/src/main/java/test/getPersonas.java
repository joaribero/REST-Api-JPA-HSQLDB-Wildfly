package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jribero.dao.HibernateUtil;
import com.jribero.dao.PersonaServiceImpl;
import com.jribero.model.Persona;

public class getPersonas {

	
	@BeforeClass
	public static void objPersona() {
		Persona p1 = new Persona("39500508","joaquin","ribero","23","mail@falso.com");
		Persona p2 = new Persona("39500926","tony","stark","45","ironman@avengers.com");
		Persona p3 = new Persona("16445406","steve","rogers","41","americas-ass@avengers.com");
		Persona p4 = new Persona("12345678","natacha","romanoff","35","blackwidow@urss.com");
		Session em = HibernateUtil.getSessionFactory().openSession();
		em.getTransaction().begin();
		em.save(p1);
		em.save(p2);
		em.save(p3);
		em.save(p4);
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void getPersonas() throws SQLException, NamingException {
		PersonaServiceImpl p = new PersonaServiceImpl();
		List<Persona>list = p.getAllQuery();		
		int c = list.size();
		assertEquals(4,c);
	}
	
	@Test
	public void getWrongDocument() throws JsonGenerationException, JsonMappingException, NamingException, IOException {
		PersonaServiceImpl p = new PersonaServiceImpl();
		String res = p.getSingleQuery("99999999");
		
		assertEquals("Error: Documento no encontrado",res);
	}
	
	
	

}
