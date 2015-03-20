/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author roberto
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "person")

public class Person implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "id_person")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_new_person")
    @SequenceGenerator(name="seq_new_person", sequenceName="seq_new_person", allocationSize = 1)
    private Long idPerson;
    
    @Column(name = "id_catalog")
    private Integer idCatalog;
    
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "second_last_name")
    private String secondLastName;
    @Basic(optional = false)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "status_person")
    private boolean statusPerson;
    @Column(name = "per_document_number")
    private String documentNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
    private Collection<CurriculumVitae> curriculumVitaeCollection;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @OneToOne(fetch = FetchType.LAZY)
    private UserDto userDto;
    @JoinColumn(name = "id_catalog", referencedColumnName = "id_catalog")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Catalog catalog;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
    private Collection<Title> titleCollection;
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private Collection<Document> documentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
    private Collection<Disability> disabilityCollection;
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private Collection<ContactData> contactDataCollection;

    public Person() {
    }

    public Person(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Person(Long idPerson, String firstName, String lastName, Date dateOfBirth, boolean statusPerson) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.statusPerson = statusPerson;
    }
    
    public Person(String firstName, String lastName, Date dateOfBirth, boolean statusPerson) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.statusPerson = statusPerson;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean getStatusPerson() {
        return statusPerson;
    }

    public void setStatusPerson(boolean statusPerson) {
        this.statusPerson = statusPerson;
    }

    public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

    public Collection<CurriculumVitae> getCurriculumVitaeCollection() {
        return curriculumVitaeCollection;
    }

    public void setCurriculumVitaeCollection(Collection<CurriculumVitae> curriculumVitaeCollection) {
        this.curriculumVitaeCollection = curriculumVitaeCollection;
    }

    public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Collection<Title> getTitleCollection() {
        return titleCollection;
    }

    public void setTitleCollection(Collection<Title> titleCollection) {
        this.titleCollection = titleCollection;
    }

    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    public Collection<Disability> getDisabilityCollection() {
        return disabilityCollection;
    }

    public void setDisabilityCollection(Collection<Disability> disabilityCollection) {
        this.disabilityCollection = disabilityCollection;
    }

    public Collection<ContactData> getContactDataCollection() {
        return contactDataCollection;
    }

    public void setContactDataCollection(Collection<ContactData> contactDataCollection) {
        this.contactDataCollection = contactDataCollection;
    }

    public Integer getIdCatalog() {
		return idCatalog;
	}

	public void setIdCatalog(Integer idCatalog) {
		this.idCatalog = idCatalog;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.Person[ idPerson=" + idPerson + " ]";
    }
    
}
