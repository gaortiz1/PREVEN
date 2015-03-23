package ec.com.gesso.security.application.impl;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.UserDto;
import ec.com.gesso.security.application.ISecurityService;
import ec.com.gesso.security.domain.model.security.SecurityRepository;

/**
 * @author roberto
 *
 */
public class SecurityServiceImpl implements ISecurityService{
	
	private SecurityRepository securityRepository;
	
	public void setSecurityRepository(SecurityRepository securityRepository) {
		this.securityRepository = securityRepository;
	}

	public UserDto autenticateUser(String userName, String userPassword) {
		return securityRepository.autenticateUser(userName, userPassword);
	}

	@Override
	public void persistNewUser(Person person) {
		securityRepository.persistNewUser(person);
	}

	@Override
	public Collection<UserDto> findAllUsers() {
		return securityRepository.findAllUsers();
	}
	
	@Override
	public void persistPerson(Person person) throws GessoException{
		securityRepository.persistPerson(person);
	}

}
