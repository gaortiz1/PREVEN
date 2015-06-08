/**
 * 
 */
package ec.com.gesso.mail.test.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.mail.exception.GessoConnectionException;
import ec.com.gesso.mail.model.impl.Email;
import ec.com.gesso.mail.model.impl.MessageNotifier;
import ec.com.gesso.mail.notifier.IEmailNotifier;

/**
 * @author Gabriel
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:ec/com/gesso/domain/resource/spring/config/gesso-mail.xml"
		})
public class TestEmailNotifierWithSpring {
	
	@Autowired 
	private ApplicationContext applicationContext;
	private IEmailNotifier emailNotifier;
	private Email email;
	
	
	@Before
	public void setUp(){
		this.emailNotifier = (IEmailNotifier) applicationContext.getBean("emailNotifier");
		
	}
	
	@Test	
	public void shouldSendMailWithModelEmailWithOutArray() {
		this.email = new Email();
		this.email.setFrom("inforprueba@plasemco.com");
		this.email.setTo("emailpruebas@hotmail.com");
		this.email.setSubject("Test");
		this.email.setMessage(new MessageNotifier("Compañia", "La compañia se genero con exito"));
		this.emailNotifier.send(this.email);
	}
	
	@Test
	public void shouldSendMailWithModelEmailWithArray() {
		this.email = new Email();
		this.email.setFrom("inforprueba@plasemco.com");
		this.email.setTo("emailpruebas@hotmail.com", "emailpruebas@hotmail.com");
		this.email.setBcc("a@a.com", "a@a.com");
		this.email.setCc("a@a.com", "a@a.com");
		this.email.setSubject("Test");
		this.email.setMessage(new MessageNotifier("Compañia", "La compañia se genero con exito"));
		this.emailNotifier.send(this.email);
	}
	
	@Test(expected=GessoConnectionException.class)
	public void shouldNotSendMailWithModelEmailWithArray() {
		this.email = new Email();
		this.email.setFrom("inforprueba");
		this.email.setTo("emailpruebas", "bisbiridolfo");
		this.email.setBcc("a@a.com", "a@a.com");
		this.email.setCc("a@a.com", "a@a.com");
		this.email.setSubject("Test");
		this.email.setMessage(new MessageNotifier("Compañia", "La compañia se genero con exito"));
		this.emailNotifier.send(this.email);
	}

}
