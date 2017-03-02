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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author PRATHAMESH
 */
public class EditGroupGuide extends javax.swing.JFrame {

    /**
     * Creates new form EditGroupGuide
     */
    public EditGroupGuide() {
        initComponents();
        try{
            Image image = new ImageIcon("Images\\icon.png").getImage();
            this.setIconImage(image);
            }catch(Exception e){
            System.out.println("Appilcation icon not found");
        }
        retData();
        this.setVisible(true);
        this.setTitle("Projob :: Edit GroupGuide");
        this.setSize(580, 340);
        this.setResizable(false);
        setLocation(440,181);
        jButton1.setOpaque(true);
        jButton2.setOpaque(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);
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
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Simplifica", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Group Guide");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 20, 220, 59);

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 290, 170);

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Delete");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 220, 90, 40);

        jLabel4.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText(" Name :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(320, 120, 80, 30);

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(320, 220, 90, 40);

        jTextField2.setBackground(new java.awt.Color(102, 102, 102));
        jTextField2.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(410, 120, 100, 30);

        jLabel2.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/samplegui/Wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, -20, 620, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index=jTable1.getSelectedRow();
        String id=jTable1.getValueAt(index, 0).toString();
        if(updateData(id,jTextField2.getText())){
            retData();
            jTextField2.setText("");
            JOptionPane.showMessageDialog(this, "Records Updated");
        }
        else{
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String name=jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        jTextField2.setText(name);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] options={"Yes","No"};
        int ans=JOptionPane.showOptionDialog(this, "Are you sure to delete this entry?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
        
        if(ans==0){
            int index=jTable1.getSelectedRow();
            String id=jTable1.getValueAt(index, 0).toString();
            if(delData(id)){
                
                retData();
                jTextField2.setText("");
                JOptionPane.showMessageDialog(this, "Deleted the selected record successfully.");
            }
            else{
                JOptionPane.showMessageDialog(this, "Error!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public Boolean delData(String id){
        String sql="Delete from guide where guideid='"+id+"'";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root");  
            Statement s=con.prepareStatement(sql);
            System.out.println(id);
            s.execute(sql);
            System.out.println(id);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public void retData(){
        DefaultTableModel dm=new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Name");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root");                
		String sql = "select * from guide";
                // execute insert SQL stetement
                Statement s=con.prepareStatement(sql);
                ResultSet rs=s.executeQuery(sql);
                while(rs.next()){
                    String id=rs.getString(1);
                    String name=rs.getString(2);
                    System.out.println(id+"\t"+name);
                    dm.addRow(new String[]{id,name});
                }

                jTable1.setModel(dm);
		//System.out.println("Record is inserted into DBUSER table!");        
        }
        catch(ClassNotFoundException | SQLException e){}
    }
    
    public Boolean updateData(String id, String name){
        String sql="update guide set guidename='"+name+"' where guideid="+id;
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root");
            
            Statement s=con.prepareStatement(sql);
            s.execute(sql);
            return true;
        }
        catch(ClassNotFoundException | SQLException e){
            return false;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditGroupGuide().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
