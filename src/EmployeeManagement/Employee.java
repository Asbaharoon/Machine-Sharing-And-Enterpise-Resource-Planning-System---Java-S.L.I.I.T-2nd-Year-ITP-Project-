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
public class Employee {
    
    private String empNo;
    private String epfNo;
    private String fullName;
    private String address;
    private String dob;
    private String gender;
    private String maritalStatus;
    private String title;
    private String nic;
    private String phoneNo;
    private String email;
    private String dateJoined;
    private String empType;
    private String location;
    private String department;
    private String designation;
    private String root;
    private double basicSalary;
    private String ot;
    private String epf;
    private String etf;
    private String acNo;
    private String remarks;
    private byte[] image;
    private String status="work";
    private String retirementDate=null;
    private String password;
    private String factory;
    private String searchDate;

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
     * @return the epfNo
     */
    public String getEpfNo() {
        return epfNo;
    }

    /**
     * @param epfNo the epfNo to set
     */
    public void setEpfNo(String epfNo) {
        this.epfNo = epfNo;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the dateJoined
     */
    public String getDateJoined() {
        return dateJoined;
    }

    /**
     * @param dateJoined the dateJoined to set
     */
    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    /**
     * @return the empType
     */
    public String getEmpType() {
        return empType;
    }

    /**
     * @param empType the empType to set
     */
    public void setEmpType(String empType) {
        this.empType = empType;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the basicSalary
     */
    public double getBasicSalary() {
        return basicSalary;
    }

    /**
     * @param basicSalary the basicSalary to set
     */
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * @return the root
     */
    public String getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(String root) {
        this.root = root;
    }

    /**
     * @return the acNo
     */
    public String getAcNo() {
        return acNo;
    }

    /**
     * @param acNo the acNo to set
     */
    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return the ot
     */
    public String getOt() {
        return ot;
    }

    /**
     * @param ot the ot to set
     */
    public void setOt(String ot) {
        this.ot = ot;
    }

    /**
     * @return the epf
     */
    public String getEpf() {
        return epf;
    }

    /**
     * @param epf the epf to set
     */
    public void setEpf(String epf) {
        this.epf = epf;
    }

    /**
     * @return the etf
     */
    public String getEtf() {
        return etf;
    }

    /**
     * @param etf the etf to set
     */
    public void setEtf(String etf) {
        this.etf = etf;
    }

    /**
     * @return the image
     */
    public byte[] getImage() {
        return image;
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
     * @return the retirementDate
     */
    public String getRetirementDate() {
        return retirementDate;
    }

    /**
     * @param retirementDate the retirementDate to set
     */
    public void setRetirementDate(String retirementDate) {
        this.retirementDate = retirementDate;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the factory
     */
    public String getFactory() {
        return factory;
    }

    /**
     * @param factory the factory to set
     */
    public void setFactory(String factory) {
        this.factory = factory;
    }

    /**
     * @return the searchDate
     */
    public String getSearchDate() {
        return searchDate;
    }

    /**
     * @param searchDate the searchDate to set
     */
    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }
}
