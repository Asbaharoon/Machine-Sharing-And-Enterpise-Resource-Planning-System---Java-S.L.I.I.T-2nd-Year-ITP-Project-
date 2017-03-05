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
public class SampleApproveDetails extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Type", "Size", "Colour", "Style No", "PO No", "Recived Qty", "Status", "Reject Qty", "Check Qty", "Type of Defect", "Remarks", "Date"};
    private static ArrayList<SampleApprove> list;//can store Style type objects in a list

    SampleApproveDetails(ArrayList<SampleApprove> SampleApproveList) {

        list = SampleApproveList;

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
                return list.get(rowIndex).getType();
            case 1:
                return list.get(rowIndex).getSize();
            case 2:
                return list.get(rowIndex).getColour();
            case 3:
                return list.get(rowIndex).getStyleNo();
            case 4:
                return list.get(rowIndex).getPONo();
            case 5:
                return list.get(rowIndex).getRecivedQty();
            case 6:
                return list.get(rowIndex).isStatus();
            case 7:
                return list.get(rowIndex).getCheckedQty();
            case 8:
                return list.get(rowIndex).getRejectQty();

            case 9:
                return list.get(rowIndex).getTypeOfDefects();
            case 10:
                return list.get(rowIndex).getRemarks();
            case 11:
                return list.get(rowIndex).getDate();
            default:
                return "Error";
        }
    }

}
