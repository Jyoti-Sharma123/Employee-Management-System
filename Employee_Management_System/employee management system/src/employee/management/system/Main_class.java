package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){   //HOME CLss
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/desk_empl.png"));
        Image i2 = i1.getImage().getScaledInstance(1000,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1000,550);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(257,17,996,36);
        heading.setFont(new Font("Raleway",Font.ITALIC,32));
        heading.setForeground(new Color(255, 223, 0));
        img.add(heading);

        //ADD BUTTON------->
        JButton add = new JButton("Add Employee");
        add.setBounds(220,200,150,40);
        add.setForeground(Color.black);
        add.setBackground(Color.WHITE);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //method for implementing events like click event for a particular task
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        //VIEW EMPLOYEE
        JButton view = new JButton("View Employee");
        view.setBounds(615,200,144,40);
        view.setForeground(Color.black);
        view.setBackground(Color.white);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(420,370,150,40);
        rem.setForeground(Color.black);
        rem.setBackground(Color.white);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        img.add(rem);

        setSize(1000,550);
        setLocation(150,80);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Main_class();
    }
}
