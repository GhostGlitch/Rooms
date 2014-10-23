package view;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JPanel;

import controller.Controller;

public class MapPanel extends JPanel
{
	Images Img = new Images();
	private Controller C;

	public MapPanel(Controller C)
	{
		this.C = C;
		setLayout(new GridLayout(0, C.layout.getGenMax() + 2));
		setOpaque(false);
		try
		{
			setupMap();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setupMap() throws IOException
	{
		for (int i = C.layout.getGenMin(); i <= C.layout.getGenMax() + 1; i++)
		{
			if (i == C.layout.getGenMin())
			{
				add(Images.toLbl(Images.scale(Images.load(Images.TopLeft),15)));
			}
			else if (i == C.layout.getGenMax() + 1)
			{
				add(Images.toLbl(Images.rotate(Images.scale(Images.load(Images.TopLeft),15))));
				
			}
			else
			{
				add(Images.toLbl(Images.scale(Images.load(Images.Horizontal),15)));
			}
		}
		for (int index = C.layout.getGenMin(); index < C.layout.getGenMax(); index++)
		{
			add(Images.toLbl(Images.scale(Images.load(Images.Vertical),15)));
			for (int index1 = C.layout.getGenMin(); index1 < C.layout.getGenMax(); index1++)
			{
				if (C.layout.get()[index][index1])
				{
					if (index == C.layout.getGenCent() && index1 == C.layout.getGenCent())
					{
						add(Images.toLbl(Images.scale(Images.load(Images.Room),15)));
					}
					else
					{
						add(Images.toLbl(Images.scale(Images.load(Images.Room),15)));
					}
				}
				else
				{
					add(Images.toLbl(Images.scale(Images.load(Images.Empty),15)));
				}
			}
			add(Images.toLbl(Images.scale(Images.load(Images.Vertical), 15)));
		}
		for (int i = C.layout.getGenMin(); i <= C.layout.getGenMax() + 1; i++)
		{
			if (i == C.layout.getGenMin())
			{
				add(Images.toLbl(Images.scale(Images.load(Images.BottomLeft),15)));
			}
			else if (i == C.layout.getGenMax() + 1)
			{
				add(Images.toLbl(Images.scale(Images.load(Images.BottomRight),15)));
			}
			else
			{
				add(Images.toLbl(Images.scale(Images.load(Images.Horizontal),15)));
			}
		}
	}
}
