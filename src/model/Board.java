package model;

import java.util.Random;

import controller.Controller;

/**
 * Generates what rooms are.
 * 
 * @author GhostGlitch
 */
public class Board
{
	/**
	 * The first part of a room's coordinates
	 */
	private int index;
	/**
	 * The second part of a room's coordinates
	 */
	private int index1;
	/**
	 * Whether or not a room is an edge
	 */
	private boolean isEdge = false;
	/**
	 * What Rooms are
	 */
	private int[][] board;
	/**
	 * How many rooms are required for a treasure
	 */
	private double roomsPerTreasure = 10;
	/**
	 * How many rooms are required for a boss
	 */
	private double roomsPerBoss = 20;
	Controller c;

	/**
	 * Generates what rooms are.
	 */
	public Board(Controller c)
	{
		this.c = c;
		board = new int[c.layout.getGenMax()][c.layout.getGenMax()];
		for (int index = c.layout.getGenMin(); index < c.layout.getGenMax(); index++)
		{
			for (int index1 = c.layout.getGenMin(); index1 < c.layout.getGenMax(); index1++)
			{
				if (c.layout.get()[index][index1])
				{
					board[index][index1] = 0;
				}
				else
				{
					board[index][index1] = -1;
				}
			}
		}
		isEdge = false;
		if (roomsPerTreasure > c.layout.RoomCount())
		{
			while (!isEdge)
			{
				index = c.layout.RanInt();
				index1 = c.layout.RanInt();
				testEdge();
			}
			isEdge = false;
			board[index][index1] = board[index][index1] + 1;
		}

		else
		{
			for (int treasure = 0; treasure != (Math.floor(c.layout.RoomCount() / roomsPerTreasure)); treasure++)
			{
				while (!isEdge)
				{
					index = c.layout.RanInt();
					index1 = c.layout.RanInt();
					testEdge();
				}
				isEdge = false;
				board[index][index1] = board[index][index1] + 1;
			}
		}
		if (roomsPerBoss > c.layout.RoomCount())
		{
			while (!isEdge)
			{
				index = c.layout.RanInt();
				index1 = c.layout.RanInt();
				testEdge();
			}
			isEdge = false;
			board[index][index1] = board[index][index1] + 10;
		}

		else
		{
			for (int boss = 0; boss != (Math.floor(c.layout.RoomCount() / roomsPerBoss)); boss++)
			{
				while (!isEdge)
				{
					index = c.layout.RanInt();
					index1 = c.layout.RanInt();
					testEdge();
				}
				isEdge = false;
				board[index][index1] = board[index][index1] + 10;
			}
		}
	}

	/**
	 * Getter for the board
	 * 
	 * @return board
	 */
	public int[][] get()
	{
		return board;
	}

	/**
	 * Checks if any room is an edge. Slightly different than that of Layout
	 * 
	 * @return if the room is an edge
	 */
	private boolean testEdge()
	{
		isEdge = false;
		if (c.layout.get()[index][index1] && !(index == c.layout.getGenCent() && index1 == c.layout.getGenCent()))
		{
			if (index != c.layout.getGenMin() && index1 != c.layout.getGenMin()
					&& (index == c.layout.getGenMax() - 1 || !c.layout.get()[index + 1][index1])
					&& (index1 == c.layout.getGenMax() - 1 || !c.layout.get()[index][index1 + 1])
					&& c.layout.get()[index - 1][index1 - 1] && c.layout.get()[index - 1][index1] && c.layout.get()[index][index1 - 1])
				isEdge = true;
			else if (index != c.layout.getGenMin() && index1 != c.layout.getGenMax() - 1
					&& (index == c.layout.getGenMax() - 1 || !c.layout.get()[index + 1][index1])
					&& (index1 == c.layout.getGenMin() || !c.layout.get()[index][index1 - 1])
					&& c.layout.get()[index - 1][index1 + 1] && c.layout.get()[index - 1][index1] && c.layout.get()[index][index1 + 1])
				isEdge = true;
			else if (index != c.layout.getGenMax() - 1 && index1 != c.layout.getGenMin()
					&& (index == c.layout.getGenMin() || !c.layout.get()[index - 1][index1])
					&& (index1 == c.layout.getGenMax() - 1 || !c.layout.get()[index][index1 + 1])
					&& c.layout.get()[index + 1][index1 - 1] && c.layout.get()[index + 1][index1] && c.layout.get()[index][index1 - 1])
				isEdge = true;
			else if (index != c.layout.getGenMax() - 1 && index1 != c.layout.getGenMax() - 1
					&& (index == c.layout.getGenMin() || !c.layout.get()[index - 1][index1])
					&& (index1 == c.layout.getGenMin() || !c.layout.get()[index][index1 - 1])
					&& c.layout.get()[index + 1][index1 + 1] && c.layout.get()[index + 1][index1] && c.layout.get()[index][index1 + 1])
				isEdge = true;
			else if ((index != c.layout.getGenMax() - 1 && c.layout.get()[index + 1][index1])
					&& (index == c.layout.getGenMin() || !c.layout.get()[index - 1][index1])
					&& (index1 == c.layout.getGenMax() - 1 || !c.layout.get()[index][index1 + 1])
					&& (index1 == c.layout.getGenMin() || !c.layout.get()[index][index1 - 1]))
				isEdge = true;
			else if ((index == c.layout.getGenMax() - 1 || !c.layout.get()[index + 1][index1])
					&& (index != c.layout.getGenMin() && c.layout.get()[index - 1][index1])
					&& (index1 == c.layout.getGenMax() - 1 || !c.layout.get()[index][index1 + 1])
					&& (index1 == c.layout.getGenMin() || !c.layout.get()[index][index1 - 1]))
				isEdge = true;
			else if ((index == c.layout.getGenMax() - 1 || !c.layout.get()[index + 1][index1])
					&& (index == c.layout.getGenMin() || !c.layout.get()[index - 1][index1])
					&& (index1 != c.layout.getGenMax() - 1 && c.layout.get()[index][index1 + 1])
					&& (index1 == c.layout.getGenMin() || !c.layout.get()[index][index1 - 1]))
				isEdge = true;
			else if ((index == c.layout.getGenMax() - 1 || !c.layout.get()[index + 1][index1])
					&& (index == c.layout.getGenMin() || !c.layout.get()[index - 1][index1])
					&& (index1 == c.layout.getGenMax() - 1 || !c.layout.get()[index][index1 + 1])
					&& (index1 != c.layout.getGenMin() && c.layout.get()[index][index1 - 1]))
				isEdge = true;
		}
		return isEdge;
	}
}
