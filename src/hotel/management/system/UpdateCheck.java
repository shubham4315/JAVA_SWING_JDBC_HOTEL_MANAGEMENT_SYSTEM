package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class UpdateCheck extends JFrame implements ActionListener {

    
    JButton b1,b2,b3;
    Choice ch;
    JTextField t1,t2,t3,t4,t5;
    
    UpdateCheck()
    {
       JLabel l1 = new JLabel("Check-In Details");
       l1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
       l1.setForeground(Color.BLUE);
       l1.setBounds(90,20,200,30);
       add(l1);
       
       JLabel l2 = new JLabel("Customer-ID");
       l2.setBounds(30,80,100,20);
       add(l2);
       
       ch = new Choice();
       try{
           conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from customer");
           while(rs.next())
           {
               ch.add(rs.getString("number"));
           }
       }catch(Exception ae)
       {
           ae.printStackTrace();
       }
       ch.setBounds(200,80,150,25);
       add(ch);
       
       JLabel l3 = new JLabel("Room Number");
       l3.setBounds(30,120,100,20);
       add(l3);
       
       t1 = new JTextField();
       t1.setBounds(200,120,150,25);
       add(t1);
       
       
       JLabel l4 = new JLabel("Name");
       l4.setBounds(30,160,100,20);
       add(l4);
       
       t2 = new JTextField();
       t2.setBounds(200,160,150,25);
       add(t2);
       
       
       JLabel l5 = new JLabel("Check-IN");
       l5.setBounds(30,200,100,20);
       add(l5);
       
       t3 = new JTextField();
       t3.setBounds(200,200,150,25);
       add(t3);
       
       JLabel l6 = new JLabel("Amount Paid");
       l6.setBounds(30,240,100,20);
       add(l6);
       
       t4 = new JTextField();
       t4.setBounds(200,240,150,25);
       add(t4);
       
       
       JLabel l7 = new JLabel("Pending Amount");
       l7.setBounds(30,280,100,20);
       add(l7);
       
       t5 = new JTextField();
       t5.setBounds(200,280,150,25);
       add(t5);
       
       b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(140,340,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(40,390,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(220,390,120,30);
        b3.addActionListener(this);
        add(b3);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        JLabel l9 =  new JLabel(i1);
        l9.setBounds(400,50,500,300);
        add(l9);
        
       setLayout(null);
       setBounds(500,180,920,500);
       setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource() == b1)
        {
            
            try
            {
                conn c = new conn();
                String room = null;
                String deposit = null;
                Integer amountPaid = 0;
                String price = null;
                String id = ch.getSelectedItem();
                String str = "select * from customer where number = '"+id+"' ;";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next())
                {
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    room = rs.getString("room");
                    deposit = rs.getString("deposit");
                    System.out.println("Room is " + room + "Deposit is " + deposit);
                }
                ResultSet rs1 = c.s.executeQuery("select * from room where num = '"+room+"';");
                while(rs1.next())
                {
                    price = rs1.getString("price");
                    amountPaid = (Integer.parseInt(price) - Integer.parseInt(deposit));
                   
                    t5.setText(Integer.toString(amountPaid));
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
    
    public static void main(String args[])
    {
        new UpdateCheck().setVisible(true);
    }
    
    
    
}
