package BankManagementSystem;
import java.awt.Color;
import java.sql.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

public class Login extends JFrame implements ActionListener{//75040936003810699

	
	JButton login,signup,clear;//Global defined because access outside of constructed
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	public Login() {   //1st
		setTitle("AUTOMATED TELLER MACHINE ");
		setLayout(null);
		
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/logo.jpg"));
			Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel label=new JLabel(i3);
		   label.setBounds(70,10,100,100);//icon moveing
		add(label);
		
		JLabel text=new JLabel("Wlcome to Atm");

		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		
		JLabel cardno=new JLabel("card No:");

		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		cardno.setBounds(120,150,150,40);
		add(cardno);
		
		
		 cardTextField=new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font( "Arial",Font.BOLD,14));//inside text box size of text
		add(cardTextField);
		
		JLabel pin=new JLabel("PIN:");

		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(120,220,250,30);
		add(pin);
		
		 pinTextField=new JPasswordField();
		pinTextField.setBounds(300,220,230,30);
		pinTextField.setFont(new Font( "Arial",Font.BOLD,14));//inside text box size of text

		add(pinTextField);
		
		
		 login=new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		
		 clear=new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		
		 signup=new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		
		
		getContentPane().setBackground(Color.white);//Panel Color
		
		
		
		setSize(750,450);
		setVisible(true);
		setLocation(350,180);
	}
	
	// button code //1st stage
	
	public  void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}else if(ae.getSource() == login) {
			
			Conn conn=new Conn();
			String cardnumber=cardTextField.getText();
			String pinnumber=pinTextField.getText();
			
			//String query="select * from login where cardnumber="'"+cardnumber+"'and pin='"+pinnumber+"'";
			String query = "SELECT * FROM login WHERE cardnumber='" + cardnumber + "' AND pin='" + pinnumber + "'";
                  
			try {
				ResultSet rs=  conn.s.executeQuery(query);
				
				if (rs.next()) {
					setVisible(false);//login frmae close
					new Transactions(pinnumber).setVisible(true);//opening new transaction frame
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect card Number or Pin");
				}
				
			} catch (Exception e) {
				 System.out.println(e);
			}
			
			
			
		}else if(ae.getSource() == signup) {
			setVisible(false);//Screen off 
			new signupOne().setVisible(true);//oppen singnup windo
			
		}
		
	}
	
	
public static void main(String[] args) {
	new Login();//2nd
}
}
