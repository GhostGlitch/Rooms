package controller;

import model.Board;
import model.Setup;
import view.Print;

/**
 * Starts up the program Rooms.
 * 
 * @author GhostGlitch
 */
public class Controller
{

	/**
	 * Starts up the program Rooms.
	 * 
	 * @param args Java requirement.
	 */
	public static void main(String[] args)
	{
		Setup setup = new Setup();
		Board board = new Board(setup);
		Print print = new Print();
		print.PrintSetup(setup);
		print.PrintBoard(setup, board);
	}
	
	public boolean EdgeTest(Setup setup,int index,int index1)
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
		}
		return isEdge;
	}
}
