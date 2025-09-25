package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login(){
        //DISPLAY TEXT--->
        JLabel username = new JLabel("Username");   //makes any text visible on the frame ----> JLable and also for image purpose
        username.setBounds(40,20,100,30);
        add(username);

        //USER FIELD TO FILL THE TEXT BOX---->
        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        //PASSWORD---->
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        //USER FIELD TO FILL THE TEXT BOX---->
        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        //BUTTON (LOGIN)------>
        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        // Back Button---->
        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        // 1st Background (Rnew_new.jpg)
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,350,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350,10,700,500);
        add(imgg);


        // 2nd image (login.jpg) on top of background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300,950,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,400);
        add(img);

        setSize(700, 400);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            try{
                String username =tusername.getText();
                String password = new String(tpassword.getPassword());

                conn conn = new conn();

                //query
                String query = "select * from login where username = '" + username +"' and  password =  '"+password+"'";
                ResultSet resultset = conn.statement.executeQuery(query);
                if(resultset.next()){
                    setVisible(false);
                    new Main_class();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid User Name or Password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == back) {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
       new Login();
    }
}
