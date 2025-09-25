package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice choiceEMPID;
    JButton delete , back;
    RemoveEmployee(){

        JLabel label = new JLabel("Employee Id");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma ",Font.BOLD,15));
        add(label);

        //drop down
        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,56,150,30);
        add(choiceEMPID);
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMPID.add(resultSet.getString("empid"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,100,30);
        labelName.setFont(new Font("Tahoma ",Font.BOLD,15));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,100,30);
        add(textName);


        JLabel phoneno = new JLabel("Phone");
        phoneno.setBounds(50,150,100,30);
        phoneno.setFont(new Font("Tahoma ",Font.BOLD,15));
        add(phoneno);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200,150,100,30);
        add(textPhone);

        JLabel mail = new JLabel("Email");
        mail.setBounds(50,200,100,30);
        mail.setFont(new Font("Tahoma ",Font.BOLD,15));
        add(mail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,100,30);
        add(textEmail);


        try {
            conn c = new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from employee where empid = '"+choiceEMPID.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textEmail.setText(resultSet.getString("mail"));
                textPhone.setText(resultSet.getString("phoneno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    ResultSet resultSet= c.statement.executeQuery("select * from employee where empid = '"+choiceEMPID.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textEmail.setText(resultSet.getString("mail"));
                        textPhone.setText(resultSet.getString("phoneno"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);


        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Delete_icon.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(590,80,290,160);
        img.setOpaque(false);
        add(img);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Icons/bbackward.jpg"));
        Image i22 = i11.getImage().getScaledInstance(990,590,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,990,590);
        add(image);


        setSize(920,450);
        setLocation(270,100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== delete){
            try {
                conn c = new conn();
                String  query = "delete from employee where empid = '"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Deleted Successfullu");
                setVisible(false);
                new Main_class();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
