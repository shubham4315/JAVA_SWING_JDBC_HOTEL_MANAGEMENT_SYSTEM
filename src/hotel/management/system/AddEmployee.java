package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField t1,t2 ,t3,t4,t5;
    JRadioButton r1,r2;
    JComboBox box;
    JButton but;
    
    AddEmployee()
    {
        JLabel name = new JLabel("NAME");
        JLabel age = new JLabel("AGE");
        JLabel salary = new JLabel("SALARY"); 
        JLabel phone =  new JLabel("PHONE");
        JLabel email = new JLabel("EMAIL");
        JLabel gender = new JLabel("GENDER");
        JLabel job = new JLabel ("JOB");
        name.setBounds(60,30,120,30);
        age.setBounds(60,80,120,30);
        salary.setBounds(60,230,120,30);
        phone.setBounds(60,280,120,25);
        email.setBounds(60,330,120,25);
        gender.setBounds(60,130,120,30);
        job.setBounds(60,180,120,30);
        name.setFont(new Font("serif" , Font.BOLD , 16));
        age.setFont(new Font("serif" , Font.BOLD , 16));
        gender.setFont(new Font("serif" , Font.BOLD , 16));
        job.setFont(new Font("serif" , Font.BOLD , 16));
        salary.setFont(new Font("serif" , Font.BOLD , 16));
        phone.setFont(new Font("serif" , Font.BOLD , 16));
        email.setFont(new Font("serif" , Font.BOLD , 16));
        t1 = new JTextField();
        t1.setBounds(200,25,150,30);
        add(t1);
        t2 = new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);
        t3 = new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);
        t4 = new JTextField();
        t4.setBounds(200,280,150,30);
        add(t4);
        t5 = new JTextField();
        t5.setBounds(200,330,150,30);
        
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");        
        r1.setFont(new Font("serif" , Font.BOLD , 16));
        r2.setFont(new Font("serif" , Font.BOLD , 16));        
        r1.setBounds(200,130,70,30);
        r2.setBounds(280,130,110,30);
        add(r1);
        r1.setBackground(Color.WHITE);
        add(r2);
        r2.setBackground(Color.WHITE);
        String jobs[] = {"Front Desk Clerk","Housekeeping","Kitchen staff","Room staff","Waiter/Waitress","Manager","Accountant","Chef"};
        box = new JComboBox(jobs);
        box.setBounds(200,180,150,30);
        box.setBackground(Color.WHITE);
        add(box);
        
        but = new JButton("Submit");
        but.setBackground(Color.BLACK);
        but.setForeground(Color.WHITE);
        but.setBounds(200,430,150,30);
        but.addActionListener(this);
        add(but);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 650, Image.SCALE_DEFAULT);
        JLabel l1 = new JLabel(new ImageIcon(i2));
        l1.setBounds(400,-60,450,550);
        add(l1);
        add(t5);
        add(age);
        add(gender);
        add(job);
        add(name);
        add(age);
        add(salary);
        add(phone);
        add(email);
        
        JLabel lab = new JLabel("ADD EMPLOYEE DETAILS");
        lab.setForeground(Color.BLUE);
        lab.setBounds(40,285,400,400);
        lab.setFont(new Font("serif", Font.BOLD , 30) );
        l1.add(lab);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(540,200,900,550);
        setVisible(true);
    
    }
    
    public static void main(String[] args)
    {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String email = t5.getText();        
        String gender = null;
        if(r1.isSelected())
            gender = "Male";
        else if(r2.isSelected())
            gender = "Female";
        String job_description = (String)box.getSelectedItem();
        String query = "insert into Employee values ('" + name +"' , '" + age + "' , '" + gender + "' , '" + job_description +"' , '"+salary+"','" + phone + "' , '" + email + "' ) ;" ;
        conn c = new conn();
        
        try{
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null , "New Employee Added");
            this.setVisible(false);
            
        }catch(Exception E)
        {
            E.printStackTrace();
        }
    }
}
