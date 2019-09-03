package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Test;

import com.jribero.dao.PersonaServiceImpl;

public class deletePersonaInexistente {

	@Test
	public void deletePersonaIn() throws SQLException, NamingException {
		PersonaServiceImpl p = new PersonaServiceImpl();
		String json = p.deleteQuery("9999999");
		
		assertEquals("Error: Documento no encontrado.",json);
	}

}
