package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{

	JButton back;
	String pinnumber;
	
	public BalanceEnquiry(String pinchange) {
		
		this.pinnumber=pinchange;
        setLayout(null);//first setLayout null then work SetBounds
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,700);
		add(image);
		 
		back=new JButton("Back");
		back.setBounds(355,418,150,30);
		back.addActionListener(this);
        image.add(back);
		
        
        Conn c=new Conn();
        int balance=0;
		try {
			ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin='" + pinnumber + "'");//Balnce Enquiry

			
			
			while (rs.next()) {
				
				if (rs.getString("type").equals("Deposit")) {
					
					balance += Integer.parseInt(rs.getString("amount"));//Integer.parseInt use string to int conver

				}else {
				
			     	balance -= Integer.parseInt(rs.getString("amount"));//balance -= Integer.parseInt(rs.getString(amount))
				}
			}
			}catch (Exception e) {
				System.out.println(e);
			}

         JLabel text=new JLabel("Your Current Account Balance is Rs "+ balance);
         text.setBounds(163,190,600,30);
 		 text.setFont(new Font("System",Font.BOLD,16));
 		 text.setForeground(Color.white);
         image.add(text);
         
         
        
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("pinnumber");
	}
	
}
