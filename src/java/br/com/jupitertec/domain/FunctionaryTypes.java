/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jupitertec.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "tb_functionary_types")
@NamedQueries({
    @NamedQuery(name = "FunctionaryTypes.findAll", query = "SELECT f FROM FunctionaryTypes f"),
    @NamedQuery(name = "FunctionaryTypes.findByFunctionaryTypeId", query = "SELECT f FROM FunctionaryTypes f WHERE f.functionaryTypeId = :functionaryTypeId"),
    @NamedQuery(name = "FunctionaryTypes.findByFunctionaryTypeName", query = "SELECT f FROM FunctionaryTypes f WHERE f.functionaryTypeName = :functionaryTypeName")})
public class FunctionaryTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "functionary_type_id")
    private Integer functionaryTypeId;
    @Basic(optional = false)
    @Column(name = "functionary_type_name")
    private String functionaryTypeName;
    @OneToMany(mappedBy = "functionaryTypeId")
    private Collection<Functionary> functionaryCollection;

    public FunctionaryTypes() {
    }

    public FunctionaryTypes(Integer functionaryTypeId) {
        this.functionaryTypeId = functionaryTypeId;
    }

    public FunctionaryTypes(Integer functionaryTypeId, String functionaryTypeName) {
        this.functionaryTypeId = functionaryTypeId;
        this.functionaryTypeName = functionaryTypeName;
    }

    public Integer getFunctionaryTypeId() {
        return functionaryTypeId;
    }

    public void setFunctionaryTypeId(Integer functionaryTypeId) {
        this.functionaryTypeId = functionaryTypeId;
    }

    public String getFunctionaryTypeName() {
        return functionaryTypeName;
    }

    public void setFunctionaryTypeName(String functionaryTypeName) {
        this.functionaryTypeName = functionaryTypeName;
    }

    public Collection<Functionary> getFunctionaryCollection() {
        return functionaryCollection;
    }

    public void setFunctionaryCollection(Collection<Functionary> functionaryCollection) {
        this.functionaryCollection = functionaryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (functionaryTypeId != null ? functionaryTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FunctionaryTypes)) {
            return false;
        }
        FunctionaryTypes other = (FunctionaryTypes) object;
        if ((this.functionaryTypeId == null && other.functionaryTypeId != null) || (this.functionaryTypeId != null && !this.functionaryTypeId.equals(other.functionaryTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jupitertec.domain.FunctionaryTypes[ functionaryTypeId=" + functionaryTypeId + " ]";
    }
    
}
