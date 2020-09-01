package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{

    JTable t1;
    JButton b1,b2;
    
    Room()
    {
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image img1 = img.getImage().getScaledInstance(600, 560, Image.SCALE_DEFAULT);
        JLabel l1 = new JLabel(new ImageIcon(img1));
        l1.setBounds(512,-20,600,600);
        add(l1);
        
        
        JLabel lab1 = new JLabel("Room Number");
        lab1.setBounds(10,10,100,20);
        add(lab1);
        
        JLabel lab2 = new JLabel("Availability");
        lab2.setBounds(125,10,90,20);
        add(lab2);
        
        JLabel lab3 = new JLabel("Status");
        lab3.setBounds(235,10,80,20);
        add(lab3);
        
        JLabel lab4 = new JLabel("Price");
        lab4.setBounds(335,10,60,20);
        add(lab4);
        
        JLabel lab5 = new JLabel("Bed Type");
        lab5.setBounds(420,10,100,20);
        add(lab5);
        
        
        t1 = new JTable();
        t1.setBounds(10,40,500,400);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBounds(100,460,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
       
        b2 = new JButton("Back");
        b2.setBounds(250,460,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(450,200,1050,600);
        setVisible(true);
    }
    
    
    
    
    public static void main(String args[])
    {
        new Room().setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == b1)
       {
          try{
              conn c = new conn();
              String query = "select * from Room;";
              ResultSet rs = c.s.executeQuery(query);
              t1.setModel(DbUtils.resultSetToTableModel(rs));
               
          }catch(Exception ae)
          {
              ae.printStackTrace();
          }
       }
       else if(e.getSource() == b2)
       {
           new Reception().setVisible(true);
           this.setVisible(false);
       }
    }
    
}
