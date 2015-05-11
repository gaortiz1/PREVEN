/**
 * 
 */
package ec.com.gesso.mail.resource;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Gabriel
 *
 */
public class ResourceBundleMail {
	
	private final static ResourceBundleMail INSTANCE = new ResourceBundleMail();
	private final ResourceBundle rb = ResourceBundle.getBundle("ec.com.gesso.domain.resource.spring.config.mail");
	
	/**
	 * @return the instance
	 */
	public static ResourceBundleMail getInstance() {
		return INSTANCE;
	}
	
	public String getValue(final String key){
		try {
			return rb.getString(key);
		} catch(MissingResourceException e){
			return StringUtils.EMPTY;
		} catch (Exception e) {
			return StringUtils.EMPTY;
		}
	}

}
