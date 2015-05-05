/**
 * 
 */
package ec.com.gesso.mail.model;

/**
 * @author Gabriel
 *
 */
public interface IModelEmail {
	
	String getFrom();
	
	String[] getTo();
	
	String[] getCc();
	
	String[] getBcc();
	
	String getSubject();
	
	IModelMessage getMessage();

}
