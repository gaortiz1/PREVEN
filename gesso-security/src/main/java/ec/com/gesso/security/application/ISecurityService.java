package ec.com.gesso.security.application;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;

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
	public User autenticateUser(String userName, String userPassword) throws GessoException;
	
	/**
	 * Create new user with minimal parameters
	 * @param person
	 */
	public void persistNewUser(Person person) throws GessoException;
	public void persistPerson(Person person) throws GessoException;
	public void persistUser(User userDto) throws GessoException;
	public Collection<User> findAllUsers() throws GessoException;
	public User findUserById(Integer usrId) throws GessoException;
}
