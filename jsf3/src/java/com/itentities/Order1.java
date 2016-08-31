/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itentities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "ORDER1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByOId", query = "SELECT o FROM Order1 o WHERE o.oId = :oId"),
    @NamedQuery(name = "Order1.findByONum", query = "SELECT o FROM Order1 o WHERE o.oNum = :oNum"),
    @NamedQuery(name = "Order1.findByODeliver", query = "SELECT o FROM Order1 o WHERE o.oDeliver = :oDeliver"),
    @NamedQuery(name = "Order1.findByODeliverTel", query = "SELECT o FROM Order1 o WHERE o.oDeliverTel = :oDeliverTel"),
    @NamedQuery(name = "Order1.findByOReciver", query = "SELECT o FROM Order1 o WHERE o.oReciver = :oReciver"),
    @NamedQuery(name = "Order1.findByOReciverTel", query = "SELECT o FROM Order1 o WHERE o.oReciverTel = :oReciverTel"),
    @NamedQuery(name = "Order1.findByOStart", query = "SELECT o FROM Order1 o WHERE o.oStart = :oStart"),
    @NamedQuery(name = "Order1.findByOEnd", query = "SELECT o FROM Order1 o WHERE o.oEnd = :oEnd"),
    @NamedQuery(name = "Order1.findByOState", query = "SELECT o FROM Order1 o WHERE o.oState = :oState"),
    @NamedQuery(name = "Order1.findByOTotal", query = "SELECT o FROM Order1 o WHERE o.oTotal = :oTotal"),
    @NamedQuery(name = "Order1.findByOProfit", query = "SELECT o FROM Order1 o WHERE o.oProfit = :oProfit"),
    @NamedQuery(name = "Order1.findByOWeight", query = "SELECT o FROM Order1 o WHERE o.oWeight = :oWeight"),
    @NamedQuery(name = "Order1.findByPTime", query = "SELECT o FROM Order1 o WHERE o.pTime = :pTime")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "O_ID")
    private BigDecimal oId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "O_NUM")
    private String oNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "O_DELIVER")
    private String oDeliver;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "O_DELIVER_TEL")
    private String oDeliverTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "O_RECIVER")
    private String oReciver;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "O_RECIVER_TEL")
    private String oReciverTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "O_START")
    private String oStart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "O_END")
    private String oEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "O_STATE")
    private String oState;
    @Column(name = "O_TOTAL")
    private Long oTotal;
    @Column(name = "O_PROFIT")
    private Long oProfit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "O_WEIGHT")
    private long oWeight;
    @Column(name = "P_TIME")
    private BigInteger pTime;
    @JoinColumn(name = "C_ID", referencedColumnName = "C_ID")
    @ManyToOne(optional = false)
    private Company cId;
    @JoinColumn(name = "M_ID", referencedColumnName = "M_ID")
    @ManyToOne(optional = false)
    private Person mId;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    @ManyToOne
    private Price pId;

    public Order1() {
    }

    public Order1(BigDecimal oId) {
        this.oId = oId;
    }

    public Order1(BigDecimal oId, String oNum, String oDeliver, String oDeliverTel, String oReciver, String oReciverTel, String oStart, String oEnd, String oState, long oWeight) {
        this.oId = oId;
        this.oNum = oNum;
        this.oDeliver = oDeliver;
        this.oDeliverTel = oDeliverTel;
        this.oReciver = oReciver;
        this.oReciverTel = oReciverTel;
        this.oStart = oStart;
        this.oEnd = oEnd;
        this.oState = oState;
        this.oWeight = oWeight;
    }

    public BigDecimal getOId() {
        return oId;
    }

    public void setOId(BigDecimal oId) {
        this.oId = oId;
    }

    public String getONum() {
        return oNum;
    }

    public void setONum(String oNum) {
        this.oNum = oNum;
    }

    public String getODeliver() {
        return oDeliver;
    }

    public void setODeliver(String oDeliver) {
        this.oDeliver = oDeliver;
    }

    public String getODeliverTel() {
        return oDeliverTel;
    }

    public void setODeliverTel(String oDeliverTel) {
        this.oDeliverTel = oDeliverTel;
    }

    public String getOReciver() {
        return oReciver;
    }

    public void setOReciver(String oReciver) {
        this.oReciver = oReciver;
    }

    public String getOReciverTel() {
        return oReciverTel;
    }

    public void setOReciverTel(String oReciverTel) {
        this.oReciverTel = oReciverTel;
    }

    public String getOStart() {
        return oStart;
    }

    public void setOStart(String oStart) {
        this.oStart = oStart;
    }

    public String getOEnd() {
        return oEnd;
    }

    public void setOEnd(String oEnd) {
        this.oEnd = oEnd;
    }

    public String getOState() {
        return oState;
    }

    public void setOState(String oState) {
        this.oState = oState;
    }

    public Long getOTotal() {
        return oTotal;
    }

    public void setOTotal(Long oTotal) {
        this.oTotal = oTotal;
    }

    public Long getOProfit() {
        return oProfit;
    }

    public void setOProfit(Long oProfit) {
        this.oProfit = oProfit;
    }

    public long getOWeight() {
        return oWeight;
    }

    public void setOWeight(long oWeight) {
        this.oWeight = oWeight;
    }

    public BigInteger getPTime() {
        return pTime;
    }

    public void setPTime(BigInteger pTime) {
        this.pTime = pTime;
    }

    public Company getCId() {
        return cId;
    }

    public void setCId(Company cId) {
        this.cId = cId;
    }

    public Person getMId() {
        return mId;
    }

    public void setMId(Person mId) {
        this.mId = mId;
    }

    public Price getPId() {
        return pId;
    }

    public void setPId(Price pId) {
        this.pId = pId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oId != null ? oId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.oId == null && other.oId != null) || (this.oId != null && !this.oId.equals(other.oId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itentities.Order1[ oId=" + oId + " ]";
    }
    
}
