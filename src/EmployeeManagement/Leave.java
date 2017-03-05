/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeManagement;

/**
 *
 * @author isuru
 */
public class Leave {
    
    private String leaveNo;
    private String empNo;
    private String name;
    private String departmentNo;
//    private String department;
    private String type;
    private String dateFrom;
    private String dateTo;
    
    private int fullDays;
    private int halfDays;
    private String reason;
    private String phoneNo;
    private String status="Pending";
    private String approvedBy;

    /**
     * @return the leaveNo
     */
    public String getLeaveNo() {
        return leaveNo;
    }

    /**
     * @param leaveNo the leaveNo to set
     */
    public void setLeaveNo(String leaveNo) {
        this.leaveNo = leaveNo;
    }

    /**
     * @return the empNo
     */
    public String getEmpNo() {
        return empNo;
    }

    /**
     * @param empNo the empNo to set
     */
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    /**
     * @return the departmentNo
     */
    public String getDepartmentNo() {
        return departmentNo;
    }

    /**
     * @param departmentNo the departmentNo to set
     */
    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the dateFrom
     */
    public String getDateFrom() {
        return dateFrom;
    }

    /**
     * @param dateFrom the dateFrom to set
     */
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * @return the dateTo
     */
    public String getDateTo() {
        return dateTo;
    }

    /**
     * @param dateTo the dateTo to set
     */
    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the fullDays
     */
    public int getFullDays() {
        return fullDays;
    }

    /**
     * @param fullDays the fullDays to set
     */
    public void setFullDays(int fullDays) {
        this.fullDays = fullDays;
    }

    /**
     * @return the halfDays
     */
    public int getHalfDays() {
        return halfDays;
    }

    /**
     * @param halfDays the halfDays to set
     */
    public void setHalfDays(int halfDays) {
        this.halfDays = halfDays;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the approvedBy
     */
    public String getApprovedBy() {
        return approvedBy;
    }

    /**
     * @param approvedBy the approvedBy to set
     */
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    
}
