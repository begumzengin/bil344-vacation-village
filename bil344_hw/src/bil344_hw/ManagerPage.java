package bil344_hw;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ManagerPage extends JFrame implements ActionListener{
	private JLabel option;
	private JButton addCustomer, addAnimator, addEquip_Person;
	
	public ManagerPage(){
		option = new JLabel("What do you want to do?");
		addCustomer = new JButton("Add New Customer");
		addAnimator = new JButton("Add New Animator");
		addEquip_Person = new JButton("Add New Equip Personnel");
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		Color co = new Color(71, 235, 233);
		c.setBackground(co);
		
		option.setAlignmentX(Component.CENTER_ALIGNMENT);
		addCustomer.setAlignmentX(Component.CENTER_ALIGNMENT);
		addAnimator.setAlignmentX(Component.CENTER_ALIGNMENT);
		addEquip_Person.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		c.add(option);
		c.add(addCustomer);
		c.add(addAnimator);
		c.add(addEquip_Person);
		
		addCustomer.addActionListener(this);
		addAnimator.addActionListener(this);
		addEquip_Person.addActionListener(this);
	}

	public static void main(String[] args) {
		ManagerPage gui = new ManagerPage();
		
		gui.setTitle("Zengin Vacation Village - Manager");
		gui.setSize(480, 300);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == addCustomer) {
			
			AddCustomer customer_obj = new AddCustomer();
			
			customer_obj.setTitle("Zengin Vacation Village - Manager");
			customer_obj.setSize(400, 400);
			customer_obj.setVisible(true);
			customer_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else if(ae.getSource() == addAnimator) {
			AddAnimator animator_obj = new AddAnimator();
			
			animator_obj.setTitle("Zengin Vacation Village - Manager");
			animator_obj.setSize(400, 400);
			animator_obj.setVisible(true);
			animator_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else if(ae.getSource() == addEquip_Person) {
			AddEquipPerson equipperson_obj = new AddEquipPerson();
			
			equipperson_obj.setTitle("Zengin Vacation Village - Manager");
			equipperson_obj.setSize(400, 400);
			equipperson_obj.setVisible(true);
			equipperson_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

}
