package bil344_hw;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
	private String customer_name;
	private String contact_phone;
	private int age;
	
	
	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


	public String getContact_phone() {
		return contact_phone;
	}


	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	private JLabel enterInfo, nameLabel, ageLabel, phoneLabel;
	private JTextField nameField, ageField, phoneField;
	private JButton confirmInfo;
	
	public AddCustomer() {
		enterInfo = new JLabel("Please enter customer information:");
		nameLabel = new JLabel("Name:");
		nameField = new JTextField(20);
		ageLabel = new JLabel("Age:");
		ageField = new JTextField(2);
		phoneLabel = new JLabel("Phone number:");
		phoneField = new JTextField(10);
		confirmInfo = new JButton("Confirm");
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		Color co = new Color(71, 235, 233);
		c.setBackground(co);
		
		enterInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
		ageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ageField.setAlignmentX(Component.CENTER_ALIGNMENT);
		phoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		phoneField.setAlignmentX(Component.CENTER_ALIGNMENT);
		confirmInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		c.add(enterInfo);
		c.add(nameLabel);
		c.add(nameField);
		c.add(ageLabel);
		c.add(ageField);
		c.add(phoneLabel);
		c.add(phoneField);
		c.add(confirmInfo);
		
		confirmInfo.addActionListener(this);
	}


	public static void main(String[] args) {
		AddCustomer addCustomerPage = new AddCustomer();
		
		addCustomerPage.setTitle("Zengin Vacation Village - Add Customer");
		addCustomerPage.setSize(480, 300);
		addCustomerPage.setVisible(true);
		addCustomerPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == confirmInfo) {
			customer_name = nameField.getText();
			age = Integer.parseInt(ageField.getText());
			contact_phone = phoneField.getText();
			
			if(contact_phone.length() != 10) {
				JOptionPane.showMessageDialog(null, "Phone number is not 10 characters!", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			
			DatabaseManager.insertCustomer(this);
			
			JOptionPane.showMessageDialog(null, "Added customer successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
