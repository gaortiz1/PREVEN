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
 * 
 * @author Gabriel
 *
 */
@Entity
@Table(name = "PROCESS")
public class Process implements Serializable{
	
	/**
	 * asdasd
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_PROCESS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id_process")
    @SequenceGenerator(name="seq_id_process", sequenceName="seq_id_process", allocationSize = 1)
	private Long id;
	
	@Column(name = "ID_PROCESS_ROOT")
	private Long idRoot;
	
	@Column(name = "NAME_PROCESS")
	private String name;
	
	@Column(name = "DESCRIPTION_PROCESS")
	private String description;
	
	@Column(name = "STATUS_PROCESS")
	private Boolean status; 
	
	@JoinColumn(name = "ID_PROCESS_ROOT", referencedColumnName = "ID_PROCESS_ROOT", insertable=false, updatable=false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Process levelProcessRoot;
	
	@OneToMany(mappedBy="processRoot")
	private Collection<SubProcess> subProcesses;
	
	@OneToMany(mappedBy="levelProcessRoot")
	private Collection<Process> subLevels;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the levelProcessRoot
	 */
	public Process getLevelProcessRoot() {
		return levelProcessRoot;
	}

	/**
	 * @param levelProcessRoot the levelProcessRoot to set
	 */
	public void setLevelProcessRoot(Process levelProcessRoot) {
		this.levelProcessRoot = levelProcessRoot;
	}

	/**
	 * @return the subProcesses
	 */
	public Collection<SubProcess> getSubProcesses() {
		return subProcesses;
	}

	/**
	 * @param subProcesses the subProcesses to set
	 */
	public void setSubProcesses(Collection<SubProcess> subProcesses) {
		this.subProcesses = subProcesses;
	}

	/**
	 * @return the subLevels
	 */
	public Collection<Process> getSubLevels() {
		return subLevels;
	}

	/**
	 * @param subLevels the subLevels to set
	 */
	public void setSubLevels(Collection<Process> subLevels) {
		this.subLevels = subLevels;
	}
}
