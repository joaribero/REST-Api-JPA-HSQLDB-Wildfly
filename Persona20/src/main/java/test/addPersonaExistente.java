package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import com.jribero.dao.PersonaServiceImpl;
import com.jribero.model.Persona;

public class addPersonaExistente {

	@Test
	public void addExistingPersona() throws JsonGenerationException, JsonMappingException, SQLException, NamingException, IOException {
		PersonaServiceImpl p = new PersonaServiceImpl();
		Persona per = new Persona();
		per.setDocumento("395005018");
		per.setNombre("Sujeto");
		per.setApellido("Test");
		per.setEmail("mail@test.com");
		per.setEdad("35");
		
		String doc = "395005018";
		
		String res = p.createQuery(per, doc);
		System.out.println(res);
		
		assertEquals("Error: Documento existente para la persona: Test Sujeto",res);
	}
}
