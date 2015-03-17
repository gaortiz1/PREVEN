package ec.com.gesso.security.infrastructure.persistence.inmemory;

import java.util.Collection;
import java.util.Map;

import ec.com.gesso.security.domain.model.handling.HandlingEventRepository;
import ec.com.gesso.security.domain.model.security.SecurityRepository;
import ec.com.gesso.security.domain.model.security.dto.Person;
import ec.com.gesso.security.domain.model.security.dto.UserDto;

/**
 * @author roberto
 *
 */
public class SecurityRepositoryInMem implements SecurityRepository{

	private Map<String, Object> securityDb;
	private HandlingEventRepository handlingEventRepository;
	  
	public UserDto autenticateUser(String username, String password) {
		return null;
	}

//	@Override
	public void persistNewUser(Person person) {
		securityDb.put("", person);
	}

//	@Override
	public Collection<UserDto> findAllUsers() {
		return null;
	}
}
