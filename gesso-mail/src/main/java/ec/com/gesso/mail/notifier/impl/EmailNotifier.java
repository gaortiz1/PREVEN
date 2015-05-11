/**
 * 
 */
package ec.com.gesso.mail.notifier.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import ec.com.gesso.mail.exception.GessoConnectionException;
import ec.com.gesso.mail.exception.GessoMailException;
import ec.com.gesso.mail.model.IEmail;
import ec.com.gesso.mail.notifier.IEmailNotifier;

/**
 * @author Gabriel
 *
 */
public class EmailNotifier implements IEmailNotifier {
	
	private JavaMailSender javaMailSender;

	public void send(final IEmail email) {
		
		this.validarModelEmail(email);
		
        try {
        	
        	final MimeMessagePreparator preparator = new MimeMessagePreparator() {

                public void prepare(final MimeMessage mimeMessage) throws Exception {
                	
                	final MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                	
                	if (ArrayUtils.isNotEmpty(email.getTo())) {
                		messageHelper.setTo(transformAddressToInternetAddress(email.getTo()));
                	}
                	
                	if (ArrayUtils.isNotEmpty(email.getCc())) {
                		messageHelper.setCc(transformAddressToInternetAddress(email.getCc()));
                	}
                	
                	if (ArrayUtils.isNotEmpty(email.getBcc())) {
                		messageHelper.setBcc(transformAddressToInternetAddress(email.getBcc()));
                	}
                	
                	messageHelper.setFrom(new InternetAddress(email.getFrom()));
                	messageHelper.setSubject(email.getSubject());
                	messageHelper.setSentDate(new Date());
                	messageHelper.setText(email.getMessage().getText(), true);
                }
            };
        	
        	this.javaMailSender.send(preparator);
		} catch (MailSendException e) {
			throw new GessoConnectionException("Fallo al intentar conectarse con servidor de mail", e);
		} catch (MailAuthenticationException e) {
			throw new GessoMailException("User o Password invalido", e);
		} catch (Exception e) {
			throw new GessoMailException("A ocurrido un error inesperado ", e);
		} 
        
	}
	
	private void validarModelEmail(final IEmail email){
		
		if (email == null) {
			throw new GessoMailException("No objeto modelEmail puede ser null ");
		}
		
		if (StringUtils.isBlank(email.getFrom())){
			throw new GessoMailException("El email debe tener una direccion de correo de referencia");
		}
		
		if (ArrayUtils.isEmpty(email.getTo())){
			throw new GessoMailException("El email debe tener al menos una dirrecion de correo para enviar");
		}
		
		if (StringUtils.isBlank(email.getSubject())){
			throw new GessoMailException("El email debe tener el subject");
		}
		
		if (email.getMessage() == null){
			throw new GessoMailException("El email debe tener el mensaje");
		}
		
		if (StringUtils.isBlank(email.getMessage().getText())){
			throw new GessoMailException("El email debe tener en el mensaje algun texto");
		}
		
	}
	
	private InternetAddress[] transformAddressToInternetAddress(final String[] addresses) throws AddressException{
		Collection<InternetAddress> internetAddresses = new ArrayList<InternetAddress>();
		for (String address : addresses) {
			internetAddresses.add(new InternetAddress(address));
		}
		return internetAddresses.toArray(new InternetAddress[]{});
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

}
