package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
   
    
    JPanel jPanel1;
    JLabel jLabel1;
    
    HotelManagementSystem()
    {
        
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setBackground(new java.awt.Color(153,153,153));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setBounds(890,450,70,70);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/system/icons/home.png"))); // NOI18N
        add(jPanel1);
        
        jPanel1.add(jLabel1);
        
        
      setBounds(300,200,1366,565);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/start_page.jpg"));
      Image img = i1.getImage().getScaledInstance(1360, 560, Image.SCALE_SMOOTH);
      JLabel l1 = new JLabel(new ImageIcon(img));
      l1.setBounds(0,0, 1366,565);
      add(l1);
      setLayout(null);
      JButton b1 = new JButton("NEXT PAGE");
      b1.setBounds(850, 470, 120, 40);
      b1.setBackground(Color.WHITE);
      b1.setForeground(Color.BLACK);
      b1.addActionListener(this);
      
      
      JLabel l2 = new JLabel("Hotel Management System");
      l2.setBounds(250,450,1000,70);
      l2.setForeground(Color.WHITE);
      l2.setFont(new Font("serif" , Font.BOLD , 50));
      l1.add(l2);
      setVisible(true);
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.setVisible(false);
    }                                    

    

    @Override
    public void actionPerformed(ActionEvent e) {
        new Login().setVisible(true);
        this.setVisible(false);
    }
    
    
}
