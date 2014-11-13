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
	private JTextField txtFld;
	private Controller c;

	public InputPanel(Controller c)
	{
		this.c = c;

		txtFld = new JTextField();


		txtFld.setBorder(new EmptyBorder(0, Img.getScaleBy(c) / 2, 0, Img.getScaleBy(c) / 2));
		txtFld.setForeground(new Color(185, 194, 198));
		txtFld.setBackground(Color.BLACK);
		txtFld.setCaretColor(new Color(185, 194, 198));
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupLayout()
	{
		setBounds(0, (c.layout.getGenMax() + 2) * Img.getScaleBy(c) * 3, (c.layout.getGenMax() + 2) * Img.getScaleBy(c) * 3, Img.Empty.getGraphics().getFontMetrics(font).getHeight() + (Img.getScaleBy(c) * 2));
		txtFld.setBounds(Img.getScaleBy(c), 0, getWidth() - (Img.getScaleBy(c) * 2), getHeight() - Img.getScaleBy(c));
	}

	private void setupPanel()
	{
		Font font = Img.pixFont("Arial", Font.PLAIN, Img.getScaleBy(c) * 2);
		txtFld.setFont(font);
		setLayout(null);
		add(txtFld);
	}

	private void setupListeners()
	{
		txtFld.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent Enter)
			{
				String txtFldVal = txtFld.getText();
				txtFld.setText(null);
				System.out.println(c.txt.checkCmd(txtFldVal));
			}
		});
	}
}
