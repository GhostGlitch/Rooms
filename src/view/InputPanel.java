package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class InputPanel extends JPanel
{
	Img Img = new Img();
	private JTextField txtFld;

	public InputPanel(Controller c)
	{
		setLayout(null);
		txtFld = new JTextField();
		txtFld.setBounds(10, 11, 80, 44);
		setSize(0, txtFld.getHeight() + (Img.getScaleBy() * 2));
		setOpaque(false);
		txtFld.setFont(new Font("Arial", Font.PLAIN, 40));
		txtFld.setBorder(new EmptyBorder(0, 10, 0, 10));
		txtFld.setForeground(new Color(185, 194, 198));
		txtFld.setBackground(Color.BLACK);
		txtFld.setCaretColor(new Color(185, 194, 198));
		add(txtFld);
		setupListeners();
	}

	private void setupListeners()
	{
		txtFld.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent Enter)
			{
				String txtFldVal = txtFld.getText();
				txtFld.setText(null);
			}
		});
	}

	public void resizeTxtFld()
	{
		txtFld.setBounds(Img.getScaleBy(), 0, getWidth() - (Img.getScaleBy() * 2), getHeight() - Img.getScaleBy());
	}
}
