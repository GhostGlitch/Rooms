package controller;

import java.awt.Frame;

import model.Board;
import model.Setup;
import view.RGUI;
import view.Print;
import view.RoomFrame;

/**
 * Starts up the program Rooms.
 * 
 * @author GhostGlitch and Narpas-Sword
 * @version 0.8.5
 */

public class Controller
{
	public Setup setup = new Setup(this);
	/**
	 * Starts up the program Rooms.
	 * 
	 * @param args Java requirement.
	 */
	public Controller()
	{
		Board board = new Board(setup);
		Print print = new Print();
		RGUI gui = new RGUI();
		RoomFrame frame = new RoomFrame(this);
		print.PrintSetup(setup);
		print.PrintSetupSimple(setup);
		print.PrintBoardSimple(setup, board);
		print.PrintBoard(setup, board);
		gui.PrintBoardPopup(setup, board);
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
