package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    Login()
    {
        
        
        
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l1.setBounds(140,52,100,20);
        l1.setForeground(Color.WHITE);
        l2.setBounds(140, 82, 100, 20);
        l2.setForeground(Color.WHITE);
        add(l1);
        add(l2);
        t1 = new JTextField();
        t1.setBounds(240 , 52 , 150 ,25);
        t2 = new JPasswordField();
        t2.setBounds(240 , 82 , 150 ,25);
        add(t1);
        add(t2);
        b1 = new JButton("Login");
        b1.setBounds(130,150,120,25);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        add(b1);
        b1.addActionListener(this);
        b2 = new JButton("Cancel");
        b2.addActionListener(this);
        b2.setBounds(270,150,120,25);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        add(b2);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/login.jpg"));
        Image img = image.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        JLabel l3 = new JLabel(new ImageIcon(img));
        l3.setBounds(0,0,600,300);
        add(l3);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,300,600,300);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == b1)
         {
             String username = t1.getText();
             String password = t2.getText();
             conn c = new conn();
             String query = "select * from login where username = '" + username + "' and password = '" + password + "' ;";
             try
             {
                 ResultSet rs = c.s.executeQuery(query);
                 if(rs.next())
                 {
                     new Dashboard().setVisible(true);
                     this.setVisible(false);
                     
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                 }
             }
             catch(Exception E)
             {
                 E.printStackTrace();
             }
             
         }else if (e.getSource() == b2)
         {
             System.exit(0);
         }
    }
}


