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
public class PurchaseOrderDetails extends AbstractTableModel{
    
    private static final String[] COLUMN_NAMES={"Style No","Purchase Order No","Size","Color","Quantity","Remarks"};
    private static ArrayList<PurchaseOrder> list ;//can store Style type objects in a list
    
    PurchaseOrderDetails(ArrayList<PurchaseOrder> orderList){
        
        list=orderList;
       
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
                return list.get(rowIndex).getPurchaseOrderNo();
            case 2:
                return list.get(rowIndex).getSize();
            case 3:
                return list.get(rowIndex).getColor();
            case 4:
                return list.get(rowIndex).getQuantity();
            case 5:
                return list.get(rowIndex).getRemarks();
            default:
                return "Error";
        }
    }
    
}
