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
@Table(name = "tb_functionary")
@NamedQueries({
    @NamedQuery(name = "Functionary.findAll", query = "SELECT f FROM Functionary f"),
    @NamedQuery(name = "Functionary.findByFunctionaryId", query = "SELECT f FROM Functionary f WHERE f.functionaryId = :functionaryId"),
    @NamedQuery(name = "Functionary.findByFunctionaryBiometry", query = "SELECT f FROM Functionary f WHERE f.functionaryBiometry = :functionaryBiometry")})
public class Functionary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "functionary_id")
    private Integer functionaryId;
    @Basic(optional = false)
    @Column(name = "functionary_biometry")
    private long functionaryBiometry;
    @JoinColumn(name = "people_id", referencedColumnName = "people_id")
    @ManyToOne
    private People peopleId;
    @JoinColumn(name = "functionary_type_id", referencedColumnName = "functionary_type_id")
    @ManyToOne
    private FunctionaryTypes functionaryTypeId;

    public Functionary() {
    }

    public Functionary(Integer functionaryId) {
        this.functionaryId = functionaryId;
    }

    public Functionary(Integer functionaryId, long functionaryBiometry) {
        this.functionaryId = functionaryId;
        this.functionaryBiometry = functionaryBiometry;
    }

    public Integer getFunctionaryId() {
        return functionaryId;
    }

    public void setFunctionaryId(Integer functionaryId) {
        this.functionaryId = functionaryId;
    }

    public long getFunctionaryBiometry() {
        return functionaryBiometry;
    }

    public void setFunctionaryBiometry(long functionaryBiometry) {
        this.functionaryBiometry = functionaryBiometry;
    }

    public People getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(People peopleId) {
        this.peopleId = peopleId;
    }

    public FunctionaryTypes getFunctionaryTypeId() {
        return functionaryTypeId;
    }

    public void setFunctionaryTypeId(FunctionaryTypes functionaryTypeId) {
        this.functionaryTypeId = functionaryTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (functionaryId != null ? functionaryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Functionary)) {
            return false;
        }
        Functionary other = (Functionary) object;
        if ((this.functionaryId == null && other.functionaryId != null) || (this.functionaryId != null && !this.functionaryId.equals(other.functionaryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jupitertec.domain.Functionary[ functionaryId=" + functionaryId + " ]";
    }
    
}
