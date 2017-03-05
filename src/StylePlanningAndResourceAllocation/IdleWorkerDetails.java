/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StylePlanningAndResourceAllocation;

import EmployeeManagement.Employee;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sampath Rajapakse
 */
class IdleWorkerDetails extends AbstractTableModel{

    private static final String[] COLUMN_NAMES={"Asset ID","Type","Name","Factory","Location"};
    private static ArrayList<Employee> list ;//can store Machine type objects in a list 
    
    public IdleWorkerDetails(ArrayList<Employee> employeeList) {
        list=employeeList;
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
                return list.get(rowIndex).getEmpNo();
            case 1:
                return list.get(rowIndex).getDesignation();
            case 2:
                return list.get(rowIndex).getFullName();
            case 3:
                return list.get(rowIndex).getFactory();
            case 4:
                return list.get(rowIndex).getLocation();   
            default:
                return "Error";
        }
    }
    
}
