/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StylePlanningAndResourceAllocation;

import StockManagement.Material;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author Sampath Rajapakse
 */
public class AvailableMaterialDetails extends AbstractTableModel{

    private static final String[] COLUMN_NAMES={"Asset ID","Brand","Quantity","Type","Color"};
    private static ArrayList<Material> list ;//can store Style type objects in a list
    
    AvailableMaterialDetails(ArrayList<Material> materialList){
        
        list=materialList;
       
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
                return list.get(rowIndex).getAssetID();
            case 1:
                return list.get(rowIndex).getBrand();
            case 2:
                return list.get(rowIndex).getQuantity();
            case 3:
                return list.get(rowIndex).getType();
            case 4:
                return list.get(rowIndex).getColor();

            default:
                return "Error";
        }
    }
    
}
