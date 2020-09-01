
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Checkout extends JFrame  implements ActionListener{
    
    
    Choice ch;
    JTextField t1;
    JButton b1,b2,b3;
    
    Checkout()
    {
        JLabel l1 = new JLabel("Check Out");
        l1.setBounds(30,20,100,30);
        l1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        l1.setForeground(Color.BLUE);
        add(l1);
        
        JLabel l2 = new JLabel("Customer Id");
        l2.setBounds(30,80,100,30);
        add(l2);
        
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);
        
        ch = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                ch.add(rs.getString("number"));
            }
        }
        catch(Exception ae)
        {
            ae.printStackTrace();
        }
        ch.setBounds(140,85,150,30);
        add(ch);
        
        b1= new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,200,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2= new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(170,200,120,30);
        b2.addActionListener(this);
        add(b2);
        
        t1 = new JTextField();
        t1.setBounds(140,130,150,25);
        add(t1);
        
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image img = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        b3 = new JButton(new ImageIcon(img));
        b3.setBounds(310,85,20,20);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(350,0,400,250);
        add(l4);
        
        setLayout(null);
        setBounds(500,200,800,300);
        setVisible(true);
    }
    
    
    public static void main(String[] args)
    {
        new Checkout().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == b1)
        {
            
            try
            {
                String id = ch.getSelectedItem();
                String room = t1.getText();
                String str = "delete from customer where number = '" + room +"' ;";
                String str2 = "update room set available = 'Available' where num = '"+room+"';" ;
                conn c = new conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null , "Checkout Successfull!");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception ae)
            {
                ae.printStackTrace();
            }
        
        }else if(e.getSource() == b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == b3)
        {
            try
            {
                conn c = new conn();
                String id = ch.getSelectedItem();
                ResultSet rs = c.s.executeQuery("select * from customer where number = '" +id+"';");
                while(rs.next())
                {
                    t1.setText(rs.getString("room"));
                }
            }catch(Exception ae)
            {
                ae.printStackTrace();
            }
            
        }
    
    }
    
}
