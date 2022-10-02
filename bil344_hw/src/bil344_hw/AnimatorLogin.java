package bil344_hw;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AnimatorLogin extends JFrame implements ActionListener{
	public String animatorPhone;
	private int animatorPassword;
	
	private JLabel enterInfo, phoneLabel, passwordLabel;
	private JTextField phoneField, passwordField;
	private JButton loginButton;
	
	public AnimatorLogin() {
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
		AnimatorLogin animatorLoginPage = new AnimatorLogin();
		
		animatorLoginPage.setTitle("Zengin Vacation Village - Animator Log In");
		animatorLoginPage.setSize(480, 300);
		animatorLoginPage.setVisible(true);
		animatorLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == loginButton) {
			
			animatorPhone = phoneField.getText();
			animatorPassword = Integer.parseInt(passwordField.getText());
			
			if(DatabaseManager.checkAnimator(animatorPhone, animatorPassword))
				JOptionPane.showMessageDialog(null, "You have logged in successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
}
