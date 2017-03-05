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
public class AssignMachine {
    
    private String assetID;
    private int styleNo;
    private String type;
    private String location;
    private String Factory;

    /**
     * @return the assetID
     */
    public String getAssetID() {
        return assetID;
    }

    /**
     * @param assetID the assetID to set
     */
    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

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
     * @return the Factory
     */
    public String getFactory() {
        return Factory;
    }

    /**
     * @param Factory the Factory to set
     */
    public void setFactory(String Factory) {
        this.Factory = Factory;
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
    
}
