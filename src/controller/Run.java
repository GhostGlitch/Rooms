package controller;

import model.Rooms;
import view.PrintBoard;

public class Run
{
	/**
	 * Starts up the program Rooms.
	 * @param args Java requirement.
	 */
	public static void main(String[] args)
	{
		Rooms board = new Rooms();
		PrintBoard print = new PrintBoard();
		print.PrintSetup(board);
	}
}
