package controller;

import model.Rooms;
import view.PrintBoard;

public class Run
{
	public static void main(String[] args)
	{
		Rooms var = new Rooms();
		PrintBoard rooms = new PrintBoard();
		rooms.PrintSetup(var);
	}
}
