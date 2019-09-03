package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.jribero.dao.PersonaServiceImpl;
import com.jribero.model.Persona;

public class updatePersona {

	@Test
	public void updatePersona() throws JsonGenerationException, JsonMappingException, SQLException, NamingException, IOException {
		PersonaServiceImpl k = new PersonaServiceImpl();
		Persona per = new Persona();
		per.setDocumento("395005018");
		per.setNombre("Sujeto");
		per.setApellido("Test");
		per.setEmail("nuevomail@test.com");
		per.setEdad("35");
		
		String json = k.updateQuery(per);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json2 = mapper.writeValueAsString(per);	
		
		assertEquals(json,"[ {\"Status\":\" Persona actualizada correctamente\" },"+ json2 + " ]");
		
	}

}
