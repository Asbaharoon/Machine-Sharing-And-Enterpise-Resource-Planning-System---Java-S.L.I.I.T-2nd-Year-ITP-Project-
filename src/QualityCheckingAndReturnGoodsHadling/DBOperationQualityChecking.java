/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QualityCheckingAndReturnGoodsHadling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import voguetexmachinesharing.managementsystem.DBConnect;

/**
 *
 * @author user
 */
public class DBOperationQualityChecking extends DBConnect {

    boolean addRegularInformation(RegularInformation r) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO regularinformation VALUES (?,?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setString(1, r.getBuyerName());//add values to the sql query
            //pst.setInt(2, r.getBuyerNo());//add values to the sql query
            pst.setInt(2, r.getSupplierNo());//add values to the sql query
            pst.setString(3, r.getSeason());//add values to the sql query
            pst.setString(4, r.getLaunchPack());//add values to the sql query
            pst.setString(5, r.getDescription());//add values to the sql query

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {
                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }
    }

    ArrayList<RegularInformation> getRegularInformation() {
        try {
            ArrayList<RegularInformation> list = new ArrayList<RegularInformation>();
            con = DriverManager.getConnection(url, username, password);//get the connection

            String query = "SELECT * FROM regularinformation";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            while (rs.next()) {//will ensure that it will execute it has rows
                RegularInformation sObj = new RegularInformation();

                sObj.setBuyerName(rs.getString(1));//get the values in column 1 and storing in Style object
                //sObj.setBuyerNo(rs.getInt(2));
                sObj.setSupplierNo(rs.getInt(2));
                sObj.setSeason(rs.getString(3));
                sObj.setLaunchPack(rs.getString(4));
                sObj.setDescription(rs.getString(5));

                System.out.println(sObj.getBuyerName());

                list.add(sObj);//add the filled Style Object to the List of Style Objects
            }
            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return null;
            }

        }
    }

    boolean deleteRegularInformation(RegularInformation r) {
        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "DELETE FROM regularinformation WHERE BuyerName='" + r.getBuyerName() + "' AND SupplierNo= '" + r.getSupplierNo() + "' AND Season ='" + r.getSeason() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    boolean updateRegularInformation(RegularInformation r, RegularInformation r1) {
        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE regularinformation SET BuyerName='" + r.getBuyerName() + "',SupplierNo='" + r.getSupplierNo() + "',Season='" + r.getSeason() + "',LaunchPack='" + r.getLaunchPack() + "',Description='" + r.getDescription() + "' WHERE BuyerName='" + r1.getBuyerName() + "' AND Season='" + r1.getSeason() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    boolean addSampleApprove(SampleApprove sa) {
        try {

            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO sample_approve VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setString(1, sa.getType());
            pst.setInt(2, sa.getSize());
            pst.setString(3, sa.getColour());
            pst.setInt(4, sa.getStyleNo());
            pst.setInt(5, sa.getPONo());
            pst.setInt(6, sa.getRecivedQty());

            pst.setBoolean(7, sa.isStatus());
            //  pst.setString(8, Boolean.toString(sa.isStatus()));
            pst.setInt(8, sa.getCheckedQty());
            pst.setInt(9, sa.getRejectQty());
            pst.setString(10, sa.getTypeOfDefects());
            pst.setString(11, sa.getRemarks());
            pst.setString(12, sa.getDate());//execute the sql query and insert the values to db table
            //since it's a INSERT statement
            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {
                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }
    }

    ArrayList<SampleApprove> getSampleApprove() {
        try {
            ArrayList<SampleApprove> list = new ArrayList<SampleApprove>();
            con = DriverManager.getConnection(url, username, password);//get the connection

            String query = "SELECT * FROM sample_approve";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            while (rs.next()) {//will ensure that it will execute it has rows
                SampleApprove sObj = new SampleApprove();
                sObj.setType(rs.getString(1));//get the values in column 1 and storing in Style object
                sObj.setSize(rs.getInt(2));
                sObj.setColour(rs.getString(3));
                sObj.setStyleNo(rs.getInt(4));
                sObj.setPONo(rs.getInt(5));
                sObj.setRecivedQty(rs.getInt(6));
                sObj.setStatus(rs.getBoolean(7));
                sObj.setCheckedQty(rs.getInt(8));
                sObj.setRejectQty(rs.getInt(9));
                sObj.setTypeOfDefects(rs.getString(10));
                sObj.setRemarks(rs.getString(11));
                sObj.setDate(rs.getString(12));

                list.add(sObj);//add the filled Style Object to the List of Style Objects
            }
            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return null;
            }

        }
    }

    boolean addFabricRegulaInformation(FabricRegularInformation fir) {

        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO fabricregular_information VALUES (?,?,?,?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setString(1, fir.getDate());//add values to the sql query
            pst.setInt(2, fir.getDyelotNo());//add values to the sql query
            pst.setInt(3, fir.getRollNo());//add values to the sql query
            pst.setDouble(4, fir.getContractWidth());//add values to the sql query
            pst.setString(5, fir.getFabDescription());//add values to the sql query
            pst.setString(6, fir.getFabricComposition());//add values to the sql query
            pst.setString(7, fir.getFabricConstruction());//add values to the sql query

            pst.executeUpdate();//execute the sql query and insert the values to db table
            //since it's a INSERT statement
            return true;

        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {
                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);

            }

        }
    }

    ArrayList<FabricRegularInformation> getFabricRegularInformation() {

        try {
            ArrayList<FabricRegularInformation> list = new ArrayList<FabricRegularInformation>();
            con = DriverManager.getConnection(url, username, password);//get the connection

            String query = "SELECT * FROM fabricregular_information";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            while (rs.next()) {//will ensure that it will execute it has rows
                FabricRegularInformation sObj = new FabricRegularInformation();

                sObj.setDate(rs.getString(1));//get the values in column 1 and storing in Style object
                sObj.setDyelotNo(rs.getInt(2));
                sObj.setRollNo(rs.getInt(3));
                sObj.setContractWidth(rs.getInt(4));
                sObj.setFabDescription(rs.getString(5));
                sObj.setFabricComposition(rs.getString(6));
                sObj.setFabricConstruction(rs.getString(7));

                list.add(sObj);//add the filled Style Object to the List of Style Objects
            }
            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return null;
            }

        }
    }

    /*FabricRegularInformation getFabricRegularInformationFill(FabricRegularInformation m) {
        
            try {
            //ArrayList<FabricRegularInformation> list=new ArrayList<FabricRegularInformation>();
            con=DriverManager.getConnection(url, username, password);//get the connection
         
            String query ="SELECT dyeLotNo,rollNo  FROM fabricregular_information WHERE dyeLotNo ='"+m.getDyelotNo()+"' AND rollNo = '"+m.getRollNo()+"'" ;
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table
         FabricRegularInformation sObj=new FabricRegularInformation();
            while(rs.next()){//will ensure that it will execute it has rows
                
                
                //sObj.setDate(rs.getString(1));//get the values in column 1 and storing in Style object
                sObj.setDyelotNo(rs.getInt(1));
                sObj.setRollNo(rs.getInt(2));
               // sObj.setContractWidth(rs.getInt(4));
               // sObj.setFabDescription(rs.getString(5));
               // sObj.setFabricComposition(rs.getString(6));
              //  sObj.setFabricConstruction(rs.getString(7));

                
                
                //list.add(sObj);//add the filled Style Object to the List of Style Objects
            }
            return sObj;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return null;
            }

        }
    }*/

    boolean updateFabricRegularInformation(FabricRegularInformation fir, FabricRegularInformation fir1) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE fabricregular_information SET date='" + fir.getDate() + "',dyeLotNo='" + fir.getDyelotNo() + "',rollNo='" + fir.getRollNo() + "',contractWidth='" + fir.getContractWidth() + "',fabricDescription='" + fir.getFabDescription() + "',fabricComposition='" + fir.getFabricComposition() + "',fabricConstruction='" + fir.getFabricConstruction() + "'WHERE dyeLotNo=" + fir1.getDyelotNo() + " AND rollNo='" + fir1.getRollNo() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    boolean deleteFabricRegularInformation(FabricRegularInformation fri) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "DELETE FROM fabricregular_information WHERE dyeLotNo='" + fri.getDyelotNo() + "' AND rollNo = '" + fri.getRollNo() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    boolean addFabricInspection(FabricInspection fi) {

        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO fabric_inspection VALUES (?,?,?,?,?,?,?,?,?)";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setInt(1, fi.getColourNo());//add values to the sql query
            pst.setInt(2, fi.getPieceNo());
            pst.setInt(3, fi.getTicket());
            pst.setInt(4, fi.getAct());
            pst.setString(5, fi.getPoint1());
            pst.setString(6, fi.getPoint2());
            pst.setString(7, fi.getPoint3());
            pst.setString(8, fi.getPoint4());
            pst.setString(9, fi.getComment());

            pst.executeUpdate();//execute the sql query and insert the values to db table
            //since it's a INSERT statement
            return true;

        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {
                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }

    }

    ArrayList<FabricInspection> getFabricInspection() {

        try {
            ArrayList<FabricInspection> list = new ArrayList<FabricInspection>();
            con = DriverManager.getConnection(url, username, password);//get the connection

            String query = "SELECT * FROM fabric_inspection";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            while (rs.next()) {//will ensure that it will execute it has rows
                FabricInspection sObj = new FabricInspection();

                sObj.setColourNo(rs.getInt(1));//get the values in column 1 and storing in Style object
                sObj.setPieceNo(rs.getInt(2));
                sObj.setTicket(rs.getInt(3));
                sObj.setAct(rs.getInt(4));
                sObj.setPoint1(rs.getString(5));
                sObj.setPoint2(rs.getString(6));
                sObj.setPoint3(rs.getString(7));
                sObj.setPoint4(rs.getString(8));
                sObj.setComment(rs.getString(9));

                list.add(sObj);//add the filled Style Object to the List of Style Objects
            }
            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return null;
            }

        }
    }

    boolean updateFabricInspection(FabricInspection fi, FabricInspection fi1) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE fabric_inspection SET colourNo='" + fi.getColourNo() + "',pieceNo='" + fi.getPieceNo() + "',ticket='" + fi.getTicket() + "',Act='" + fi.getAct() + "',1point='" + fi.getPoint1() + "',2point='" + fi.getPoint2() + "',3point='" + fi.getPoint3() + "',4point='" + fi.getPoint4() + "',comments='" + fi.getComment() + "'WHERE pieceNo=" + fi1.getColourNo() + " AND ticket='" + fi1.getPieceNo() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    boolean deleteFabricInspection(FabricInspection fi) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "DELETE FROM fabric_inspection WHERE pieceNo='" + fi.getPieceNo() + "' AND ticket = '" + fi.getTicket() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    boolean updateSampleApprove(SampleApprove sa, SampleApprove sa1) {
        System.out.println(sa.getType());
        System.out.println(sa.getSize());
        System.out.println(sa.getColour());
        System.out.println(sa.getStyleNo());
        System.out.println(sa.getPONo());
        System.out.println(sa.getRecivedQty());
        System.out.println(sa.isStatus());
        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE sample_approve SET Type='" + sa.getType() + "',size='" + sa.getSize() + "',colour='" + sa.getColour() + "',styleNo='" + sa.getStyleNo() + "',PONo='" + sa.getPONo() + "',recivedQty='" + sa.getRecivedQty() + "',status='" + sa.isStatus() + "',chkQuantity='" + sa.getCheckedQty() + "',rejectQuantity='" + sa.getRejectQty() + "',defectType='" + sa.getTypeOfDefects() + "',remarks='" + sa.getRemarks() + "',date='" + sa.getDate() + "'WHERE styleNo=" + sa1.getStyleNo() + " AND PONo='" + sa1.getPONo() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    boolean deleteSampleApprove(SampleApprove sa) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "DELETE FROM sample_approve WHERE styleNo='" + sa.getStyleNo() + "' AND PONo = '" + sa.getPONo() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    ArrayList<FinalProductInspection> getFinalProductInspection() {

        try {
            ArrayList<FinalProductInspection> list = new ArrayList<FinalProductInspection>();
            con = DriverManager.getConnection(url, username, password);//get the connection

            String query = "SELECT * FROM finalproduct_inspection";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            while (rs.next()) {//will ensure that it will execute it has rows
                FinalProductInspection sObj = new FinalProductInspection();

                sObj.setDateFP(rs.getString(1));//get the values in column 1 and storing in Style object
                sObj.setPieceId(rs.getInt(2));
                sObj.setBuyerFP(rs.getString(3));
                sObj.setOrderNumberFP(rs.getInt(4));
                sObj.setOrderQtyFP(rs.getInt(5));
                sObj.setStyleNoFP(rs.getInt(6));
                sObj.setProductTypeFP(rs.getString(7));
                sObj.setSampleSize(rs.getString(8));
                sObj.setFabric(rs.getString(9));
                sObj.setConstruction(rs.getString(10));
                sObj.setTrims(rs.getString(11));
                sObj.setPrint(rs.getString(12));
                sObj.setWash(rs.getString(13));
                sObj.setClean(rs.getString(14));
                sObj.setMeasurements(rs.getString(15));

                list.add(sObj);//add the filled Style Object to the List of Style Objects
            }
            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return null;
            }

        }
    }

    boolean addFinalProductInspection(FinalProductInspection fp) {

        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO finalproduct_inspection VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setString(1, fp.getDateFP());//add values to the sql query
            pst.setInt(2, fp.getPieceId());
            pst.setString(3, fp.getBuyerFP());
            pst.setInt(4, fp.getOrderNumberFP());
            pst.setInt(5, fp.getOrderQtyFP());
            pst.setInt(6, fp.getStyleNoFP());
            pst.setString(7, fp.getProductTypeFP());
            pst.setString(8, fp.getSampleSize());
            pst.setString(9, fp.getFabric());
            pst.setString(10, fp.getConstruction());
            pst.setString(11, fp.getTrims());
            pst.setString(12, fp.getPrint());
            pst.setString(13, fp.getWash());
            pst.setString(14, fp.getClean());
            pst.setString(15, fp.getMeasurements());

            pst.executeUpdate();//execute the sql query and insert the values to db table
            //since it's a INSERT statement
            return true;

        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {
                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }

    }

    boolean updateFinalProductInspection(FinalProductInspection fp, FinalProductInspection fp1) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE finalproduct_inspection SET date='" + fp.getDateFP() + "',pieceId='" + fp.getPieceId() + "',buyer='" + fp.getBuyerFP() + "',orderNo='" + fp.getOrderNumberFP() + "',orderQty='" + fp.getOrderQtyFP() + "',styleNo='" + fp.getStyleNoFP() + "',productType='" + fp.getProductTypeFP() + "',sampleSize='" + fp.getSampleSize() + "',fabric='" + fp.getFabric() + "',construction='" + fp.getConstruction() + "',trims='" + fp.getTrims() + "',print='" + fp.getPrint() + "',wash='" + fp.getWash() + "',clean='" + fp.getClean() + "',measurements='" + fp.getMeasurements() + "'WHERE pieceId=" + fp1.getPieceId() + " AND orderNo='" + fp1.getOrderQtyFP() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    boolean deleteFinalProductInspection(FinalProductInspection fp) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "DELETE FROM finalproduct_inspection WHERE pieceId='" + fp.getPieceId() + "' AND orderNo = '" + fp.getOrderNumberFP() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    boolean addPackingInspection(PackingInspection pi) {

        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO packing_inspection VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setString(1, pi.getDatePI());//add values to the sql query
            pst.setString(2, pi.getBuyerPI());
            pst.setInt(3, pi.getOrderNoPI());
            pst.setInt(4, pi.getOrderQtyPI());
            pst.setString(5, pi.getSizePI());
            pst.setString(6, Boolean.toString(pi.isInformationPI()));
            pst.setString(7, Boolean.toString(pi.isPolybagPI()));
            pst.setString(8, Boolean.toString(pi.isCartonSizePI()));
            pst.setString(9, Boolean.toString(pi.isContentPI()));
            pst.setString(10, Boolean.toString(pi.isQuantityPI()));
            pst.setString(11, Boolean.toString(pi.isCartonMarksPI()));
            pst.setString(12, Boolean.toString(pi.isCartonQuantity()));
            pst.setString(13, Boolean.toString(pi.isOthersPI()));
            pst.setString(14, pi.getDescribe());

            pst.executeUpdate();//execute the sql query and insert the values to db table
            //since it's a INSERT statement
            return true;

        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {
                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }
    }

    ArrayList<PackingInspection> getPackingInspection() {

        try {
            ArrayList<PackingInspection> list = new ArrayList<PackingInspection>();
            con = DriverManager.getConnection(url, username, password);//get the connection

            String query = "SELECT * FROM packing_inspection";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            while (rs.next()) {//will ensure that it will execute it has rows
                PackingInspection sObj = new PackingInspection();

                sObj.setDatePI(rs.getString(1));//get the values in column 1 and storing in Style object
                sObj.setBuyerPI(rs.getString(2));
                sObj.setOrderNoPI(rs.getInt(3));
                sObj.setOrderQtyPI(rs.getInt(4));
                sObj.setSizePI(rs.getString(5));
                sObj.setInformationPI(rs.getBoolean(6));
                sObj.setPolybagPI(rs.getBoolean(7));
                sObj.setCartonSizePI(rs.getBoolean(8));
                sObj.setContentPI(rs.getBoolean(9));
                sObj.setQuantityPI(rs.getBoolean(10));
                sObj.setCartonMarksPI(rs.getBoolean(11));
                sObj.setCartonQuantity(rs.getBoolean(12));
                sObj.setOthersPI(rs.getBoolean(13));
                sObj.setDescribe(rs.getString(14));

                list.add(sObj);//add the filled Style Object to the List of Style Objects
            }
            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return null;
            }

        }
    }

    boolean deletePacckingInspection(PackingInspection pi) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "DELETE FROM packing_inspection WHERE buyer='" + pi.getBuyerPI() + "' AND orderNo = '" + pi.getOrderNoPI() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }
    }

    boolean updatePackingInformation(PackingInspection pi, PackingInspection pi1) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE packing_inspection SET date='" + pi.getDatePI() + "',buyer='" + pi.getBuyerPI() + "',orderNo='" + pi.getOrderNoPI() + "',orderQty='" + pi.getOrderQtyPI() + "',size='" + pi.getSizePI() + "',incorrectInfo='" + pi.isInformationPI() + "',IncorrectPolyBagSize='" + pi.isPolybagPI() + "',cartonSizeOutOfSpec='" + pi.isCartonSizePI() + "',contentIncorrect='" + pi.isContentPI() + "',quantityIncorrect='" + pi.isQuantityPI() + "',incorrectCartonMarks='" + pi.isCartonMarksPI() + "',poorCartonQuantity='" + pi.isCartonQuantity() + "',other='" + pi.isOthersPI() + "',describeOther='" + pi.getDescribe() + "'WHERE buyer='" + pi1.getBuyerPI() + "' AND orderNo='" + pi1.getOrderNoPI() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }

    }

    boolean addReturnGoods(ReturnGoods rg) {

        try {
            con = (Connection) DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO return_goods VALUES (?,?,?,?,?,?) ";

            pst = con.prepareStatement(query);//making a prepared statement

            pst.setString(1, rg.getReturnBy());
            pst.setString(2, rg.getProductType());//add values to the sql query
            pst.setString(3, rg.getBuyer());
            pst.setInt(4, rg.getOrderNo());
            pst.setString(5, rg.getDefectType());
            pst.setString(6, rg.getReturnStatus());

            pst.executeUpdate();//execute the sql query and insert the values to db table
            //since it's a INSERT statement
            return true;

        } catch (Exception e) {
            System.out.println("Exception is throws " + e);
            return false;
        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {
                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
            }

        }

    }

    ArrayList<ReturnGoods> getReturnGoods() {

        try {
            ArrayList<ReturnGoods> list = new ArrayList<ReturnGoods>();
            con = DriverManager.getConnection(url, username, password);//get the connection

            String query = "SELECT * FROM return_goods";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            while (rs.next()) {//will ensure that it will execute it has rows
                ReturnGoods sObj = new ReturnGoods();

                sObj.setReturnBy(rs.getString(1));
                sObj.setProductType(rs.getString(2));//get the values in column 2 and storing in Style object
                sObj.setBuyer(rs.getString(3));
                sObj.setOrderNo(rs.getInt(4));
                sObj.setDefectType(rs.getString(5));
                sObj.setReturnStatus(rs.getString(6));

                list.add(sObj);//add the filled Style Object to the List of Style Objects
            }
            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return null;
            }

        }

    }

    boolean updateReturnGoods(ReturnGoods rg, ReturnGoods rg1) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "UPDATE return_goods SET returnBy='" + rg.getReturnBy() + "', productType='" + rg.getProductType() + "',buyer='" + rg.getBuyer() + "',orderNo='" + rg.getOrderNo() + "',DefectType='" + rg.getDefectType() + "',returnState='" + rg.getReturnStatus() + "'WHERE buyer='" + rg1.getBuyer() + "' AND orderNo='" + rg1.getOrderNo() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }

    }

    boolean deleteReturnGoods(ReturnGoods rg) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "DELETE FROM return_goods WHERE buyer='" + rg.getBuyer() + "' AND orderNo = '" + rg.getOrderNo() + "'";
            pst = con.prepareStatement(query);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return false;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return false;
            }

        }

    }

    ArrayList<rgChoose> getRGChoose() {

        try {
            ArrayList<rgChoose> list = new ArrayList<rgChoose>();
            con = DriverManager.getConnection(url, username, password);//get the connection

            String query = "SELECT * FROM rg_type";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();//we use executeQuery instead of executeUpdate since we don't change any values in table

            while (rs.next()) {//will ensure that it will execute it has rows

                rgChoose sObj = new rgChoose();

                sObj.setProductType(rs.getString(2));

                sObj.setReturnBy(rs.getString(1));
                System.out.println(sObj.getReturnBy());

                list.add(sObj);//add the filled Style Object to the List of Style Objects
            }

            return list;
        } catch (Exception e) {

            System.out.println("Exception is throws " + e);
            return null;

        } finally {
            //closing all the resources
            try {
                if (pst != null) {
                    pst.close();//resetting
                }
                if (con != null) {

                    con.close();//reseting
                }
            } catch (Exception e) {
                System.out.println("Exception is throws " + e);
                return null;
            }

        }
    }

}
