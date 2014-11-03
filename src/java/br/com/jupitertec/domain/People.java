/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jupitertec.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "tb_people")
@NamedQueries({
    @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p"),
    @NamedQuery(name = "People.findByPeopleId", query = "SELECT p FROM People p WHERE p.peopleId = :peopleId"),
    @NamedQuery(name = "People.findByPeopleName", query = "SELECT p FROM People p WHERE p.peopleName = :peopleName"),
    @NamedQuery(name = "People.findByPeopleCpf", query = "SELECT p FROM People p WHERE p.peopleCpf = :peopleCpf"),
    @NamedQuery(name = "People.findByPeopleDistrict", query = "SELECT p FROM People p WHERE p.peopleDistrict = :peopleDistrict"),
    @NamedQuery(name = "People.findByPeopleCep", query = "SELECT p FROM People p WHERE p.peopleCep = :peopleCep"),
    @NamedQuery(name = "People.findByPeopleEnd", query = "SELECT p FROM People p WHERE p.peopleEnd = :peopleEnd"),
    @NamedQuery(name = "People.findByPeopleComplement", query = "SELECT p FROM People p WHERE p.peopleComplement = :peopleComplement"),
    @NamedQuery(name = "People.findByPeopleRg", query = "SELECT p FROM People p WHERE p.peopleRg = :peopleRg"),
    @NamedQuery(name = "People.findByPeoplePhoto", query = "SELECT p FROM People p WHERE p.peoplePhoto = :peoplePhoto"),
    @NamedQuery(name = "People.findByPeopleNasc", query = "SELECT p FROM People p WHERE p.peopleNasc = :peopleNasc"),
    @NamedQuery(name = "People.findByPeopleSex", query = "SELECT p FROM People p WHERE p.peopleSex = :peopleSex"),
    @NamedQuery(name = "People.findByPeopleMail", query = "SELECT p FROM People p WHERE p.peopleMail = :peopleMail")})
public class People implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "people_id")
    private Integer peopleId;
    @Basic(optional = false)
    @Column(name = "people_name")
    private String peopleName;
    @Column(name = "people_cpf")
    private String peopleCpf;
    @Column(name = "people_district")
    private String peopleDistrict;
    @Column(name = "people_cep")
    private String peopleCep;
    @Column(name = "people_end")
    private String peopleEnd;
    @Column(name = "people_complement")
    private String peopleComplement;
    @Column(name = "people_rg")
    private String peopleRg;
    @Column(name = "people_photo")
    private String peoplePhoto;
    @Column(name = "people_nasc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date peopleNasc;
    @Basic(optional = false)
    @Column(name = "people_sex")
    private String peopleSex;
    @Column(name = "people_mail")
    private String peopleMail;
    @OneToMany(mappedBy = "peopleId")
    private Collection<Functionary> functionaryCollection;
    @Transient
    @OneToMany(mappedBy = "peopleId")
    private Collection<Client> clientCollection;
    @Transient
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City cityId;

    public People() {
    }

    public People(Integer peopleId) {
        this.peopleId = null;
    }

    public People(Integer peopleId, String peopleName, String peopleSex) {
        this.peopleId = null;
        this.peopleName = peopleName;
        this.peopleSex = peopleSex;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleCpf() {
        return peopleCpf;
    }

    public void setPeopleCpf(String peopleCpf) {
        this.peopleCpf = peopleCpf;
    }

    public String getPeopleDistrict() {
        return peopleDistrict;
    }

    public void setPeopleDistrict(String peopleDistrict) {
        this.peopleDistrict = peopleDistrict;
    }

    public String getPeopleCep() {
        return peopleCep;
    }

    public void setPeopleCep(String peopleCep) {
        this.peopleCep = peopleCep;
    }

    public String getPeopleEnd() {
        return peopleEnd;
    }

    public void setPeopleEnd(String peopleEnd) {
        this.peopleEnd = peopleEnd;
    }

    public String getPeopleComplement() {
        return peopleComplement;
    }

    public void setPeopleComplement(String peopleComplement) {
        this.peopleComplement = peopleComplement;
    }

    public String getPeopleRg() {
        return peopleRg;
    }

    public void setPeopleRg(String peopleRg) {
        this.peopleRg = peopleRg;
    }

    public String getPeoplePhoto() {
        return peoplePhoto;
    }

    public void setPeoplePhoto(String peoplePhoto) {
        this.peoplePhoto = peoplePhoto;
    }

    public Date getPeopleNasc() {
        return peopleNasc;
    }

    public void setPeopleNasc(Date peopleNasc) {
        this.peopleNasc = peopleNasc;
    }

    public String getPeopleSex() {
        return peopleSex;
    }

    public void setPeopleSex(String peopleSex) {
        this.peopleSex = peopleSex;
    }

    public String getPeopleMail() {
        return peopleMail;
    }

    public void setPeopleMail(String peopleMail) {
        this.peopleMail = peopleMail;
    }

    public Collection<Functionary> getFunctionaryCollection() {
        return functionaryCollection;
    }

    public void setFunctionaryCollection(Collection<Functionary> functionaryCollection) {
        this.functionaryCollection = functionaryCollection;
    }

    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peopleId != null ? peopleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.peopleId == null && other.peopleId != null) || (this.peopleId != null && !this.peopleId.equals(other.peopleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jupitertec.domain.People[ peopleId=" + peopleId + " ]";
    }
    
}
