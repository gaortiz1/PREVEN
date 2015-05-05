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
import ec.com.gesso.mail.model.impl.ModelEmail;
import ec.com.gesso.mail.model.impl.ModelMessageNotifier;
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
	private ModelEmail modelEmail;
	
	
	@Before
	public void setUp(){
		this.emailNotifier = (IEmailNotifier) applicationContext.getBean("emailNotifier");
		
	}
	
	@Test	
	public void shouldSendMailWithModelEmailWithOutArray() {
		this.modelEmail = new ModelEmail();
		this.modelEmail.setFrom("inforprueba@plasemco.com");
		this.modelEmail.setTo("maniac787@hotmail.com");
		this.modelEmail.setSubject("Test");
		this.modelEmail.setMessage(new ModelMessageNotifier("Compañia", "La compañia se genero con exito"));
		this.emailNotifier.send(this.modelEmail);
	}
	
	@Test
	public void shouldSendMailWithModelEmailWithArray() {
		this.modelEmail = new ModelEmail();
		this.modelEmail.setFrom("inforprueba@plasemco.com");
		this.modelEmail.setTo("maniac787@hotmail.com", "bisbiridolfo@hotmail.com");
		this.modelEmail.setBcc("a@a.com", "a@a.com");
		this.modelEmail.setCc("a@a.com", "a@a.com");
		this.modelEmail.setSubject("Test");
		this.modelEmail.setMessage(new ModelMessageNotifier("Compañia", "La compañia se genero con exito"));
		this.emailNotifier.send(this.modelEmail);
	}
	
	@Test(expected=GessoConnectionException.class)
	public void shouldNotSendMailWithModelEmailWithArray() {
		this.modelEmail = new ModelEmail();
		this.modelEmail.setFrom("inforprueba");
		this.modelEmail.setTo("maniac787m", "bisbiridolfo");
		this.modelEmail.setBcc("a@a.com", "a@a.com");
		this.modelEmail.setCc("a@a.com", "a@a.com");
		this.modelEmail.setSubject("Test");
		this.modelEmail.setMessage(new ModelMessageNotifier("Compañia", "La compañia se genero con exito"));
		this.emailNotifier.send(this.modelEmail);
	}

}
