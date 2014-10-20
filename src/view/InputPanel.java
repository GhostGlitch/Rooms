package view;

import javax.swing.JPanel;

import controller.Controller;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class InputPanel extends JPanel
{
	Controller c = new Controller();
	private JTextField textField;
	public InputPanel(Controller c) 
	{
			this.c = c;
			setupPanel();
			setupLayout();
			setupListeners();
		
		setBackground(Color.CYAN);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 90, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textField, 440, SpringLayout.WEST, this);
		add(textField);
		textField.setColumns(10);
	}
	private void setupListeners()
	{
		
	}
	private void setupLayout()
	{
		
	}
	private void setupPanel()
	{
		
	}

}
