package ec.com.gesso.security.domain.model.security;

import ec.com.gesso.security.domain.model.security.dto.UserDto;

public interface SecurityRepository {
	public UserDto autenticateUser(String username, String password);

}
