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
	private Controller c;

	public InputPanel(Controller c)
	{
		this.c=c;
		Font font = Img.pixFont("Arial", Font.PLAIN, Img.getScaleBy(c) * 3);
		setLayout(null);
		txtFld = new JTextField();
		txtFld.setBounds(10, 11, 20, Img.Empty.getGraphics().getFontMetrics(font).getHeight());
		setSize(0, txtFld.getHeight() + (Img.getScaleBy(c) * 2));
		setOpaque(false);
		txtFld.setFont(font);
		txtFld.setBorder(new EmptyBorder(0, Img.getScaleBy(c)/2, 0, Img.getScaleBy(c)/2));
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
		txtFld.setBounds(img.getScaleBy(c), 0, getWidth() - (img.getScaleBy(c) * 2), getHeight() - img.getScaleBy(c));
	}
}
