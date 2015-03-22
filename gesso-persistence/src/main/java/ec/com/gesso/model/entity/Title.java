/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "title")
@NamedQueries({
    @NamedQuery(name = "Title.findAll", query = "SELECT t FROM Title t")})
public class Title implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TitlePK titlePK;
    @Basic(optional = false)
    @Column(name = "status_title")
    private boolean statusTitle;
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person person;
    @JoinColumns({
        @JoinColumn(name = "id_degree", referencedColumnName = "id_degree", insertable = false, updatable = false),
        @JoinColumn(name = "id_leveleducation", referencedColumnName = "id_leveleducation", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Degree degree;

    public Title() {
    }

    public Title(TitlePK titlePK) {
        this.titlePK = titlePK;
    }

    public Title(TitlePK titlePK, boolean statusTitle) {
        this.titlePK = titlePK;
        this.statusTitle = statusTitle;
    }

    public Title(int idDegree, int idLeveleducation, long idPerson) {
        this.titlePK = new TitlePK(idDegree, idLeveleducation, idPerson);
    }

    public TitlePK getTitlePK() {
        return titlePK;
    }

    public void setTitlePK(TitlePK titlePK) {
        this.titlePK = titlePK;
    }

    public boolean getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(boolean statusTitle) {
        this.statusTitle = statusTitle;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
