package ec.com.gesso.security.domain.model.security;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;

/**
 * @author roberto
 *
 */
public interface SecurityRepository {
	
	public User autenticateUser(String username, String password) throws GessoException;
	public void persistNewUser(Person person) throws GessoException;
	public void persistUser(User userDto) throws GessoException;
	public Collection<User> findAllUsers() throws GessoException;
	public void persistPerson(Person person) throws GessoException;
	public User findUserById(Integer usrId) throws GessoException;
}
