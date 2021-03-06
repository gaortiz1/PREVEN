/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.criteria.test.entity;

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
    private Collection<ActivityEconomicCompany> activityEconomicCompanyCollection;
    
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Document> documentCollection;
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
	 * @return the activityEconomicCompanyCollection
	 */
	public Collection<ActivityEconomicCompany> getActivityEconomicCompanyCollection() {
		return activityEconomicCompanyCollection;
	}

	/**
	 * @param activityEconomicCompanyCollection the activityEconomicCompanyCollection to set
	 */
	public void setActivityEconomicCompanyCollection(
			Collection<ActivityEconomicCompany> activityEconomicCompanyCollection) {
		this.activityEconomicCompanyCollection = activityEconomicCompanyCollection;
	}

	/**
	 * @return the documentCollection
	 */
	public Collection<Document> getDocumentCollection() {
		return documentCollection;
	}

	/**
	 * @param documentCollection the documentCollection to set
	 */
	public void setDocumentCollection(Collection<Document> documentCollection) {
		this.documentCollection = documentCollection;
	}
}
