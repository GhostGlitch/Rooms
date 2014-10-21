package view;

import javax.swing.JFrame;
import controller.Controller;
import javax.swing.BoxLayout;

public class RoomFrame extends JFrame
{
	private CombinePanel combine;

	public RoomFrame(Controller controller)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		combine = new CombinePanel(controller);
		setupFrame();
	}
	private void setupFrame()
	{
		getContentPane().add(combine);
		this.setResizable(true);
		setSize(combine.getPreferredSize());
		this.setVisible(true);
	}
}
