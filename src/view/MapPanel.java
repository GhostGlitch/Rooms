package view;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class MapPanel extends JPanel
{
	private Controller C;
	JLabel[][] map;

	public MapPanel(Controller C)
	{
		this.C = C;
		setLayout(new GridLayout(0, C.layout.getGenMax() + 2));
		setOpaque(false);
		setupMap();
	}

	private void setupMap()
	{
		map = new JLabel[C.layout.getGenMax() + 2][C.layout.getGenMax() + 2];
		for (int i = C.layout.getGenMin(); i <= C.layout.getGenMax() + 1; i++)
		{
			if (i == C.layout.getGenMin())
			{
				
				add(Img.toLbl(Img.scale(Img.getScaleBy(C), Img.Corner)));
			}
			else if (i == C.layout.getGenMax() + 1)
			{
				add(Img.toLbl(Img.rotate(Img.Rotn.QUARTER, Img.scale(Img.getScaleBy(C), Img.Corner))));
			}
			else
			{
				add(Img.toLbl(Img.scale(Img.getScaleBy(C), Img.Borderln)));
			}
		}
		for (int index = C.layout.getGenMin(); index < C.layout.getGenMax(); index++)
		{
			add(Img.toLbl(Img.rotate(Img.Rotn.QUARTER, Img.scale(Img.getScaleBy(C), Img.Borderln))));
			for (int index1 = C.layout.getGenMin(); index1 < C.layout.getGenMax(); index1++)
			{
				if (C.layout.get()[index][index1])
				{
					if (index == C.layout.getGenCent() && index1 == C.layout.getGenCent())
					{
						add(Img.toLbl(Img.scale(Img.getScaleBy(C), Img.Room)));
					}
					else
					{
						add(Img.toLbl(Img.scale(Img.getScaleBy(C), Img.Room)));
					}
				}
				else
				{
					add(Img.toLbl(Img.scale(Img.getScaleBy(C), Img.Empty)));
				}
			}
			add(Img.toLbl(Img.rotate(Img.Rotn.QUARTER, Img.scale(Img.getScaleBy(C), Img.Borderln))));
		}
		for (int i = C.layout.getGenMin(); i <= C.layout.getGenMax() + 1; i++)
		{
			if (i == C.layout.getGenMin())
			{
				add(Img.toLbl(Img.rotate(Img.Rotn.COUNTER_QUARTER, Img.scale(Img.getScaleBy(C), Img.Corner))));
			}
			else if (i == C.layout.getGenMax() + 1)
			{
				add(Img.toLbl(Img.rotate(Img.Rotn.HALF, Img.scale(Img.getScaleBy(C), Img.Corner))));
			}
			else
			{
				add(Img.toLbl(Img.scale(Img.getScaleBy(C), Img.Borderln)));
			}
		}
	}
}
