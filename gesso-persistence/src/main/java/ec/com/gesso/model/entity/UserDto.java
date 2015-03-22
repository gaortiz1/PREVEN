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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "seg_user")
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usr_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_new_user")
    @SequenceGenerator(name="seq_new_user", sequenceName="seq_new_user", allocationSize = 1)
    private Integer usrId;
    @Basic(optional = false)
    @Column(name = "usr_nick_name")
    private String usrNickName;
    @Basic(optional = false)
    @Column(name = "usr_password")
    private String usrPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDto", fetch = FetchType.LAZY)
    private Collection<UserProfileDto> segUserProfileCollection;

    @OneToOne(mappedBy = "userDto", fetch = FetchType.LAZY)
//    @Transient
    private Person person;
    
    public UserDto() {
    }

    public UserDto(Integer usrId) {
        this.usrId = usrId;
    }

    public UserDto(Integer usrId, String usrNickName, String usrPassword) {
        this.usrId = usrId;
        this.usrNickName = usrNickName;
        this.usrPassword = usrPassword;
    }
    
    public UserDto(String usrNickName, String usrPassword) {
        this.usrNickName = usrNickName;
        this.usrPassword = usrPassword;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrNickName() {
		return usrNickName;
	}

	public void setUsrNickName(String usrNickName) {
		this.usrNickName = usrNickName;
	}

	public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public Collection<UserProfileDto> getSegUserProfileCollection() {
        return segUserProfileCollection;
    }

    public void setSegUserProfileCollection(Collection<UserProfileDto> segUserProfileCollection) {
        this.segUserProfileCollection = segUserProfileCollection;
    }

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
    
}
