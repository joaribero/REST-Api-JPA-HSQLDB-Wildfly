package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ getPersonas.class, 
	addPersona.class,
	addPersonaExistente.class,
	updatePersonaInexistente.class,
	updatePersona.class,
	deletePersonaInexistente.class,
	deletePersona.class  })
public class AllTests {

}
