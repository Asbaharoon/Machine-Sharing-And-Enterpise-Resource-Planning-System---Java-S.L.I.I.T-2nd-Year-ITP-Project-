/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StylePlanningAndResourceAllocation;

/**
 *
 * @author Sampath Rajapakse
 */
public class StyleOperation {
    
    private int styleNo;
    private int operationNo;
    private String Type;
    private String Machine;
    private int quantity;
    private String speciality;
    private String remarks;
    private double mc;
    private double ma;
    private int difference;

    /**
     * @return the styleNo
     */
    public int getStyleNo() {
        return styleNo;
    }

    /**
     * @param styleNo the styleNo to set
     */
    public void setStyleNo(int styleNo) {
        this.styleNo = styleNo;
    }

    /**
     * @return the operationNo
     */
    public int getOperationNo() {
        return operationNo;
    }

    /**
     * @param operationNo the operationNo to set
     */
    public void setOperationNo(int operationNo) {
        this.operationNo = operationNo;
    }

    /**
     * @return the Type
     */
    public String getType() {
        return Type;
    }

    /**
     * @param Type the Type to set
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * @return the Machine
     */
    public String getMachine() {
        return Machine;
    }

    /**
     * @param Machine the Machine to set
     */
    public void setMachine(String Machine) {
        this.Machine = Machine;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the speciality
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * @param speciality the speciality to set
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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
     * @return the mc
     */
    public double getMc() {
        return mc;
    }

    /**
     * @param mc the mc to set
     */
    public void setMc(double mc) {
        this.mc = mc;
    }

    /**
     * @return the ma
     */
    public double getMa() {
        return ma;
    }

    /**
     * @param ma the ma to set
     */
    public void setMa(double ma) {
        this.ma = ma;
    }

    /**
     * @return the difference
     */
    public int getDifference() {
        return difference;
    }

    /**
     * @param difference the difference to set
     */
    public void setDifference(int difference) {
        this.difference = difference;
    }
    
}
