package hotel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddRooms extends JFrame implements ActionListener{

    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    JComboBox box1,box2,box3;
    
    
    AddRooms()
    {
        JLabel Add = new JLabel("ADD ROOMS");
        Add.setBounds(150 , 20 , 150 , 20 );
        Add.setFont(new Font("Tahona" , Font.BOLD , 18));
        add(Add);
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(60 , 80 , 120 , 30 );
        room.setFont(new Font("Tahona" , Font.PLAIN , 16));
        add(room);
        
        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);
        
        JLabel available = new JLabel("Available");
        available.setBounds(60 , 130 , 120 , 30 );
        available.setFont(new Font("Tahona" , Font.PLAIN , 16));
        add(available);
        
        box1 = new JComboBox(new String[]{"Available" , "Occupied"});
        box1.setBounds(200,130,150,30);
        box1.setBackground(Color.WHITE);
        add(box1);
        
        JLabel status = new JLabel("Cleaning Status");
        status.setBounds(60 , 180 , 120 , 30 );
        status.setFont(new Font("Tahona" , Font.PLAIN , 16));
        add(status);
        
        box2 = new JComboBox(new String[]{"Clean" , "Dirty"});
        box2.setBounds(200,180,150,30);
        box2.setBackground(Color.WHITE);
        add(box2);
        
        box3 = new JComboBox(new String[]{"Single Bed" , "Double Bed"});
        box3.setBounds(200,280,150,30);
        box3.setBackground(Color.WHITE);
        add(box3);
        
        JLabel price = new JLabel("Price");
        price.setBounds(60 , 230 , 120 , 30 );
        price.setFont(new Font("Tahona" , Font.PLAIN , 16));
        add(price);
        
        t2 = new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);
        
        JLabel type = new JLabel("Bed Type");
        type.setBounds(60 , 280 , 120 , 30 );
        type.setFont(new Font("Tahona" , Font.PLAIN , 16));
        add(type);
        
        
        b1 = new JButton("Add Room");
        b1.setBounds(60,350 , 130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("Cancel");
        b2.setBounds(220,350 , 130,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(this);
        
        getContentPane().setForeground(Color.WHITE);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        JLabel l1 = new JLabel(img);
        l1.setBounds(400,30,500,350);
        add(l1);
        
        setLayout(null);
        setBounds(500,200,950,470);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
    
        new AddRooms();
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        if(e.getSource() == b1)
        {
            String num = t1.getText();
            String available = (String)box1.getSelectedItem();
            String status = (String)box2.getSelectedItem();
            String price = t2.getText();
            String type = (String)box3.getSelectedItem();
            
            conn c = new conn();
            String query = "insert into Room values ('" + num + "','" + available + "','"+status+"','"+price+"','" + type + "' );";
            try{
            
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                this.setVisible(false);
                
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
                
                    
            
        }else if(e.getSource() == b2)
        {
            this.setVisible(false);
        }
            
        
    }
    
}
