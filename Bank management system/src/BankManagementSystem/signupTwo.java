package BankManagementSystem;

import java.awt.event.*;

import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;

public class signupTwo extends JFrame implements ActionListener {
	
	
	JTextField pan,aadhar;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	String formno;
	
	JComboBox religion,category,occupation,education,income; 
	
	public signupTwo(String formno) {
		this.formno=formno;
		setLayout(null);
		
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
				
		JLabel additionalDetails=new JLabel("Page 2:Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		
		JLabel name=new JLabel("Religion:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		String valReligion[]= {"Hindu","Muslim","Sikh","Christian","Other"};
		 religion=new JComboBox(valReligion); 
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.white);
		add(religion);
		
		
		
		
		JLabel fname=new JLabel("Category:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		String valcategory[]= {"General","OBC","sc","st","Other"};
		 category= new JComboBox(valcategory);
		category.setBounds(300,190,400,30);
		category.setBackground(Color.white);
		add(category);
		

		JLabel dob=new JLabel("Income:");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		
		String incomecategory[]= {"Null","<1,50,000","<2,50,50000","<5,00,000","Upto 10,00,000"};
		  income= new JComboBox(incomecategory);
		income.setBounds(300,240,400,30);
		income.setBackground(Color.white);
		add(income);
		
		
		
		JLabel gender=new JLabel("Educational");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,320,200,30);
		add(gender);
		
		
		JLabel email=new JLabel("Qulification:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,340,200,30);
		add(email);
		
		
		String educationValues[]= {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
		 education= new JComboBox(educationValues);
		education.setBounds(300,315,400,30);
		education.setBackground(Color.white);
		add(education);
		

		
		JLabel marital=new JLabel("Occupation:");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,390,200,30);
		add(marital);
		

		String occupationValues[]= {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
		 occupation= new JComboBox(occupationValues);
		occupation.setBounds(300,390,400,30);
		occupation.setBackground(Color.white);
		add(occupation);
		
		
		 syes= new JRadioButton("Yes");
		 syes.setBounds(300,540,100,30);
		 syes.setBackground(Color.white);
		add(syes);
		
		
		 sno= new JRadioButton("No");
		 sno.setBounds(450,540,100,30);
		 sno.setBackground(Color.white);
		add(sno);
		

		
		ButtonGroup Maritalgroup =new ButtonGroup();
		Maritalgroup.add(syes);
		Maritalgroup.add(sno);
		
			
     	JLabel address=new JLabel("PAN Number:");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		
		 pan=new JTextField();
		pan.setFont(new Font("Raleway",Font.BOLD,14));
		pan.setBounds(300,440,400,30);
		add(pan);
		
		
		
     	JLabel address1=new JLabel("Aadhar Number:");
		address1.setFont(new Font("Raleway",Font.BOLD,20));
		address1.setBounds(100,440,300,130);
		add(address1);
		
		
		 aadhar=new JTextField();
		 aadhar.setFont(new Font("Raleway",Font.BOLD,14));
		 aadhar.setBounds(300,490,400,30);
		add(aadhar);
	
		
		
		JLabel state=new JLabel("Senior Citizen:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
//
//		 cityTextField=new JTextField();
//		cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
//		cityTextField.setBounds(300,490,400,30);
//		add(cityTextField);
//		
//		
//		
//
//		 stateTextField=new JTextField();
//		stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
//		stateTextField.setBounds(300,540,400,30);
//		add(stateTextField);
		
		
		JLabel pincode=new JLabel("Existing Account:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		
		eyes= new JRadioButton("Yes");
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.white);
		add(eyes);
		
		
		 eno= new JRadioButton("No");
		 eno.setBounds(450,590,100,30);
		 eno.setBackground(Color.white);
		add(eno);
		

		
		ButtonGroup emaritalgroup =new ButtonGroup();
		emaritalgroup.add(eyes);
		emaritalgroup.add(eno);
		//emaritalgroup.add(other);

		
		
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
		String sreligion=(String)religion.getSelectedItem();
		String scategory=(String)category.getSelectedItem();
		String sincome=(String)income.getSelectedItem();
		String seducation=(String)education.getSelectedItem();
		String soccupation=(String)occupation.getSelectedItem();
		String seniorcitizen=null;
		if (syes.isSelected()) {
			seniorcitizen="Yes";
		} else if (sno.isSelected()){
			seniorcitizen="No";
		}
	    String exisitingaccount=null;
	    if (eyes.isSelected()) {
	    	exisitingaccount="Yes";
		}else if (eno.isSelected()) {
			exisitingaccount="No";
		
	    
	    
	    String span=pan.getText();
	    String saadhar=aadhar.getText();
	    
	    
	    
	    
	    try {		
    			Conn c=new Conn();
				//String query = "INSERT INTO signuptwo VALUES ('" + formno + "', '" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" +soccupation + "','" + span + "','" + saadhar + "','" + seniorcitizen + "','" +exisitingaccount  + "',')";
    			String query = "INSERT INTO signuptwo VALUES ('" + formno + "', '" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + seniorcitizen + "','" + exisitingaccount  + "')";

				c.s.executeUpdate(query);
				//singnupThree Object
				setVisible(false);
				new signupThree(formno).setVisible(true);
				
			}	    	
		 catch (Exception e) {
			System.out.println(e);
		 }
	    
	    
		}	
	}
	
	public static void main(String[] args) {
		new signupTwo("");
	}

}