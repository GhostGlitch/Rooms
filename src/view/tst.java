package view;

import javax.swing.JFrame;

public class tst extends JFrame
{
	int width;
	int height;
	public tst()
	{
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		width = getWidth() - getInsets().left - getInsets().right;
		height = getHeight() - getInsets().top - getInsets().bottom;
		setVisible(false);
	}
}
