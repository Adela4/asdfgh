/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itentities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "PRICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Price.findAll", query = "SELECT p FROM Price p"),
    @NamedQuery(name = "Price.findByPId", query = "SELECT p FROM Price p WHERE p.pId = :pId"),
    @NamedQuery(name = "Price.findByCId", query = "SELECT p FROM Price p WHERE p.cId = :cId"),
    @NamedQuery(name = "Price.findByPStart", query = "SELECT p FROM Price p WHERE p.pStart = :pStart"),
    @NamedQuery(name = "Price.findByPEnd", query = "SELECT p FROM Price p WHERE p.pEnd = :pEnd"),
    @NamedQuery(name = "Price.findByPBasic", query = "SELECT p FROM Price p WHERE p.pBasic = :pBasic"),
    @NamedQuery(name = "Price.findByPExtra", query = "SELECT p FROM Price p WHERE p.pExtra = :pExtra"),
    @NamedQuery(name = "Price.findByPTime", query = "SELECT p FROM Price p WHERE p.pTime = :pTime")})
public class Price implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "P_ID")
    private BigDecimal pId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C_ID")
    private BigInteger cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "P_START")
    private String pStart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "P_END")
    private String pEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "P_BASIC")
    private long pBasic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "P_EXTRA")
    private long pExtra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "P_TIME")
    private BigInteger pTime;
    @OneToMany(mappedBy = "pId")
    private Collection<Order1> order1Collection;

    public Price() {
    }

    public Price(BigDecimal pId) {
        this.pId = pId;
    }

    public Price(BigDecimal pId, BigInteger cId, String pStart, String pEnd, long pBasic, long pExtra, BigInteger pTime) {
        this.pId = pId;
        this.cId = cId;
        this.pStart = pStart;
        this.pEnd = pEnd;
        this.pBasic = pBasic;
        this.pExtra = pExtra;
        this.pTime = pTime;
    }

    public BigDecimal getPId() {
        return pId;
    }

    public void setPId(BigDecimal pId) {
        this.pId = pId;
    }

    public BigInteger getCId() {
        return cId;
    }

    public void setCId(BigInteger cId) {
        this.cId = cId;
    }

    public String getPStart() {
        return pStart;
    }

    public void setPStart(String pStart) {
        this.pStart = pStart;
    }

    public String getPEnd() {
        return pEnd;
    }

    public void setPEnd(String pEnd) {
        this.pEnd = pEnd;
    }

    public long getPBasic() {
        return pBasic;
    }

    public void setPBasic(long pBasic) {
        this.pBasic = pBasic;
    }

    public long getPExtra() {
        return pExtra;
    }

    public void setPExtra(long pExtra) {
        this.pExtra = pExtra;
    }

    public BigInteger getPTime() {
        return pTime;
    }

    public void setPTime(BigInteger pTime) {
        this.pTime = pTime;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Price)) {
            return false;
        }
        Price other = (Price) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itentities.Price[ pId=" + pId + " ]";
    }
    
}
