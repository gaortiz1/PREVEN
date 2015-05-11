/**
 * 
 */
package ec.com.gesso.mail.model.impl;

import java.io.Serializable;

import ec.com.gesso.mail.model.IEmail;
import ec.com.gesso.mail.model.IMessage;
import ec.com.gesso.mail.resource.ResourceBundleMail;


/**
 * @author Gabriel
 *
 */
public class EmailDefaultFrom implements IEmail, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String from;
	private String[] to;
	private String[] cc;
	private String[] bcc;
	private String subject;
	private IMessage message;
	
	/**
	 * 
	 */
	public EmailDefaultFrom() {
		this.from = "no-reply@gesso.com";
	}
	
	/**
	 * @param from
	 * @param to
	 * @param cc
	 * @param bcc
	 * @param subject
	 * @param message
	 */
	public EmailDefaultFrom(String from, String[] to, String[] cc, String[] bcc, String subject, IMessage message) {
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.message = message;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public String[] getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String... to) {
		this.to = to;
	}
	/**
	 * @return the cc
	 */
	public String[] getCc() {
		return cc;
	}
	/**
	 * @param cc the cc to set
	 */
	public void setCc(String... cc) {
		this.cc = cc;
	}
	/**
	 * @return the bcc
	 */
	public String[] getBcc() {
		return bcc;
	}
	/**
	 * @param bcc the bcc to set
	 */
	public void setBcc(String... bcc) {
		this.bcc = bcc;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * @return the message
	 */
	public IMessage getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(IMessage message) {
		this.message = message;
	}
}
