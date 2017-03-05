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
public class AssignDriverDetails extends AbstractTableModel{
    
     private static final String[] COLUMN_NAMES={"Driver Name","Driver NIC","Date of Birth","Gender","Vehicle Type","Vehicle Number"};
    private static ArrayList<AssingDriver> list ;//can store Style type objects in a list
    
    AssignDriverDetails(ArrayList<AssingDriver> driverlist){
        
        list=driverlist;
       
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
                return list.get(rowIndex).getDriverName();
            case 1:
                return list.get(rowIndex).getDriverNIC();
            case 2:
                return list.get(rowIndex).getDob();
            case 3:
                return list.get(rowIndex).getGender();
            case 4:
                return list.get(rowIndex).getVehicleType();
            case 5:
                return list.get(rowIndex).getVehicleNumber();
                  
            default:
                return "Error";
        }
    }
}
