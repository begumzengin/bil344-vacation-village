package bil344_hw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEquipPerson extends JFrame implements ActionListener{
	private int ssn;
	private String ep_name;
	private String ep_surname;
	private String ep_contactphone;
	
	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getEp_name() {
		return ep_name;
	}

	public void setEp_name(String ep_name) {
		this.ep_name = ep_name;
	}

	public String getEp_surname() {
		return ep_surname;
	}

	public void setEp_surname(String ep_surname) {
		this.ep_surname = ep_surname;
	}

	public String getEp_contactphone() {
		return ep_contactphone;
	}

	public void setEp_contactphone(String ep_contactphone) {
		this.ep_contactphone = ep_contactphone;
	}
	
	private JLabel enterInfo, ssnLabel, nameLabel, surnameLabel, phoneLabel;
	private JTextField ssnField, nameField, surnameField, phoneField;
	private JButton confirmInfo;
	
	public AddEquipPerson(){
		enterInfo = new JLabel("Please enter equip person information:");
		ssnLabel = new JLabel("Social security number:");
		ssnField = new JTextField(20);
		nameLabel = new JLabel("Name:");
		nameField = new JTextField(20);
		surnameLabel = new JLabel("Surname:");
		surnameField = new JTextField(20);
		phoneLabel = new JLabel("Phone number:");
		phoneField = new JTextField(10);
		confirmInfo = new JButton("Confirm");
		
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		Color co = new Color(71, 235, 233);
		c.setBackground(co);
		
		enterInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		ssnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ssnField.setAlignmentX(Component.CENTER_ALIGNMENT);
		nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
		surnameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		surnameField.setAlignmentX(Component.CENTER_ALIGNMENT);
		phoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		phoneField.setAlignmentX(Component.CENTER_ALIGNMENT);
		confirmInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		c.add(enterInfo);
		c.add(ssnLabel);
		c.add(ssnField);
		c.add(nameLabel);
		c.add(nameField);
		c.add(surnameLabel);
		c.add(surnameField);
		c.add(phoneLabel);
		c.add(phoneField);
		c.add(confirmInfo);
		
		confirmInfo.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		AddEquipPerson addEpPage = new AddEquipPerson();
		
		addEpPage.setTitle("Zengin Vacation Village - Add Equip Person");
		addEpPage.setSize(480, 300);
		addEpPage.setVisible(true);
		addEpPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == confirmInfo) {
			ssn = Integer.parseInt(ssnField.getText());
			ep_name = nameField.getText();
			ep_surname = surnameField.getText();
			ep_contactphone = phoneField.getText();
			
			if(ep_contactphone.length() != 10) {
				JOptionPane.showMessageDialog(null, "Phone number is not 10 characters!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			DatabaseManager.insertEquipPerson(this);
			
			JOptionPane.showMessageDialog(null, "Added equip person successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
