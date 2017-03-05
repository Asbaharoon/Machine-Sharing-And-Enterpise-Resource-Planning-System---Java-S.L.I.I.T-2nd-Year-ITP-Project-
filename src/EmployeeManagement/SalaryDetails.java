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
public class SalaryDetails extends AbstractTableModel{

    private static final String[] COLUMN_NAMES={"EmployeeNo","EPFNo","BasicSalary","Deductions","Bonus","GrossSalary","NetSalary"};
    private static ArrayList<Salary> list ;
    
    SalaryDetails(ArrayList<Salary> salaryList){
        
        list=salaryList;
       
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
                return list.get(rowIndex).getEmployeeNo();
            case 1:
                return list.get(rowIndex).getEpfNo();
            case 2:
                return list.get(rowIndex).getBasicSalary();
            case 3:
                return list.get(rowIndex).getDeductions();
            case 4:
                return list.get(rowIndex).getBonus();
            case 5:
                return list.get(rowIndex).getGrossSalary();
            case 6:
                return list.get(rowIndex).getNetSalary();
            default:
                return "Error";
        }
    }
    
}
