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
class ReturnGoodsDetails extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Return by", "Product Type", "Buyer", "Order No", "Defect Type", "Return State"};
    private static ArrayList<ReturnGoods> list;//can store Style type objects in a list

    ReturnGoodsDetails(ArrayList<ReturnGoods> ReturnGoodsList) {

        list = ReturnGoodsList;

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
                return list.get(rowIndex).getReturnBy();
            case 1:
                return list.get(rowIndex).getProductType();
            case 2:
                return list.get(rowIndex).getBuyer();
            case 3:
                return list.get(rowIndex).getOrderNo();
            case 4:
                return list.get(rowIndex).getDefectType();
            case 5:
                return list.get(rowIndex).getReturnStatus();

            default:
                return "Error";
        }
    }
}
