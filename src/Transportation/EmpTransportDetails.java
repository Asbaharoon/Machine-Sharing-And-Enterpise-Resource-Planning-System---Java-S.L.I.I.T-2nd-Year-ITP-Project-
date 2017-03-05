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
public class EmpTransportDetails extends AbstractTableModel{
    private static final String[] COLUMN_NAMES={"Date","Route","Employee Count"};
    private static ArrayList<Emp> list ;//can store Style type objects in a list
    
    EmpTransportDetails(ArrayList<Emp> Emplist){
        
        list=Emplist;
       
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
                return list.get(rowIndex).getDate();
            case 1:
                return list.get(rowIndex).getRoute();
            case 2:
                return list.get(rowIndex).getEmployeeCount();
            
            default:
                return "Error";
        }
    }
}
