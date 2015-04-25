/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id_company")
    @SequenceGenerator(name="seq_id_company", sequenceName="seq_id_company", allocationSize = 1)
    @Column(name = "id_company")
    private Long id;
    
    @Column(name = "ID_TYPE_COMPANY")
    private String idTypeCompany;
    
    @Column(name = "ID_PRODUCTIVE_SECTOR")
    private String idProductiveSector;
    
    @Column(name = "ID_GEOPOLITICAL_DIVISION")
	private Long idGeopoliticalDivision;
    
    @Basic(optional = false)
    @Column(name = "name_company")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    
    @Basic(optional = false)
    @Column(name = "state_company")
    private Boolean state;
    
    @JoinColumn(name = "ID_PRODUCTIVE_SECTOR", referencedColumnName = "id_catalog", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Catalog catalogSectorProductivo;
    
    @JoinColumn(name = "ID_TYPE_COMPANY", referencedColumnName = "id_catalog", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Catalog typeCompany;
    
    @JoinColumn(name = "ID_GEOPOLITICAL_DIVISION", referencedColumnName = "ID_GEOPOLITICAL_DIVISION", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GeopoliticalDivision geopoliticalDivision;
    
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Subcompany> subcompanyCollection;
    
    @OneToMany( mappedBy = "company1", fetch = FetchType.LAZY)
    private Set<Subcompany> subcompanyCollection1;
    
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<ActivityEconomicCompany> activityEconomicCompanyCollection;
    
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Document> documentCollection;
    
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<ScheduleWork> scheduleWorkCollection;
    
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<ContactData> contactDataCollection;

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
	 * @return the idTypeCompany
	 */
	public String getIdTypeCompany() {
		return idTypeCompany;
	}

	/**
	 * @param idTypeCompany the idTypeCompany to set
	 */
	public void setIdTypeCompany(String idTypeCompany) {
		this.idTypeCompany = idTypeCompany;
	}

	/**
	 * @return the idProductiveSector
	 */
	public String getIdProductiveSector() {
		return idProductiveSector;
	}

	/**
	 * @param idProductiveSector the idProductiveSector to set
	 */
	public void setIdProductiveSector(String idProductiveSector) {
		this.idProductiveSector = idProductiveSector;
	}

	/**
	 * @return the idGeopoliticalDivision
	 */
	public Long getIdGeopoliticalDivision() {
		return idGeopoliticalDivision;
	}

	/**
	 * @param idGeopoliticalDivision the idGeopoliticalDivision to set
	 */
	public void setIdGeopoliticalDivision(Long idGeopoliticalDivision) {
		this.idGeopoliticalDivision = idGeopoliticalDivision;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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
	 * @return the catalogSectorProductivo
	 */
	public Catalog getCatalogSectorProductivo() {
		return catalogSectorProductivo;
	}

	/**
	 * @param catalogSectorProductivo the catalogSectorProductivo to set
	 */
	public void setCatalogSectorProductivo(Catalog catalogSectorProductivo) {
		this.catalogSectorProductivo = catalogSectorProductivo;
	}

	/**
	 * @return the typeCompany
	 */
	public Catalog getTypeCompany() {
		return typeCompany;
	}

	/**
	 * @param typeCompany the typeCompany to set
	 */
	public void setTypeCompany(Catalog typeCompany) {
		this.typeCompany = typeCompany;
	}

	/**
	 * @return the geopoliticalDivision
	 */
	public GeopoliticalDivision getGeopoliticalDivision() {
		return geopoliticalDivision;
	}

	/**
	 * @param geopoliticalDivision the geopoliticalDivision to set
	 */
	public void setGeopoliticalDivision(GeopoliticalDivision geopoliticalDivision) {
		this.geopoliticalDivision = geopoliticalDivision;
	}

	/**
	 * @return the subcompanyCollection
	 */
	public Set<Subcompany> getSubcompanyCollection() {
		return subcompanyCollection;
	}

	/**
	 * @param subcompanyCollection the subcompanyCollection to set
	 */
	public void setSubcompanyCollection(Set<Subcompany> subcompanyCollection) {
		this.subcompanyCollection = subcompanyCollection;
	}

	/**
	 * @return the subcompanyCollection1
	 */
	public Set<Subcompany> getSubcompanyCollection1() {
		return subcompanyCollection1;
	}

	/**
	 * @param subcompanyCollection1 the subcompanyCollection1 to set
	 */
	public void setSubcompanyCollection1(Set<Subcompany> subcompanyCollection1) {
		this.subcompanyCollection1 = subcompanyCollection1;
	}

	/**
	 * @return the activityEconomicCompanyCollection
	 */
	public Set<ActivityEconomicCompany> getActivityEconomicCompanyCollection() {
		return activityEconomicCompanyCollection;
	}

	/**
	 * @param activityEconomicCompanyCollection the activityEconomicCompanyCollection to set
	 */
	public void setActivityEconomicCompanyCollection(
			Set<ActivityEconomicCompany> activityEconomicCompanyCollection) {
		this.activityEconomicCompanyCollection = activityEconomicCompanyCollection;
	}

	/**
	 * @return the documentCollection
	 */
	public Set<Document> getDocumentCollection() {
		return documentCollection;
	}

	/**
	 * @param documentCollection the documentCollection to set
	 */
	public void setDocumentCollection(Set<Document> documentCollection) {
		this.documentCollection = documentCollection;
	}

	/**
	 * @return the scheduleWorkCollection
	 */
	public Set<ScheduleWork> getScheduleWorkCollection() {
		return scheduleWorkCollection;
	}

	/**
	 * @param scheduleWorkCollection the scheduleWorkCollection to set
	 */
	public void setScheduleWorkCollection(Set<ScheduleWork> scheduleWorkCollection) {
		this.scheduleWorkCollection = scheduleWorkCollection;
	}

	/**
	 * @return the contactDataCollection
	 */
	public Set<ContactData> getContactDataCollection() {
		return contactDataCollection;
	}

	/**
	 * @param contactDataCollection the contactDataCollection to set
	 */
	public void setContactDataCollection(Set<ContactData> contactDataCollection) {
		this.contactDataCollection = contactDataCollection;
	}
}
