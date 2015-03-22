/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "catalog")
@NamedQueries({
    @NamedQuery(name = "Catalog.findAll", query = "SELECT c FROM Catalog c")})
public class Catalog implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_catalog")
    private String id;
    
    @Column(name = "id_groupcatalog")
    private String idGroupcatalog;
    
    @Basic(optional = false)
    @Column(name = "name_catalog")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "STATUS_CATALOG")
    private Boolean state;
    
    @JoinColumn(name = "id_groupcatalog", referencedColumnName = "id_groupcatalog", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupCatalog groupCatalog;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the idGroupcatalog
	 */
	public String getIdGroupcatalog() {
		return idGroupcatalog;
	}

	/**
	 * @param idGroupcatalog the idGroupcatalog to set
	 */
	public void setIdGroupcatalog(String idGroupcatalog) {
		this.idGroupcatalog = idGroupcatalog;
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
	 * @return the groupCatalog
	 */
	public GroupCatalog getGroupCatalog() {
		return groupCatalog;
	}

	/**
	 * @param groupCatalog the groupCatalog to set
	 */
	public void setGroupCatalog(GroupCatalog groupCatalog) {
		this.groupCatalog = groupCatalog;
	}
}
