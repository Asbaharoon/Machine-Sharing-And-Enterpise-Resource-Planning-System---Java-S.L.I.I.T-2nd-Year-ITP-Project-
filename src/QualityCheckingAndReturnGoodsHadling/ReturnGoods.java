/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QualityCheckingAndReturnGoodsHadling;

/**
 *
 * @author user
 */
class ReturnGoods {

    private String returnBy;
    private String productType;
    private String buyer;
    private int orderNo;
    private String defectType;
    private String returnStatus;

    /**
     * @return the returnBy
     */
    public String getReturnBy() {
        return returnBy;
    }

    /**
     * @param returnBy the returnBy to set
     */
    public void setReturnBy(String returnBy) {
        this.returnBy = returnBy;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the buyer
     */
    public String getBuyer() {
        return buyer;
    }

    /**
     * @param buyer the buyer to set
     */
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    /**
     * @return the orderNo
     */
    public int getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo the orderNo to set
     */
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * @return the defectType
     */
    public String getDefectType() {
        return defectType;
    }

    /**
     * @param defectType the defectType to set
     */
    public void setDefectType(String defectType) {
        this.defectType = defectType;
    }

    /**
     * @return the returnStatus
     */
    public String getReturnStatus() {
        return returnStatus;
    }

    /**
     * @param returnStatus the returnStatus to set
     */
    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

}
