package view;

import javax.swing.JPanel;

import controller.Controller;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class InputPanel extends JPanel
{
	private JTextField textField;
	public InputPanel(Controller c) 
	{
			setupPanel();
			setupLayout();
			setupListeners();
		
		setBackground(Color.RED);
		setLayout(null);
		setSize(400, 42);
		
		textField = new JTextField();
		textField.setBounds(10, 11, this.getWidth() - 20, this.getHeight()-22);
		add(textField);
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
