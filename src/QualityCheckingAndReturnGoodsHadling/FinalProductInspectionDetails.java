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
class FinalProductInspectionDetails extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Date", "Piece ID", "Buyer", "Order No", "Order Quantity", "Style No", "Product Type", "Sample Size", "Fabric", "Construction", "Trims", "Print/Embroidery", "Wash", "Clean Lines", "Measurements"};
    private static ArrayList<FinalProductInspection> list;//can store Style type objects in a list

    FinalProductInspectionDetails(ArrayList<FinalProductInspection> FinalProductInspectionList) {

        list = FinalProductInspectionList;

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
                return list.get(rowIndex).getDateFP();
            case 1:
                return list.get(rowIndex).getPieceId();
            case 2:
                return list.get(rowIndex).getBuyerFP();
            case 3:
                return list.get(rowIndex).getOrderNumberFP();
            case 4:
                return list.get(rowIndex).getOrderQtyFP();
            case 5:
                return list.get(rowIndex).getStyleNoFP();
            case 6:
                return list.get(rowIndex).getProductTypeFP();
            case 7:
                return list.get(rowIndex).getSampleSize();
            case 8:
                return list.get(rowIndex).getFabric();
            case 9:
                return list.get(rowIndex).getConstruction();
            case 10:
                return list.get(rowIndex).getTrims();
            case 11:
                return list.get(rowIndex).getPrint();
            case 12:
                return list.get(rowIndex).getWash();
            case 13:
                return list.get(rowIndex).getClean();
            case 14:
                return list.get(rowIndex).getMeasurements();
            default:
                return "Error";
        }
    }
}
