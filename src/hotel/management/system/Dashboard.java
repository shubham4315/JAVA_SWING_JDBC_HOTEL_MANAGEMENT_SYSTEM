package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    
    Dashboard(){
        
        mb = new JMenuBar();
        add(mb);
        m1 = new JMenu("HOTEL MANAGEMENT");
        mb.add(m1);
        m2 = new JMenu("ADMIN");
        mb.add(m2);
        
        i1 = new JMenuItem("FRONT DESK");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3 = new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4 = new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);
        
        mb.setBounds(0,0,1950,30);
        m1.setForeground(Color.RED);
        m2.setForeground(Color.BLUE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/hotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1300, Image.SCALE_DEFAULT);
     
        JLabel l1 = new JLabel(new ImageIcon(i2));
        l1.setBounds(0,-200,1950,1300);
        add(l1);
        
        
        
        setLayout(null);
        setBounds(-6,-4,2000,1100 );
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Dashboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("FRONT DESK"))
        {
           // System.out.println("Reception pe click huaa");
            new Reception().setVisible(true);
        }
        else if(e.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee().setVisible(true);
        }
        else if(e.getActionCommand().equals("ADD ROOMS"))
        {
             new AddRooms().setVisible(true);
        }   
        else if(e.getActionCommand().equals("ADD DRIVERS"))
        {
            //System.out.println("Drivers pe click huaa");
            new AddDrivers().setVisible(true);
        }
            
    }
}
