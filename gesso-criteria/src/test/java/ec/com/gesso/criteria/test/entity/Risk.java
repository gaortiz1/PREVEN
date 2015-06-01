/**
 * 
 */
package ec.com.gesso.criteria.test.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Gabriel
 *
 */
@Entity
@Table(name = "RISK")
public class Risk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @Column(name = "ID_RISK")
	private Long id;
	
	@Column(name = "ID_FACTOR")
	private Long idFactor;
	
	@Column(name = "NAME_RISK")
	private String name;
	
	@Column(name = "STATE_RISK")
	private Boolean state;
	
	@JoinColumn(name = "ID_FACTOR", referencedColumnName = "ID_FACTOR", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Factor factor;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="risk")
	private Collection<JobRisk> jobRisks;

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
	 * @return the idFactor
	 */
	public Long getIdFactor() {
		return idFactor;
	}

	/**
	 * @param idFactor the idFactor to set
	 */
	public void setIdFactor(Long idFactor) {
		this.idFactor = idFactor;
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
	 * @return the factor
	 */
	public Factor getFactor() {
		return factor;
	}

	/**
	 * @param factor the factor to set
	 */
	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	/**
	 * @return the jobRisks
	 */
	public Collection<JobRisk> getJobRisks() {
		return jobRisks;
	}

	/**
	 * @param jobRisks the jobRisks to set
	 */
	public void setJobRisks(Collection<JobRisk> jobRisks) {
		this.jobRisks = jobRisks;
	}

}
