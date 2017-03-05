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
public class StyleMaterial {
    
    private int styleNo;
    private int materialNo;
    private String type;
    private String color;
    private float quantity;
    private String remarks; 
    private float difference;

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
     * @return the materialNo
     */
    public int getMaterialNo() {
        return materialNo;
    }

    /**
     * @param materialNo the materialNo to set
     */
    public void setMaterialNo(int materialNo) {
        this.materialNo = materialNo;
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
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the quantity
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(float quantity) {
        this.quantity = quantity;
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
     * @return the difference
     */
    
    public float getDifference() {
        return difference;
    }
  

    /**
     * @param difference the difference to set
     */
   
    public void setDifference(float difference) {
        this.difference = difference;
    }
   
    
}
