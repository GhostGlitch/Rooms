package view;

import java.awt.GridLayout;

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
		setupMap();
	}

	private void setupMap()
	{
		for (int i = C.layout.getGenMin(); i <= C.layout.getGenMax() + 1; i++)
		{
			if (i == C.layout.getGenMin())
			{
				add(Img.loadTile(Img.TopLeft));
			}
			else if (i == C.layout.getGenMax() + 1)
			{
				add(Img.loadTile(Img.TopRight));
			}
			else
			{
				add(Img.loadTile(Img.Horizontal));
			}
		}
		for (int index = C.layout.getGenMin(); index < C.layout.getGenMax(); index++)
		{
			add(Img.loadTile(Img.Vertical));
			for (int index1 = C.layout.getGenMin(); index1 < C.layout.getGenMax(); index1++)
			{
				if (C.layout.get()[index][index1])
				{
					if (index == C.layout.getGenCent() && index1 == C.layout.getGenCent())
					{
						add(Img.loadTile(Img.Room));
					}
					else
					{
						add(Img.loadTile(Img.Room));
					}
				}
				else
				{
					add(Img.loadTile(Img.Empty));
				}
			}
			add(Img.loadTile(Img.Vertical));
		}
		for (int i = C.layout.getGenMin(); i <= C.layout.getGenMax() + 1; i++)
		{
			if (i == C.layout.getGenMin())
			{
				add(Img.loadTile(Img.BottomLeft));
			}
			else if (i == C.layout.getGenMax() + 1)
			{
				add(Img.loadTile(Img.BottomRight));
			}
			else
			{
				add(Img.loadTile(Img.Horizontal));
			}
		}
	}
}
