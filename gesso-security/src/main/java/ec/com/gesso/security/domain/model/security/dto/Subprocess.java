/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.gesso.security.domain.model.security.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "subprocess")
@NamedQueries({
    @NamedQuery(name = "Subprocess.findAll", query = "SELECT s FROM Subprocess s")})
public class Subprocess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_subprocess")
    private Long idSubprocess;
    @Basic(optional = false)
    @Column(name = "name_subprocess")
    private String nameSubprocess;
    @Basic(optional = false)
    @Column(name = "description_subprocess")
    private String descriptionSubprocess;
    @Basic(optional = false)
    @Column(name = "status_subprocess")
    private boolean statusSubprocess;
    @OneToMany(mappedBy = "subprocess", fetch = FetchType.LAZY)
    private Collection<Subprocess> subprocessCollection;
    @JoinColumn(name = "sub_id_subprocess", referencedColumnName = "id_subprocess")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subprocess subprocess;
    @JoinColumn(name = "id_process", referencedColumnName = "id_process")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Process process;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subprocess", fetch = FetchType.LAZY)
    private Collection<Job> jobCollection;

    public Subprocess() {
    }

    public Subprocess(Long idSubprocess) {
        this.idSubprocess = idSubprocess;
    }

    public Subprocess(Long idSubprocess, String nameSubprocess, String descriptionSubprocess, boolean statusSubprocess) {
        this.idSubprocess = idSubprocess;
        this.nameSubprocess = nameSubprocess;
        this.descriptionSubprocess = descriptionSubprocess;
        this.statusSubprocess = statusSubprocess;
    }

    public Long getIdSubprocess() {
        return idSubprocess;
    }

    public void setIdSubprocess(Long idSubprocess) {
        this.idSubprocess = idSubprocess;
    }

    public String getNameSubprocess() {
        return nameSubprocess;
    }

    public void setNameSubprocess(String nameSubprocess) {
        this.nameSubprocess = nameSubprocess;
    }

    public String getDescriptionSubprocess() {
        return descriptionSubprocess;
    }

    public void setDescriptionSubprocess(String descriptionSubprocess) {
        this.descriptionSubprocess = descriptionSubprocess;
    }

    public boolean getStatusSubprocess() {
        return statusSubprocess;
    }

    public void setStatusSubprocess(boolean statusSubprocess) {
        this.statusSubprocess = statusSubprocess;
    }

    public Collection<Subprocess> getSubprocessCollection() {
        return subprocessCollection;
    }

    public void setSubprocessCollection(Collection<Subprocess> subprocessCollection) {
        this.subprocessCollection = subprocessCollection;
    }

    public Subprocess getSubprocess() {
        return subprocess;
    }

    public void setSubprocess(Subprocess subprocess) {
        this.subprocess = subprocess;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Collection<Job> getJobCollection() {
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection) {
        this.jobCollection = jobCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubprocess != null ? idSubprocess.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subprocess)) {
            return false;
        }
        Subprocess other = (Subprocess) object;
        if ((this.idSubprocess == null && other.idSubprocess != null) || (this.idSubprocess != null && !this.idSubprocess.equals(other.idSubprocess))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.Subprocess[ idSubprocess=" + idSubprocess + " ]";
    }
    
}
