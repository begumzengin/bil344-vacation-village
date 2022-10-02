package bil344_hw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class villageAppGUI extends JFrame{
	
	private JButton managerButton, customerButton, animatorButton, exit_sign;
	private JLabel welcomeSign, userType, leave, imageLabel;
	private ImageIcon cocktail;
	
	public villageAppGUI(){
		managerButton = new JButton("Manager");
		customerButton = new JButton("Customer");
		animatorButton = new JButton("Animator");
		welcomeSign = new JLabel("Welcome to Zengin Vacation Village!");
		userType = new JLabel("Please select user type:");
		leave = new JLabel("If you wish to leave :(");
		exit_sign = new JButton("Exit :(");
		
		cocktail = new ImageIcon(getClass().getResource("cocktail.gif"));
		imageLabel = new JLabel(cocktail);
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		Color co = new Color(71, 235, 233);
		c.setBackground(co);
		
		welcomeSign.setAlignmentX(Component.CENTER_ALIGNMENT);
		userType.setAlignmentX(Component.CENTER_ALIGNMENT);
		managerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		customerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		animatorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		leave.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit_sign.setAlignmentX(Component.CENTER_ALIGNMENT);
		imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		c.add(welcomeSign);
		c.add(userType);
		c.add(managerButton);
		c.add(customerButton);
		c.add(animatorButton);
		c.add(leave);
		c.add(exit_sign);
		c.add(imageLabel);
		
		MyEventHandler myEvent = new MyEventHandler();
		managerButton.addActionListener(myEvent);
		customerButton.addActionListener(myEvent);
		animatorButton.addActionListener(myEvent);
		exit_sign.addActionListener(
				new ActionListener() {  
					public void actionPerformed(ActionEvent ae) {
						System.exit(0); 
					}
				}
			);
	}
	

	public static void main(String[] args) {
		
		villageAppGUI gui = new villageAppGUI();
		
		gui.setTitle("Zengin Vacation Village");
		gui.setSize(480, 530);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class MyEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			
			if(ae.getSource() == managerButton) {
				
				ManagerPage manager_obj = new ManagerPage();
				
				manager_obj.setTitle("Zengin Vacation Village - Manager");
				manager_obj.setSize(400, 400);
				manager_obj.setVisible(true);
				manager_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
			else if(ae.getSource() == customerButton) {
				
				CustomerLogin customerlogin_obj = new CustomerLogin();
				
				customerlogin_obj.setTitle("Zengin Vacation Village - Customer Log In");
				customerlogin_obj.setSize(400, 400);
				customerlogin_obj.setVisible(true);
				customerlogin_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
			else if(ae.getSource() == animatorButton) {
				
				AnimatorLogin animatorlogin_obj = new AnimatorLogin();
				
				animatorlogin_obj.setTitle("Zengin Vacation Village - Animator Log In");
				animatorlogin_obj.setSize(400, 400);
				animatorlogin_obj.setVisible(true);
				animatorlogin_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
		}
		
	}
}
