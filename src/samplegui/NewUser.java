/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplegui;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author PRATHAMESH
 */
public class NewUser extends javax.swing.JFrame {

    /**
     * Creates new form NewUser
     */
    public NewUser() {
        initComponents();
        this.setTitle("Projob :: New User");
        try{
            Image image = new ImageIcon("Images\\icon.png").getImage();
            this.setIconImage(image);
            }catch(Exception e){
            System.out.println("Appilcation icon not found");
        }
        this.setVisible(true);
        this.setSize(657,556);
        this.setLocation(380,150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        jButton1.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent arg0) {
                
            }
            public void mouseEntered(MouseEvent arg0) {
                
            }
            public void mouseExited(MouseEvent arg0) {
                
            }
            public void mousePressed(MouseEvent arg0) {
            }
            public void mouseReleased(MouseEvent arg0) {
                con();
            }
        });
    }
    
    public void con(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root");
            Statement stmt=con.createStatement();
            String un=jTextField2.getText();
            String psw1=jPasswordField1.getText();
            String psw2=jPasswordField2.getText();
            String utype=(String) jComboBox1.getSelectedItem();
            String sql="SELECT username from login";
            ResultSet rs=stmt.executeQuery(sql);
            System.out.println("Checks for username");
            while(rs.next()){
                System.out.println("Retriving info");
                String cmpun=rs.getString("username");
                System.out.println(cmpun+"\n"+un);
                if(cmpun.equals(un)){
                    System.out.println("Username already exists");
                    JOptionPane.showMessageDialog(this,"Username already exist");
                }
                else if(psw1.equals(psw2)){
                    insert();
                }
                else{
                    System.out.println("Password doesn't match!\npsw1:"+psw1+"\npsw2:"+psw2);
                    JOptionPane.showMessageDialog(this,"Password doesn't match!");
                 
                }
                /*
                if(cmpun.equals(un)){
                    System.out.println(cmpun+"\n"+un);
                    JOptionPane.showMessageDialog(this,"Username already Exist!");    
                }
                else{
                    if(psw1!=psw2){
                        PreparedStatement preparedStatement=null;
                        String insertSQL="INSERT INTO login"+"(username,password,usertype) VALUES"+ "(?,?,?)";
                        preparedStatement=con.prepareStatement(insertSQL);
                        preparedStatement.setString(1, un);
                        preparedStatement.setString(2, psw1);
                        preparedStatement.setString(3, utype);
                        
                        preparedStatement.executeUpdate();
                        System.out.println("User Created!");
                        JOptionPane.showMessageDialog(this,"User has been successfully added");
                        this.dispose();                       
                        
                        
                    }
                    else{
                        System.out.println("Password doesn't match!\npsw1:"+psw1+"\npsw2:"+psw2);
                        JOptionPane.showMessageDialog(this,"Password doesn't match!");
                    }
                }
                
                */
            }
        }
        catch(Exception e){
            
        }
    }
    public void insert(){
        String un=jTextField2.getText();
        String psw1=jPasswordField1.getText();
        String psw2=jPasswordField1.getText();
        String utype=(String)jComboBox1.getSelectedItem();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root");
            
            PreparedStatement preparedStatement=null;
            String insertSQL="INSERT INTO login"+"(username,password,usertype) VALUES"+ "(?,?,?)";
            preparedStatement=con.prepareStatement(insertSQL);
            preparedStatement.setString(1, un);
            preparedStatement.setString(2, psw1);
            preparedStatement.setString(3, utype);
                        
            preparedStatement.executeUpdate();
            System.out.println("User Created!");
            JOptionPane.showMessageDialog(this,"User has been successfully added");
            this.dispose();   
        }
        catch(Exception e){
            
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

        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1.setFont(new java.awt.Font("Simplifica", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Simplifica", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username :");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 120, 150, 40);

        jLabel3.setFont(new java.awt.Font("Simplifica", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password :");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 190, 150, 40);

        jLabel4.setFont(new java.awt.Font("Simplifica", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirm Password :");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 260, 150, 40);

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Simplifica", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create User");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 440, 170, 60);

        jPasswordField1.setBackground(new java.awt.Color(102, 102, 102));
        jPasswordField1.setFont(new java.awt.Font("Simplifica", 1, 20)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(380, 190, 150, 40);

        jPasswordField2.setBackground(new java.awt.Color(102, 102, 102));
        jPasswordField2.setFont(new java.awt.Font("Simplifica", 1, 20)); // NOI18N
        jPasswordField2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(380, 260, 150, 40);

        jTextField2.setBackground(new java.awt.Color(102, 102, 102));
        jTextField2.setFont(new java.awt.Font("Simplifica", 1, 20)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(380, 120, 150, 40);

        jLabel5.setFont(new java.awt.Font("Simplifica", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("New User");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 30, 350, 40);

        jLabel6.setFont(new java.awt.Font("Simplifica", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("User Type :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 330, 150, 50);

        jComboBox1.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox1.setFont(new java.awt.Font("Simplifica", 1, 20)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Teacher", "Student" }));
        jComboBox1.setToolTipText("Select for user type");
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(380, 330, 150, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/samplegui/Wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-20, -40, 760, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
