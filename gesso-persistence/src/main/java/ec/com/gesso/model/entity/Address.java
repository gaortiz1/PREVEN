/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @Column(name = "id_contactdata")
    private Long idContactData;
    
    @Basic(optional = false)
    @Column(name = "name_address")
    private String nameAddress;
    
    @Basic(optional = false)
    @Column(name = "STATE_ADDRESS")
    private Boolean state;
    
    @JoinColumn(name = "id_contactdata", referencedColumnName = "id_contactdata", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ContactData contactData;

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
	 * @return the idContactData
	 */
	public Long getIdContactData() {
		return idContactData;
	}

	/**
	 * @param idContactData the idContactData to set
	 */
	public void setIdContactData(Long idContactData) {
		this.idContactData = idContactData;
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
	 * @return the contactData
	 */
	public ContactData getContactData() {
		return contactData;
	}

	/**
	 * @param contactData the contactData to set
	 */
	public void setContactData(ContactData contactData) {
		this.contactData = contactData;
	}
}
