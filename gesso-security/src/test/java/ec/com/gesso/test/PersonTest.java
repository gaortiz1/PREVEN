/**
 * 
 */
package ec.com.gesso.test;

import java.util.Date;

import org.junit.Test;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.security.factory.GessoSecurityFactory;

/**
 * @author roberto
 *
 */
public class PersonTest {
	@Test
	public void crearPersona(){
		Person person = new Person();
		person.setFirstName("Roberto");
		person.setLastName("Chasipanta");
		person.setDocumentNumber("1717171717");
		person.setDateOfBirth(new Date());
		person.setIdSexCatalog(1);
		
		
		
		
//		person.setIdSexCatalog(1);
		try {
			GessoSecurityFactory.getInstance().getSecurityService().persistPerson(person);
			System.out.println("pruebas");
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}