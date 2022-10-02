package bil344_hw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerMainPage extends JFrame{
	private JLabel option;
	
	public CustomerMainPage() {
		option = new JLabel("What do you want to do?");
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		Color co = new Color(71, 235, 233);
		c.setBackground(co);
		
		option.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		c.add(option);
	}
	
	public static void main(String[] args) {
		CustomerMainPage customer_gui = new CustomerMainPage();
		
		customer_gui.setTitle("Zengin Vacation Village - Customer");
		customer_gui.setSize(480, 300);
		customer_gui.setVisible(true);
		customer_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
