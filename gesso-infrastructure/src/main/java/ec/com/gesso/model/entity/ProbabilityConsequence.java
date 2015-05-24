/**
 * 
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Gabriel
 *
 */
@Entity
@Table(name = "PROBABILITY_CONSEQUENCES")
public class ProbabilityConsequence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProbabilityConsequencePK id;
	
	@Column(name = "ESTIMATE_RISK")
	private String estimateRiks;
	
	@Column(name = "STATE_PRO_CON")
	private Boolean state;
	
	@JoinColumn(name = "ID_PROBABILITY", referencedColumnName = "id_catalog", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Catalog probability;
	
	
	@JoinColumn(name = "ID_CONSEQUENCES", referencedColumnName = "id_catalog", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Catalog consequence;
	
	@OneToMany(mappedBy="probabilityConsequence", fetch=FetchType.LAZY)
	private Collection<JobRisk> jobRisks;


	/**
	 * @return the id
	 */
	public ProbabilityConsequencePK getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(ProbabilityConsequencePK id) {
		this.id = id;
	}


	/**
	 * @return the estimateRiks
	 */
	public String getEstimateRiks() {
		return estimateRiks;
	}


	/**
	 * @param estimateRiks the estimateRiks to set
	 */
	public void setEstimateRiks(String estimateRiks) {
		this.estimateRiks = estimateRiks;
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
	 * @return the probability
	 */
	public Catalog getProbability() {
		return probability;
	}


	/**
	 * @param probability the probability to set
	 */
	public void setProbability(Catalog probability) {
		this.probability = probability;
	}


	/**
	 * @return the consequence
	 */
	public Catalog getConsequence() {
		return consequence;
	}


	/**
	 * @param consequence the consequence to set
	 */
	public void setConsequence(Catalog consequence) {
		this.consequence = consequence;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
