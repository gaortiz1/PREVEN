package ec.com.gesso.security.domain.model.security;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.model.entity.UserProfile;

/**
 * @author roberto
 *
 */
public interface SecurityRepository {
	
	User autenticateUser(String username, String password) throws GessoException;
	void persistNewUser(Person person) throws GessoException;
	void persistUser(User userDto) throws GessoException;
	Collection<User> findAllUsers() throws GessoException;
    Collection<Person> findAllUsersByPerson () throws GessoException;
	void persistPerson(Person person) throws GessoException;
	User findUserById(Integer usrId) throws GessoException;

	Collection<Person> findAllPersons() throws GessoException;

	void persistPersonUpdate(Person person);

	Collection<UserProfile> findMenuForUser(Integer usrId) throws GessoException;
}
