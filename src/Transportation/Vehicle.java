/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transportation;

/**
 *
 * @author Dasuni Anupama
 */
public class Vehicle {
    private String vehicleNUm;
    private String type;
    private int capacity;
    private String route;
    private String DriverAssigned;
    private int availableCapacity;


    /**
     * @return the vehicleNUm
     */
    public String getVehicleNUm() {
        return vehicleNUm;
    }

    /**
     * @param vehicleNUm the vehicleNUm to set
     */
    public void setVehicleNUm(String vehicleNUm) {
        this.vehicleNUm = vehicleNUm;
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
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the route
     */
    public String getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * @return the DriverAssigned
     */
    public String getDriverAssigned() {
        return DriverAssigned;
    }

    /**
     * @param DriverAssigned the DriverAssigned to set
     */
    public void setDriverAssigned(String DriverAssigned) {
        this.DriverAssigned = DriverAssigned;
    }

    /**
     * @return the availableCapacity
     */
    public int getAvailableCapacity() {
        return availableCapacity;
    }

    /**
     * @param availableCapacity the availableCapacity to set
     */
    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

  
    
}
