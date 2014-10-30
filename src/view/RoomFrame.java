package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import controller.Controller;

public class RoomFrame extends JFrame
{
	private CombinePanel combine;
	private Controller c;

	public RoomFrame(Controller c)
	{
		getContentPane().setBackground(Color.BLACK);
		this.c = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupFrame();
	}
	private void setupFrame()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(gridBagLayout);
		combine = new CombinePanel(c);
		GridBagConstraints gbc_combine = new GridBagConstraints();
		gbc_combine.anchor = GridBagConstraints.NORTHWEST;
		gbc_combine.gridx = 0;
		gbc_combine.gridy = 0;
		getContentPane().add(combine, gbc_combine);
		setResizable(true);
		pack();

		setMinimumSize(getPreferredSize());
		setVisible(true);
	}
}
