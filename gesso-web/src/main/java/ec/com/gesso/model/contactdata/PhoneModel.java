/**
 * 
 */
package ec.com.gesso.model.contactdata;

import java.io.Serializable;

/**
 * @author Gabriel
 *
 */
public class PhoneModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
    
    private String number;

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
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

}
