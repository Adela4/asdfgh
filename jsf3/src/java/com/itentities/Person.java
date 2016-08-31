/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itentities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "PERSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByMId", query = "SELECT p FROM Person p WHERE p.mId = :mId"),
    @NamedQuery(name = "Person.findByMName", query = "SELECT p FROM Person p WHERE p.mName = :mName"),
    @NamedQuery(name = "Person.findByMTruename", query = "SELECT p FROM Person p WHERE p.mTruename = :mTruename"),
    @NamedQuery(name = "Person.findByMTel", query = "SELECT p FROM Person p WHERE p.mTel = :mTel"),
    @NamedQuery(name = "Person.findByMPassword", query = "SELECT p FROM Person p WHERE p.mPassword = :mPassword"),
    @NamedQuery(name = "Person.findByMAuthority", query = "SELECT p FROM Person p WHERE p.mAuthority = :mAuthority")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "M_ID")
    private BigDecimal mId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "M_NAME")
    private String mName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "M_TRUENAME")
    private String mTruename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "M_TEL")
    private String mTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "M_PASSWORD")
    private String mPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "M_AUTHORITY")
    private String mAuthority;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mId")
    private Collection<Order1> order1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mId")
    private Collection<Company> companyCollection;

    public Person() {
    }

    public Person(BigDecimal mId) {
        this.mId = mId;
    }

    public Person(BigDecimal mId, String mName, String mTruename, String mTel, String mPassword, String mAuthority) {
        this.mId = mId;
        this.mName = mName;
        this.mTruename = mTruename;
        this.mTel = mTel;
        this.mPassword = mPassword;
        this.mAuthority = mAuthority;
    }

    public BigDecimal getMId() {
        return mId;
    }

    public void setMId(BigDecimal mId) {
        this.mId = mId;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMTruename() {
        return mTruename;
    }

    public void setMTruename(String mTruename) {
        this.mTruename = mTruename;
    }

    public String getMTel() {
        return mTel;
    }

    public void setMTel(String mTel) {
        this.mTel = mTel;
    }

    public String getMPassword() {
        return mPassword;
    }

    public void setMPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getMAuthority() {
        return mAuthority;
    }

    public void setMAuthority(String mAuthority) {
        this.mAuthority = mAuthority;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @XmlTransient
    public Collection<Company> getCompanyCollection() {
        return companyCollection;
    }

    public void setCompanyCollection(Collection<Company> companyCollection) {
        this.companyCollection = companyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mId != null ? mId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.mId == null && other.mId != null) || (this.mId != null && !this.mId.equals(other.mId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itentities.Person[ mId=" + mId + " ]";
    }
    
}
