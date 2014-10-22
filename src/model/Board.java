package model;

import java.util.Random;

import controller.Controller;

public class Board
{
	int index;
	int index1;
	boolean isEdge = false;
	int[][] Board;
	double roomsPerTreasure = 10;
	double roomsPerBoss = 20;

	public Board(Layout setup)
	{
		Board = new int[setup.getGenMax()][setup.getGenMax()];
		for (int index = setup.getGenMin(); index < setup.getGenMax(); index++)
		{
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (setup.get()[index][index1])
				{
					Board[index][index1] = 0;
				}
				else
				{
					Board[index][index1] = -1;
				}
			}
		}
		/*
		 * while (!isEdge) { index = RanInt(setup); index1 = RanInt(setup);
		 * EdgeTest(setup); System.out.println(index + " " + index1);
		 * System.out.println(isEdge); }
		 */
		isEdge = false;
		if (roomsPerTreasure > setup.RoomCount())
		{
			while (!isEdge)
			{
				index = RanInt(setup);
				index1 = RanInt(setup);
				EdgeTest(setup);
			}
			isEdge = false;
			Board[index][index1] = Board[index][index1] + 1;
		}

		else
		{
			for (int treasure = 0; treasure != (Math.floor(setup.RoomCount() / roomsPerTreasure)); treasure++)
			{
				while (!isEdge)
				{
					index = RanInt(setup);
					index1 = RanInt(setup);
					EdgeTest(setup);
				}
				isEdge = false;
				Board[index][index1] = Board[index][index1] + 1;
			}
		}
		if (roomsPerBoss > setup.RoomCount())
		{
			while (!isEdge)
			{
				index = RanInt(setup);
				index1 = RanInt(setup);
				EdgeTest(setup);
			}
			isEdge = false;
			Board[index][index1] = Board[index][index1] + 10;
		}

		else
		{
			for (int boss = 0; boss != (Math.floor(setup.RoomCount() / roomsPerBoss)); boss++)
			{
				while (!isEdge)
				{
					index = RanInt(setup);
					index1 = RanInt(setup);
					EdgeTest(setup);
				}
				isEdge = false;
				Board[index][index1] = Board[index][index1] + 10;
			}
		}
	}

	private int RanInt(Layout setup)
	{
		Random rand = new Random();
		return rand.nextInt((setup.getGenMax() - setup.getGenMin())) + setup.getGenMin();
	}

	public int[][] get()
	{
		return Board;
	}

	boolean EdgeTest(Layout setup)
	{
		isEdge = false;
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
