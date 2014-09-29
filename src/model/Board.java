package model;

import java.util.Random;

public class Board
{

	public Board(Setup currentSetup)
	{
		RanInt(currentSetup);
	}

	private int RanInt(Setup currentSetup)
	{
		Random rand = new Random();
		int ranNum = rand.nextInt((currentSetup.getGenMax() - currentSetup.getGenMin()) + 1) + currentSetup.getGenMin();
		return ranNum;
	}
}
