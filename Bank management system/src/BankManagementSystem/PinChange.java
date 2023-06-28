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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener{//10

	JPasswordField pin,repin;
	JButton change,back;
	String pinumber;
	public PinChange(String pinnumber) {
		this.pinumber=pinnumber;
		
		setLayout(null);
		 
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,700);
		add(image);
		
		
		JLabel text=new JLabel("CHANGE YOUR PIN");
		text.setBounds(240,200,500,30);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.white);
        image.add(text);
		
        
        JLabel pintext=new JLabel("New PIN:");
        pintext.setBounds(180,240,180,25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.white);
        image.add(pintext);
        
        
         pin=new JPasswordField();
		 pin.setFont(new Font("Raleway",Font.BOLD,25));
		 pin.setBounds(330,240,180,25);
		image.add(pin);
        
		
		
		
        JLabel repintext=new JLabel("Re-Enter New PIN:");
        repintext.setBounds(165,280,180,25);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setForeground(Color.white);
        image.add(repintext);
        
        
         repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,280,180,25);
		image.add(repin);
       
		 change= new JButton("Change");
		change.setBounds(355,385,150,30);
		change.setBackground(Color.white);
		change.addActionListener(this);
		image.add(change);
        
		
		back= new JButton("Back");
		back.setBounds(355,418,150,30);
		back.setBackground(Color.white);
		back.addActionListener(this);
		image.add(back);
		
		
        
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);//full screen show use
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()== change) {
			
		
		try {
			
			String npin=pin.getText();
			String rpin=repin.getText();
			
			if (!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null,"Entered Pin Dosent Match");
				return;
			}
		
			if (npin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please Enter New PIN");
				return;
			}
			
			if (rpin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");
				return;
			}
			
			Conn conn=new Conn();
			
			String query1="Update bank set pin='"+rpin+"'where pin ='"+ pinumber+"'";
			String query2="Update login set pin='"+rpin+"'where pin ='"+ pinumber+"'";
			String query3="Update signupthree set pin='"+rpin+"'where pin ='"+ pinumber+"'";
		conn.s.executeUpdate(query1);
		conn.s.executeUpdate(query2);
		conn.s.executeUpdate(query3);
		
		JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
		
		setVisible(false);
		new Login().setVisible(true);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		}else {
			setVisible(false);
			new Transactions(pinumber).setVisible(true);
		}
	}
	
	
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}
}
