package bil344_hw;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AddAnimator extends JFrame implements ActionListener{
	private String employee_name;
	private String expertise_area;
	private String phone_number;
	
	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getExpertise_area() {
		return expertise_area;
	}

	public void setExpertise_area(String expertise_area) {
		this.expertise_area = expertise_area;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	private JLabel enterInfo, nameLabel, expertiseLabel, phoneLabel;
	private JTextField nameField, expertiseField, phoneField;
	private JButton confirmInfo;
	
	public AddAnimator() {
		enterInfo = new JLabel("Please enter animator information:");
		nameLabel = new JLabel("Name:");
		nameField = new JTextField(20);
		expertiseLabel = new JLabel("Area of expertise:");
		expertiseField = new JTextField(20);
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
		expertiseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		expertiseField.setAlignmentX(Component.CENTER_ALIGNMENT);
		phoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		phoneField.setAlignmentX(Component.CENTER_ALIGNMENT);
		confirmInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		c.add(enterInfo);
		c.add(nameLabel);
		c.add(nameField);
		c.add(expertiseLabel);
		c.add(expertiseField);
		c.add(phoneLabel);
		c.add(phoneField);
		c.add(confirmInfo);
		
		confirmInfo.addActionListener(this);
	}
	
	public static void main(String[] args) {
		AddAnimator addAnimatorPage = new AddAnimator();
		
		addAnimatorPage.setTitle("Zengin Vacation Village - Add Animator");
		addAnimatorPage.setSize(480, 300);
		addAnimatorPage.setVisible(true);
		addAnimatorPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == confirmInfo) {
			employee_name = nameField.getText();
			expertise_area = expertiseField.getText();
			phone_number = phoneField.getText();
			
			if(phone_number.length() != 10) {
				JOptionPane.showMessageDialog(null, "Phone number is not 10 characters!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			DatabaseManager.insertAnimator(this);
			
			JOptionPane.showMessageDialog(null, "Added animator successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}


}
