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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Gabriel
 *
 */
@Entity
@Table(name = "FACTOR")
public class Factor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "ID_FACTOR")
	private Long id;
	
	@Column(name = "NAME_FACTOR")
	private String name;
	
	@Column(name = "ORDER")
	private Integer order;
	
	@Column(name = "STATE_FACTOR")
	private Boolean state;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="factor")
	private Collection<Risk> risks;

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
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
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
	 * @return the risks
	 */
	public Collection<Risk> getRisks() {
		return risks;
	}

	/**
	 * @param risks the risks to set
	 */
	public void setRisks(Collection<Risk> risks) {
		this.risks = risks;
	}

}
