package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{

	JTextField amount;
	JButton deposit,back;
	String pinumber;
	
	public Deposit(String pinnumber) {
		
		this.pinumber=pinnumber;
		setLayout(null);//first setLayout null then work SetBounds
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,700);
		add(image);
		
		

		JLabel text=new JLabel("Enter the Amount you want to Deposit");
		text.setBounds(190,200,600,30);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.white);
        image.add(text);
		
        

         amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(190,250,290,24);
       image.add(amount);
        
        deposit=new JButton("Deposit");
       deposit.setBounds(355,385,150,30);
      deposit.addActionListener(this);
       image.add(deposit);
       
       
        back=new JButton("Back");
       back.setBounds(355,418,150,30);
       back.addActionListener(this);
       image.add(back);
       
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource()== deposit) {
			
			String number=amount.getText();
			Date date=new Date();
			
			if (number.equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter the amount you want to Deposit");
			}else {
				try {
				Conn conn=new Conn();
			    String query= "INSERT INTO bank VALUES ('"+pinumber+"','"+date+"', 'Deposit','"+number+"')";
			    conn.s.executeUpdate(query);
			    JOptionPane.showMessageDialog(null, "Rs "+ number+ "Deopsited Successfuly");
			    setVisible(false);
			    new Transactions(number).setVisible(true);//&
				}catch (Exception e) {
					   System.out.println(e);
				}
			}
			
		}else if (ae.getSource()== back) {
			setVisible(false);
			new Transactions(pinumber).setVisible(true);
		}
		
	}
	
	
   public static void main(String[] args) {
	   new Deposit("");
   }
}
