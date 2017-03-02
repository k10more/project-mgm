package samplegui;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author PRATHAMESH
 */

public class SampleGUI extends JFrame{
    public static String username;
    public static String usertype;    
    String password;
    JFrame jfrm;
    JComboBox usrtype;
    JTextField usr;
    JPasswordField psw;
    JLabel sbtn;
    JLabel titlebar;
    JLabel usrtypelbl;
    JLabel usrlbl;
    JLabel pswlbl;
    JLabel bg;
    Font minimal;
    String[] user={"Admin","Teacher","Student"};
    boolean b=false;
    SampleGUI(){
        
        
        
    }
    
    public void initComponent(){
        //JFRAME Properties with background using image from :: C:\\Users\\PRATHAMESH\\Documents\\NetBeansProjects\\SampleGUI\\src\\Images\\Wallpaper1.jpg
        jfrm=new JFrame("Projob :: Login");
        jfrm.setSize(658,370);
        jfrm.setLayout(null);
        jfrm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jfrm.setLocation(350,170);
        this.setAlwaysOnTop(true);
        jfrm.setResizable(false);
        try{
            JLabel bg=new JLabel(new ImageIcon(ImageIO.read(new File("Images\\Wallpaper.jpg"))));
            bg.setSize(700,400);
            jfrm.setContentPane(bg);
        }catch(IOException e){
            System.out.println("Image Doesn't Exist!");
        }
        jfrm.pack();

        //Font Settings
        minimal=new Font("Simplifica",Font.BOLD,20);
        sbtn=new JLabel();
        //All components properties
        try{
            sbtn.setIcon(new ImageIcon(ImageIO.read(new File("Images\\submit.png"))));
        }
        catch(Exception e){}
        usrtypelbl=new JLabel("User Type       :");
        usrlbl=new JLabel("User Name     :");
        pswlbl=new JLabel("Password       :");
        usr=new JTextField();
        psw=new JPasswordField();
        psw.setEchoChar('#');
        usrtype =new JComboBox(user);  
        
        usrtypelbl.setBounds(180,120,100,30);
        usrtypelbl.setForeground(Color.decode("#fafafa"));
        usrtype.setBounds(350,120,150,30);
        
        usrlbl.setBounds(180,170,100,30);
        usrlbl.setForeground(Color.decode("#fafafa"));
        usr.setBounds(350,170,150,30);
        
        pswlbl.setBounds(180,220,100,30);
        pswlbl.setForeground(Color.decode("#fafafa"));
        psw.setBounds(350,220,150,30);
        
        sbtn.setBounds(270,270,100,50);
        
        jfrm.add(sbtn);
        jfrm.add(usrtype);
        jfrm.add(usrlbl);
        jfrm.add(pswlbl);
        jfrm.add(usrtypelbl);
        jfrm.add(psw);
        jfrm.add(usr);
        
        //Jlabel having gray background and white as foreground without border
        psw.setBackground(Color.decode("#616161"));
        psw.setForeground(Color.decode("#fafafa"));
        psw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        usr.setBackground(Color.decode("#616161"));
        usr.setForeground(Color.decode("#fafafa"));
        usr.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        usrtype.setBackground(Color.decode("#616161"));
        usrtype.setForeground(Color.decode("#fafafa"));
        usrtype.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        //font setting to components
        usrtype.setFont(minimal);
        usr.setFont(minimal);
        psw.setFont(minimal);
        usrlbl.setFont(minimal);
        usrtypelbl.setFont(minimal);
        pswlbl.setFont(minimal);
        
        mouseactionlabel();
        sbtn.setFont(minimal);
        
        try{
            Image image = new ImageIcon("Images\\icon.png").getImage();
            jfrm.setIconImage(image);
            }catch(Exception e){
            System.out.println("Appilcation icon not found");
        }
        jfrm.setVisible(true);
    }
    final void mouseactionlabel(){
        sbtn.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent arg0) {
                try{
                    sbtn.setIcon(new ImageIcon(ImageIO.read(new File("Images\\submit_clicked.png"))));}
                catch(Exception e){}
            }
            public void mouseEntered(MouseEvent arg0) {
                try{
                    sbtn.setIcon(new ImageIcon(ImageIO.read(new File("Images\\submit_hover.png"))));}
                catch(Exception e){}
            }
            public void mouseExited(MouseEvent arg0) {
                try{
                    sbtn.setIcon(new ImageIcon(ImageIO.read(new File("Images\\submit.png"))));}
                catch(Exception e){}
            }
            public void mousePressed(MouseEvent arg0) {
                try{
                    sbtn.setIcon(new ImageIcon(ImageIO.read(new File("Images\\submit_clicked.png"))));}
                catch(Exception e){}
            }
            public void mouseReleased(MouseEvent arg0) {
                con();                
            }
        });
    }
    
    public void con(){
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projob","root","root")) {
                //here sonoo is database name, root is username and password
                Statement stmt=con.createStatement();
                String sql = "SELECT * FROM login";
                
                ResultSet rs = stmt.executeQuery(sql);
                username=usr.getText();
                password=psw.getText();
                usertype=(String) usrtype.getSelectedItem();
                //STEP 5: Extract data from result set
                System.out.println(username+"/n"+password+"/n"+usertype);
                while(rs.next()){
                    //Retrieve by column name
                    System.out.println("Hello");
                    String un = rs.getString(1);
                    String passworddb  = rs.getString(2);
                    String utype  = rs.getString(3);
                    System.out.println(un+"/n"+passworddb+"/n"+utype);
                    
                    
                    
                    if(un.equals(username)&&passworddb.equals(password)&&utype.equals(usertype))
                    {
                        b=true;
                        break;
                    }
                }
                    if(b==true){
                        jfrm.dispose();
                        MainForm m=new MainForm();
                    }
                    else{
                        JOptionPane.showMessageDialog(jfrm,"Please enter valid username and password");
                    }
                      
            }  
        }catch(Exception z)
        { 
            
        
        }
    }
    
    public static void main(String[] args) {
        SampleGUI app=new SampleGUI();  
        app.initComponent();
        app.setUndecorated(true);
        app.setResizable(false);
    }

    
}