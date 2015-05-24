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
@Table(name = "phone")
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id_phone")
    @SequenceGenerator(name="seq_id_phone", sequenceName="seq_id_phone", allocationSize = 1)
    @Column(name = "id_phone")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "ID_CATALOG_PHONE")
    private String idtypePhone;
    
    @Column(name = "id_contactdata")
    private Long idContactData;
    
    @Basic(optional = false)
    @Column(name = "number")
    private String number;
    
    @Basic(optional = false)
    @Column(name = "STATE_PHONE")
    private Boolean state;
    
    @JoinColumn(name = "ID_CATALOG_PHONE", referencedColumnName = "id_catalog", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Catalog catalogTypePhone;
    
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
	 * @return the idtypePhone
	 */
	public String getIdtypePhone() {
		return idtypePhone;
	}

	/**
	 * @param idtypePhone the idtypePhone to set
	 */
	public void setIdtypePhone(String idtypePhone) {
		this.idtypePhone = idtypePhone;
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
	 * @return the catalogTypePhone
	 */
	public Catalog getCatalogTypePhone() {
		return catalogTypePhone;
	}

	/**
	 * @param catalogTypePhone the catalogTypePhone to set
	 */
	public void setCatalogTypePhone(Catalog catalogTypePhone) {
		this.catalogTypePhone = catalogTypePhone;
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
