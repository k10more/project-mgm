/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplegui;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static samplegui.SampleGUI.usertype;



/**
 *
 * @author PRATHAMESH
 */
public class NewGroup extends javax.swing.JFrame {

    /**
     * Creates new form NewGroup
     */
    
    
    public NewGroup() {
        initComponents();
        con();
        try{
            Image image = new ImageIcon("Images\\icon.png").getImage();
            this.setIconImage(image);
            }catch(Exception e){
            System.out.println("Appilcation icon not found");
        }
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jButton1.setOpaque(true);
        this.setLocation(463,147);
        this.setSize(477,542);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Projob :: New Group");
        this.setAlwaysOnTop(true);
    }
    public void con(){
        
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root");
                //here sonoo is database name, root is username and password
                Statement stmt=con.createStatement();
                //combobox for groupguide
                String sql = "SELECT guideid FROM guide";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String name  = rs.getString("guideid");  
                    System.out.println(name);
                    jComboBox5.addItem(rs.getString("guideid"));
                }
                
                sql="SELECT rollno from student";
                rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String roll=rs.getString("rollno");
                    jComboBox2.addItem(roll);
                    jComboBox3.addItem(roll);
                    jComboBox4.addItem(roll);
                }
                
        }               
        catch(Exception z)
        {      
        }
        
             
    }
    
    public void refreshCombo(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root");
                //here sonoo is database name, root is username and password
                Statement stmt=con.createStatement();
                //combobox for leader
                String roll=(String)jComboBox2.getSelectedItem();
                String sql = "SELECT name FROM student WHERE rollno="+roll;
                System.out.println(roll);
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                String name=rs.getString("name");
                System.out.println(name);
                jTextField3.setText(name);
                }
                
                //combobox for mem1
                roll=(String)jComboBox3.getSelectedItem();
                sql = "SELECT name FROM student WHERE rollno="+roll;
                System.out.println(roll);
                rs = stmt.executeQuery(sql);
                while(rs.next()){
                String name=rs.getString("name");
                System.out.println(name);
                jTextField4.setText(name);
                }
                
                //combobox for mem2
                roll=(String)jComboBox4.getSelectedItem();
                sql = "SELECT name FROM student WHERE rollno="+roll;
                System.out.println(roll);
                rs = stmt.executeQuery(sql);
                while(rs.next()){
                String name=rs.getString("name");
                System.out.println(name);
                jTextField5.setText(name);
                }
                
                //combobox for guidename
                String id=(String)jComboBox5.getSelectedItem();
                sql = "SELECT guidename FROM guide WHERE guideid="+id;
                System.out.println(roll);
                rs = stmt.executeQuery(sql);
                while(rs.next()){
                String name=rs.getString("guidename");
                System.out.println(name);
                jTextField6.setText(name);
                }
        }
        catch(Exception e){
            
        }
        
    }
    
    public void conn()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root");
                        
            Statement stmt=con.createStatement();
            String sql = "SELECT groupname FROM groupdata";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String name  = rs.getString("groupname");  
                    System.out.println(name);
                    if(name==null){
                        break;
                    }
                }
            String groupid=jTextField1.getText();
            int id1=Integer.parseInt(groupid);
            //String sql="Select groupid from project";
            String groupname=jTextField2.getText();
            String leader=jTextField3.getText();
            String mem1=jTextField4.getText();
            String mem2=jTextField5.getText();
            String branch=(String)jComboBox1.getSelectedItem();
            String guide=jTextField6.getText();
            PreparedStatement preparedStatement = null;
            System.out.println("Accepted values:"+"\n"+groupid+"\n"+groupname+"\n"+leader+"\n"+mem1+"\n"+mem2+"\n"+branch+"\n"+guide);
            String insertTableSQL = "INSERT INTO groupdata"+ "(groupid, groupname, leader, mem1, mem2, branch, guide) VALUES"+ "(?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, id1);
            preparedStatement.setString(2, groupname);
            preparedStatement.setString(3, leader);
            preparedStatement.setString(4, mem1);
            preparedStatement.setString(5, mem2);
            preparedStatement.setString(6, branch);
            preparedStatement.setString(7, guide);
            System.out.println("executing update");
            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            System.out.println("updateExecuted");
            System.out.println("Record is inserted into DBUSER table!");
            JOptionPane.showMessageDialog(this,"Record successfully added.");       
        }
        catch(Exception e){
            System.out.println("Error::"+e);
        }
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
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Group ID :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(69, 65, 106, 40);

        jLabel2.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Group Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(69, 116, 106, 40);

        jTextField1.setBackground(new java.awt.Color(102, 102, 102));
        jTextField1.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(252, 70, 160, 40);

        jTextField2.setBackground(new java.awt.Color(102, 102, 102));
        jTextField2.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(252, 116, 160, 40);

        jLabel3.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Group Leader :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(69, 162, 106, 40);

        jLabel4.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Group Member 1 :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(69, 208, 106, 40);

        jLabel5.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Group Member 2 :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(69, 254, 110, 40);

        jLabel6.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Branch :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(69, 300, 106, 40);

        jComboBox1.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox1.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INFT", "CMPN", "EXTC", "ETRX" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(252, 300, 160, 40);

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(170, 450, 130, 40);

        jLabel7.setFont(new java.awt.Font("Simplifica", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("New Group");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(190, 20, 153, 36);

        jComboBox2.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox2.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(252, 162, 40, 40);

        jComboBox3.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox3.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(252, 208, 40, 40);

        jComboBox4.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox4.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox4);
        jComboBox4.setBounds(252, 254, 40, 40);

        jLabel9.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Guide Name :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(70, 350, 140, 40);

        jComboBox5.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox5.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox5);
        jComboBox5.setBounds(252, 346, 40, 40);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(102, 102, 102));
        jTextField3.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField3);
        jTextField3.setBounds(300, 162, 140, 40);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(102, 102, 102));
        jTextField4.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField4);
        jTextField4.setBounds(300, 210, 140, 40);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(102, 102, 102));
        jTextField5.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField5);
        jTextField5.setBounds(300, 255, 140, 40);

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(102, 102, 102));
        jTextField6.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField6);
        jTextField6.setBounds(300, 346, 140, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/samplegui/Wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 550, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*if(){
            
        }*/
        /*else{*/
            conn();
            this.dispose();
       //}
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        refreshCombo();
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        refreshCombo();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        refreshCombo();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        refreshCombo();
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(NewGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewGroup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
