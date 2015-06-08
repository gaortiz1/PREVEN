package ec.com.gesso.model.contactdata;

import java.io.Serializable;

public class AddressModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
    private String nameAddress;

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
	 * @return the nameAddress
	 */
	public String getNameAddress() {
		return nameAddress;
	}

	/**
	 * @param nameAddress the nameAddress to set
	 */
	public void setNameAddress(String nameAddress) {
		this.nameAddress = nameAddress;
	}

}
