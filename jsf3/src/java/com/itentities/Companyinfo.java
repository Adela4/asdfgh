/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itentities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "COMPANYINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companyinfo.findAll", query = "SELECT c FROM Companyinfo c"),
    @NamedQuery(name = "Companyinfo.findByCiId", query = "SELECT c FROM Companyinfo c WHERE c.ciId = :ciId"),
    @NamedQuery(name = "Companyinfo.findByCiText", query = "SELECT c FROM Companyinfo c WHERE c.ciText = :ciText"),
    @NamedQuery(name = "Companyinfo.findByCiTime", query = "SELECT c FROM Companyinfo c WHERE c.ciTime = :ciTime"),
    @NamedQuery(name = "Companyinfo.findByMId", query = "SELECT c FROM Companyinfo c WHERE c.mId = :mId")})
public class Companyinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CI_ID")
    private BigDecimal ciId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "CI_TEXT")
    private String ciText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CI_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ciTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "M_ID")
    private String mId;

    public Companyinfo() {
    }

    public Companyinfo(BigDecimal ciId) {
        this.ciId = ciId;
    }

    public Companyinfo(BigDecimal ciId, String ciText, Date ciTime, String mId) {
        this.ciId = ciId;
        this.ciText = ciText;
        this.ciTime = ciTime;
        this.mId = mId;
    }

    public BigDecimal getCiId() {
        return ciId;
    }

    public void setCiId(BigDecimal ciId) {
        this.ciId = ciId;
    }

    public String getCiText() {
        return ciText;
    }

    public void setCiText(String ciText) {
        this.ciText = ciText;
    }

    public Date getCiTime() {
        return ciTime;
    }

    public void setCiTime(Date ciTime) {
        this.ciTime = ciTime;
    }

    public String getMId() {
        return mId;
    }

    public void setMId(String mId) {
        this.mId = mId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciId != null ? ciId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companyinfo)) {
            return false;
        }
        Companyinfo other = (Companyinfo) object;
        if ((this.ciId == null && other.ciId != null) || (this.ciId != null && !this.ciId.equals(other.ciId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itentities.Companyinfo[ ciId=" + ciId + " ]";
    }
    
}
