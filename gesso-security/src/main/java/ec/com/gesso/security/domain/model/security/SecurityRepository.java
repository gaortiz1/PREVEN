package ec.com.gesso.security.domain.model.security;

public interface SecurityRepository {
	public void autenticateUser(String username, String password);

}
