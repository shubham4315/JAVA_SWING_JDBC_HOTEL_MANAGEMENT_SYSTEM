
package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class EmployeeInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    
    EmployeeInfo()
    {
     
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40,15,70,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(170,15,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(320,15,70,20);
        add(l3);
        
        JLabel l4 = new JLabel("Department");
        l4.setBounds(450,15,70,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(590,15,70,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone");
        l6.setBounds(750,15,70,20);
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(890,15,70,20);
        add(l7);
        
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
        new EmployeeInfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == b1)
       {
            try
            {
                conn c = new conn();
                String query = "select * from Employee ;";
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
