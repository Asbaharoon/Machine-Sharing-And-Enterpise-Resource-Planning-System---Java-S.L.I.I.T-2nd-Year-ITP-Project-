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
class FabricRegularInformation {

    private String date;
    private int dyelotNo;
    private int rollNo;
    private String fabDescription;
    private double contractWidth;
    //private double fabricWidth;
    private String fabricComposition;
    private String fabricConstruction;

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the dyelotNo
     */
    public int getDyelotNo() {
        return dyelotNo;
    }

    /**
     * @param dyelotNo the dyelotNo to set
     */
    public void setDyelotNo(int dyelotNo) {
        this.dyelotNo = dyelotNo;
    }

    /**
     * @return the rollNo
     */
    public int getRollNo() {
        return rollNo;
    }

    /**
     * @param rollNo the rollNo to set
     */
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    /**
     * @return the fabDescription
     */
    public String getFabDescription() {
        return fabDescription;
    }

    /**
     * @param fabDescription the fabDescription to set
     */
    public void setFabDescription(String fabDescription) {
        this.fabDescription = fabDescription;
    }

    /**
     * @return the contractWidth
     */
    public double getContractWidth() {
        return contractWidth;
    }

    /**
     * @param contractWidth the contractWidth to set
     */
    public void setContractWidth(double contractWidth) {
        this.contractWidth = contractWidth;
    }

    /*
 
    public double getFabricWidth() {
        return fabricWidth;
    }


    public void setFabricWidth(double fabricWidth) {
        this.fabricWidth = fabricWidth;
    }
     */
    /**
     * @return the fabricComposition
     */
    public String getFabricComposition() {
        return fabricComposition;
    }

    /**
     * @param fabricComposition the fabricComposition to set
     */
    public void setFabricComposition(String fabricComposition) {
        this.fabricComposition = fabricComposition;
    }

    /**
     * @return the fabricConstruction
     */
    public String getFabricConstruction() {
        return fabricConstruction;
    }

    /**
     * @param fabricConstruction the fabricConstruction to set
     */
    public void setFabricConstruction(String fabricConstruction) {
        this.fabricConstruction = fabricConstruction;
    }

}
