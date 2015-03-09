package ec.com.gesso.security.infrastructure.persistence.inmemory;

import java.util.Map;

import ec.com.gesso.security.domain.model.handling.HandlingEventRepository;
import ec.com.gesso.security.domain.model.security.SecurityRepository;

public class SecurityRepositoryInMem implements SecurityRepository{

	private Map<String, Object> cargoDb;
	private HandlingEventRepository handlingEventRepository;
	  
	public void autenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		
	}
	

}
