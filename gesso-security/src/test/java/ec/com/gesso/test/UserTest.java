package ec.com.gesso.test;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
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
	
	@Ignore
	public void sigInUser(){
		Person person = new Person("prueba", "prueba", new Date(), true);
		person.setIdSexCatalog("M");
		
		person.setUserDto(new User("pruebas", "qwe123"));
		
		try {
			GessoSecurityFactory.getInstance().getSecurityService().persistNewUser(person);
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
