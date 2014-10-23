package controller;

import model.Board;
import model.Layout;
import view.Images;
import view.RoomFrame;

/**
 * Starts up the program Rooms.
 * 
 * @author GhostGlitch and Narpas-Sword
 * @version 0.8.5
 */

public class Controller
{
	public Images R = new Images();
	public Layout layout = new Layout(this);
	/**
	 * Starts up the program Rooms.
	 * 
	 * @param args Java requirement.
	 */
	public Controller()
	{
		new Board(layout);
		new RoomFrame(this);

	}
	public boolean edgeTest(Layout setup,int index,int index1)
	{
		boolean isEdge = false;
		if (setup.get()[index][index1] && !(index == setup.getGenCent() && index1 == setup.getGenCent()))
		{
			if (index != setup.getGenMin() && index1 != setup.getGenMin()
					&& (index == setup.getGenMax() - 1 || !setup.get()[index + 1][index1])
					&& (index1 == setup.getGenMax() - 1 || !setup.get()[index][index1 + 1])
					&& setup.get()[index - 1][index1 - 1] && setup.get()[index - 1][index1] && setup.get()[index][index1 - 1])
			{
				isEdge = true;
			}
			else if (index != setup.getGenMin() && index1 != setup.getGenMax() - 1
					&& (index == setup.getGenMax() - 1 || !setup.get()[index + 1][index1])
					&& (index1 == setup.getGenMin() || !setup.get()[index][index1 - 1])
					&& setup.get()[index - 1][index1 + 1] && setup.get()[index - 1][index1] && setup.get()[index][index1 + 1])
			{
				isEdge = true;
			}
			else if (index != setup.getGenMax() - 1 && index1 != setup.getGenMin()
					&& (index == setup.getGenMin() || !setup.get()[index - 1][index1])
					&& (index1 == setup.getGenMax() - 1 || !setup.get()[index][index1 + 1])
					&& setup.get()[index + 1][index1 - 1] && setup.get()[index + 1][index1] && setup.get()[index][index1 - 1])
			{
				isEdge = true;
			}
			else if (index != setup.getGenMax() - 1 && index1 != setup.getGenMax() - 1
					&& (index == setup.getGenMin() || !setup.get()[index - 1][index1])
					&& (index1 == setup.getGenMin() || !setup.get()[index][index1 - 1])
					&& setup.get()[index + 1][index1 + 1] && setup.get()[index + 1][index1] && setup.get()[index][index1 + 1])
			{
				isEdge = true;
			}
			else if ((index != setup.getGenMax() - 1 && setup.get()[index + 1][index1])
					&& (index == setup.getGenMin() || !setup.get()[index - 1][index1])
					&& (index1 == setup.getGenMax() - 1 || !setup.get()[index][index1 + 1])
					&& (index1 == setup.getGenMin() || !setup.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if ((index == setup.getGenMax() - 1 || !setup.get()[index + 1][index1])
					&& (index != setup.getGenMin() && setup.get()[index - 1][index1])
					&& (index1 == setup.getGenMax() - 1 || !setup.get()[index][index1 + 1])
					&& (index1 == setup.getGenMin() || !setup.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if ((index == setup.getGenMax() - 1 || !setup.get()[index + 1][index1])
					&& (index == setup.getGenMin() || !setup.get()[index - 1][index1])
					&& (index1 != setup.getGenMax() - 1 && setup.get()[index][index1 + 1])
					&& (index1 == setup.getGenMin() || !setup.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if ((index == setup.getGenMax() - 1 || !setup.get()[index + 1][index1])
					&& (index == setup.getGenMin() || !setup.get()[index - 1][index1])
					&& (index1 == setup.getGenMax() - 1 || !setup.get()[index][index1 + 1])
					&& (index1 != setup.getGenMin() && setup.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if (index != setup.getGenMin() && index1 != setup.getGenMin() && index != setup.getGenMax() - 1 && index1 != setup.getGenMax() - 1 
					&& !setup.get()[index + 1][index1]
					&& setup.get()[index - 1][index1 - 1] && setup.get()[index - 1][index1] && setup.get()[index][index1 - 1] 
					&& setup.get()[index - 1][index1 + 1] && setup.get()[index][index1 + 1])
			{
				isEdge = true;
			}
			else if (index != setup.getGenMin() && index1 != setup.getGenMin() && index != setup.getGenMax() - 1 && index1 != setup.getGenMax() - 1 
					&& !setup.get()[index - 1][index1]
					&& setup.get()[index + 1][index1 + 1] && setup.get()[index + 1][index1] && setup.get()[index][index1 + 1] 
					&& setup.get()[index + 1][index1 - 1] && setup.get()[index][index1 - 1])
			{
				isEdge = true;
			}
			else if (index != setup.getGenMin() && index1 != setup.getGenMin() && index != setup.getGenMax() - 1 && index1 != setup.getGenMax() - 1 
					&& !setup.get()[index][index1 - 1]
					&& setup.get()[index + 1][index1 + 1] && setup.get()[index + 1][index1] && setup.get()[index][index1 + 1] 
					&& setup.get()[index - 1][index1 + 1] && setup.get()[index - 1][index1])
			{
				isEdge = true;
			}
			else if (index != setup.getGenMin() && index1 != setup.getGenMin() && index != setup.getGenMax() - 1 && index1 != setup.getGenMax() - 1 
					&& !setup.get()[index][index1 + 1]
					&& setup.get()[index - 1][index1 - 1] && setup.get()[index - 1][index1] && setup.get()[index][index1 - 1] 
					&& setup.get()[index + 1][index1 - 1] && setup.get()[index + 1][index1])
			{
				isEdge = true;
			}
		}
		return isEdge;
	}
}
