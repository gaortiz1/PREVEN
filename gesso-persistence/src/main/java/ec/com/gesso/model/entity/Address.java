/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_address")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id_address")
    @SequenceGenerator(name="seq_id_address", sequenceName="seq_id_address", allocationSize = 1)
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "name_address")
    private String nameAddress;
    
    @Basic(optional = false)
    @Column(name = "STATE_ADDRESS")
    private Boolean state;
    
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Collection<ContactData> contactDataCollection;

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

	/**
	 * @return the state
	 */
	public Boolean getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Boolean state) {
		this.state = state;
	}

	/**
	 * @return the contactDataCollection
	 */
	public Collection<ContactData> getContactDataCollection() {
		return contactDataCollection;
	}

	/**
	 * @param contactDataCollection the contactDataCollection to set
	 */
	public void setContactDataCollection(
			Collection<ContactData> contactDataCollection) {
		this.contactDataCollection = contactDataCollection;
	}
}
