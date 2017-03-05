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
public class MaterialDiffDetails extends AbstractTableModel{
    private static final String[] COLUMN_NAMES={"Style No","Type","Difference"};
    private static ArrayList<StyleMaterial> list ;//can store Style type objects in a list
    
    MaterialDiffDetails(ArrayList<StyleMaterial> materialDiffList){
        
        list=materialDiffList;
       
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
                return list.get(rowIndex).getType();
            case 2:
                return list.get(rowIndex).getDifference();
            default:
                return "Error";
        }
    }
}
