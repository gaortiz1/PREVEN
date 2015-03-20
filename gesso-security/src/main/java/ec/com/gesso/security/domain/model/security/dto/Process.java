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
@Table(name = "process")
@NamedQueries({
    @NamedQuery(name = "Process.findAll", query = "SELECT p FROM Process p")})
public class Process implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_process")
    private Long idProcess;
    @Basic(optional = false)
    @Column(name = "name_process")
    private String nameProcess;
    @Basic(optional = false)
    @Column(name = "description_process")
    private String descriptionProcess;
    @Basic(optional = false)
    @Column(name = "status_process")
    private boolean statusProcess;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "process", fetch = FetchType.LAZY)
    private Collection<Subprocess> subprocessCollection;
    @OneToMany(mappedBy = "process", fetch = FetchType.LAZY)
    private Collection<Process> processCollection;
    @JoinColumn(name = "pro_id_process", referencedColumnName = "id_process")
    @ManyToOne(fetch = FetchType.LAZY)
    private Process process;

    public Process() {
    }

    public Process(Long idProcess) {
        this.idProcess = idProcess;
    }

    public Process(Long idProcess, String nameProcess, String descriptionProcess, boolean statusProcess) {
        this.idProcess = idProcess;
        this.nameProcess = nameProcess;
        this.descriptionProcess = descriptionProcess;
        this.statusProcess = statusProcess;
    }

    public Long getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(Long idProcess) {
        this.idProcess = idProcess;
    }

    public String getNameProcess() {
        return nameProcess;
    }

    public void setNameProcess(String nameProcess) {
        this.nameProcess = nameProcess;
    }

    public String getDescriptionProcess() {
        return descriptionProcess;
    }

    public void setDescriptionProcess(String descriptionProcess) {
        this.descriptionProcess = descriptionProcess;
    }

    public boolean getStatusProcess() {
        return statusProcess;
    }

    public void setStatusProcess(boolean statusProcess) {
        this.statusProcess = statusProcess;
    }

    public Collection<Subprocess> getSubprocessCollection() {
        return subprocessCollection;
    }

    public void setSubprocessCollection(Collection<Subprocess> subprocessCollection) {
        this.subprocessCollection = subprocessCollection;
    }

    public Collection<Process> getProcessCollection() {
        return processCollection;
    }

    public void setProcessCollection(Collection<Process> processCollection) {
        this.processCollection = processCollection;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcess != null ? idProcess.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Process)) {
            return false;
        }
        Process other = (Process) object;
        if ((this.idProcess == null && other.idProcess != null) || (this.idProcess != null && !this.idProcess.equals(other.idProcess))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.Process[ idProcess=" + idProcess + " ]";
    }
    
}
