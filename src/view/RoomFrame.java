package view;

import javax.swing.JFrame;
import controller.Controller;

public class RoomFrame extends JFrame
{
	private MapPanel panel;

	public RoomFrame(Controller controller)
	{
		panel = new MapPanel(controller);
		setupFrame();
	}
	private void setupFrame()
	{
		this.add(panel);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}
}
