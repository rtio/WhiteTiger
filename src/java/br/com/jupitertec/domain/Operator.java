/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jupitertec.domain;

import java.io.Serializable;
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

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "tb_operator")
@NamedQueries({
    @NamedQuery(name = "Operator.findAll", query = "SELECT o FROM Operator o"),
    @NamedQuery(name = "Operator.findByOperatorId", query = "SELECT o FROM Operator o WHERE o.operatorId = :operatorId"),
    @NamedQuery(name = "Operator.findByOperatorName", query = "SELECT o FROM Operator o WHERE o.operatorName = :operatorName")})
public class Operator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "operator_id")
    private Integer operatorId;
    @Basic(optional = false)
    @Column(name = "operator_name")
    private String operatorName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operatorId")
    private Collection<Telephone> telephoneCollection;

    public Operator() {
    }

    public Operator(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Operator(Integer operatorId, String operatorName) {
        this.operatorId = operatorId;
        this.operatorName = operatorName;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Collection<Telephone> getTelephoneCollection() {
        return telephoneCollection;
    }

    public void setTelephoneCollection(Collection<Telephone> telephoneCollection) {
        this.telephoneCollection = telephoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operatorId != null ? operatorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operator)) {
            return false;
        }
        Operator other = (Operator) object;
        if ((this.operatorId == null && other.operatorId != null) || (this.operatorId != null && !this.operatorId.equals(other.operatorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jupitertec.domain.Operator[ operatorId=" + operatorId + " ]";
    }
    
}
