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
import ec.com.gesso.mail.model.IMessage;
import ec.com.gesso.mail.model.impl.Email;
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
		Email email = new Email();
		email.setSubject("test");
		email.setFrom("bisbiridolfo@hotmail.com");
		email.setMessage(new IMessage() {
			
			@Override
			public String getText() {
				return "Send Message";
			}
		});
		this.emailNotifier.send(email);
	}
	
	@Test(expected=GessoMailException.class)
	public void shouldNotSendMailWithNullParameterFrom(){
		Email email = new Email();
		email.setTo("bisbiridolfo@hotmail.com");
		email.setSubject("test");
		email.setMessage(new IMessage() {
			
			@Override
			public String getText() {
				return "Send Message";
			}
		});
		this.emailNotifier.send(email);
	}
	
	@Test(expected=GessoMailException.class)
	public void shouldNotSendMailWithNullParameterSubject(){
		Email email = new Email();
		email.setTo("bisbiridolfo@hotmail.com");
		email.setFrom("bisbiridolfo@hotmail.com");
		email.setMessage(new IMessage() {
			
			@Override
			public String getText() {
				return "Send Message";
			}
		});
		this.emailNotifier.send(email);
	}
	
	@Test(expected=GessoMailException.class)
	public void shouldNotSendMailWithNullParameterMessage(){
		Email email = new Email();
		email.setTo("bisbiridolfo@hotmail.com");
		email.setSubject("test");
		email.setFrom("bisbiridolfo@hotmail.com");
		email.setMessage(null);
		this.emailNotifier.send(email);
	}
	
	@Test(expected=GessoMailException.class)
	public void shouldNotSendMailWithNullParameterText(){
		Email email = new Email();
		email.setTo("bisbiridolfo@hotmail.com");
		email.setSubject("test");
		email.setFrom("bisbiridolfo@hotmail.com");
		email.setMessage(new IMessage() {
			
			@Override
			public String getText() {
				return null;
			}
		});
		this.emailNotifier.send(email);
	}
	
	@Test
	public void shouldSendMailWithParameterModelEmail(){
		Email email = new Email();
		email.setTo("bisbiridolfo@hotmail.com");
		email.setSubject("test");
		email.setFrom("bisbiridolfo@hotmail.com");
		email.setMessage(new IMessage() {
			
			@Override
			public String getText() {
				return "Send Message";
			}
		});
		
		this.emailNotifier.send(email);
	}

}
