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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "degree")
@NamedQueries({
    @NamedQuery(name = "Degree.findAll", query = "SELECT d FROM Degree d")})
public class Degree implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DegreePK degreePK;
    @Basic(optional = false)
    @Column(name = "name_degree")
    private String nameDegree;
    @Basic(optional = false)
    @Column(name = "status_degree")
    private boolean statusDegree;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "degree", fetch = FetchType.LAZY)
    private Collection<Title> titleCollection;
    @JoinColumn(name = "id_leveleducation", referencedColumnName = "id_leveleducation", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeveleDucation leveleDucation;

    public Degree() {
    }

    public Degree(DegreePK degreePK) {
        this.degreePK = degreePK;
    }

    public Degree(DegreePK degreePK, String nameDegree, boolean statusDegree) {
        this.degreePK = degreePK;
        this.nameDegree = nameDegree;
        this.statusDegree = statusDegree;
    }

    public Degree(int idDegree, int idLeveleducation) {
        this.degreePK = new DegreePK(idDegree, idLeveleducation);
    }

    public DegreePK getDegreePK() {
        return degreePK;
    }

    public void setDegreePK(DegreePK degreePK) {
        this.degreePK = degreePK;
    }

    public String getNameDegree() {
        return nameDegree;
    }

    public void setNameDegree(String nameDegree) {
        this.nameDegree = nameDegree;
    }

    public boolean getStatusDegree() {
        return statusDegree;
    }

    public void setStatusDegree(boolean statusDegree) {
        this.statusDegree = statusDegree;
    }

    public Collection<Title> getTitleCollection() {
        return titleCollection;
    }

    public void setTitleCollection(Collection<Title> titleCollection) {
        this.titleCollection = titleCollection;
    }

    public LeveleDucation getLeveleDucation() {
        return leveleDucation;
    }

    public void setLeveleDucation(LeveleDucation leveleDucation) {
        this.leveleDucation = leveleDucation;
    }
    
}
