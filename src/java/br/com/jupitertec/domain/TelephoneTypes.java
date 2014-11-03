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
@Table(name = "tb_telephone_types")
@NamedQueries({
    @NamedQuery(name = "TelephoneTypes.findAll", query = "SELECT t FROM TelephoneTypes t"),
    @NamedQuery(name = "TelephoneTypes.findByTelephoneTypeId", query = "SELECT t FROM TelephoneTypes t WHERE t.telephoneTypeId = :telephoneTypeId"),
    @NamedQuery(name = "TelephoneTypes.findByTelephoneTypeName", query = "SELECT t FROM TelephoneTypes t WHERE t.telephoneTypeName = :telephoneTypeName")})
public class TelephoneTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "telephone_type_id")
    private Integer telephoneTypeId;
    @Basic(optional = false)
    @Column(name = "telephone_type_name")
    private String telephoneTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telephoneTypeId")
    private Collection<Telephone> telephoneCollection;

    public TelephoneTypes() {
    }

    public TelephoneTypes(Integer telephoneTypeId) {
        this.telephoneTypeId = telephoneTypeId;
    }

    public TelephoneTypes(Integer telephoneTypeId, String telephoneTypeName) {
        this.telephoneTypeId = telephoneTypeId;
        this.telephoneTypeName = telephoneTypeName;
    }

    public Integer getTelephoneTypeId() {
        return telephoneTypeId;
    }

    public void setTelephoneTypeId(Integer telephoneTypeId) {
        this.telephoneTypeId = telephoneTypeId;
    }

    public String getTelephoneTypeName() {
        return telephoneTypeName;
    }

    public void setTelephoneTypeName(String telephoneTypeName) {
        this.telephoneTypeName = telephoneTypeName;
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
        hash += (telephoneTypeId != null ? telephoneTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelephoneTypes)) {
            return false;
        }
        TelephoneTypes other = (TelephoneTypes) object;
        if ((this.telephoneTypeId == null && other.telephoneTypeId != null) || (this.telephoneTypeId != null && !this.telephoneTypeId.equals(other.telephoneTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jupitertec.domain.TelephoneTypes[ telephoneTypeId=" + telephoneTypeId + " ]";
    }
    
}
