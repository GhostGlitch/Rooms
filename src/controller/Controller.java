package controller;

import model.Board;
import model.Layout;
import view.RoomFrame;

/**
 * Controls Rooms.
 */
public class Controller
{
	/**
	 * The layout for the current game.
	 */
	public Layout layout;
	public Board board;
	/**
	 * Constructor for Controller
	 */
	public Controller()
	{
		layout = new Layout(this);
		board = new Board(layout);
		new RoomFrame(this);
	}
	/**
	 * NEEDS TO BE MOVED!!
	 * Checks if any room is an edge.
	 * @param layout a layout of rooms
	 * @param index the first part of a room's coordinates.
	 * @param index1 the second part of a room's coordinates.
	 * @return if the room is an edge
	 */
	public boolean edgeTest(Layout layout,int index,int index1)
	{
		boolean isEdge = false;
		if (layout.get()[index][index1] && !(index == layout.getGenCent() && index1 == layout.getGenCent()))
		{
			if (index != layout.getGenMin() && index1 != layout.getGenMin()
					&& (index == layout.getGenMax() - 1 || !layout.get()[index + 1][index1])
					&& (index1 == layout.getGenMax() - 1 || !layout.get()[index][index1 + 1])
					&& layout.get()[index - 1][index1 - 1] && layout.get()[index - 1][index1] && layout.get()[index][index1 - 1])
			{
				isEdge = true;
			}
			else if (index != layout.getGenMin() && index1 != layout.getGenMax() - 1
					&& (index == layout.getGenMax() - 1 || !layout.get()[index + 1][index1])
					&& (index1 == layout.getGenMin() || !layout.get()[index][index1 - 1])
					&& layout.get()[index - 1][index1 + 1] && layout.get()[index - 1][index1] && layout.get()[index][index1 + 1])
			{
				isEdge = true;
			}
			else if (index != layout.getGenMax() - 1 && index1 != layout.getGenMin()
					&& (index == layout.getGenMin() || !layout.get()[index - 1][index1])
					&& (index1 == layout.getGenMax() - 1 || !layout.get()[index][index1 + 1])
					&& layout.get()[index + 1][index1 - 1] && layout.get()[index + 1][index1] && layout.get()[index][index1 - 1])
			{
				isEdge = true;
			}
			else if (index != layout.getGenMax() - 1 && index1 != layout.getGenMax() - 1
					&& (index == layout.getGenMin() || !layout.get()[index - 1][index1])
					&& (index1 == layout.getGenMin() || !layout.get()[index][index1 - 1])
					&& layout.get()[index + 1][index1 + 1] && layout.get()[index + 1][index1] && layout.get()[index][index1 + 1])
			{
				isEdge = true;
			}
			else if ((index != layout.getGenMax() - 1 && layout.get()[index + 1][index1])
					&& (index == layout.getGenMin() || !layout.get()[index - 1][index1])
					&& (index1 == layout.getGenMax() - 1 || !layout.get()[index][index1 + 1])
					&& (index1 == layout.getGenMin() || !layout.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if ((index == layout.getGenMax() - 1 || !layout.get()[index + 1][index1])
					&& (index != layout.getGenMin() && layout.get()[index - 1][index1])
					&& (index1 == layout.getGenMax() - 1 || !layout.get()[index][index1 + 1])
					&& (index1 == layout.getGenMin() || !layout.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if ((index == layout.getGenMax() - 1 || !layout.get()[index + 1][index1])
					&& (index == layout.getGenMin() || !layout.get()[index - 1][index1])
					&& (index1 != layout.getGenMax() - 1 && layout.get()[index][index1 + 1])
					&& (index1 == layout.getGenMin() || !layout.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if ((index == layout.getGenMax() - 1 || !layout.get()[index + 1][index1])
					&& (index == layout.getGenMin() || !layout.get()[index - 1][index1])
					&& (index1 == layout.getGenMax() - 1 || !layout.get()[index][index1 + 1])
					&& (index1 != layout.getGenMin() && layout.get()[index][index1 - 1]))
			{
				isEdge = true;
			}
			else if (index != layout.getGenMin() && index1 != layout.getGenMin() && index != layout.getGenMax() - 1 && index1 != layout.getGenMax() - 1 
					&& !layout.get()[index + 1][index1]
					&& layout.get()[index - 1][index1 - 1] && layout.get()[index - 1][index1] && layout.get()[index][index1 - 1] 
					&& layout.get()[index - 1][index1 + 1] && layout.get()[index][index1 + 1])
			{
				isEdge = true;
			}
			else if (index != layout.getGenMin() && index1 != layout.getGenMin() && index != layout.getGenMax() - 1 && index1 != layout.getGenMax() - 1 
					&& !layout.get()[index - 1][index1]
					&& layout.get()[index + 1][index1 + 1] && layout.get()[index + 1][index1] && layout.get()[index][index1 + 1] 
					&& layout.get()[index + 1][index1 - 1] && layout.get()[index][index1 - 1])
			{
				isEdge = true;
			}
			else if (index != layout.getGenMin() && index1 != layout.getGenMin() && index != layout.getGenMax() - 1 && index1 != layout.getGenMax() - 1 
					&& !layout.get()[index][index1 - 1]
					&& layout.get()[index + 1][index1 + 1] && layout.get()[index + 1][index1] && layout.get()[index][index1 + 1] 
					&& layout.get()[index - 1][index1 + 1] && layout.get()[index - 1][index1])
			{
				isEdge = true;
			}
			else if (index != layout.getGenMin() && index1 != layout.getGenMin() && index != layout.getGenMax() - 1 && index1 != layout.getGenMax() - 1 
					&& !layout.get()[index][index1 + 1]
					&& layout.get()[index - 1][index1 - 1] && layout.get()[index - 1][index1] && layout.get()[index][index1 - 1] 
					&& layout.get()[index + 1][index1 - 1] && layout.get()[index + 1][index1])
			{
				isEdge = true;
			}
		}
		return isEdge;
	}
}
