/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
 * @author sawad
 */
@Entity
@Table(name = "storage_forms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StorageForm.findAll", query = "SELECT s FROM StorageForm s")
    , @NamedQuery(name = "StorageForm.findByRequestNo", query = "SELECT s FROM StorageForm s WHERE s.requestNo = :requestNo")
    , @NamedQuery(name = "StorageForm.findByComments", query = "SELECT s FROM StorageForm s WHERE s.comments = :comments")
    , @NamedQuery(name = "StorageForm.findByExpectedGrowth", query = "SELECT s FROM StorageForm s WHERE s.expectedGrowth = :expectedGrowth")
    , @NamedQuery(name = "StorageForm.findByOwnerEmail", query = "SELECT s FROM StorageForm s WHERE s.ownerEmail = :ownerEmail")
    , @NamedQuery(name = "StorageForm.findByShareName", query = "SELECT s FROM StorageForm s WHERE s.shareName = :shareName")
    , @NamedQuery(name = "StorageForm.findByShareType", query = "SELECT s FROM StorageForm s WHERE s.shareType = :shareType")
    , @NamedQuery(name = "StorageForm.findBySize", query = "SELECT s FROM StorageForm s WHERE s.size = :size")
    , @NamedQuery(name = "StorageForm.findByTargetHosts", query = "SELECT s FROM StorageForm s WHERE s.targetHosts = :targetHosts")
    , @NamedQuery(name = "StorageForm.findByTeamEmail", query = "SELECT s FROM StorageForm s WHERE s.teamEmail = :teamEmail")
    , @NamedQuery(name = "StorageForm.findByLastUpdatedDate", query = "SELECT s FROM StorageForm s WHERE s.lastUpdatedDate = :lastUpdatedDate")
    , @NamedQuery(name = "StorageForm.findByCreatedBy", query = "SELECT s FROM StorageForm s WHERE s.createdBy = :createdBy")
    , @NamedQuery(name = "StorageForm.findByStatus", query = "SELECT s FROM StorageForm s WHERE s.status = :status")
    , @NamedQuery(name = "StorageForm.findByDepartment", query = "SELECT s FROM StorageForm s WHERE s.department = :department")
    , @NamedQuery(name = "StorageForm.findByDivision", query = "SELECT s FROM StorageForm s WHERE s.division = :division")})
public class StorageForm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "request_no")
    private String requestNo;
    @Size(max = 255)
    @Column(name = "comments")
    private String comments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expected_growth")
    private Integer expectedGrowth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "owner_email")
    private String ownerEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "share_name")
    private String shareName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "share_type")
    private String shareType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "size")
    private Integer size;
    @Size(max = 1073741823)
    @Column(name = "target_Hosts")
    private String targetHosts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "team_email")
    private String teamEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @Size(max = 1073741823)
    @Column(name = "department")
    private String department;
    @Size(max = 1073741823)
    @Column(name = "division")
    private String division;

    public StorageForm() {
    }

    public StorageForm(String requestNo) {
        this.requestNo = requestNo;
    }

    public StorageForm(String requestNo, int expectedGrowth, String ownerEmail, String shareName, String shareType, Integer size, String teamEmail, Date lastUpdatedDate, String createdBy, String status) {
        this.requestNo = requestNo;
        this.expectedGrowth = expectedGrowth;
        this.ownerEmail = ownerEmail;
        this.shareName = shareName;
        this.shareType = shareType;
        this.size = size;
        this.teamEmail = teamEmail;
        this.lastUpdatedDate = lastUpdatedDate;
        this.createdBy = createdBy;
        this.status = status;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getExpectedGrowth() {
        return expectedGrowth;
    }

    public void setExpectedGrowth(Integer expectedGrowth) {
        this.expectedGrowth = expectedGrowth;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getTargetHosts() {
        return targetHosts;
    }

    public void setTargetHosts(String targetHosts) {
        this.targetHosts = targetHosts;
    }

    public String getTeamEmail() {
        return teamEmail;
    }

    public void setTeamEmail(String teamEmail) {
        this.teamEmail = teamEmail;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestNo != null ? requestNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StorageForm)) {
            return false;
        }
        StorageForm other = (StorageForm) object;
        if ((this.requestNo == null && other.requestNo != null) || (this.requestNo != null && !this.requestNo.equals(other.requestNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StorageForm[ requestNo=" + requestNo + " ]";
    }
    
}
