/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QualityCheckingAndReturnGoodsHadling;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class RegularInformationDetails extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Buyer Name", "Supplier Name", "Season", "Launch Pack", "Description"};
    private static ArrayList<RegularInformation> list;//can store Style type objects in a list

    RegularInformationDetails(ArrayList<RegularInformation> RegularInformatonList) {

        list = RegularInformatonList;

    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    public String getColumnName(int columnIndex) {//to display the column names in the GUI table
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getBuyerName();
            case 1:
                return list.get(rowIndex).getSupplierNo();
            case 2:
                return list.get(rowIndex).getSeason();
            case 3:
                return list.get(rowIndex).getLaunchPack();
            case 4:
                return list.get(rowIndex).getDescription();

            default:
                return "Error";
        } //To change body of generated methods, choose Tools | Templates.
    }

}
