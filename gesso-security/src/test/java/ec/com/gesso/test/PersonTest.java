/**
 * 
 */
package ec.com.gesso.test;

import java.util.Date;

import org.junit.Test;

import ec.com.gesso.security.domain.model.security.dto.Person;
import ec.com.gesso.security.factory.GessoSecurityFactory;

/**
 * @author roberto
 *
 */
public class PersonTest {
	@Test
	public void crearPersona(){
		Person person = new Person("Roberto", "Chasipanta", new Date(), Boolean.TRUE);
		GessoSecurityFactory.getInstance().getSecurityService().persistPerson(person);
	}
}