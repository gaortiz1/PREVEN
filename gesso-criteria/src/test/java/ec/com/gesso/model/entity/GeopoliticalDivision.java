/**
 * 
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
 * @author Gabriel
 *
 */
@Entity
@Table(name = "GEOPOLITICAL_DIVISION")
public class GeopoliticalDivision implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_div_geo_pol")
	@SequenceGenerator(name = "seq_id_div_geo_pol", sequenceName = "seq_id_div_geo_pol", allocationSize = 1)
	@Column(name = "ID_GEOPOLITICAL_DIVISION")
	private Long id;

	@Column(name = "ID_ROOT_GEOPOLITICAL_DIVISION")
	private Long idRoot;

	@Column(name = "NAME_GEOPOLITICAL_DIVISION")
	private String name;

	@Column(name = "STATE_GEOPOLITICAL_DIVISION")
	private Boolean state;
	
	@JoinColumn(name = "ID_ROOT_GEOPOLITICAL_DIVISION", referencedColumnName = "ID_GEOPOLITICAL_DIVISION", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private GeopoliticalDivision geopoliticalDivisionRoot;
	
	@OneToMany(mappedBy = "geopoliticalDivisionRoot", fetch = FetchType.LAZY)
	private Collection<GeopoliticalDivision> collectionDivisionsChild;

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
	 * @return the idRoot
	 */
	public Long getIdRoot() {
		return idRoot;
	}

	/**
	 * @param idRoot the idRoot to set
	 */
	public void setIdRoot(Long idRoot) {
		this.idRoot = idRoot;
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
	 * @return the geopoliticalDivisionRoot
	 */
	public GeopoliticalDivision getGeopoliticalDivisionRoot() {
		return geopoliticalDivisionRoot;
	}

	/**
	 * @param geopoliticalDivisionRoot the geopoliticalDivisionRoot to set
	 */
	public void setGeopoliticalDivisionRoot(
			GeopoliticalDivision geopoliticalDivisionRoot) {
		this.geopoliticalDivisionRoot = geopoliticalDivisionRoot;
	}

	/**
	 * @return the collectionDivisionsChild
	 */
	public Collection<GeopoliticalDivision> getCollectionDivisionsChild() {
		return collectionDivisionsChild;
	}

	/**
	 * @param collectionDivisionsChild the collectionDivisionsChild to set
	 */
	public void setCollectionDivisionsChild(
			Collection<GeopoliticalDivision> collectionDivisionsChild) {
		this.collectionDivisionsChild = collectionDivisionsChild;
	}

}