/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voguetexmachinesharing.managementsystem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import EmployeeManagement.Employee;

/**
 *
 * @author Sampath Rajapakse
 */
public class ProgressBar extends javax.swing.JFrame {

    /**
     * Creates new form ProgressBar
     */
    DBConnect dbOps;
    public ProgressBar(DBConnect dbObj) {
        initComponents();
        this.dbOps=dbObj;
        new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0; i<=100; i++){
                
                    jProgressBar1.setValue(i);
                    
                    if(i<10){
                        try {
                            ImageIcon icon1 = new ImageIcon("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\src\\Images\\load5.jpg");
                            loadImage.setIcon(icon1);
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    lblLoading.setText(null);
                    lblLoading.setText("Loading Database............");
                    }
                    
                    else if(i<20){
                        try {
                            Thread.sleep(90);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ImageIcon icon2 = new ImageIcon("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\src\\Images\\load2.jpg");
                        loadImage.setIcon(icon2);
                        lblLoading.setText("Connecting Database..........");
                    }
                    
                    else if(i<30){
                        try {
                            Thread.sleep(80);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ImageIcon icon3 = new ImageIcon("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\src\\Images\\load7.jpg");
                    loadImage.setIcon(icon3);
                    lblLoading.setText("Loading interface..........");
                    }
                    
                    else if(i<40){
                        try {
                            Thread.sleep(70);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ImageIcon icon4 = new ImageIcon("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\src\\Images\\load6.jpg");
                    loadImage.setIcon(icon4);
                    lblLoading.setText("Loading Images..........");
                    }
                     
                    else if(i<50){
                        try {
                            Thread.sleep(60);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ImageIcon icon5 = new ImageIcon("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\src\\Images\\load1.jpg");
                    loadImage.setIcon(icon5);
                    lblLoading.setText("Reading Preferences..........");
                    }
                      
                    else if(i<60){
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ImageIcon icon6 = new ImageIcon("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\src\\Images\\load3.jpg");
                    loadImage.setIcon(icon6);
                    lblLoading.setText("Scanning for plugins..........");
                    }
                       
                    else if(i<70){
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ImageIcon icon7 = new ImageIcon("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\src\\Images\\load8.jpg");
                    loadImage.setIcon(icon7);
                    lblLoading.setText("Initializing tools..........");
                    }
                    else if(i<80){
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ImageIcon icon8 = new ImageIcon("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\src\\Imagesload2.jpg");
                    loadImage.setIcon(icon8);
                    lblLoading.setText("Loading fonts..........");
                    }
                         else if(i<90){
                        try {
                           
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       ImageIcon icon9 = new ImageIcon("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\src\\Images\\load4.jpg");
                       loadImage.setIcon(icon9);  
                    lblLoading.setText("Reading tool functions..........");
                    }
                         else if(i==100){
                        try {
                            
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    ImageIcon icon10 = new ImageIcon("C:\\Users\\Sampath Rajapakse\\Documents\\NetBeansProjects\\VogueTexMachineSharing&ManagementSystem\\src\\Images\\load8.jpg");
                    loadImage.setIcon(icon10);    
                    lblLoading.setText("Finishing..........");
                    s();
                    }
                    
                                        }
                
            }
        }).start();
    }
    void s(){
        
        new Home(loadUser()).setVisible(true);
        this.dispose();
    
    }
    
    Employee loadUser(){
        DBConnect dbs=new DBConnect();
        Employee emp=dbs.loadUser(dbOps.userID);
        System.out.println(emp.getDepartment());
        return emp;
    
    }
        
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblLoading = new javax.swing.JLabel();
        loadImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loading");

        jPanel1.setLayout(null);
        jPanel1.add(jProgressBar1);
        jProgressBar1.setBounds(10, 224, 360, 14);

        lblLoading.setForeground(new java.awt.Color(255, 255, 255));
        lblLoading.setText("Loading");
        jPanel1.add(lblLoading);
        lblLoading.setBounds(10, 249, 170, 14);

        loadImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/load5.jpg"))); // NOI18N
        jPanel1.add(loadImage);
        loadImage.setBounds(130, 10, 155, 200);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Greenbackground.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-6, -6, 410, 310);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProgressBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgressBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgressBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgressBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DBConnect dbOps=new DBConnect();
                new ProgressBar(dbOps).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel loadImage;
    // End of variables declaration//GEN-END:variables
}
