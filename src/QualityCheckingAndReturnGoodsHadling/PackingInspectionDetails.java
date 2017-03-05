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
class PackingInspectionDetails extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Date", "Buyer", "Order No", "Order Qty", "Size", "Incorrect Information", "Incorrect Poly Bag", "Carton Size", "Content Incorrect", "Quantity Incorrect", "Incorrect Carton Marks", "Poor Carton Quantity", "Others", "Describe Other"};
    private static ArrayList<PackingInspection> list;//can store Style type objects in a list

    PackingInspectionDetails(ArrayList<PackingInspection> PackingInspectionList) {

        list = PackingInspectionList;

    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getDatePI();
            case 1:
                return list.get(rowIndex).getBuyerPI();
            case 2:
                return list.get(rowIndex).getOrderNoPI();
            case 3:
                return list.get(rowIndex).getOrderQtyPI();
            case 4:
                return list.get(rowIndex).getSizePI();
            case 5:
                return list.get(rowIndex).isInformationPI();
            case 6:
                return list.get(rowIndex).isPolybagPI();
            case 7:
                return list.get(rowIndex).isCartonSizePI();
            case 8:
                return list.get(rowIndex).isContentPI();
            case 9:
                return list.get(rowIndex).isQuantityPI();
            case 10:
                return list.get(rowIndex).isCartonMarksPI();
            case 11:
                return list.get(rowIndex).isCartonQuantity();
            case 12:
                return list.get(rowIndex).isOthersPI();
            case 13:
                return list.get(rowIndex).getDescribe();
            default:
                return "Error";
        }
    }
}
