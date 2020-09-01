package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class SearchRoom extends JFrame implements ActionListener {

    JComboBox box1;
    JCheckBox ch;
    JButton b1,b2;
    JTable t1;
    SearchRoom()
    {
    
        JLabel l1 = new JLabel("Search For Room");
        l1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(400,30,200,30);
        add(l1);
        
        JLabel l2 = new JLabel("Search For Room");;
        l2.setBounds(50,100,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Room Number");;
        l3.setBounds(50,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Available");;
        l4.setBounds(240,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Cleaning Status");;
        l5.setBounds(410,160,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Price");;
        l6.setBounds(650,160,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Bed Type");;
        l7.setBounds(850,160,100,20);
        add(l7);
        
        
        box1 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        box1.setBounds(170,100,150,25);
        box1.setBackground(Color.WHITE);
        add(box1);
        
        ch = new JCheckBox("Only display available");
        ch.setBounds(650,100,150,25);
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
        t1.setBounds(0,200,1000,300);
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
               String bed = (String)box1.getSelectedItem();
               String str = "select * from room where bed = '"+bed+"';";
               String str1 = "select * from room where bed = '"+bed+"' and available = 'Available' ;";
               if(ch.isSelected())
               {
                   ResultSet rs1 = c.s.executeQuery(str1);
                    //ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs1));
               }else
               {
                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
               }
               
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
        new SearchRoom().setVisible(true);
    }
    
}
