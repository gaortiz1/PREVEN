package ec.com.gesso.security.domain.model.security;

import java.util.Collection;

import ec.com.gesso.security.domain.model.security.dto.Person;
import ec.com.gesso.security.domain.model.security.dto.UserDto;

/**
 * @author roberto
 *
 */
public interface SecurityRepository {
	
	public UserDto autenticateUser(String username, String password);

	public void persistNewUser(Person person);
	
	public Collection<UserDto> findAllUsers();
}
