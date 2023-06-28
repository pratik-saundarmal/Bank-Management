package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.Date;
import java.sql.ResultSet;

import javax.swing.*;
import javax.xml.crypto.Data;

import com.mysql.cj.xdevapi.Result;

public class FastCash extends JFrame implements ActionListener {//9

	
	JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
	String pinnumber;
	public FastCash(String pinnumber) {
		this.pinnumber=pinnumber;
		setLayout(null);
		 
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,700);
		add(image);
		
		
		JLabel text=new JLabel("Select Withdrawl Amount");
		text.setBounds(210,200,600,30);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.white);
        image.add(text);
		
        
         deposit=new JButton("Rs 100");
        deposit.setBounds(170,315,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(355,315,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
       
         fastcash=new JButton("Rs 1000");
        fastcash.setBounds(170,350,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        

         ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,350,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
       
         pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,385,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
		

         balanceenquiry=new JButton("Rs 10000");
        balanceenquiry.setBounds(355,385,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
         exit=new JButton("Back");
        exit.setBounds(355,418,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);//full screen show use
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource()==exit) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}else  {//Deposit class if (ae.getSource()==deposit)
			String amount=((JButton)ae.getSource()).getText().substring(3);
			//Jis Butoon Pe Click karoge uska text milega use substring(3) you can remove Rs and space
			
			Conn c=new Conn();
			try {
				ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin='" + pinnumber + "'");//Balnce Enquiry

				
				int balance=0;
				while (rs.next()) {
					
					if (rs.getString("type").equals("Deposit")) {
						//balance += Integer.parseInt(rs.getString(amount));//Integer.parseInt use string to int conver
						balance += Integer.parseInt(rs.getString("amount"));

					}else {
						//balance -= Integer.parseInt(rs.getString(amount));
						balance -= Integer.parseInt(rs.getString("amount"));
					}
			  
				}
				
				if (ae.getSource() != exit && balance< Integer.parseInt(amount)){
					
					JOptionPane.showMessageDialog(null,"Insufficient Blance");
					return;
				}
				Date date=new Date();
				String query = "INSERT INTO bank VALUES ('" + pinnumber + "', '" + date + "', 'withdrawl', '"+amount+"')";
				
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited sucessfuly");
				
				setVisible(false);
                new Transactions(pinnumber).setVisible(true);				
				
			} catch (Exception e) {
				System.out.println(e);
			} 
		}
		 
	}
	
	
	public static void main(String[] args) {
		new FastCash("");
		
	}
}
