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
@Table(name = "contact_data")
public class ContactData implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_contactdata")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id_contact_data")
    @SequenceGenerator(name="seq_id_contact_data", sequenceName="seq_id_contact_data", allocationSize = 1)
    private Long id;
    
    @Column(name = "id_email")
    private Long idEmail;
    
    @Column(name = "ID_ADDRESS")
    private Long idAddress;
    
    @Column(name = "id_phone")
    private Long idPhone;
    
    @Column(name = "id_person")
    private Long idPerson;
    
    @Column(name = "id_company")
    private Long idCompany;
    
    @Column(name = "STATE_CONTACTDATA")
    private Boolean state;
    
    @JoinColumn(name = "id_phone", referencedColumnName = "id_phone", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Phone phone;
    
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
    
    @JoinColumn(name = "id_email", referencedColumnName = "id_email", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Email email;
    
    @JoinColumn(name = "id_company", referencedColumnName = "id_company", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    
    @JoinColumn(name = "id_address", referencedColumnName = "id_address", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

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
	 * @return the idEmail
	 */
	public Long getIdEmail() {
		return idEmail;
	}

	/**
	 * @param idEmail the idEmail to set
	 */
	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}

	/**
	 * @return the idAddress
	 */
	public Long getIdAddress() {
		return idAddress;
	}

	/**
	 * @param idAddress the idAddress to set
	 */
	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	/**
	 * @return the idPhone
	 */
	public Long getIdPhone() {
		return idPhone;
	}

	/**
	 * @param idPhone the idPhone to set
	 */
	public void setIdPhone(Long idPhone) {
		this.idPhone = idPhone;
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
	 * @return the phone
	 */
	public Phone getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Phone phone) {
		this.phone = phone;
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
	 * @return the email
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(Email email) {
		this.email = email;
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
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
