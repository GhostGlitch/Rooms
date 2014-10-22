package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

public class InputPanel extends JPanel
{
	private JTextField textField;

	public InputPanel(Controller c)
	{
		setupPanel();
		setupLayout();
		setupListeners();

		setBackground(Color.CYAN);
		setLayout(null);
		setSize(100, 85);

		textField = new JTextField();
		textField.setFont(new Font("Courier New", Font.PLAIN, 37));
		textField.setBorder(null);
		textField.setForeground(Color.CYAN);
		textField.setBackground(Color.BLACK);
		textField.setBounds(21, 21, 206, 43);
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

	public void fixSize()
	{
		textField.setBounds(10, 11, this.getWidth() - 20, this.getHeight() - 22);
	}
}
