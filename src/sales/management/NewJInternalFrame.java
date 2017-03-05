package sales.management;

/**
 *
 * @author Vishaka
 */
//import humanresourcemanagementsystem.MyReportViewer;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import mycodeSales.SalesManagementDBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import voguetexmachinesharing.managementsystem.MyReportViewer;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.JasperCompileManager;

public class NewJInternalFrame extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null; // get the database value and store data into the rs variable
    private Object dateboxto;
    private Object JasperCompileManager;

    public NewJInternalFrame() {
        initComponents();

        DefaultTableModel model;
        con = SalesManagementDBConnect.connect();

        buyertableload();
        ordertableload();

    }

    private Pattern regexPattern;
    private Matcher regMatcher;

    public boolean validateEmailAddress(String emailAddress) {

        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        regMatcher = regexPattern.matcher(emailAddress);
        if (regMatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public void buyertableload() {
        try {
            String Sql = "SELECT buyer_code,buyer,dDate,email,delivary_mode,country FROM buyer_details";
            pst = con.prepareStatement(Sql);
            rs = pst.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }

    public void ordertableload() {
        try {
            String sql = "SELECT * From order_details";
//order_no,company_name,item,country_origin,season,account_no,issueDate,endDate,supplier,supplier_no,country,delivary_mode,quntity,unit_price,cost
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            orderTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }

    }

    public void Ordertableloadsearch() {
        try {

            String key = searchbox.getText();
            String sql = "SELECT order_no,company_name,item,country_origin,season,account_no,issueDate,endDate,supplier,supplier_no,country,delivary_mode,quntity,unit_price,cost From order_details WHERE order_no LIKE '%" + key + "%'";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            orderTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        countrybox = new java.awt.TextField();
        delivermodebox = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        DELETE_BUYER = new javax.swing.JButton();
        SEARCH_BUYER = new javax.swing.JButton();
        searchbox = new javax.swing.JTextField();
        CLEAR_BUYER = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        DEMO = new javax.swing.JButton();
        Update_Buyer = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        buyercodebox = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        emailbox = new javax.swing.JTextField();
        datebox = new com.toedter.calendar.JDateChooser();
        buyerbox = new java.awt.TextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        accountbox = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        seasonbox = new javax.swing.JTextField();
        enddatebox = new com.toedter.calendar.JDateChooser();
        jLabel64 = new javax.swing.JLabel();
        oitem = new javax.swing.JTextField();
        orderbox = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        issuedatebox = new com.toedter.calendar.JDateChooser();
        UPDATE_ORDER = new javax.swing.JButton();
        ADD_ORDER = new javax.swing.JButton();
        DELETE_ORDER = new javax.swing.JButton();
        CLEAR_ORDER = new javax.swing.JButton();
        SEARCH_ORDER = new javax.swing.JButton();
        ordersearchbox = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        DEMO_order = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        pcountry1 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        delivarybox = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        unitbox = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        ocostbox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        oquntitybox = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        supplierbox = new javax.swing.JTextField();
        suppliernobox = new javax.swing.JTextField();
        oricountrybox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        setTitle("Sales Management");

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destination", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countrybox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                countryboxKeyTyped(evt);
            }
        });
        jPanel4.add(countrybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 120, -1));

        delivermodebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select", "Ocean", "Sky" }));
        delivermodebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delivermodeboxActionPerformed(evt);
            }
        });
        jPanel4.add(delivermodebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 120, -1));

        jLabel19.setText("Delivary Mode");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel21.setText("Country");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Buyer_code", "Buyer", "Company", "email", "Delivary_Mode", "Country", "Currency", "dDate"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Table);

        DELETE_BUYER.setText("Delete");
        DELETE_BUYER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE_BUYERActionPerformed(evt);
            }
        });

        SEARCH_BUYER.setText("Search");
        SEARCH_BUYER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCH_BUYERActionPerformed(evt);
            }
        });

        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchboxKeyTyped(evt);
            }
        });

        CLEAR_BUYER.setText("Clear");
        CLEAR_BUYER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR_BUYERActionPerformed(evt);
            }
        });

        jLabel53.setText("Buyer ");

        DEMO.setText("Demo");
        DEMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DEMOActionPerformed(evt);
            }
        });

        Update_Buyer.setText("Update");
        Update_Buyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_BuyerActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel71.setText("Buyer code");

        buyercodebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buyercodeboxKeyTyped(evt);
            }
        });

        email.setText("email");

        datebox.setDateFormatString("YYYY-MM-dd");

        buyerbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buyerboxKeyTyped(evt);
            }
        });

        jLabel7.setText("Buyer");

        jLabel11.setText("Date");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addComponent(email)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datebox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailbox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyercodebox, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyerbox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(buyercodebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buyerbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(emailbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(datebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)))
        );

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(DELETE_BUYER, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(Update_Buyer, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(CLEAR_BUYER, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(DEMO, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jButton3))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(SEARCH_BUYER)))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SEARCH_BUYER))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DELETE_BUYER)
                        .addComponent(Update_Buyer)
                        .addComponent(CLEAR_BUYER)
                        .addComponent(DEMO)
                        .addComponent(jButton3)))
                .addGap(49, 49, 49))
        );

        jTabbedPane2.addTab("Buyer Details", jPanel10);

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Contrack ID");
        jInternalFrame1.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel5.setText("Order No");
        jInternalFrame1.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 20, -1, -1));

        jLabel6.setText("Issue Date");
        jInternalFrame1.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 20, -1, -1));

        jLabel8.setText("Incterm");
        jInternalFrame1.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, -1, -1));

        jLabel10.setText("Payment Terms");
        jInternalFrame1.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 111, 93, -1));

        jLabel12.setText("Business Code Des");
        jInternalFrame1.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 137, -1, -1));

        jLabel13.setText("Depatment");
        jInternalFrame1.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 168, -1, -1));

        jTextField4.setText("FOB,COLOMBO,SRI LANKA");
        jInternalFrame1.getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 82, 146, -1));

        jTextField8.setText("45 days from document presentation");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 108, -1, -1));

        jTextField9.setText("RETAIL-CANADA");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 134, 103, -1));

        jTextField10.setText("MENS SHIRTS");
        jInternalFrame1.getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 165, 103, -1));

        jLabel14.setText("Country Of Origin");
        jInternalFrame1.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 228, -1, -1));

        jTextField11.setText("SRI LANKA");
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 225, 103, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setText("Shipping Mode");

        jTextField12.setText("SEA");

        jLabel16.setText("Revised Ship Date");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(34, 34, 34)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame1.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        jInternalFrame1.getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 367, -1, -1));

        jLabel17.setText("Account Code");
        jInternalFrame1.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 197, -1, -1));

        jTextField13.setText("000M02958");
        jInternalFrame1.getContentPane().add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 194, 103, -1));

        jLabel18.setText("Season");
        jInternalFrame1.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 254, -1, -1));

        jTextField14.setText("AU16");
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 251, 103, -1));

        jLabel30.setText("Business Code");
        jInternalFrame1.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 225, -1, 20));

        jTextField17.setText("jTextField8");
        jInternalFrame1.getContentPane().add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 225, -1, -1));

        jLabel31.setText("Supplier cOde");
        jInternalFrame1.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 254, 69, -1));

        jTextField19.setText("jTextField9");
        jInternalFrame1.getContentPane().add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 251, -1, -1));

        jPanel11.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 299, 0, 0));

        jInternalFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setText("Contrack ID");
        jInternalFrame2.getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel34.setText("Order No");
        jInternalFrame2.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 20, -1, -1));

        jLabel35.setText("Issue Date");
        jInternalFrame2.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 20, -1, -1));

        jLabel36.setText("Incterm");
        jInternalFrame2.getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, -1, -1));

        jLabel37.setText("Payment Terms");
        jInternalFrame2.getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 111, 93, -1));

        jLabel38.setText("Business Code Des");
        jInternalFrame2.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 137, -1, -1));

        jLabel39.setText("Depatment");
        jInternalFrame2.getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 168, -1, -1));

        jTextField23.setText("FOB,COLOMBO,SRI LANKA");
        jInternalFrame2.getContentPane().add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 82, 146, -1));

        jTextField24.setText("45 days from document presentation");
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 108, -1, -1));

        jTextField25.setText("RETAIL-CANADA");
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 134, 103, -1));

        jTextField26.setText("MENS SHIRTS");
        jInternalFrame2.getContentPane().add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 165, 103, -1));

        jLabel40.setText("Country Of Origin");
        jInternalFrame2.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 228, -1, -1));

        jTextField27.setText("SRI LANKA");
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 225, 103, -1));

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel41.setText("Shipping Mode");

        jTextField28.setText("SEA");

        jLabel42.setText("Revised Ship Date");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(34, 34, 34)
                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel42))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame2.getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        jInternalFrame2.getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 367, -1, -1));

        jLabel43.setText("Account Code");
        jInternalFrame2.getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 197, -1, -1));

        jTextField29.setText("000M02958");
        jInternalFrame2.getContentPane().add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 194, 103, -1));

        jLabel44.setText("Season");
        jInternalFrame2.getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 254, -1, -1));

        jTextField30.setText("AU16");
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 251, 103, -1));

        jLabel45.setText("Business Code");
        jInternalFrame2.getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 225, -1, 20));

        jTextField31.setText("jTextField8");
        jInternalFrame2.getContentPane().add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 225, -1, -1));

        jLabel46.setText("Supplier cOde");
        jInternalFrame2.getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 254, 69, -1));

        jTextField32.setText("jTextField9");
        jInternalFrame2.getContentPane().add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 251, -1, -1));

        jPanel11.add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel48.setText("Order No");
        jPanel11.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel49.setText("Issue Date");
        jPanel11.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel54.setText("Country_ Origin");
        jPanel11.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel57.setText("Account No");
        jPanel11.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        accountbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                accountboxKeyTyped(evt);
            }
        });
        jPanel11.add(accountbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 160, -1));

        jLabel58.setText("Season");
        jPanel11.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        seasonbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seasonboxActionPerformed(evt);
            }
        });
        seasonbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                seasonboxKeyTyped(evt);
            }
        });
        jPanel11.add(seasonbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 160, -1));

        enddatebox.setDateFormatString("YYYY-MM-dd");
        jPanel11.add(enddatebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 160, -1));

        jLabel64.setText("Item");
        jPanel11.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        oitem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                oitemKeyTyped(evt);
            }
        });
        jPanel11.add(oitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 160, -1));

        orderbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                orderboxKeyTyped(evt);
            }
        });
        jPanel11.add(orderbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 160, -1));

        jLabel67.setText("End Date");
        jPanel11.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        issuedatebox.setDateFormatString("YYYY-MM-dd");
        jPanel11.add(issuedatebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 160, -1));

        UPDATE_ORDER.setText("Update");
        UPDATE_ORDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE_ORDERActionPerformed(evt);
            }
        });
        jPanel11.add(UPDATE_ORDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 70, -1));

        ADD_ORDER.setText("Add");
        ADD_ORDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD_ORDERActionPerformed(evt);
            }
        });
        jPanel11.add(ADD_ORDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 70, -1));

        DELETE_ORDER.setText("Delete");
        DELETE_ORDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE_ORDERActionPerformed(evt);
            }
        });
        jPanel11.add(DELETE_ORDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 70, -1));

        CLEAR_ORDER.setText("Clear");
        CLEAR_ORDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR_ORDERActionPerformed(evt);
            }
        });
        jPanel11.add(CLEAR_ORDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 70, -1));

        SEARCH_ORDER.setText("Search");
        SEARCH_ORDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCH_ORDERActionPerformed(evt);
            }
        });
        jPanel11.add(SEARCH_ORDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 80, -1));
        jPanel11.add(ordersearchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 100, -1));

        jLabel74.setText("Order No");
        jPanel11.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        DEMO_order.setText("DEMO");
        DEMO_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DEMO_orderActionPerformed(evt);
            }
        });
        jPanel11.add(DEMO_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 70, -1));

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Delivary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setText("Country");
        jPanel13.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        pcountry1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pcountry1KeyTyped(evt);
            }
        });
        jPanel13.add(pcountry1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 80, -1));

        jLabel55.setText("Delivary Mode");
        jPanel13.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        delivarybox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select", "Ocean", "Sky" }));
        jPanel13.add(delivarybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 80, -1));

        jLabel22.setText("Unit_price");
        jPanel13.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        unitbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                unitboxKeyTyped(evt);
            }
        });
        jPanel13.add(unitbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 80, -1));

        jLabel23.setText("Cost(USD)");
        jPanel13.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        ocostbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ocostboxKeyTyped(evt);
            }
        });
        jPanel13.add(ocostbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 80, -1));

        jLabel3.setText("Quntity");
        jPanel13.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        oquntitybox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                oquntityboxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                oquntityboxKeyTyped(evt);
            }
        });
        jPanel13.add(oquntitybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 80, -1));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 220, 180));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "order_no", "item", "country_origin", "season", "account_no", "issueDate", "endDate", "supplier", "supplier_no", "country", "delivary_mode", "quntity", "unit_price", "cost"
            }
        ));
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(orderTable);

        jPanel11.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 960, 240));

        jLabel1.setText("Company_Name");
        jPanel11.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel24.setText("Supplier");
        jPanel11.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel25.setText("Supplier No");
        jPanel11.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        supplierbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                supplierboxKeyTyped(evt);
            }
        });
        jPanel11.add(supplierbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 160, -1));

        suppliernobox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                suppliernoboxKeyTyped(evt);
            }
        });
        jPanel11.add(suppliernobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 160, -1));

        oricountrybox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select", "Sri Lanka" }));
        jPanel11.add(oricountrybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 160, -1));

        jLabel2.setText("VOGUE TEX (PVT) LIMITED");
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 160, -1));

        jTabbedPane2.addTab("Order Details", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1331, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void suppliernoboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suppliernoboxKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_suppliernoboxKeyTyped

    private void supplierboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierboxKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_supplierboxKeyTyped

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked
        int row = orderTable.getSelectedRow();
        String order_no = orderTable.getValueAt(row, 0).toString();
        
        String item = orderTable.getValueAt(row, 1).toString();
        String country_origin = orderTable.getValueAt(row, 2).toString();
        String season = orderTable.getValueAt(row, 3).toString();
        String account_no = orderTable.getValueAt(row, 4).toString();
        String issueDate = orderTable.getValueAt(row, 5).toString();
        String endDate = orderTable.getValueAt(row, 6).toString();
        String supplier = orderTable.getValueAt(row, 7).toString();
        String supplier_no = orderTable.getValueAt(row, 8).toString();
        String country = orderTable.getValueAt(row, 9).toString();
        String delivary_mode = orderTable.getValueAt(row, 10).toString();
        String quntity = orderTable.getValueAt(row, 11).toString();
        String unit_price = orderTable.getValueAt(row, 12).toString();
        String cost = orderTable.getValueAt(row, 13).toString();

        orderbox.setText(order_no);
        
        oitem.setText(item);
        oricountrybox.setSelectedItem(country_origin);
        seasonbox.setText(season);
        accountbox.setText(account_no);
        ((JTextField) issuedatebox.getDateEditor().getUiComponent()).setText(issueDate);
        ((JTextField) enddatebox.getDateEditor().getUiComponent()).setText(endDate);
        supplierbox.setText(supplier);
        suppliernobox.setText(supplier_no);
        pcountry1.setText(country);
        delivarybox.setSelectedItem(delivary_mode);
        oquntitybox.setText(quntity);
        unitbox.setText(unit_price);
        ocostbox.setText(cost);

    }//GEN-LAST:event_orderTableMouseClicked

    private void oquntityboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oquntityboxKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_oquntityboxKeyTyped

    private void ocostboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ocostboxKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_ocostboxKeyTyped

    private void unitboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitboxKeyTyped
        // TODO add your handling code here:
      try{
           char c=evt.getKeyChar();
            if(!(Character.isDigit(c)||(c==evt.VK_BACK_SPACE)||c==evt.VK_DELETE||evt.getKeyChar() == '.')){
            //  evt.getKeyChar() == '.' does accept point when jtextfield accepts decimal number
            evt.consume();
            getToolkit().beep();
            }
        }catch(Exception e){
        
        }
    }//GEN-LAST:event_unitboxKeyTyped

    private void pcountry1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pcountry1KeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_pcountry1KeyTyped

    private void DEMO_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DEMO_orderActionPerformed
         // TODO add your handling code here:

        orderbox.setText("6");
        oitem.setText("SHIRT");
        oricountrybox.setSelectedItem("Sri Lanka");
        seasonbox.setText("AU12");
        accountbox.setText("23");
        ((JTextField) issuedatebox.getDateEditor().getUiComponent()).setText("2016-09-01");
        ((JTextField)enddatebox.getDateEditor().getUiComponent()).setText("2016-9-31");
        supplierbox.setText("victoria");
        suppliernobox.setText("3");
        pcountry1.setText("Canada");
        delivarybox.setSelectedItem("Ocean");
        oquntitybox.setText("500");
        unitbox.setText("5.65");
        ocostbox.setText("2825");
        
        

    }//GEN-LAST:event_DEMO_orderActionPerformed

    private void SEARCH_ORDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCH_ORDERActionPerformed
        int order_no = Integer.parseInt(ordersearchbox.getText());

        int key = Integer.parseInt(ordersearchbox.getText());
        String sql = "SELECT * from order_details where order_no like '%" + key + "%'";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            orderTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SEARCH_ORDERActionPerformed

    private void CLEAR_ORDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR_ORDERActionPerformed
        // TODO add your handling code here:

        orderbox.setText("");
       
        oitem.setText("");
        pcountry1.setText("");
        seasonbox.setText("");
        oricountrybox.setSelectedItem("select");
        accountbox.setText("");
        issuedatebox.setDate(null);
        enddatebox.setDate(null);
        supplierbox.setText("");
        suppliernobox.setText("");
        countrybox.setText("");
        delivermodebox.setSelectedItem("select");
        oquntitybox.setText("");
        unitbox.setText("");
        ocostbox.setText("");

    }//GEN-LAST:event_CLEAR_ORDERActionPerformed

    private void DELETE_ORDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE_ORDERActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Do you really want to delete");

        if (x == 0) {
            int order_no = Integer.parseInt(orderbox.getText());
            String sql = "DELETE from order_details where order_no='" + order_no + "'";

            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                ordertableload();
                JOptionPane.showMessageDialog(rootPane, "successfull");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Not successfull");
            }
        }
    }//GEN-LAST:event_DELETE_ORDERActionPerformed

    private void ADD_ORDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD_ORDERActionPerformed

        String stringg1 = "2016-01-01";
        SimpleDateFormat bdf = new SimpleDateFormat("YYYY-MM-dd", Locale.getDefault());
        String issueDate = bdf.format(issuedatebox.getDate());
        String endDate = bdf.format(enddatebox.getDate());
        if ((issuedatebox.getCalendar().getTime().after(enddatebox.getCalendar().getTime())) || ((stringg1.compareTo(issueDate) > 0) || (stringg1.compareTo(endDate) > 0))) {
            JOptionPane.showMessageDialog(rootPane, "Invalid  date");
        } else {
            int order_no = Integer.parseInt(orderbox.getText());
            
            String item = oitem.getText();
            String country_origin = oricountrybox.getSelectedItem().toString();                            
            String season = seasonbox.getText();
            int account_no = Integer.parseInt(accountbox.getText());
            String supplier = supplierbox.getText();
            int supplier_no = Integer.parseInt(suppliernobox.getText());
            String country = pcountry1.getText();
            String delivary_mode = delivarybox.getSelectedItem().toString();
            int quntity = Integer.parseInt(oquntitybox.getText());
            double unit_price = Double.parseDouble(unitbox.getText());
            double cost = Double.parseDouble(ocostbox.getText());

            try {
                
                String Que = "INSERT INTO order_details (order_no,item,country_origin,season,account_no,issueDate,endDate,supplier,supplier_no,country,delivary_mode,quntity,unit_price,cost) "
                        + "values ('" + order_no + "'," + "'" + item + "','" + country_origin + "','" + season + "','" + account_no + "','" + issueDate + "','" + endDate + "','" + supplier + "','" + supplier_no + "','" + country + "','" + delivary_mode + "','" + quntity + "','" + unit_price + "','" + cost + "')";
                pst = con.prepareStatement(Que);
                pst.execute();
                ordertableload(); //load table
                JOptionPane.showMessageDialog(rootPane, "Success");
            } catch (Exception e) {

                System.out.println("Exception Thorw" + e);
            }

    }//GEN-LAST:event_ADD_ORDERActionPerformed
    }
    private void UPDATE_ORDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE_ORDERActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Do you really want to update");

        SimpleDateFormat bdf = new SimpleDateFormat("YYYY-MM-dd", Locale.getDefault());
        if (x == 0) {
            int order_no = Integer.parseInt(orderbox.getText());
            
            String item = oitem.getText();
            String country_origin = oricountrybox.getSelectedItem().toString();
            String season = seasonbox.getText();
            int account_no = Integer.parseInt(accountbox.getText());
            String issueDate = bdf.format(issuedatebox.getDate());
            String endDate = bdf.format(enddatebox.getDate());
            String supplier = supplierbox.getText();
            int supplier_no = Integer.parseInt(suppliernobox.getText());
            String country = countrybox.getText();
            String delivary_mode = delivarybox.getSelectedItem().toString();
            int quntity = Integer.parseInt(oquntitybox.getText());
            double unit_price = Double.parseDouble(unitbox.getText());
            double cost = Double.parseDouble(ocostbox.getText());

        //    DecimalFormat df = new DecimalFormat("0.#");
        //    int supplier_no = Integer.parseInt(df.format(Double.parseDouble(supplier_noq)));

            String Sql = "UPDATE order_details SET item='" + item + "',country_origin='" + country_origin + "',season='" + season + "',account_no='" + account_no + "',issueDate='" + issueDate + "',endDate ='" + endDate + "',supplier = '" + supplier + "',supplier_no = '" + supplier_no + "',country='" + country + "',delivary_mode='" + delivary_mode + "',quntity='" + quntity + "',unit_price='" + unit_price + "',cost='" + cost + "' where order_no='" + order_no + "'";
        //    System.out.println("sql : " + Sql);
            try {
                pst = con.prepareStatement(Sql);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Succesfull !!");
                ordertableload();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Not Succesfull.!");
            }
        }
    }//GEN-LAST:event_UPDATE_ORDERActionPerformed

    private void orderboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderboxKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_orderboxKeyTyped

    private void oitemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oitemKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_oitemKeyTyped

    private void seasonboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seasonboxKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_seasonboxKeyTyped

    private void seasonboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seasonboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seasonboxActionPerformed

    private void accountboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountboxKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_accountboxKeyTyped

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //  DefaultTableModel model = (DefaultTableModel)Table.getModel();
        // model.addRow(new Object[]{buyercodebox.getText(),Buyerbox.getText(),Companybox.getText(),emailbox.getText(), Delivermodebox.getSelectedItem().toString(),countrybox.getText(), currencybox.getText(),Datebox.getDate()});

        SimpleDateFormat bdf = new SimpleDateFormat("YYYY-MM-dd", Locale.getDefault());

        int buyer_code = Integer.parseInt(buyercodebox.getText());
        String buyer = buyerbox.getText();
        String email = emailbox.getText();
        String dDate = bdf.format(datebox.getDate());
        String delivary_mode = delivermodebox.getSelectedItem().toString();
        String country = countrybox.getText();

        try {

            String Que = "INSERT INTO buyer_details (buyer_code,buyer,email,dDate,delivary_mode,country) values ('" + buyer_code + "','" + buyer + "','" + email + "','" + dDate + "','" + delivary_mode + "','" + country + "')";
            pst = con.prepareStatement(Que);
            pst.execute();
            buyertableload(); //load table
            JOptionPane.showMessageDialog(rootPane, "Success");
        } catch (Exception e) {

            System.out.println("Exception Thorw" + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buyerboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buyerboxKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_buyerboxKeyTyped

    private void buyercodeboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buyercodeboxKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_buyercodeboxKeyTyped

    private void Update_BuyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_BuyerActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to update");

        if (x == 0) {
            SimpleDateFormat bdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            int buyer_code = Integer.parseInt(buyercodebox.getText());
            String buyer = buyerbox.getText();
            String email1 = emailbox.getText();
            String dDate = bdf.format(datebox.getDate());
            String delivary_mode = delivermodebox.getSelectedItem().toString();
            String country = countrybox.getText();

            String Sql = "UPDATE buyer_details SET buyer='" + buyer + "',email='" + email1 + "',dDate='" + dDate + "',delivary_mode='" + delivary_mode + "',country='" + country + "' where buyer_code='" + buyer_code + "'";

            try {
                pst = con.prepareStatement(Sql);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Succesfull !!");
                buyertableload();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Not Succesfull.!");
            }
        }
    }//GEN-LAST:event_Update_BuyerActionPerformed

    private void DEMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DEMOActionPerformed
        // TODO add your handling code here:
         
        buyercodebox.setText("001");
        buyerbox.setText("Eddie Bauer");
        emailbox.setText("Edd@gmail.com");
        ((JTextField) datebox.getDateEditor().getUiComponent()).setText("2016-09-01");
        delivermodebox.setSelectedItem("Ocean");
        countrybox.setText("CANADA");

    }//GEN-LAST:event_DEMOActionPerformed

    private void CLEAR_BUYERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR_BUYERActionPerformed
        buyercodebox.setText("");
        buyerbox.setText("");
        emailbox.setText("");
        datebox.setDate(null);
        delivermodebox.setSelectedItem("");
        countrybox.setText("");

    }//GEN-LAST:event_CLEAR_BUYERActionPerformed

    private void searchboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_searchboxKeyTyped

    private void SEARCH_BUYERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCH_BUYERActionPerformed

        String buyer = searchbox.getText();
        String Sql = "SELECT buyer_code,buyer,email,dDate,delivary_mode,country from buyer_details where buyer LIKE '%" + buyer + "%'";
        try {
            pst = con.prepareStatement(Sql);
            rs = pst.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
            // Ordertableloadsearch() ;
        } catch (Exception e) {
        }
    }//GEN-LAST:event_SEARCH_BUYERActionPerformed

    private void DELETE_BUYERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE_BUYERActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to delete");

        if (x == 0) {
            String buyer_code = buyercodebox.getText();
           // int buyer_code =Integer.parseInt(buyercodebox.getText());

            String sql = "DELETE from buyer_details where buyer_code='" + buyer_code + "'";

            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                buyertableload();
                JOptionPane.showMessageDialog(rootPane, "successfull");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Not successfull");
            }
        }
    }//GEN-LAST:event_DELETE_BUYERActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked

        // DefaultTableModel model = (DefaultTableModel)Table.getModel();
        int row = Table.getSelectedRow();
        String buyer_code = Table.getValueAt(row, 0).toString();
        String buyer = Table.getValueAt(row, 1).toString();
        String dDate = Table.getValueAt(row, 2).toString();
        String email = Table.getValueAt(row, 3).toString();
        String delivary_mode = Table.getValueAt(row, 4).toString();
        String country = Table.getValueAt(row, 5).toString();

        buyercodebox.setText(buyer_code);
        buyerbox.setText(buyer);
        emailbox.setText(email);
        delivermodebox.setSelectedItem(delivary_mode);
        countrybox.setText(country);
        ((JTextField) datebox.getDateEditor().getUiComponent()).setText(dDate);
    }//GEN-LAST:event_TableMouseClicked

    private void delivermodeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delivermodeboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delivermodeboxActionPerformed

    private void countryboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_countryboxKeyTyped
        // TODO add your handling code here:
        try {
            char c = evt.getKeyChar();
            if (Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_countryboxKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     /*       
           try{
              
            String report="C:\\Users\\us\\Documents\\NetBeansProjects\\studentupdate\\Reports\\Quiz1_marks.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr ,null,con);
            JasperViewer.viewReport(jp,false);
        }
        catch(Exception e){
            System.out.println(e);
            }*/
     MyReportViewer r = new MyReportViewer("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\ireports\\SalesManagement\\BuyerReport.jasper");
        r.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void oquntityboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oquntityboxKeyReleased

        double total = Double.parseDouble(unitbox.getText()) * Double.parseDouble(oquntitybox.getText());
        ocostbox.setText(String.valueOf(total));
    }//GEN-LAST:event_oquntityboxKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD_ORDER;
    private javax.swing.JButton CLEAR_BUYER;
    private javax.swing.JButton CLEAR_ORDER;
    private javax.swing.JButton DELETE_BUYER;
    private javax.swing.JButton DELETE_ORDER;
    private javax.swing.JButton DEMO;
    private javax.swing.JButton DEMO_order;
    private javax.swing.JButton SEARCH_BUYER;
    private javax.swing.JButton SEARCH_ORDER;
    private javax.swing.JTable Table;
    private javax.swing.JButton UPDATE_ORDER;
    private javax.swing.JButton Update_Buyer;
    private javax.swing.JTextField accountbox;
    private java.awt.TextField buyerbox;
    private javax.swing.JTextField buyercodebox;
    private java.awt.TextField countrybox;
    private com.toedter.calendar.JDateChooser datebox;
    private javax.swing.JComboBox delivarybox;
    private javax.swing.JComboBox delivermodebox;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailbox;
    private com.toedter.calendar.JDateChooser enddatebox;
    private com.toedter.calendar.JDateChooser issuedatebox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField ocostbox;
    private javax.swing.JTextField oitem;
    private javax.swing.JTextField oquntitybox;
    private javax.swing.JTable orderTable;
    private javax.swing.JTextField orderbox;
    private javax.swing.JTextField ordersearchbox;
    private javax.swing.JComboBox oricountrybox;
    private javax.swing.JTextField pcountry1;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField seasonbox;
    private javax.swing.JTextField supplierbox;
    private javax.swing.JTextField suppliernobox;
    private javax.swing.JTextField unitbox;
    // End of variables declaration//GEN-END:variables
}
