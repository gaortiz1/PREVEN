/**
 * 
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Gabriel
 *
 */
@Entity
@Table(name = "JOB_RISK")
public class JobRisk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private JobRiskPK id;
	
	@Column(name = "ID_PROBABILITY")
	private Long idProbability;
	
	@Column(name = "ID_CONSEQUENCES")
	private Long idConsequence;
	
	@Column(name = "STATE_JOB_RISK")
	private Boolean state;
	
	@JoinColumn(name = "ID_JOB", referencedColumnName = "ID_JOB", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Job job;
	
	@JoinColumn(name = "ID_RISK", referencedColumnName = "ID_RISK", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Risk risk;
	
	@JoinColumns({
		@JoinColumn(name = "ID_PROBABILITY", referencedColumnName = "ID_PROBABILITY", insertable=false, updatable=false), 
		@JoinColumn(name = "ID_CONSEQUENCES", referencedColumnName = "ID_CONSEQUENCES", insertable=false, updatable=false)
	})
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProbabilityConsequence probabilityConsequence;

	/**
	 * @return the id
	 */
	public JobRiskPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(JobRiskPK id) {
		this.id = id;
	}

	/**
	 * @return the idProbability
	 */
	public Long getIdProbability() {
		return idProbability;
	}

	/**
	 * @param idProbability the idProbability to set
	 */
	public void setIdProbability(Long idProbability) {
		this.idProbability = idProbability;
	}

	/**
	 * @return the idConsequence
	 */
	public Long getIdConsequence() {
		return idConsequence;
	}

	/**
	 * @param idConsequence the idConsequence to set
	 */
	public void setIdConsequence(Long idConsequence) {
		this.idConsequence = idConsequence;
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
	 * @return the job
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	/**
	 * @return the risk
	 */
	public Risk getRisk() {
		return risk;
	}

	/**
	 * @param risk the risk to set
	 */
	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	/**
	 * @return the probabilityConsequence
	 */
	public ProbabilityConsequence getProbabilityConsequence() {
		return probabilityConsequence;
	}

	/**
	 * @param probabilityConsequence the probabilityConsequence to set
	 */
	public void setProbabilityConsequence(ProbabilityConsequence probabilityConsequence) {
		this.probabilityConsequence = probabilityConsequence;
	}
}
