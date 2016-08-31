/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itentities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "BULLET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bullet.findAll", query = "SELECT b FROM Bullet b"),
    @NamedQuery(name = "Bullet.findByBId", query = "SELECT b FROM Bullet b WHERE b.bId = :bId"),
    @NamedQuery(name = "Bullet.findByBText", query = "SELECT b FROM Bullet b WHERE b.bText = :bText"),
    @NamedQuery(name = "Bullet.findByBTime", query = "SELECT b FROM Bullet b WHERE b.bTime = :bTime"),
    @NamedQuery(name = "Bullet.findByMId", query = "SELECT b FROM Bullet b WHERE b.mId = :mId")})
public class Bullet implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "B_ID")
    private BigDecimal bId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "B_TEXT")
    private String bText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "B_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "M_ID")
    private BigInteger mId;

    public Bullet() {
    }

    public Bullet(BigDecimal bId) {
        this.bId = bId;
    }

    public Bullet(BigDecimal bId, String bText, Date bTime, BigInteger mId) {
        this.bId = bId;
        this.bText = bText;
        this.bTime = bTime;
        this.mId = mId;
    }

    public BigDecimal getBId() {
        return bId;
    }

    public void setBId(BigDecimal bId) {
        this.bId = bId;
    }

    public String getBText() {
        return bText;
    }

    public void setBText(String bText) {
        this.bText = bText;
    }

    public Date getBTime() {
        return bTime;
    }

    public void setBTime(Date bTime) {
        this.bTime = bTime;
    }

    public BigInteger getMId() {
        return mId;
    }

    public void setMId(BigInteger mId) {
        this.mId = mId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bullet)) {
            return false;
        }
        Bullet other = (Bullet) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itentities.Bullet[ bId=" + bId + " ]";
    }
    
}
