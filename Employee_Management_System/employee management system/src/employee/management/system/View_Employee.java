package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class View_Employee extends JFrame implements ActionListener {
    JTable table;
    Choice choice_emp;
    JButton searchbtn , print, update, back;

    View_Employee(){
        getContentPane().setBackground(new Color(255,131,122));
        JLabel search = new JLabel("Search by Employee ID:");
        search.setBounds(20,20,150,20);
        add(search);

        //Drop down
        choice_emp = new Choice();
        choice_emp.setBounds(180,20,150,20);
        add(choice_emp);


        //try and catch
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choice_emp.add(resultSet.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        //try and catch
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee ");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);

        setSize(900,530);
        setLayout(null);
        setLocation(200,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn){
            String query = " Select * from employee where empid = '"+choice_emp.getSelectedItem()+"'";
            try {
                conn c = new conn();
                ResultSet resultSet = c. statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print ) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()== update) {
            setVisible(false);
            new UpdateEmployee(choice_emp.getSelectedItem());

        }else {
            setVisible(false);
            new Main_class();
        }

    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
