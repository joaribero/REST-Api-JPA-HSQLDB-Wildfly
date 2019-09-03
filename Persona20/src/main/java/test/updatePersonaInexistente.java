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

public class updatePersonaInexistente {

	@Test
	public void updatePersonaInexistente() throws JsonGenerationException, JsonMappingException, SQLException, NamingException, IOException {
		PersonaServiceImpl p = new PersonaServiceImpl();
		Persona per = new Persona();
		per.setDocumento("88888888");
		per.setNombre("Sujeto");
		per.setApellido("Test");
		per.setEmail("mail@test.com");
		per.setEdad("35");
		
		String res = p.updateQuery(per);
		
		assertEquals("Error: Documento no encontrado.",res);
	}
}
