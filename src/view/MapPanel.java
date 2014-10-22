package view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import controller.Controller;

public class MapPanel extends JPanel
{
	RGUI R = new RGUI();
	private Controller c;

	public MapPanel(Controller c)
	{
		setLayout(new GridLayout(0, c.layout.getGenMax() + 2));
		setOpaque(false);
		for (int i = c.layout.getGenMin(); i <= c.layout.getGenMax() + 1; i++)
		{
			if (i == c.layout.getGenMin())
			{
				add(R.LoadBigImgLbl(R.TopLeft));
			}
			else if (i == c.layout.getGenMax() + 1)
			{
				add(R.LoadBigImgLbl(R.TopRight));
			}
			else
			{
				add(R.LoadBigImgLbl(R.Horizontal));
			}
		}
		for (int index = c.layout.getGenMin(); index < c.layout.getGenMax(); index++)
		{
			add(R.LoadBigImgLbl(R.Vertical));
			for (int index1 = c.layout.getGenMin(); index1 < c.layout.getGenMax(); index1++)
			{
				if (c.layout.get()[index][index1])
				{
					if (index == c.layout.getGenCent() && index1 == c.layout.getGenCent())
					{
						add(R.LoadBigImgLbl(R.Room));
					}
					else
					{
						add(R.LoadBigImgLbl(R.Room));
					}
				}
				else
				{
					add(R.LoadBigImgLbl(R.Empty));
				}
			}
			add(R.LoadBigImgLbl(R.Vertical));
		}
		for (int i = c.layout.getGenMin(); i <= c.layout.getGenMax() + 1; i++)
		{
			if (i == c.layout.getGenMin())
			{
				add(R.LoadBigImgLbl(R.BottomLeft));
			}
			else if (i == c.layout.getGenMax() + 1)
			{
				add(R.LoadBigImgLbl(R.BottomRight));
			}
			else
			{
				add(R.LoadBigImgLbl(R.Horizontal));
			}
		}
	}
}
