package ec.com.gesso.security.application;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.model.entity.UserProfile;

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
	User autenticateUser(String userName, String userPassword) throws GessoException;
	
	/**
	 * Create new user with minimal parameters
	 * @param person
	 */
	void persistNewUser(Person person) throws GessoException;
	void persistPerson(Person person) throws GessoException;
	void persistPersonUpdate(Person person) throws GessoException;

	void persistUser(User userDto) throws GessoException;
	void updateUser(User userDto) throws GessoException;
	Collection<User> findAllUsers() throws GessoException;
	Collection<Person> findAllUsersByPerson() throws GessoException;
	User findUserById(Integer usrId) throws GessoException;
	Collection<Person> findAllPersons() throws GessoException;

	Collection<UserProfile> findMenuForUser(Integer usrId) throws GessoException;
}
