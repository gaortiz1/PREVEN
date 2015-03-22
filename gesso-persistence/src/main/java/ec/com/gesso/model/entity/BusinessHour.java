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
@Table(name = "business_hour")
@NamedQueries({
    @NamedQuery(name = "BusinessHour.findAll", query = "SELECT b FROM BusinessHour b")})
public class BusinessHour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_business_hour")
    private Integer idBusinessHour;
    @Basic(optional = false)
    @Column(name = "name_business_hour")
    private String nameBusinessHour;
    @Basic(optional = false)
    @Column(name = "state_business_hour")
    private boolean stateBusinessHour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businessHour", fetch = FetchType.LAZY)
    private Collection<ScheduleWork> scheduleWorkCollection;

    public BusinessHour() {
    }

    public BusinessHour(Integer idBusinessHour) {
        this.idBusinessHour = idBusinessHour;
    }

    public BusinessHour(Integer idBusinessHour, String nameBusinessHour, boolean stateBusinessHour) {
        this.idBusinessHour = idBusinessHour;
        this.nameBusinessHour = nameBusinessHour;
        this.stateBusinessHour = stateBusinessHour;
    }

    public Integer getIdBusinessHour() {
        return idBusinessHour;
    }

    public void setIdBusinessHour(Integer idBusinessHour) {
        this.idBusinessHour = idBusinessHour;
    }

    public String getNameBusinessHour() {
        return nameBusinessHour;
    }

    public void setNameBusinessHour(String nameBusinessHour) {
        this.nameBusinessHour = nameBusinessHour;
    }

    public boolean getStateBusinessHour() {
        return stateBusinessHour;
    }

    public void setStateBusinessHour(boolean stateBusinessHour) {
        this.stateBusinessHour = stateBusinessHour;
    }

    public Collection<ScheduleWork> getScheduleWorkCollection() {
        return scheduleWorkCollection;
    }

    public void setScheduleWorkCollection(Collection<ScheduleWork> scheduleWorkCollection) {
        this.scheduleWorkCollection = scheduleWorkCollection;
    }
}
