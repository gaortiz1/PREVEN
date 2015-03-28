package ec.com.gesso.security.infrastructure.persistence.inmemory;

import java.util.Collection;
import java.util.Map;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.UserDto;
import ec.com.gesso.security.domain.model.handling.HandlingEventRepository;
import ec.com.gesso.security.domain.model.security.SecurityRepository;

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
	
	public void persistPerson(Person person) {
		
	}

	@Override
	public void persistUser(UserDto userDto) throws GessoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDto findUserById(Integer usrId) throws GessoException {
		// TODO Auto-generated method stub
		return null;
	}
}
