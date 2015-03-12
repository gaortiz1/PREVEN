package ec.com.gesso.security.application;

import java.util.Collection;

import ec.com.gesso.security.domain.model.security.dto.Person;
import ec.com.gesso.security.domain.model.security.dto.UserDto;

/**
 * @author roberto
 *
 */
public interface ISecurityService {
	/**
	 * User autentication 
	 * @param userName
	 * @param userPassword
	 * @return User loged
	 */
	public UserDto autenticateUser(String userName, String userPassword);
	
	/**
	 * Create new user with minimal parameters
	 * @param person
	 */
	public void persistNewUser(Person person);
	
	
	public Collection<UserDto> findAllUsers();
}
