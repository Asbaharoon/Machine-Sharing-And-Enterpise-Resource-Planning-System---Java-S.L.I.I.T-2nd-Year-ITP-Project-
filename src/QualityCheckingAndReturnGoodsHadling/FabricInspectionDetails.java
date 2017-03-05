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
class FabricInspectionDetails extends AbstractTableModel {

    private static String[] COLUMN_NAMES = {"Colour No", "Pieace No", "Act", "Ticket", "Point 1", "Point 2", "Point 3", "Point 4", "Comments"};
    private static ArrayList<FabricInspection> list;//can store Style type objects in a list

    FabricInspectionDetails(ArrayList<FabricInspection> FabricInspectionList) {

        list = FabricInspectionList;
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
                return list.get(rowIndex).getColourNo();
            case 1:
                return list.get(rowIndex).getPieceNo();
            case 2:
                return list.get(rowIndex).getTicket();
            case 3:
                return list.get(rowIndex).getAct();
            case 4:
                return list.get(rowIndex).getPoint1();
            case 5:
                return list.get(rowIndex).getPoint2();
            case 6:
                return list.get(rowIndex).getPoint3();
            case 7:
                return list.get(rowIndex).getPoint4();
            case 8:
                return list.get(rowIndex).getComment();
            default:
                return "Error";
        }

    }
}
