package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice ch;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;
    
    UpdateRoom(){
        
        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("tahoma" , Font.PLAIN , 20));
        l1.setBounds(30,20,250,30);
        l1.setForeground(Color.BLUE);
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);
        
        JLabel l2 = new JLabel("Guest ID");
        l2.setBounds(30,80,120,20);
        add(l2);
        
        t2 = new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,120,20);
        add(l3);
        
        
        JLabel l4 = new JLabel("Availability");
        l4.setBounds(30,180,120,20);
        add(l4);
        
        JLabel l5 = new JLabel("Status");
        l5.setBounds(30,230,120,20);
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);
        
        
        ch = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ch.add(rs.getString("number"));
            }
            
        }
        catch(Exception ae)
        {
            ae.printStackTrace();
        }
        ch.setBounds(200,80,150,25);
        add(ch);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(140,300,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(40,350,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(220,350,120,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);        
        JLabel l6 = new JLabel(new ImageIcon(i2));
        l6.setBounds(400,10,500,400);
        add(l6);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,980,450);
        setVisible(true);
                
    }
    
    public static void main(String args[])
    {
        new UpdateRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
            String s1 = ch.getSelectedItem();
            String room = null;
            try
            {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+s1+"' ;");
                while(rs.next())
                {
                    t1.setText(rs.getString("room"));
                    room = rs.getString("room");
                }
                ResultSet rs1 = c.s.executeQuery("select * from room where num = '"+room+"' ;");
                while(rs1.next())
                {
                    t2.setText(rs1.getString("available"));
                    t3.setText(rs1.getString("status"));
                }
                
            
            }catch(Exception ae)
            {
                ae.printStackTrace();
            }
        
        }else if(e.getSource() == b2)
        {
        
            try{
                conn c = new conn();
                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();
                String q1 = "update room set available = '"+available+"', status = '"+status+"' where num = '"+room+"' ;";
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Updated Successfully");
                
                
            }catch(Exception ae)
            {
                ae.printStackTrace();
            }
            
            
        }else if(e.getSource() == b3)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
}
