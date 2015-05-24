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
@Table(name = "contact_data")
public class ContactData implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_contactdata")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id_contact_data")
    @SequenceGenerator(name="seq_id_contact_data", sequenceName="seq_id_contact_data", allocationSize = 1)
    private Long id;
    
    @Column(name = "id_person")
    private Long idPerson;
    
    @Column(name = "id_company")
    private Long idCompany;
    
    @Column(name = "STATE_CONTACTDATA")
    private Boolean state;
    
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
    
    @JoinColumn(name = "id_company", referencedColumnName = "id_company", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    
    @OneToMany(mappedBy = "contactData", fetch = FetchType.LAZY)
    private Collection<Phone> collectionPhones;
    
    @OneToMany(mappedBy = "contactData", fetch = FetchType.LAZY)
    private Collection<Email> collectionEmails;
    
    @OneToMany(mappedBy = "contactData", fetch = FetchType.LAZY)
    private Collection<Address> collectionAddress;

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
	 * @return the idPerson
	 */
	public Long getIdPerson() {
		return idPerson;
	}

	/**
	 * @param idPerson the idPerson to set
	 */
	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	/**
	 * @return the idCompany
	 */
	public Long getIdCompany() {
		return idCompany;
	}

	/**
	 * @param idCompany the idCompany to set
	 */
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
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
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the collectionPhones
	 */
	public Collection<Phone> getCollectionPhones() {
		return collectionPhones;
	}

	/**
	 * @param collectionPhones the collectionPhones to set
	 */
	public void setCollectionPhones(Collection<Phone> collectionPhones) {
		this.collectionPhones = collectionPhones;
	}

	/**
	 * @return the collectionEmails
	 */
	public Collection<Email> getCollectionEmails() {
		return collectionEmails;
	}

	/**
	 * @param collectionEmails the collectionEmails to set
	 */
	public void setCollectionEmails(Collection<Email> collectionEmails) {
		this.collectionEmails = collectionEmails;
	}

	/**
	 * @return the collectionAddress
	 */
	public Collection<Address> getCollectionAddress() {
		return collectionAddress;
	}

	/**
	 * @param collectionAddress the collectionAddress to set
	 */
	public void setCollectionAddress(Collection<Address> collectionAddress) {
		this.collectionAddress = collectionAddress;
	}
}
