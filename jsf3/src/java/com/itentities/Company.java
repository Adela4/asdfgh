/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itentities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "COMPANY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByCId", query = "SELECT c FROM Company c WHERE c.cId = :cId"),
    @NamedQuery(name = "Company.findByCName", query = "SELECT c FROM Company c WHERE c.cName = :cName"),
    @NamedQuery(name = "Company.findByCEstablishTime", query = "SELECT c FROM Company c WHERE c.cEstablishTime = :cEstablishTime"),
    @NamedQuery(name = "Company.findByCTel", query = "SELECT c FROM Company c WHERE c.cTel = :cTel"),
    @NamedQuery(name = "Company.findByCContactor", query = "SELECT c FROM Company c WHERE c.cContactor = :cContactor")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "C_ID")
    private BigDecimal cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "C_NAME")
    private String cName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C_ESTABLISH_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cEstablishTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "C_TEL")
    private String cTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "C_CONTACTOR")
    private String cContactor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cId")
    private Collection<Order1> order1Collection;
    @JoinColumn(name = "M_ID", referencedColumnName = "M_ID")
    @ManyToOne(optional = false)
    private Person mId;

    public Company() {
    }

    public Company(BigDecimal cId) {
        this.cId = cId;
    }

    public Company(BigDecimal cId, String cName, Date cEstablishTime, String cTel, String cContactor) {
        this.cId = cId;
        this.cName = cName;
        this.cEstablishTime = cEstablishTime;
        this.cTel = cTel;
        this.cContactor = cContactor;
    }

    public BigDecimal getCId() {
        return cId;
    }

    public void setCId(BigDecimal cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public Date getCEstablishTime() {
        return cEstablishTime;
    }

    public void setCEstablishTime(Date cEstablishTime) {
        this.cEstablishTime = cEstablishTime;
    }

    public String getCTel() {
        return cTel;
    }

    public void setCTel(String cTel) {
        this.cTel = cTel;
    }

    public String getCContactor() {
        return cContactor;
    }

    public void setCContactor(String cContactor) {
        this.cContactor = cContactor;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    public Person getMId() {
        return mId;
    }

    public void setMId(Person mId) {
        this.mId = mId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itentities.Company[ cId=" + cId + " ]";
    }
    
}
