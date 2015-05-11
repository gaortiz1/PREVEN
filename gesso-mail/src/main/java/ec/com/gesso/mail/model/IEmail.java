/**
 * 
 */
package ec.com.gesso.mail.model;

/**
 * @author Gabriel
 *
 */
public interface IEmail {
	
	String getFrom();
	
	String[] getTo();
	
	String[] getCc();
	
	String[] getBcc();
	
	String getSubject();
	
	IMessage getMessage();

}
