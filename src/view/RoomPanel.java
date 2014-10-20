package view;

import javax.swing.JPanel;
import controller.Controller;
import java.awt.Color;
import java.awt.GridLayout;
import view.RGUI;

public class RoomPanel extends JPanel
{
	RGUI R = new RGUI();
	private Controller controller;
	public RoomPanel(Controller controller)
	{
		this.controller = controller;
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		setBackground(Color.CYAN);
		for (int i = controller.setup.getGenMin(); i <= controller.setup.getGenMax() + 1; i++)
		{
			if (i == controller.setup.getGenMin())
			{
				this.add(R.LoadBigImg(R.TopLeft));
			}
			else if (i == controller.setup.getGenMax() + 1)
			{
				this.add(R.LoadBigImg(R.TopRight));
			}
			else
			{
				this.add(R.LoadBigImg(R.Horizontal));
			}
		}
		for (int index = controller.setup.getGenMin(); index < controller.setup.getGenMax(); index++)
		{
			this.add(R.LoadBigImg(R.Vertical));
			for (int index1 = controller.setup.getGenMin(); index1 < controller.setup.getGenMax(); index1++)
			{
				if (controller.setup.get()[index][index1])
				{
					if (index == controller.setup.getGenCent() && index1 == controller.setup.getGenCent())
					{
						this.add(R.LoadBigImg(R.Room));
					}
					else
					{
						this.add(R.LoadBigImg(R.Room));
					}
				}
				else
				{
					this.add(R.LoadBigImg(R.Empty));
				}
			}
			this.add(R.LoadBigImg(R.Vertical));
		}
		for (int i = controller.setup.getGenMin(); i <= controller.setup.getGenMax() + 1; i++)
		{
			if (i == controller.setup.getGenMin())
			{
				this.add(R.LoadBigImg(R.BottomLeft));
			}
			else if (i == controller.setup.getGenMax() + 1)
			{
				this.add(R.LoadBigImg(R.BottomRight));
			}
			else
			{
				this.add(R.LoadBigImg(R.Horizontal));
			}
		}
	}

	private void setupLayout()
	{
		setLayout(new GridLayout(0, controller.setup.getGenMax() + 2));
		
	}

	private void setupListeners()
	{

	}
}
