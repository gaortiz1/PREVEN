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
    private Long idCatalog;
    @Basic(optional = false)
    @Column(name = "name_catalog")
    private String nameCatalog;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    
    @JoinColumn(name = "id_groupcatalog", referencedColumnName = "id_groupcatalog")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupCatalog groupCatalog;

    public Catalog() {
    }

    public Catalog(Long idCatalog) {
        this.idCatalog = idCatalog;
    }

    public Catalog(Long idCatalog, String nameCatalog, boolean status) {
        this.idCatalog = idCatalog;
        this.nameCatalog = nameCatalog;
        this.status = status;
    }

    public Long getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(Long idCatalog) {
        this.idCatalog = idCatalog;
    }

    public String getNameCatalog() {
        return nameCatalog;
    }

    public void setNameCatalog(String nameCatalog) {
        this.nameCatalog = nameCatalog;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public GroupCatalog getGroupCatalog() {
        return groupCatalog;
    }

    public void setGroupCatalog(GroupCatalog groupCatalog) {
        this.groupCatalog = groupCatalog;
    }
}
