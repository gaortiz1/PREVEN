package ec.com.gesso.security.application.impl;

import ec.com.gesso.security.application.ISecurityService;
import ec.com.gesso.security.domain.model.security.SecurityRepository;

public class SecurityServiceImpl implements ISecurityService{
	private SecurityRepository securityRepository;
	
	public void autenticateUser(String userName, String userPassword) {
		securityRepository.autenticateUser(userName, userPassword);
	}

}
