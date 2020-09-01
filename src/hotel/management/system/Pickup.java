package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class Pickup extends JFrame implements ActionListener {

    JComboBox box1;
    Choice ch;
    JButton b1,b2;
    JTable t1;
    Pickup()
    {
    
        JLabel l1 = new JLabel("Pickup");
        l1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(400,30,200,30);
        add(l1);
        
        JLabel l2 = new JLabel("Type Of Car");;
        l2.setBounds(50,100,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Driver Name");;
        l3.setBounds(30,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Age");;
        l4.setBounds(210,160,80,20);
        add(l4);
        
        JLabel l5 = new JLabel("Gender");;
        l5.setBounds(360,160,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Car");;
        l6.setBounds(530,160,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Availability");;
        l7.setBounds(700,160,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Location");;
        l8.setBounds(890,160,100,20);
        add(l8);
        
       
        
        ch = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next())
            {
                ch.add(rs.getString("car"));
            }
            
        }catch(Exception ae)
        {
            ae.printStackTrace();
        }
        ch.setBounds(170,100,120,25);
        add(ch);
        ch.setBackground(Color.WHITE);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(300,520,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(500,520,120,30);
        b2.addActionListener(this);
        add(b2);
        
        t1 = new JTable();
        t1.setBounds(0,185,1000,300);
        add(t1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,1000,650);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == b1)
       {
           try{
           
               conn c = new conn();
               String car = (String)ch.getSelectedItem();
               String str = "select * from driver where car = '"+car+"';";
               
                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
               
               
           }catch(Exception ae)
           {
               ae.printStackTrace();
           }
       }else if(e.getSource() == b2)
       {
           new Reception().setVisible(true);
           this.setVisible(false);
       }
    
    }
    
    public static void main(String[] args)
    {
        new Pickup().setVisible(true);
    }
    
}
