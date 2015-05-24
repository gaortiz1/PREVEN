/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

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
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author roberto
 * pruebas
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
    
//    @Column(name = "ID_GEOPOLITICAL_DIVISION")
    @Transient
	private Long idDivgeoPol;
    
    @Column(name = "id_catalog")
    private String idSexCatalog;
    
    @Column(name = "id_catalog_vulnerability")
    private String idCatalogVulnerability;
    
    @Column(name = "lactation_period")
    private Boolean lactationPeriod;
    
    @Column(name = "personal_local_phone")
    private String personalLocalPhone;
    @Column(name = "personal_mobil_phone")
    private String personalMobilPhone;
    
    @Column(name = "personal_email")
    private String personalEmail;
    
    @Column(name = "id_code_profesion")
    private String idCodeProfesion;
    
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
//    @Basic(optional = false)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(iso = ISO.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "status_person")
    private Boolean statusPerson;
    @Column(name = "per_document_number")
    private String documentNumber;
    
    @Column(name = "disability")
    private Boolean disability;
    
    
    @Column(name = "percentage_disability")
    private Integer percentageDisability;
    
    @Column(name = "occupational_accident")
    private Boolean occupationalAccident;
    
    @Column(name = "occupational_accident_detail")
    private String occupationalAccidentDetail;

    @Column(name = "usr_id")
    private Integer userId;
    
    @Column(name = "security_training_detail")
    private String securityTrainingDetail;
    
    private String paiscodigo;
    
    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(iso = ISO.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Transient
    private Date dateJobStart;
    
    @Column(name = "id_catalog_education")
    private String idEducaionLevelCatalog;
    
    @Column(name = "work_review")
    private String workReview;
    
    @Transient
    private String lastCompany;
    
    @Column(name = "security_unit_member")
    private Boolean securityUnitMember;
    
    @Column(name = "security_committee_member")
    private Boolean securityCommitteeMember;
    
    
    @Transient
    private Long idProcess;
    
    @Transient
    private Long idSubProcess;
    
    @Column(name = "id_job")
    private Long idJob;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
    private Collection<CurriculumVitae> curriculumVitaeCollection;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", insertable = false, updatable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private User userDto;
    @JoinColumn(name = "id_catalog", referencedColumnName = "id_catalog", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Catalog sexCatalogDto;
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

    public Person(Long idPerson, String firstName, String lastName, Date dateOfBirth, Boolean statusPerson) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.statusPerson = statusPerson;
    }
    
    public Person(String firstName, String lastName, Date dateOfBirth, Boolean statusPerson) {
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

    /**
	 * @return the idDivgeoPol
	 */
	public Long getIdDivgeoPol() {
		return idDivgeoPol;
	}

	/**
	 * @param idDivgeoPol the idDivgeoPol to set
	 */
	public void setIdDivgeoPol(Long idDivgeoPol) {
		this.idDivgeoPol = idDivgeoPol;
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

    public Boolean getStatusPerson() {
        return statusPerson;
    }

    public void setStatusPerson(Boolean statusPerson) {
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

    public User getUserDto() {
		return userDto;
	}

	public void setUserDto(User userDto) {
		this.userDto = userDto;
	}

    public Catalog getSexCatalogDto() {
		return sexCatalogDto;
	}

	public void setSexCatalogDto(Catalog sexCatalogDto) {
		this.sexCatalogDto = sexCatalogDto;
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

	

	public String getIdSexCatalog() {
		return idSexCatalog;
	}

	public void setIdSexCatalog(String idSexCatalog) {
		this.idSexCatalog = idSexCatalog;
	}



	public Boolean getDisability() {
		return disability;
	}

	public void setDisability(Boolean disability) {
		this.disability = disability;
	}

	public Integer getPercentageDisability() {
		return percentageDisability;
	}

	public void setPercentageDisability(Integer percentageDisability) {
		this.percentageDisability = percentageDisability;
	}

	
	public String getIdCatalogVulnerability() {
		return idCatalogVulnerability;
	}

	public void setIdCatalogVulnerability(String idCatalogVulnerability) {
		this.idCatalogVulnerability = idCatalogVulnerability;
	}

	public Boolean getLactationPeriod() {
		return lactationPeriod;
	}

	public void setLactationPeriod(Boolean lactationPeriod) {
		this.lactationPeriod = lactationPeriod;
	}

	public String getPersonalLocalPhone() {
		return personalLocalPhone;
	}

	public void setPersonalLocalPhone(String personalLocalPhone) {
		this.personalLocalPhone = personalLocalPhone;
	}

	public String getPersonalMobilPhone() {
		return personalMobilPhone;
	}

	public void setPersonalMobilPhone(String personalMobilPhone) {
		this.personalMobilPhone = personalMobilPhone;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getPaiscodigo() {
		return paiscodigo;
	}

	public void setPaiscodigo(String paiscodigo) {
		this.paiscodigo = paiscodigo;
	}

	public Date getDateJobStart() {
		return dateJobStart;
	}

	public void setDateJobStart(Date dateJobStart) {
		this.dateJobStart = dateJobStart;
	}

	public String getIdEducaionLevelCatalog() {
		return idEducaionLevelCatalog;
	}

	public void setIdEducaionLevelCatalog(String idEducaionLevelCatalog) {
		this.idEducaionLevelCatalog = idEducaionLevelCatalog;
	}

	public String getWorkReview() {
		return workReview;
	}

	public void setWorkReview(String workReview) {
		this.workReview = workReview;
	}

	public String getLastCompany() {
		return lastCompany;
	}

	public void setLastCompany(String lastCompany) {
		this.lastCompany = lastCompany;
	}

	public Boolean getOccupationalAccident() {
		return occupationalAccident;
	}

	public void setOccupationalAccident(Boolean occupationalAccident) {
		this.occupationalAccident = occupationalAccident;
	}

	public String getOccupationalAccidentDetail() {
		return occupationalAccidentDetail;
	}

	public void setOccupationalAccidentDetail(String occupationalAccidentDetail) {
		this.occupationalAccidentDetail = occupationalAccidentDetail;
	}

	public String getSecurityTrainingDetail() {
		return securityTrainingDetail;
	}

	public void setSecurityTrainingDetail(String securityTrainingDetail) {
		this.securityTrainingDetail = securityTrainingDetail;
	}

	public String getIdCodeProfesion() {
		return idCodeProfesion;
	}

	public void setIdCodeProfesion(String idCodeProfesion) {
		this.idCodeProfesion = idCodeProfesion;
	}

	public Boolean getSecurityUnitMember() {
		return securityUnitMember;
	}

	public void setSecurityUnitMember(Boolean securityUnitMember) {
		this.securityUnitMember = securityUnitMember;
	}

	public Boolean getSecurityCommitteeMember() {
		return securityCommitteeMember;
	}

	public void setSecurityCommitteeMember(Boolean securityCommitteeMember) {
		this.securityCommitteeMember = securityCommitteeMember;
	}

	public Long getIdProcess() {
		return idProcess;
	}

	public void setIdProcess(Long idProcess) {
		this.idProcess = idProcess;
	}

	public Long getIdSubProcess() {
		return idSubProcess;
	}

	public void setIdSubProcess(Long idSubProcess) {
		this.idSubProcess = idSubProcess;
	}

	public Long getIdJob() {
		return idJob;
	}

	public void setIdJob(Long idJob) {
		this.idJob = idJob;
	}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
