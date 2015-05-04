/**
 * 
 */
package ec.com.gesso.mail.test.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSender;

import ec.com.gesso.mail.exception.GessoMailException;
import ec.com.gesso.mail.model.IModelMessage;
import ec.com.gesso.mail.model.impl.ModelEmail;
import ec.com.gesso.mail.notifier.impl.EmailNotifier;

/**
 * @author Gabriel
 *
 */
@RunWith(MockitoJUnitRunner.class) 
public class TestEmailNotifier {
	
	@Mock private JavaMailSender javaMailSenderMock;
	private EmailNotifier emailNotifier;
	
	
	@Before
	public void setUp(){
		this.emailNotifier = new EmailNotifier();
		this.emailNotifier.setJavaMailSender(javaMailSenderMock);
		
	}
	
	@Test(expected=GessoMailException.class)	
	public void shouldNotSendMailWithParameterNull() {
		this.emailNotifier.send(null);
	}
	
	@Test(expected=GessoMailException.class)
	public void shouldNotSendMailWithNullParameterTo(){
		ModelEmail modelEmail = new ModelEmail();
		modelEmail.setSubject("test");
		modelEmail.setFrom("bisbiridolfo@hotmail.com");
		modelEmail.setMessage(new IModelMessage() {
			
			@Override
			public String getText() {
				return "Send Message";
			}
		});
		this.emailNotifier.send(modelEmail);
	}
	
	@Test(expected=GessoMailException.class)
	public void shouldNotSendMailWithNullParameterFrom(){
		ModelEmail modelEmail = new ModelEmail();
		modelEmail.setTo("bisbiridolfo@hotmail.com");
		modelEmail.setSubject("test");
		modelEmail.setMessage(new IModelMessage() {
			
			@Override
			public String getText() {
				return "Send Message";
			}
		});
		this.emailNotifier.send(modelEmail);
	}
	
	@Test(expected=GessoMailException.class)
	public void shouldNotSendMailWithNullParameterSubject(){
		ModelEmail modelEmail = new ModelEmail();
		modelEmail.setTo("bisbiridolfo@hotmail.com");
		modelEmail.setFrom("bisbiridolfo@hotmail.com");
		modelEmail.setMessage(new IModelMessage() {
			
			@Override
			public String getText() {
				return "Send Message";
			}
		});
		this.emailNotifier.send(modelEmail);
	}
	
	@Test(expected=GessoMailException.class)
	public void shouldNotSendMailWithNullParameterMessage(){
		ModelEmail modelEmail = new ModelEmail();
		modelEmail.setTo("bisbiridolfo@hotmail.com");
		modelEmail.setSubject("test");
		modelEmail.setFrom("bisbiridolfo@hotmail.com");
		modelEmail.setMessage(null);
		this.emailNotifier.send(modelEmail);
	}
	
	@Test(expected=GessoMailException.class)
	public void shouldNotSendMailWithNullParameterText(){
		ModelEmail modelEmail = new ModelEmail();
		modelEmail.setTo("bisbiridolfo@hotmail.com");
		modelEmail.setSubject("test");
		modelEmail.setFrom("bisbiridolfo@hotmail.com");
		modelEmail.setMessage(new IModelMessage() {
			
			@Override
			public String getText() {
				return null;
			}
		});
		this.emailNotifier.send(modelEmail);
	}
	
	@Test
	public void shouldSendMailWithParameterModelEmail(){
		ModelEmail modelEmail = new ModelEmail();
		modelEmail.setTo("bisbiridolfo@hotmail.com");
		modelEmail.setSubject("test");
		modelEmail.setFrom("bisbiridolfo@hotmail.com");
		modelEmail.setMessage(new IModelMessage() {
			
			@Override
			public String getText() {
				return "Send Message";
			}
		});
		
		this.emailNotifier.send(modelEmail);
	}

}
