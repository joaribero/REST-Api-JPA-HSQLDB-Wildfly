package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import com.jribero.dao.PersonaServiceImpl;
import com.jribero.model.Persona;

public class deletePersona {

	@Test
	public void deletePersona() throws SQLException, NamingException {
		PersonaServiceImpl p = new PersonaServiceImpl();
		List<Persona>list = p.getAllQuery();
		int beforeDelSize = list.size();		
		String json = p.deleteQuery("395005018");
		list = p.getAllQuery();
		int afterDelSize = list.size();
		
		assertEquals(afterDelSize,beforeDelSize-1);
	}

}
