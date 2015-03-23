package ec.com.gesso.security.domain.model.security;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.UserDto;

/**
 * @author roberto
 *
 */
public interface SecurityRepository {
	
	public UserDto autenticateUser(String username, String password) throws GessoException;

	public void persistNewUser(Person person) throws GessoException;
	
	public Collection<UserDto> findAllUsers() throws GessoException;
	
	public void persistPerson(Person person) throws GessoException;
}
