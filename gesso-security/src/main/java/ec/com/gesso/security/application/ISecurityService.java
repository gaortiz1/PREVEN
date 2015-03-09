package ec.com.gesso.security.application;

import ec.com.gesso.security.domain.model.security.dto.UserDto;

public interface ISecurityService {
	public UserDto autenticateUser(String userName, String userPassword);
}
