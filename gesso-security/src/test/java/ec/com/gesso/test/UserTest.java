package ec.com.gesso.test;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import ec.com.gesso.security.domain.model.security.dto.Person;
import ec.com.gesso.security.domain.model.security.dto.UserDto;
import ec.com.gesso.security.factory.GessoSecurityFactory;

public class UserTest {
	@Test
	public void loginUser(){
		GessoSecurityFactory.getInstance().getSecurityService().autenticateUser("", "");
	}
	
	@Test
	public void sigInUser(){
		Person person = new Person("prueba", "prueba", new Date(), true);
		person.setIdSexCatalog(1);
		
		person.setUserDto(new UserDto("pruebas", "qwe123"));
		
		GessoSecurityFactory.getInstance().getSecurityService().persistNewUser(person);
	}
}
