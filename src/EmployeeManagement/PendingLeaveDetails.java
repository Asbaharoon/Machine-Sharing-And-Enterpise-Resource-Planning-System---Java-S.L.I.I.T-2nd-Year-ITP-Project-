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
public class PendingLeaveDetails extends AbstractTableModel {
    
    private static final String[] COLUMN_NAMES={"LeaveNo","EmployeeNo","Type","FromDate","ToDate"};
    private static ArrayList<Leave> list ;
    
    PendingLeaveDetails(ArrayList<Leave> leaveList){
        
        list=leaveList;
       
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
                return list.get(rowIndex).getLeaveNo();
            case 1:
                return list.get(rowIndex).getEmpNo();
            case 2:
                return list.get(rowIndex).getType();
            case 3:
                return list.get(rowIndex).getDateFrom();
            case 4:
                return list.get(rowIndex).getDateTo();
            default:
                return "Error";
        }
    }
    
}
