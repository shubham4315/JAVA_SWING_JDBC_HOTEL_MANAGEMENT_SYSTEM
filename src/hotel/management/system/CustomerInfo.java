
package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    
    CustomerInfo()
    {
     
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10,15,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(160,15,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(300,15,70,20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(410,15,70,20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(550,15,70,20);
        add(l5);
        
        JLabel l6 = new JLabel("Room");
        l6.setBounds(670,15,70,20);
        add(l6);
        
        JLabel l7 = new JLabel("Status");
        l7.setBounds(790,15,70,20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(905,15,70,20);
        add(l8);
        
        
        t1 = new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        
        
        b1 = new JButton("Load Data");
        b1.setBounds(350,560,120,30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(530,560,120,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(450,200,1000,650);
        setVisible(true);
    
    }
    
    public static void main(String[] args)
    {
        new CustomerInfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == b1)
       {
            try
            {
                conn c = new conn();
                String query = "select * from Customer ;";
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
