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
@Table(name = "SUBPROCESS")
public class Job implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_JOB")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id_job")
    @SequenceGenerator(name="seq_id_job", sequenceName="seq_id_job	", allocationSize = 1)
	private Long id;
	
	@Column(name = "ID_JOB_ROOT")
	private Long idRoot;
	
	@Column(name = "ID_SUBPROCESS")
	private Long idSubProcess;
	
	@Column(name = "NAME_JOB")
	private String name;
	
	@Column(name = "DESCRIPTION_JOB")
	private String description;
	
	@Column(name = "STATUS_JOB")
	private Boolean status; 
	
	@JoinColumn(name = "ID_JOB_ROOT", referencedColumnName = "ID_JOB_ROOT", insertable=false, updatable=false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Job levelJobRoot;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_SUBPROCESS", referencedColumnName = "ID_SUBPROCESS", insertable=false, updatable=false)
	private SubProcess subProcessRoot;
	
	@OneToMany(mappedBy="levelJobRoot")
	private Collection<Job> subLevels;

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
	 * @return the idSubProcess
	 */
	public Long getIdSubProcess() {
		return idSubProcess;
	}

	/**
	 * @param idSubProcess the idSubProcess to set
	 */
	public void setIdSubProcess(Long idSubProcess) {
		this.idSubProcess = idSubProcess;
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
	 * @return the levelJobRoot
	 */
	public Job getLevelJobRoot() {
		return levelJobRoot;
	}

	/**
	 * @param levelJobRoot the levelJobRoot to set
	 */
	public void setLevelJobRoot(Job levelJobRoot) {
		this.levelJobRoot = levelJobRoot;
	}

	/**
	 * @return the subProcessRoot
	 */
	public SubProcess getSubProcessRoot() {
		return subProcessRoot;
	}

	/**
	 * @param subProcessRoot the subProcessRoot to set
	 */
	public void setSubProcessRoot(SubProcess subProcessRoot) {
		this.subProcessRoot = subProcessRoot;
	}

	/**
	 * @return the subLevels
	 */
	public Collection<Job> getSubLevels() {
		return subLevels;
	}

	/**
	 * @param subLevels the subLevels to set
	 */
	public void setSubLevels(Collection<Job> subLevels) {
		this.subLevels = subLevels;
	}
}
