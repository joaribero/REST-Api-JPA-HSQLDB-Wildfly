package com.jribero.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;

import com.jribero.model.Persona;
import com.jribero.service.PersonaService;



public class PersonaServiceImpl {

	private EntityManager em;
	private List<Persona> listPersona;
	
	
	public List getAllQuery() throws SQLException, NamingException {
		
		em = HibernateUtil.getSessionFactory().openSession();
	    em.getTransaction().begin();
	    listPersona = em.createQuery("FROM Persona").getResultList();
	    em.getTransaction().commit();
	    em.close();
	    return listPersona;
	}

	
	public String getSingleQuery(String doc) throws NamingException, JsonGenerationException, JsonMappingException, IOException {
		
		Session em = HibernateUtil.getSessionFactory().openSession();
	    em.getTransaction().begin();
	    Persona p = em.find(Persona.class, doc);
	    if (p != null) {
	    	ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(p);	
			em.close();
			return json;
	    }
	    else {
	    	em.close();
	    	return ("Error: Documento no encontrado");
	    }
	    
	}

	
	public String createQuery(Persona p, String doc) throws SQLException, NamingException, JsonGenerationException, JsonMappingException, IOException {
		Persona p1 = new Persona();
		Session em = HibernateUtil.getSessionFactory().openSession();
	    em.getTransaction().begin();
	    Persona p2 = em.find(Persona.class, doc);
	    if (p2 != null) {
	    	em.close();
	    	return ("Error: Documento existente para la persona: "+p2.getApellido() + " " + p2.getNombre());
	    }
	    else {
	    	p1.setDocumento(p.getDocumento());
		    p1.setNombre(p.getNombre());
		    p1.setApellido(p.getApellido());
		    p1.setEdad(p.getEdad());
		    p1.setEmail(p.getEmail());
		    em.save(p1);
		    em.getTransaction().commit();
		    em.close();
			
		    ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(p1);	
			em.close();
			return ("[ {\"Status\":\" Persona creada correctamente\" },"+ json + " ]");
	    }
	    
	}

	
	public String deleteQuery(String doc) throws SQLException, NamingException {
		Persona p = new Persona();
		Session em = HibernateUtil.getSessionFactory().openSession();
	    em.getTransaction().begin();
	    p = em.find(Persona.class, doc);
	    if (p == null) {
	    	em.close();
	    	return ("Error: Documento no encontrado.");
	    }
	    else {
	    	em.remove(p);
	        em.getTransaction().commit();
	        em.close();
	        return ("Persona borrada correctamente.");
	    }
		
	}

	public String updateQuery(Persona p) throws SQLException, NamingException, JsonGenerationException, JsonMappingException, IOException {
		Persona p1 = new Persona();
		Session em = HibernateUtil.getSessionFactory().openSession();
	    em.getTransaction().begin();
	    Persona p2 = em.find(Persona.class, p.getDocumento());
	    if (p2 == null) {
	    	em.close();
	    	return ("Error: Documento no encontrado.");
	    }
	    else {
	    	p1.setDocumento(p.getDocumento());
		    p1.setNombre(p.getNombre());
		    p1.setApellido(p.getApellido());
		    p1.setEdad(p.getEdad());
		    p1.setEmail(p.getEmail());
		    em.merge(p1);
		    em.getTransaction().commit();
		    em.close();
		    ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(p1);	
			em.close();
			return ("[ {\"Status\":\" Persona actualizada correctamente\" },"+ json + " ]");
	    }
	    
		
	}

}
