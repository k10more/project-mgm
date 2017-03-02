/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplegui;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PRATHAMESH
 */
public class DisplayGroup extends javax.swing.JFrame {

    /**
     * Creates new form DisplayGroup
     */
    public DisplayGroup() {
        initComponents();
        try{
            Image image = new ImageIcon("Images\\icon.png").getImage();
            this.setIconImage(image);
            }catch(Exception e){
            System.out.println("Appilcation icon not found");
        }
        this.setSize(680,400);
        this.setVisible(true);
        
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jButton1.setOpaque(true);
        this.setLocation(346,188);
        this.setAlwaysOnTop(true);
        this.setTitle("Projob :: Group Table");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Simplifica", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Group Tables");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(261, 23, 177, 34);

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Group ID", "Group Name", "Group Leader", "Group Member 1", "Group Member 2", "Guide Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 153, 255));
        jTable1.setNextFocusableComponent(jButton1);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 75, 641, 210);

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Retieve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 310, 144, 42);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/samplegui/Wallpaper.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 690, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void retData(){
        DefaultTableModel dm=new DefaultTableModel();
        dm.addColumn("Group ID");
        dm.addColumn("Group Name");
        dm.addColumn("Group Leader");
        dm.addColumn("Group Member1");
        dm.addColumn("Group Member2");
        dm.addColumn("Guide Name");        
        dm.addColumn("Branch");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root");                
		String sql = "select * from project";
                // execute insert SQL stetement
                Statement s=con.prepareStatement(sql);
                ResultSet rs=s.executeQuery(sql);
                while(rs.next()){
                    String groupid=rs.getString(1);
                    String groupname=rs.getString(2);
                    String groupleader=rs.getString(3);
                    String groupmem1=rs.getString(4);
                    String groupmem2=rs.getString(5);
                    String guidename=rs.getString(6);
                    String branch=rs.getString(7);
                    //System.out.println(id+"\t"+name);
                    dm.addRow(new String[]{groupid,groupname,groupleader,groupmem1,groupmem2,guidename,branch});
                }

                jTable1.setModel(dm);
		//System.out.println("Record is inserted into DBUSER table!");        
        }
        catch(ClassNotFoundException | SQLException e){}
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        retData();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DisplayGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayGroup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
