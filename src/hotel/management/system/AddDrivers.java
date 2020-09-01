package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4;
    JComboBox box1, box2;
    JButton b1,b2;
    
    AddDrivers()
    {
        JLabel title = new JLabel("ADD DRIVERS");
        title.setBounds(150,10,150,30);
        title.setFont(new Font("Tahone" , Font.BOLD , 18));
        add(title);
        
        JLabel name = new JLabel("NAME");
        name.setBounds(60,70,100,30);
        name.setFont(new Font("Tahone" , Font.PLAIN , 14));
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);
        
        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahone" , Font.PLAIN , 14));
        age.setBounds(60,110,100,30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200,110,150,30);
        add(t2);
        
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahone" , Font.PLAIN , 14));
        gender.setBounds(60,150,100,30);
        add(gender);
        
        box1 = new JComboBox(new String[]{"Male ", "Female"});
        box1.setBounds(200,150,150,30);
        box1.setBackground(Color.WHITE);
        add(box1);
        
        JLabel car = new JLabel("CAR");
        car.setBounds(60,190,100,30);
        car.setFont(new Font("Tahone" , Font.PLAIN , 14));
        add(car);
        
        t3 = new JTextField();
        t3.setBounds(200,190,150,30);
        add(t3);
        
        JLabel available = new JLabel("AVAILABLE");
        available.setBounds(60,230,100,30);
        available.setFont(new Font("Tahone" , Font.PLAIN , 14));
        add(available);
        
        box2 = new JComboBox(new String[]{"Available", "Busy"});
        box2.setBounds(200,230,150,30);
        box2.setBackground(Color.WHITE);
        add(box2);
        
        JLabel location = new JLabel("LOCATION");
        location.setBounds(60,270,100,30);
        location.setFont(new Font("Tahone" , Font.PLAIN , 14));
        add(location);
        
        t4 = new JTextField();
        t4.setBounds(200,270,150,30);
        add(t4);
        
        b1 = new JButton("Add Driver");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60,370,130,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(215,370,130,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image img = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        JLabel lab = new JLabel(new ImageIcon(img));
        lab.setBounds(400,30,500,400);
        add(lab);
        
        setLayout(null);
        setBounds(400,200,980,500);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new AddDrivers();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == b1)
        {
            conn c = new conn();
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String)box1.getSelectedItem();
            String car = t3.getText();
            String available = (String)box2.getSelectedItem();
            String location = t4.getText();
            try{
                String query = "insert into Driver values ( '"+name+"','"+age+"','"+gender+"','"+car+"','"+available+"','"+location+"');";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                setVisible(false);
            }catch(Exception ae)
            {
                ae.printStackTrace();
            }
            
            
        } else if (e.getSource() == b2)
        {
            setVisible(false);
        }
    }
}
