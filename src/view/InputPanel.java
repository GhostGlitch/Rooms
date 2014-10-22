package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

public class InputPanel extends JPanel
{
	RGUI R = new RGUI();
	private JTextField txtInput;

	public InputPanel(Controller c)
	{
		setOpaque(false);
		setupPanel();
		setupLayout();
		setupListeners();
		setLayout(null);

		txtInput = new JTextField();
		txtInput.setFont(new Font("Arial", Font.PLAIN, 37));
		txtInput.setBorder(null);
		txtInput.setForeground(new Color(185, 194, 198));
		txtInput.setBackground(Color.BLACK);
		txtInput.setBounds(10, 11, 80, 44);
		setSize(txtInput.getHeight() + R.scale, txtInput.getWidth() + (R.scale) * 2);
		add(txtInput);
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
		txtInput.setBounds(R.scale, 0, getWidth() - (R.scale * 2), getHeight() - R.scale);
	}
}
