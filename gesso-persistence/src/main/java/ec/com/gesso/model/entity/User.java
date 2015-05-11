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
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usr_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_new_user")
    @SequenceGenerator(name="seq_new_user", sequenceName="seq_new_user", allocationSize = 1)
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "usr_nick_name")
    private String nickName;
    @Basic(optional = false)
    @Column(name = "usr_password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDto", fetch = FetchType.LAZY)
    private Collection<UserProfile> lstUserProfile;

    @OneToOne(mappedBy = "userDto", fetch = FetchType.LAZY)
//    @Transient
    private Person person;
    
    public User() {
    }

    public User(Integer usrId) {
        this.userId = usrId;
    }

    public User(Integer usrId, String usrNickName, String usrPassword) {
        this.userId = usrId;
        this.nickName = usrNickName;
        this.password = usrPassword;
    }
    
    public User(String usrNickName, String usrPassword) {
        this.nickName = usrNickName;
        this.password = usrPassword;
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<UserProfile> getLstUserProfile() {
		return lstUserProfile;
	}

	public void setLstUserProfile(Collection<UserProfile> lstUserProfile) {
		this.lstUserProfile = lstUserProfile;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

    
    
}
