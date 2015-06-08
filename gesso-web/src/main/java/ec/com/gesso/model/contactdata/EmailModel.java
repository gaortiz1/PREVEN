/**
 * 
 */
package ec.com.gesso.model.contactdata;

import java.io.Serializable;

/**
 * @author Gabriel
 *
 */
public class EmailModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
    
    private String emailaddess;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the emailaddess
	 */
	public String getEmailaddess() {
		return emailaddess;
	}

	/**
	 * @param emailaddess the emailaddess to set
	 */
	public void setEmailaddess(String emailaddess) {
		this.emailaddess = emailaddess;
	}
}
