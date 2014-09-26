package model;

import java.util.Random;
import model.Setup;

public class Board
{
	public Board(Setup currentSetup)
	{
		
	}
	RanInt()
	public int RanInt(int min, int max)
	{
		Random rand = new Random();
		int ranNum = rand.nextInt((max - min) + 1) + min;
		return ranNum;
	}
}
