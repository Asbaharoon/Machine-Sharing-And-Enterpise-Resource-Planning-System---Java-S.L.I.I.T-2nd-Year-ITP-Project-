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
class FabricRegularInformationDetails extends AbstractTableModel {

    private static String[] COLUMN_NAMES = {"Date", "Dye lot No", "Roll No", "Contract Width", "Fabric Description", "Description", "Fabric Composition", "Fabric Composition"};
    private static ArrayList<FabricRegularInformation> list;//can store Style type objects in a list

    FabricRegularInformationDetails(ArrayList<FabricRegularInformation> FabricRegularInformatonList) {

        list = FabricRegularInformatonList;

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
                return list.get(rowIndex).getDate();
            case 1:
                return list.get(rowIndex).getDyelotNo();
            case 2:
                return list.get(rowIndex).getRollNo();
            case 3:
                return list.get(rowIndex).getContractWidth();
            case 4:
                return list.get(rowIndex).getFabDescription();
            case 5:
                return list.get(rowIndex).getFabricComposition();
            case 6:
                return list.get(rowIndex).getFabricConstruction();
            default:
                return "Error";
        }
    }
}
