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
 * @author Gabriel
 */
@Entity
@Table(name = "email")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id_email")
    @SequenceGenerator(name="seq_id_email", sequenceName="seq_id_email", allocationSize = 1)
    @Column(name = "id_email")
    private Long id;
    
    @Column(name = "id_contactdata")
    private Long idContactData;
    
    @Basic(optional = false)
    @Column(name = "emailaddess")
    private String emailaddess;
    
    @Basic(optional = false)
    @Column(name = "STATE_EMAIL")
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
