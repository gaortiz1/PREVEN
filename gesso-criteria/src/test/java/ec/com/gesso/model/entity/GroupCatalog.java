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
    @Column(name = "status_group_catalog")
    private Boolean state;
    
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
