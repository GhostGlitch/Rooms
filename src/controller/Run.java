package controller;

import model.Board;
import model.Setup;
import view.PrintBoard;

/**
 * Starts up the program Rooms.
 * 
 * @author GhostGlitch
 */
public class Run
{
	/**
	 * Starts up the program Rooms.
	 * 
	 * @param args Java requirement.
	 */
	public static void main(String[] args)
	{
		Setup currentSetup = new Setup();
		Board currentBoard = new Board(currentSetup);
		PrintBoard print = new PrintBoard();
		print.PrintSetup(currentSetup);
	}
}
