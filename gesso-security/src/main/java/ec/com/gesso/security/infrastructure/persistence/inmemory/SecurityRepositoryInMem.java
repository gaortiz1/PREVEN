package ec.com.gesso.security.infrastructure.persistence.inmemory;

import java.util.Collection;
import java.util.Map;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.security.domain.model.handling.HandlingEventRepository;
import ec.com.gesso.security.domain.model.security.SecurityRepository;

/**
 * @author roberto
 *
 */
public class SecurityRepositoryInMem implements SecurityRepository{

	private Map<String, Object> securityDb;
	private HandlingEventRepository handlingEventRepository;
	  
	public User autenticateUser(String username, String password) {
		return null;
	}

//	@Override
	public void persistNewUser(Person person) {
		securityDb.put("", person);
	}

//	@Override
	public Collection<User> findAllUsers() {
		return null;
	}

	@Override
	public Collection<Person> findAllUsersByPerson() throws GessoException {
		return null;
	}

	public void persistPerson(Person person) {
		
	}

	@Override
	public void persistUser(User userDto) throws GessoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserById(Integer usrId) throws GessoException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Person> findAllPersons() throws GessoException {
		return null;
	}

	public void persistPersonUpdate(Person person) {

	}
}
