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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private String typePhone;
    
    @Basic(optional = false)
    @Column(name = "number")
    private String number;
    
    @Basic(optional = false)
    @Column(name = "STATE_PHONE")
    private Boolean state;
    
    @JoinColumn(name = "ID_CATALOG_PHONE", referencedColumnName = "id_catalog", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Catalog catalog;
    
    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY)
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
	 * @return the typePhone
	 */
	public String getTypePhone() {
		return typePhone;
	}

	/**
	 * @param typePhone the typePhone to set
	 */
	public void setTypePhone(String typePhone) {
		this.typePhone = typePhone;
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
	 * @return the catalog
	 */
	public Catalog getCatalog() {
		return catalog;
	}

	/**
	 * @param catalog the catalog to set
	 */
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
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
