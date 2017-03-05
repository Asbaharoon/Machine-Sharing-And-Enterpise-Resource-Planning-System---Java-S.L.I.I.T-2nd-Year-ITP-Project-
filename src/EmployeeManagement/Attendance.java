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
public class Attendance {
    private String empNo;
    private String inTime;
    private String offTime;
    private String date;
    private int otHrs;

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
     * @return the inTime
     */
    public String getInTime() {
        return inTime;
    }

    /**
     * @param inTime the inTime to set
     */
    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the otHrs
     */
    public int getOtHrs() {
        return otHrs;
    }

    /**
     * @param otHrs the otHrs to set
     */
    public void setOtHrs(int otHrs) {
        this.otHrs = otHrs;
    }

    /**
     * @return the offTime
     */
    public String getOffTime() {
        return offTime;
    }

    /**
     * @param offTime the offTime to set
     */
    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }
    
}
