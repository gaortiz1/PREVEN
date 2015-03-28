package ec.com.gesso.security.application;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.UserDto;

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
	public UserDto autenticateUser(String userName, String userPassword) throws GessoException;
	
	/**
	 * Create new user with minimal parameters
	 * @param person
	 */
	public void persistNewUser(Person person) throws GessoException;
	public void persistPerson(Person person) throws GessoException;
	public void persistUser(UserDto userDto) throws GessoException;
	public Collection<UserDto> findAllUsers() throws GessoException;
	public UserDto findUserById(Integer usrId) throws GessoException;
}
