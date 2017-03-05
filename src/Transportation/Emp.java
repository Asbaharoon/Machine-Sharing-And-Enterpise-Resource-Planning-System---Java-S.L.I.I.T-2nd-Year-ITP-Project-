/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transportation;

import java.util.Date;

/**
 *
 * @author Dasuni Anupama
 */
public class Emp {
    private Date date;
    private String route;
    private int employeeCount;
   

 
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

 

    /**
     * @return the employeeCount
     */
    public int getEmployeeCount() {
        return employeeCount;
    }

    /**
     * @param employeeCount the employeeCount to set
     */
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    
}
