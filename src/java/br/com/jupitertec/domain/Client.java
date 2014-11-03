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
@Table(name = "tb_client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientId", query = "SELECT c FROM Client c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Client.findByClientBiometry", query = "SELECT c FROM Client c WHERE c.clientBiometry = :clientBiometry"),
    @NamedQuery(name = "Client.findByClientPassword", query = "SELECT c FROM Client c WHERE c.clientPassword = :clientPassword"),
    @NamedQuery(name = "Client.findByClientStatus", query = "SELECT c FROM Client c WHERE c.clientStatus = :clientStatus"),
    @NamedQuery(name = "Client.findByClientObs", query = "SELECT c FROM Client c WHERE c.clientObs = :clientObs")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "client_id")
    private Integer clientId;
    @Basic(optional = false)
    @Column(name = "client_biometry")
    private long clientBiometry;
    @Column(name = "client_password")
    private String clientPassword;
    @Column(name = "client_status")
    private Boolean clientStatus;
    @Column(name = "client_obs")
    private String clientObs;
    @JoinColumn(name = "people_id", referencedColumnName = "people_id")
    @ManyToOne
    private People peopleId;

    public Client() {
    }

    public Client(Integer clientId) {
        this.clientId = clientId;
    }

    public Client(Integer clientId, long clientBiometry) {
        this.clientId = clientId;
        this.clientBiometry = clientBiometry;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public long getClientBiometry() {
        return clientBiometry;
    }

    public void setClientBiometry(long clientBiometry) {
        this.clientBiometry = clientBiometry;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public Boolean getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(Boolean clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getClientObs() {
        return clientObs;
    }

    public void setClientObs(String clientObs) {
        this.clientObs = clientObs;
    }

    public People getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(People peopleId) {
        this.peopleId = peopleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jupitertec.domain.Client[ clientId=" + clientId + " ]";
    }
    
}
