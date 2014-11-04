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
		layout = new Layout();
		board = new Board(this);
		new RoomFrame(this);
	}
}
