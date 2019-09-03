package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import com.jribero.dao.PersonaServiceImpl;
import com.jribero.model.Persona;

public class addPersona {

	@Test
	public void addPersona() throws SQLException, NamingException, JsonGenerationException, JsonMappingException, IOException {
		PersonaServiceImpl p = new PersonaServiceImpl();
		Persona per = new Persona();
		per.setDocumento("395005018");
		per.setNombre("Sujeto");
		per.setApellido("Test");
		per.setEmail("mail@test.com");
		per.setEdad("35");
		
		String doc = "395005018";
		
		List<Persona>list = p.getAllQuery();		
		int beforeaddsize = list.size();
		System.out.println(beforeaddsize);
		String res = p.createQuery(per, doc);
		
		list = p.getAllQuery();		
		int afteraddsize = list.size();
		System.out.println(afteraddsize);
		assertEquals(afteraddsize,beforeaddsize+1);
	}
	
	
}
