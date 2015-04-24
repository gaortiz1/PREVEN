package ec.com.gesso.security.application.impl;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.security.application.ISecurityService;
import ec.com.gesso.security.domain.model.security.SecurityRepository;

/**
 * @author roberto
 *
 */
public class SecurityServiceImpl implements ISecurityService{
	
	private SecurityRepository securityRepository;
	
	public void setSecurityRepository(SecurityRepository securityRepository){
		this.securityRepository = securityRepository;
	}
	
	@Override
	public User autenticateUser(String userName, String userPassword) throws GessoException{
		return securityRepository.autenticateUser(userName, userPassword);
	}

	@Override
	public void persistNewUser(Person person) throws GessoException{
		securityRepository.persistNewUser(person);
	}

	@Override
	public Collection<User> findAllUsers() throws GessoException{
		return securityRepository.findAllUsers();
	}
	
	@Override
	public void persistPerson(Person person) throws GessoException{
		securityRepository.persistPerson(person);
	}

	@Override
	public void persistUser(User userDto) throws GessoException {
		securityRepository.persistUser(userDto);
	}

	@Override
	public User findUserById(Integer usrId) throws GessoException {
		return securityRepository.findUserById(usrId);
	}

	public Collection<Person> findAllPersons() throws GessoException {
		return securityRepository.findAllPersons();
	}


}
