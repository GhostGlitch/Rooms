package view;

import javax.swing.JFrame;

public class DummyFrame extends JFrame
{
	int width;
	int height;
	public DummyFrame()
	{
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		width = getWidth() - getInsets().left - getInsets().right;
		height = getHeight() - getInsets().top - getInsets().bottom;
		setVisible(false);
	}
}
