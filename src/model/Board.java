package model;

import java.util.Random;

import controller.Controller;

public class Board
{
	Controller controller = new Controller();
	int index;
	int index1;
	boolean isEdge = false;
	int[][] Board;

	public Board(Setup setup)
	{
		
		Board = new int[setup.getGenMax()][setup.getGenMax()];
		for (int index = setup.getGenMin(); index < setup.getGenMax(); index++)
		{
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (setup.get()[index][index1])
				{
					Board[index][index1] = 1;
				}
			}
		}
		for (int index = setup.getGenMin(); index < setup.getGenMax(); index++)
		{
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (controller.EdgeTest(setup, index, index1))
				{
					Board[index][index1] = 2;
				}
			}
		}
		/*
		while (!isEdge)
		{
			index = RanInt(setup);
			index1 = RanInt(setup);
			isEdge = controller.EdgeTest(setup, index, index1);
			System.out.println(index + " " + index1);
			System.out.println(isEdge);
		}
		*/
	}

	private int RanInt(Setup setup)
	{
		Random rand = new Random();
		return rand.nextInt((setup.getGenMax() - setup.getGenMin())) + setup.getGenMin();
	}

	public int[][] get()
	{
		return Board;
	}
}