/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeManagement;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author isuru
 */
public class DepartmentDetails extends AbstractTableModel {
    
    private static final String[] COLUMN_NAMES={"DepartmentNo","DepartmentName"};
    private static ArrayList<Department> list ;
    
    DepartmentDetails(ArrayList<Department> departmentList){
        
        list=departmentList;
       
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
                return list.get(rowIndex).getDepartmentNo();
            case 1:
                return list.get(rowIndex).getDepartmentName();
            default:
                return "Error";
        }    }
    
}
