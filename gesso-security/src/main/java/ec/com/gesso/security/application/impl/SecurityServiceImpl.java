package ec.com.gesso.security.application.impl;

import ec.com.gesso.security.application.ISecurityService;
import ec.com.gesso.security.domain.model.security.SecurityRepository;
import ec.com.gesso.security.domain.model.security.dto.Person;
import ec.com.gesso.security.domain.model.security.dto.UserDto;

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

}