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
public class EditProject extends javax.swing.JFrame {

    /**
     * Creates new form EditProject
     */
    public EditProject() {
        initComponents();
        try{
            Image image = new ImageIcon("Images\\icon.png").getImage();
            this.setIconImage(image);
            }catch(Exception e){
            System.out.println("Appilcation icon not found");
        }
        this.setSize(665,560);
        this.setTitle("Projob :: Edit Project");
        this.setVisible(true);
        this.setLocation(362,150);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);
        retData();
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Group ID", "Project Name", "Branch", "Project Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setBounds(10, 80, 632, 172);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 450, 125, 40);

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(400, 450, 125, 40);

        jLabel1.setFont(new java.awt.Font("Simplifica", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Project");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(252, 28, 136, 36);

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Project Name :");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 270, 140, 40);

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Project Description :");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(150, 320, 130, 40);

        jTextField1.setBackground(new java.awt.Color(102, 102, 102));
        jTextField1.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setToolTipText("");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(380, 280, 160, 30);

        jTextArea1.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(380, 330, 210, 80);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/samplegui/Wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 650, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Boolean delData(String id){
        String sql="update project set prodesc=null, projectname=null where groupid="+id;
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
    
    public Boolean updateData(String id, String projname,String prodesc){
        String sql="update project set projectname='"+prodesc+"', prodesc='"+projname+"' where groupid="+id;
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(projname+"\n"+prodesc);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root");
            
            Statement s=con.prepareStatement(sql);
            s.execute(sql);
            return true;
        }
        catch(ClassNotFoundException | SQLException e){
            return false;
        }
    }
    
    public void retData(){
        DefaultTableModel dm=new DefaultTableModel();
        dm.addColumn("Group ID");
        dm.addColumn("Projecte");
        dm.addColumn("Branch");
        dm.addColumn("Project Description");
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
                    String projname=rs.getString(9);
                    String branch=rs.getString(7);
                    String prodesc=rs.getString(8);
                    System.out.println(projname+"\n"+prodesc);
                    //System.out.println(id+"\t"+name);
                    dm.addRow(new String[]{groupid,projname,branch,prodesc});
                }

                jTable1.setModel(dm);
		//System.out.println("Record is inserted into DBUSER table!");        
        }
        catch(ClassNotFoundException | SQLException e){}
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // delete
        String[] options={"Yes","No"};
        int ans=JOptionPane.showOptionDialog(this, "Are you sure to delete this entry?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
        
        if(ans==0){
            int index=jTable1.getSelectedRow();
            String id=jTable1.getValueAt(index, 0).toString();
            
            if(jTable1.getValueAt(index, 1)==null){
                    JOptionPane.showMessageDialog(this, "Recored is not available or already deleted");
                }
            
            else if(delData(id)){
                
                retData();
                jTextField1.setText("");
                jTextArea1.setText("");
                
                JOptionPane.showMessageDialog(this, "Deleted the selected record successfully.");
            }
            else{
                JOptionPane.showMessageDialog(this, "Error!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // update
        int index=jTable1.getSelectedRow();
        String id=jTable1.getValueAt(index, 0).toString();
        System.out.println(id);
            System.out.println("button action:"+jTextField1.getText()+"\n"+jTextArea1.getText());
        if(updateData(id,jTextField1.getText(),jTextArea1.getText())){
            retData();
            jTextField1.setText("");
            jTextArea1.setText("");
            
            JOptionPane.showMessageDialog(this, "Records Updated");
        }
        else{
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String projname=jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String prodesc=jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        jTextField1.setText(projname);
        jTextArea1.setText(prodesc);
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
