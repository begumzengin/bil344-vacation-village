package bil344_hw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreateActivity extends JFrame{
	
	private JLabel choose;
	private JButton massActivityButton, indivActivityButton;
	
	public CreateActivity() {
		choose = new JLabel("Choose the type of activity you wish to create:");
		massActivityButton = new JButton("Mass Activity");
		indivActivityButton = new JButton("Individual Activity");
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		Color co = new Color(71, 235, 233);
		c.setBackground(co);
		
		choose.setAlignmentX(Component.CENTER_ALIGNMENT);
		massActivityButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		indivActivityButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		c.add(choose);
		c.add(massActivityButton);
		c.add(indivActivityButton);
	}
	
	
	public static void main(String[] args) {
		CreateActivity creategui = new CreateActivity();
		
		creategui.setTitle("Zengin Vacation Village - Create Activity");
		creategui.setSize(480, 300);
		creategui.setVisible(true);
		creategui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
