package ec.com.gesso;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import ec.com.gesso.security.domain.model.security.dto.Catalog;
import ec.com.gesso.security.domain.model.security.dto.GroupCatalog;
import ec.com.gesso.security.domain.model.security.dto.Person;
import ec.com.gesso.security.domain.model.security.dto.UserDto;
import ec.com.gesso.security.factory.GessoSecurityFactory;

public class GessoTest {
	
	@Ignore
	public void loginUser(){
		GessoSecurityFactory.getInstance().getSecurityService().autenticateUser("", "");
	}
	
	@Ignore
	public void sigInUser(){
		Person person = new Person("prueba", "prueba", new Date(), true);
		person.setIdSexCatalog(1);
		
		
		person.setUserDto(new UserDto("pruebas", "qwe123"));
		
		
		GessoSecurityFactory.getInstance().getSecurityService().persistNewUser(person);
	}
}
