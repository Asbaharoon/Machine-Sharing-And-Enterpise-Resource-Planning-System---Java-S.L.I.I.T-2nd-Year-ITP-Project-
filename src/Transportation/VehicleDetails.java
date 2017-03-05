/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transportation;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dasuni Anupama
 */
public class VehicleDetails extends AbstractTableModel{
    private static final String[] COLUMN_NAMES={"Vehicle Number","Vehicle Type","Capacity","Route","Driver Assigned","Available Capacity"};
    private static ArrayList<Vehicle> list ;//can store Style type objects in a list
    
    VehicleDetails(ArrayList<Vehicle> Vehiclelist){
        
        list=Vehiclelist;
       
    }

    @Override
    public int getRowCount() {
        return list.size();//return the no of rows in the table
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    public String getColumnName(int columnIndex){//to display the column names in the GUI table
        return COLUMN_NAMES[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex){   
            case 0:
                return list.get(rowIndex).getVehicleNUm();
            case 1:
                return list.get(rowIndex).getType();
            case 2:
                return list.get(rowIndex).getCapacity();
            case 3:
                return list.get(rowIndex).getRoute();
            case 4:
                return list.get(rowIndex).getDriverAssigned();
            case 5:
                return list.get(rowIndex).getAvailableCapacity();
            default:
                return "Error";
        }
    }
}
