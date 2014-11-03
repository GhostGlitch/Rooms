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
	Img img = new Img();
	private JTextField txtFld;

	public InputPanel(Controller c)
	{
		Font font = Img.getFont("Arial", Font.PLAIN, Img.scaleBy * 3);
		setLayout(null);
		txtFld = new JTextField();
		txtFld.setBounds(10, 11, 20, Img.Empty.getGraphics().getFontMetrics(font).getHeight());
		setSize(0, txtFld.getHeight() + (Img.scaleBy * 2));
		setOpaque(false);
		txtFld.setFont(font);
		txtFld.setBorder(new EmptyBorder(0, Img.scaleBy/2, 0, Img.scaleBy/2));
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
		txtFld.setBounds(img.getScaleBy(), 0, getWidth() - (img.getScaleBy() * 2), getHeight() - img.getScaleBy());
	}
}
