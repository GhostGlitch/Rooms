package model;

import java.util.Random;

public class Board
{
	Random rand = new Random();
	int index;
	int index1;
	boolean isEdge = false;

	public Board(Setup setup)
	{
		boolean[][] Board = new boolean[setup.getGenMax()][setup.getGenMax()];
		while (!isEdge)
		{
			index = RanInt(setup);
			index1 = RanInt(setup);
			EdgeTest(setup);
		}
	}

	private int RanInt(Setup setup)
	{
		return rand.nextInt((setup.getGenMax() - setup.getGenMin()) + 1) + setup.getGenMin();
	}

	private boolean EdgeTest(Setup setup)
	{
		int roomCount = 0;
		if (index != setup.getGenMax() - 1 && index1 != setup.getGenMax() - 1)
		{
			if ((index != setup.getGenMax() - 1 && !setup.get()[index + 1][index1]) && !setup.get()[index][index1 + 1])
			{
				isEdge = true;
				return isEdge;
			}
		}
		else if (index != setup.getGenMin() && index1 != setup.getGenMin())
		{
			if (!setup.get()[index - 1][index1] && !setup.get()[index][index1 - 1])
			{

			}
		}
		else if (index1 != setup.getGenMax() - 1)
		{
			if (setup.get()[index][index1 + 1])
			{

			}
		}
		else if (index1 != setup.getGenMin())
		{
			if (setup.get()[index][index1 - 1])
			{

			}
		}
		if (roomCount == 1)
		{
			percent = .5;
		}
		else if (roomCount == 2)
		{
			percent = .25;
		}
		return Math.random() < percent;
	}
}
