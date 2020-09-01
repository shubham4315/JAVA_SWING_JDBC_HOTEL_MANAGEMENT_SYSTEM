package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class Department extends JFrame implements ActionListener {

    JComboBox box1;
    JButton b1,b2;
    JTable t1;
    Department()
    {
    
        
        JLabel l2 = new JLabel("Department");;
        l2.setBounds(60,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Budget");;
        l3.setBounds(360,10,100,20);
        add(l3);
        
        
        b1 = new JButton("Load Data");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(180,400,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(380,400,120,30);
        b2.addActionListener(this);
        add(b2);
        
        t1 = new JTable();
        t1.setBounds(0,50,500,300);
        add(t1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,700,550);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == b1)
       {
           try{
           
               conn c = new conn();
               String str = "select * from department;";
               
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
        new Department().setVisible(true);
    }
    
}
