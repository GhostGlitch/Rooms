package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import controller.Controller;

public class MapPanel extends JPanel
{
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
				add(Img.toLbl(Img.scale(Img.scaleBy, Img.Corner)));
			}
			else if (i == C.layout.getGenMax() + 1)
			{
				add(Img.toLbl(Img.rotate(Img.Rotn.QUARTER, Img.scale(Img.scaleBy, Img.Corner))));
			}
			else
			{
				add(Img.toLbl(Img.scale(Img.scaleBy, Img.Borderln)));
			}
		}
		for (int index = C.layout.getGenMin(); index < C.layout.getGenMax(); index++)
		{
			add(Img.toLbl(Img.rotate(Img.Rotn.QUARTER, Img.scale(Img.scaleBy, Img.Borderln))));
			for (int index1 = C.layout.getGenMin(); index1 < C.layout.getGenMax(); index1++)
			{
				if (C.layout.get()[index][index1])
				{
					if (index == C.layout.getGenCent() && index1 == C.layout.getGenCent())
					{
						add(Img.toLbl(Img.scale(Img.scaleBy, Img.Room)));
					}
					else
					{
						add(Img.toLbl(Img.scale(Img.scaleBy, Img.Room)));
					}
				}
				else
				{
					add(Img.toLbl(Img.scale(Img.scaleBy, Img.Empty)));
				}
			}
			add(Img.toLbl(Img.rotate(Img.Rotn.QUARTER, Img.scale(Img.scaleBy, Img.Borderln))));
		}
		for (int i = C.layout.getGenMin(); i <= C.layout.getGenMax() + 1; i++)
		{
			if (i == C.layout.getGenMin())
			{
				add(Img.toLbl(Img.rotate(Img.Rotn.COUNTER_QUARTER, Img.scale(Img.scaleBy, Img.Corner))));
			}
			else if (i == C.layout.getGenMax() + 1)
			{
				add(Img.toLbl(Img.rotate(Img.Rotn.HALF, Img.scale(Img.scaleBy, Img.Corner))));
			}
			else
			{
				add(Img.toLbl(Img.scale(Img.scaleBy, Img.Borderln)));
			}
		}
	}
}
