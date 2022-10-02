package bil344_hw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnimatorPage extends JFrame{
	private JLabel select;
	private JButton createActivity, emergencyInfo, addEquip;
	
	public AnimatorPage(){
		select = new JLabel("Select an operation:");
		createActivity = new JButton("Create Activity");
		emergencyInfo = new JButton("Emergency Information");
		addEquip = new JButton("Add Equipment");
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		Color co = new Color(71, 235, 233);
		c.setBackground(co);
		
		select.setAlignmentX(Component.CENTER_ALIGNMENT);
		createActivity.setAlignmentX(Component.CENTER_ALIGNMENT);
		emergencyInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		addEquip.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		c.add(select);
		c.add(createActivity);
		c.add(emergencyInfo);
		c.add(addEquip);
		
	}
	
	public static void main(String[] args) {
		
		AnimatorPage gui = new AnimatorPage();
		gui.setTitle("Zengin Vacation Village - Animator");
		gui.setSize(480, 300);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
