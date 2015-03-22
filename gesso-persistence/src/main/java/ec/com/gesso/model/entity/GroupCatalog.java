/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "group_catalog")
@NamedQueries({
    @NamedQuery(name = "GroupCatalog.findAll", query = "SELECT g FROM GroupCatalog g")})
public class GroupCatalog implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_groupcatalog")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "name_groupcatalog")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "STATUS_GROUP_CATALOG")
    private boolean status;
    
    @OneToMany(mappedBy = "groupCatalog", fetch = FetchType.LAZY)
    private Collection<Catalog> catalogCollection;

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
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the catalogCollection
	 */
	public Collection<Catalog> getCatalogCollection() {
		return catalogCollection;
	}

	/**
	 * @param catalogCollection the catalogCollection to set
	 */
	public void setCatalogCollection(Collection<Catalog> catalogCollection) {
		this.catalogCollection = catalogCollection;
	}
    
}
