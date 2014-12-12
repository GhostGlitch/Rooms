package view;

import static view.Img.Borderln;
import static view.Img.Corner;
import static view.Img.Empty;
import static view.Img.Room;
import static view.Img.getScaleBy;
import static view.Img.rotate;
import static view.Img.scale;
import static view.Img.toLbl;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.Img.Rotn;
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

				add(toLbl(scale(getScaleBy(C), Corner)));
			}
			else if (i == C.layout.getGenMax() + 1)
			{
				add(toLbl(rotate(Rotn.QUARTER, scale(getScaleBy(C), Corner))));
			}
			else
			{
				add(toLbl(scale(getScaleBy(C), Borderln)));
			}
		}
		for (int index = C.layout.getGenMin(); index < C.layout.getGenMax(); index++)
		{
			add(toLbl(rotate(Rotn.QUARTER, scale(getScaleBy(C), Borderln))));
			for (int index1 = C.layout.getGenMin(); index1 < C.layout.getGenMax(); index1++)
			{
				if (C.layout.get()[index][index1])
				{
					if (index == C.layout.getGenCent() && index1 == C.layout.getGenCent())
					{
						add(toLbl(scale(getScaleBy(C), Room)));
					}
					else
					{
						add(toLbl(scale(getScaleBy(C), Room)));
					}
				}
				else
				{
					add(toLbl(scale(getScaleBy(C), Empty)));
				}
			}
			add(toLbl(rotate(Rotn.QUARTER, scale(getScaleBy(C), Borderln))));
		}
		for (int i = C.layout.getGenMin(); i <= C.layout.getGenMax() + 1; i++)
		{
			if (i == C.layout.getGenMin())
			{
				add(toLbl(rotate(Rotn.COUNTER_QUARTER, scale(getScaleBy(C), Corner))));
			}
			else if (i == C.layout.getGenMax() + 1)
			{
				add(toLbl(rotate(Rotn.HALF, scale(getScaleBy(C), Corner))));
			}
			else
			{
				add(toLbl(scale(getScaleBy(C), Borderln)));
			}
		}
	}
}
