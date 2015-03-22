/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
    private Integer idGroupcatalog;
    @Basic(optional = false)
    @Column(name = "name_groupcatalog")
    private String nameGroupcatalog;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupCatalog", fetch = FetchType.LAZY)
    private Collection<Catalog> catalogCollection;

    public GroupCatalog() {
    }

    public GroupCatalog(Integer idGroupcatalog) {
        this.idGroupcatalog = idGroupcatalog;
    }

    public GroupCatalog(Integer idGroupcatalog, String nameGroupcatalog, boolean status) {
        this.idGroupcatalog = idGroupcatalog;
        this.nameGroupcatalog = nameGroupcatalog;
        this.status = status;
    }

    public Integer getIdGroupcatalog() {
        return idGroupcatalog;
    }

    public void setIdGroupcatalog(Integer idGroupcatalog) {
        this.idGroupcatalog = idGroupcatalog;
    }

    public String getNameGroupcatalog() {
        return nameGroupcatalog;
    }

    public void setNameGroupcatalog(String nameGroupcatalog) {
        this.nameGroupcatalog = nameGroupcatalog;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<Catalog> getCatalogCollection() {
        return catalogCollection;
    }

    public void setCatalogCollection(Collection<Catalog> catalogCollection) {
        this.catalogCollection = catalogCollection;
    }
    
}
