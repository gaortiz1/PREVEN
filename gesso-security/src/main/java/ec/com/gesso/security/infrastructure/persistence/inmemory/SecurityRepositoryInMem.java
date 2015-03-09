package ec.com.gesso.security.infrastructure.persistence.inmemory;

import java.util.Map;

import ec.com.gesso.security.domain.model.handling.HandlingEventRepository;
import ec.com.gesso.security.domain.model.security.SecurityRepository;
import ec.com.gesso.security.domain.model.security.dto.UserDto;

public class SecurityRepositoryInMem implements SecurityRepository{

	private Map<String, Object> cargoDb;
	private HandlingEventRepository handlingEventRepository;
	  
	public UserDto autenticateUser(String username, String password) {
		return null;
	}
}
