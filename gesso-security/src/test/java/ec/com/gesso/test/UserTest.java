package ec.com.gesso.test;

import java.util.Date;

import org.junit.Test;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.UserDto;
import ec.com.gesso.security.factory.GessoSecurityFactory;

public class UserTest {
	@Test()
	public void loginUser(){
		try {
			GessoSecurityFactory.getInstance().getSecurityService().autenticateUser("", "");
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void sigInUser(){
		Person person = new Person("prueba", "prueba", new Date(), true);
		person.setIdSexCatalog("M");
		
		person.setUserDto(new UserDto("pruebas", "qwe123"));
		
		try {
			GessoSecurityFactory.getInstance().getSecurityService().persistNewUser(person);
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
