package BankManagementSystem;

import java.awt.event.*;

import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;

public class signupOne extends JFrame implements ActionListener {
	
	long random;
	JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
	JButton next;
	JRadioButton male,female,other,married,unmarried;
	JDateChooser dateChooser;
	
	
	public signupOne() {
		
		setLayout(null);
		
		Random ran=new Random();//random number 
		long random=Math.abs((ran.nextLong() % 9000L) + 1000l);//random number print and size
		
		JLabel formno=new JLabel("APPLICATION FORM NO."+ random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		
		JLabel personDetails=new JLabel("Page 1:Personal Details");
		personDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personDetails.setBounds(290,80,400,30);
		add(personDetails);
		
		
		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		
		 nameTextField=new JTextField();
		nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		
		JLabel fname=new JLabel("Father Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		
		 fnameTextField=new JTextField();
		fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		

		JLabel dob=new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		 dateChooser=new  JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		
		JLabel gender=new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		 male= new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.white);
		add(male);
		
		
		
		
		 female= new JRadioButton("Female");
        female.setBounds(450,290,120,30);
    	female.setBackground(Color.white);
		add(female);
		
		ButtonGroup genderGroup =new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		JLabel email=new JLabel("Email Address:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,340,200,30);
		add(email);
		
		
		

		 emailTextField=new JTextField();
		emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
		
		
		JLabel marital=new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		
		 married= new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.white);
		add(married);
		
		
		 unmarried= new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		 other= new JRadioButton("Other");
		other.setBounds(630,390,100,30);
		other.setBackground(Color.white);
		add(other);
		
		ButtonGroup Maritalgroup =new ButtonGroup();
		Maritalgroup.add(married);
		Maritalgroup.add(unmarried);
		Maritalgroup.add(other);
		
		
		
		JLabel address=new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		
		 addressTextField=new JTextField();
		addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		
		

		JLabel city=new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		

		 cityTextField=new JTextField();
		cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		
		JLabel state=new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
		

		 stateTextField=new JTextField();
		stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
		
		JLabel pincode=new JLabel("Pin Code:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		
		 pinTextField=new JTextField();
		pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
		pinTextField.setBounds(300,590,400,30);
		add(pinTextField);
		
		
		 next=new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,640,80,30);
		next.addActionListener(this);
		add(next);
		
		
		
		getContentPane().setBackground(Color.white);
		
		setSize(850,800);//   frame size
		setLocation(350,10);//frame location
		setVisible(true);//frame visible
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formno=""+random;//long(""+)use to convert long to string
		String name=nameTextField.getText();//get text se value le sakte he
		String fname=fnameTextField.getText();
		String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if (male.isSelected()) {
			gender="male";
		} else if (female.isSelected()){
            gender="female";
		}
	    String email=emailTextField.getText();
	    String marital=null;
	    if (married.isSelected()) {
			marital="married";
		}else if (unmarried.isSelected()) {
			marital="unmarried";
		}else if (other.isSelected()) {
			marital="other";
		}
	    
	    
	    
	    String address=addressTextField.getText();
	    String city=cityTextField.getText();
	    String state=stateTextField.getText();
	    String pin=pinTextField.getText();
	    
	    
	    
	    
	    try {
			
	    	if (name.equals("")) {
				JOptionPane.showMessageDialog(null,"name is Required");//this type all thigs is use for if you dont pass data
				//then showing message
			}else  {
				
				Conn c=new Conn();
				String query = "INSERT INTO signup VALUES ('" + formno + "', '" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";

				//String query="insert into signup values('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"''"+state+"')";              
				c.s.executeUpdate(query);
				setVisible(false);
				new signupTwo(formno).setVisible(true);
			}
	    	
	    	if (fname.equals("")) {
				JOptionPane.showMessageDialog(null,"Father name is Required");
			}
	    	
	    	if (dob.equals("")) {
				JOptionPane.showMessageDialog(null,"date of Birth is Required");
			}
	    	
	    	if (gender.equals("")) {
				JOptionPane.showMessageDialog(null,"Choose the Gender");
			}
	    	if (email.equals("")) {
				JOptionPane.showMessageDialog(null,"Email is Required");
			}
	    	
	    	if (marital.equals("")) {
				JOptionPane.showMessageDialog(null,"Marital is Required");
			}
	    	
	    	if (address.equals("")) {
				JOptionPane.showMessageDialog(null,"Address is Required");
			}
	    	
	    	if (city.equals("")) {
				JOptionPane.showMessageDialog(null,"City is Required");
			}
	    	
	    	if (state.equals("")) {
				JOptionPane.showMessageDialog(null,"State is Required");
			}
	    	
	    	if (pin.equals("")) {
				JOptionPane.showMessageDialog(null,"Pin is Required");
			}
	    	
		} catch (Exception e) {
			System.out.println(e);
		}
	    
	    
		
	}
	
	public static void main(String[] args) {
		new signupOne();
	}

}
