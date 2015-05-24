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
@Table(name = "levele_ducation")
@NamedQueries({
    @NamedQuery(name = "LeveleDucation.findAll", query = "SELECT l FROM LeveleDucation l")})
public class LeveleDucation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_leveleducation")
    private Integer idLeveleducation;
    @Basic(optional = false)
    @Column(name = "name_level")
    private String nameLevel;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leveleDucation", fetch = FetchType.LAZY)
    private Collection<Degree> degreeCollection;

    public LeveleDucation() {
    }

    public LeveleDucation(Integer idLeveleducation) {
        this.idLeveleducation = idLeveleducation;
    }

    public LeveleDucation(Integer idLeveleducation, String nameLevel, boolean status) {
        this.idLeveleducation = idLeveleducation;
        this.nameLevel = nameLevel;
        this.status = status;
    }

    public Integer getIdLeveleducation() {
        return idLeveleducation;
    }

    public void setIdLeveleducation(Integer idLeveleducation) {
        this.idLeveleducation = idLeveleducation;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<Degree> getDegreeCollection() {
        return degreeCollection;
    }

    public void setDegreeCollection(Collection<Degree> degreeCollection) {
        this.degreeCollection = degreeCollection;
    }
    
}
