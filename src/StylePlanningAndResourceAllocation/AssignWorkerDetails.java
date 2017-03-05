/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StylePlanningAndResourceAllocation;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sampath Rajapakse
 */
public class AssignWorkerDetails extends AbstractTableModel{
      private static final String[] COLUMN_NAMES={"Asset ID","Style No","Type","Operation","Factory","Location"};
    private static ArrayList<AssignWorker> list ;//can store Machine type objects in a list 
    
    AssignWorkerDetails(ArrayList<AssignWorker> workerList){
        
        list=workerList;
       
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
                return list.get(rowIndex).getStyleNo();
            case 2:
                return list.get(rowIndex).getType();
            case 3:
                return list.get(rowIndex).getOperation();
            case 4:
                return list.get(rowIndex).getFactory();
            case 5:
                return list.get(rowIndex).getLocation();   
            default:
                return "Error";
        }
    }
}
