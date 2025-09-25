package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();

    int number = ran.nextInt(999999);
    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid;

    JDateChooser tdob;

    JButton add, back;
    JComboBox Boxeducation;

    AddEmployee() {

        getContentPane().setBackground(new Color(163, 255, 188));
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(220, 20, 550, 50);
        heading.setFont(new Font("serif", Font.BOLD, 43));
        add(heading);

        //labels for text field
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        //textfield
        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        JLabel fname = new JLabel("Father's Name ");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth ");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);
        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setBackground(new Color(177, 252, 197));
        add(tdob);

        JLabel salary = new JLabel("Salary ");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        JLabel adress = new JLabel("Address ");
        adress.setBounds(50, 250, 150, 30);
        adress.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(adress);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel phoneno = new JLabel("Phone Number ");
        phoneno.setBounds(400, 250, 150, 30);
        phoneno.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phoneno);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        JLabel mail = new JLabel("E-mail ");
        mail.setBounds(50, 300, 150, 30);
        mail.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(mail);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        JLabel edu = new JLabel("Highest Education ");
        edu.setBounds(400, 300, 150, 30);
        edu.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(edu);

        String items[] = {"B.B.A", "B.C.A", "B.Sc.", " M.B.A.", "B.com", "M.Com.", "M.C.A.", "M.Sc.", "PHD", "B.A.", "M.A.", "M.Tech", "B.Phar.", "D.Phar."};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177, 252, 197));
        Boxeducation.setBounds(600, 300, 150, 30);
        add(Boxeducation);

        JLabel aadhar = new JLabel("Aadhar Number ");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(177, 252, 197));
        add(taadhar);

        JLabel empid = new JLabel("Employee Id ");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel("" + number);
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);


        JLabel des = new JLabel("Designation ");
        des.setBounds(50, 350, 150, 30);
        des.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(des);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        add = new JButton("ADD");
        add.setBounds(450, 500, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(250, 500, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setSize(1000, 590);
        setLocation(200, 50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String adress = taddress.getText();
            String phoneno = tphone.getText();
            String mail = temail.getText();
            String edu = (String) Boxeducation.getSelectedItem();
            String des = tdesignation.getText();
            String aadhar = taadhar.getText();
            String empid = tempid.getText();

            try {
                conn c = new conn();
                String query = " insert into employee values('" + name + "','" + fname + "','" + dob + "','" + salary + "', '" + adress + "','" +phoneno+"','" + mail + "', '" + edu + "', '" + des + "', '" + aadhar + "','" + empid + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main_class();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new Main_class();
        }
    }

        public static void main (String[]args){
            new AddEmployee();
        }
    }