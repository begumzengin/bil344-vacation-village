package bil344_hw;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class CustomerLogin extends JFrame implements ActionListener{
	public String customerPhone;
	private int customerPassword;
	
	private JLabel enterInfo, phoneLabel, passwordLabel;
	private JTextField phoneField, passwordField;
	private JButton loginButton;
	
	public CustomerLogin() {
		enterInfo = new JLabel("Please enter log in information:");
		phoneLabel = new JLabel("Phone number:");
		phoneField = new JTextField(10);
		passwordLabel = new JLabel("Password:");
		passwordField = new JTextField(10);
		loginButton = new JButton("Log In");
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		Color co = new Color(71, 235, 233);
		c.setBackground(co);
		
		enterInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		phoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		phoneField.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		c.add(enterInfo);
		c.add(phoneLabel);
		c.add(phoneField);
		c.add(passwordLabel);
		c.add(passwordField);
		c.add(loginButton);
		
		loginButton.addActionListener(this);
	}

	public static void main(String[] args) {
		CustomerLogin customerLoginPage = new CustomerLogin();
		
		customerLoginPage.setTitle("Zengin Vacation Village - Customer Log In");
		customerLoginPage.setSize(480, 300);
		customerLoginPage.setVisible(true);
		customerLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == loginButton) {
			
			customerPhone = phoneField.getText();
			customerPassword = Integer.parseInt(passwordField.getText());
			
			if(DatabaseManager.checkCustomer(customerPhone, customerPassword))
				JOptionPane.showMessageDialog(null, "You have logged in successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}

}
