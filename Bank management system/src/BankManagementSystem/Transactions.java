package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

	
	JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
	String pinnumber;
	public Transactions(String pinnumber) {
		this.pinnumber=pinnumber;
		setLayout(null);
		 
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,700);
		add(image);
		
		
		JLabel text=new JLabel("Please Select your Transaction");
		text.setBounds(210,200,600,30);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.white);
        image.add(text);
		
        
         deposit=new JButton("Deposit");
        deposit.setBounds(170,315,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl=new JButton("Cash withdrawl");
        withdrawl.setBounds(355,315,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
       
         fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,350,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        

         ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,350,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
       
         pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,385,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
		

         balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,385,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
         exit=new JButton("Exit");
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
			System.exit(0);
		}else if (ae.getSource()==deposit) {//Deposit class 
			setVisible(false);//Trnascation class close
			new Deposit(pinnumber).setVisible(true);// Deposit Class Open
		}else if (ae.getSource()==withdrawl) {
				setVisible(false);
				new Withdrawl(pinnumber).setVisible(true);  
				
		}else if (ae.getSource() == fastcash) {//starting new clsss opening
			
			setVisible(false);//close clss
			new FastCash(pinnumber).setVisible(true);//opent Fast class 
		}else if (ae.getSource()== pinchange) {
			
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}else if (ae.getSource()== balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}else if (ae.getSource() == ministatement) {
			new MiniStatement(pinnumber).setVisible(true);
		}
		 
	}
	
	
	public static void main(String[] args) {
		new Transactions("");
		
	}
}
