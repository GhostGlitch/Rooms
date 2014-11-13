package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class OutputPanel extends JPanel
{
	private JTextPane txtPane;
	private Controller c;

	public OutputPanel(Controller c)
	{
		this.c = c;
		Font font = Img.pixFont("Arial", Font.PLAIN, Img.getScaleBy(c) * 2);
		setLayout(null);
		txtPane = new JTextPane();
		txtPane.setBounds(10, 11, 20, (Img.Empty.getGraphics().getFontMetrics(font).getHeight() * 2));
		setSize(0, txtPane.getHeight() + (Img.getScaleBy(c) * 2));
		setOpaque(false);
		txtPane.setFont(font);
		txtPane.setBorder(new EmptyBorder(0, Img.getScaleBy(c) / 2, 0, Img.getScaleBy(c) / 2));
		txtPane.setForeground(new Color(185, 194, 198));
		txtPane.setBackground(Color.BLACK);
		txtPane.setCaretColor(new Color(185, 194, 198));
		add(txtPane);
	}

	public void resizeTxtPane()
	{
		txtPane.setBounds(Img.getScaleBy(c), 0, getWidth() - (Img.getScaleBy(c) * 2), getHeight() - Img.getScaleBy(c));
	}
}
