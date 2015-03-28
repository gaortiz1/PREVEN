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
	
	public void setSecurityRepository(SecurityRepository securityRepository){
		this.securityRepository = securityRepository;
	}
	
	@Override
	public UserDto autenticateUser(String userName, String userPassword) throws GessoException{
		return securityRepository.autenticateUser(userName, userPassword);
	}

	@Override
	public void persistNewUser(Person person) throws GessoException{
		securityRepository.persistNewUser(person);
	}

	@Override
	public Collection<UserDto> findAllUsers() throws GessoException{
		return securityRepository.findAllUsers();
	}
	
	@Override
	public void persistPerson(Person person) throws GessoException{
		securityRepository.persistPerson(person);
	}

	@Override
	public void persistUser(UserDto userDto) throws GessoException {
		securityRepository.persistUser(userDto);
	}

	@Override
	public UserDto findUserById(Integer usrId) throws GessoException {
		return securityRepository.findUserById(usrId);
	}

	

}
