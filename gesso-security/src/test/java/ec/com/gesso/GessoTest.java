package ec.com.gesso;

import ec.com.gesso.security.factory.GessoSecurityFactory;

public class GessoTest {
	public static void main(String args[]){
		GessoSecurityFactory.getInstance().getSecurityService().autenticateUser("", "");
	}
}
