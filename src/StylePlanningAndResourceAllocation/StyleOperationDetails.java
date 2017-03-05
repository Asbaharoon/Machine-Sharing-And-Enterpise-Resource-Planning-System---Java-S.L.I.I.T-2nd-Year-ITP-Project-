/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StylePlanningAndResourceAllocation;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
/**
 *
 * @author Sampath Rajapakse
 */
public class StyleOperationDetails extends AbstractTableModel{

    private static final String[] COLUMN_NAMES={"Style No","Operation No","Type","Machine","Quantity","Speciality","Remarks","M/C","M/A"};
    private static ArrayList<StyleOperation> list ;//can store Style type objects in a list
    
    StyleOperationDetails(ArrayList<StyleOperation> operationList){
        
        list=operationList;
       
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
                return list.get(rowIndex).getStyleNo();
            case 1:
                return list.get(rowIndex).getOperationNo();
            case 2:
                return list.get(rowIndex).getType();
            case 3:
                return list.get(rowIndex).getMachine();
            case 4:
                return list.get(rowIndex).getQuantity();
            case 5:
                return list.get(rowIndex).getSpeciality();
            case 6:
                return list.get(rowIndex).getRemarks();
            case 7:
                return list.get(rowIndex).getMc();
            case 8:
                return list.get(rowIndex).getMa();
            default:
                return "Error";
        }
    }
}
