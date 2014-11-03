/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jupitertec.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "tb_telephone")
@NamedQueries({
    @NamedQuery(name = "Telephone.findAll", query = "SELECT t FROM Telephone t"),
    @NamedQuery(name = "Telephone.findByTelephoneId", query = "SELECT t FROM Telephone t WHERE t.telephoneId = :telephoneId"),
    @NamedQuery(name = "Telephone.findByTelephoneNumber", query = "SELECT t FROM Telephone t WHERE t.telephoneNumber = :telephoneNumber")})
public class Telephone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "telephone_id")
    private Integer telephoneId;
    @Basic(optional = false)
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @JoinColumn(name = "telephone_type_id", referencedColumnName = "telephone_type_id")
    @ManyToOne(optional = false)
    private TelephoneTypes telephoneTypeId;
    @JoinColumn(name = "operator_id", referencedColumnName = "operator_id")
    @ManyToOne(optional = false)
    private Operator operatorId;

    public Telephone() {
    }

    public Telephone(Integer telephoneId) {
        this.telephoneId = telephoneId;
    }

    public Telephone(Integer telephoneId, String telephoneNumber) {
        this.telephoneId = telephoneId;
        this.telephoneNumber = telephoneNumber;
    }

    public Integer getTelephoneId() {
        return telephoneId;
    }

    public void setTelephoneId(Integer telephoneId) {
        this.telephoneId = telephoneId;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public TelephoneTypes getTelephoneTypeId() {
        return telephoneTypeId;
    }

    public void setTelephoneTypeId(TelephoneTypes telephoneTypeId) {
        this.telephoneTypeId = telephoneTypeId;
    }

    public Operator getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Operator operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telephoneId != null ? telephoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telephone)) {
            return false;
        }
        Telephone other = (Telephone) object;
        if ((this.telephoneId == null && other.telephoneId != null) || (this.telephoneId != null && !this.telephoneId.equals(other.telephoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jupitertec.domain.Telephone[ telephoneId=" + telephoneId + " ]";
    }
    
}
