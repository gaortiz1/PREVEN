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
@Table(name = "email")
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e")})
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_email")
    private Long idEmail;
    @Basic(optional = false)
    @Column(name = "emailaddess")
    private String emailaddess;
    @Basic(optional = false)
    @Column(name = "status_email")
    private boolean statusEmail;
    @OneToMany(mappedBy = "email", fetch = FetchType.LAZY)
    private Collection<ContactData> contactDataCollection;

    public Email() {
    }

    public Email(Long idEmail) {
        this.idEmail = idEmail;
    }

    public Email(Long idEmail, String emailaddess, boolean statusEmail) {
        this.idEmail = idEmail;
        this.emailaddess = emailaddess;
        this.statusEmail = statusEmail;
    }

    public Long getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Long idEmail) {
        this.idEmail = idEmail;
    }

    public String getEmailaddess() {
        return emailaddess;
    }

    public void setEmailaddess(String emailaddess) {
        this.emailaddess = emailaddess;
    }

    public boolean getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(boolean statusEmail) {
        this.statusEmail = statusEmail;
    }

    public Collection<ContactData> getContactDataCollection() {
        return contactDataCollection;
    }

    public void setContactDataCollection(Collection<ContactData> contactDataCollection) {
        this.contactDataCollection = contactDataCollection;
    }
}
