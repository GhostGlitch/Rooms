package rooms.controller;

public class Rooms
{
	boolean[][] Setup = new boolean[7][7];

	public void RoomSetup()
	{
		while (RoomCount() < 10)
		{
			System.out.println();
			Setup[3][3] = true;
			while (!Setup[2][3] && !Setup[4][3] && !Setup[3][2] && !Setup[3][4])
			{
				Setup[2][3] = RanBool(.75);
				Setup[4][3] = RanBool(.75);
				Setup[3][2] = RanBool(.75);
				Setup[3][4] = RanBool(.75);
			}
			Setup[2][2] = RanBool(getSurrounding(2, 2));
			Setup[2][4] = RanBool(getSurrounding(2, 4));
			Setup[4][2] = RanBool(getSurrounding(4, 2));
			Setup[4][4] = RanBool(getSurrounding(4, 4));
			Setup[3][1] = RanBool(getSurrounding(3, 1));
			Setup[1][3] = RanBool(getSurrounding(1, 3));
			Setup[5][3] = RanBool(getSurrounding(5, 3));
			Setup[3][5] = RanBool(getSurrounding(3, 5));
			Setup[2][1] = RanBool(getSurrounding(2, 1));
			Setup[1][2] = RanBool(getSurrounding(1, 2));
			Setup[4][1] = RanBool(getSurrounding(4, 1));
			Setup[1][4] = RanBool(getSurrounding(1, 4));
			Setup[5][2] = RanBool(getSurrounding(5, 2));
			Setup[2][5] = RanBool(getSurrounding(2, 5));
			Setup[4][5] = RanBool(getSurrounding(4, 5));
			Setup[5][4] = RanBool(getSurrounding(5, 4));
			System.out.println("          [" + RoomCount() + "]");
			PrintSetup();
		}
	}

	private boolean RanBool(double Percent)
	{
		return Math.random() < Percent;
	}

	private int RoomCount()
	{
		int roomCount = 0;
		for (int index = 0; index < 7; index++)
		{
			for (int index1 = 0; index1 < 7; index1++)
			{
				if (Setup[index][index1])
				{
					roomCount++;
				}
			}
		}
		return roomCount;
	}

	private void PrintSetup()
	{
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■");
		for (int index = 0; index < 7; index++)
		{
			System.out.print("¦");
			for (int index1 = 0; index1 < 7; index1++)
			{
				if (Setup[index][index1])
				{
					System.out.print("[■]");
				}
				else
				{
					System.out.print(" ● ");
				}
			}
			System.out.println("¦");
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■");
	}

	private double getSurrounding(int index, int index1)
	{
		double roomCount = 0;
		if (Setup[index + 1][index1])
		{
			roomCount = roomCount + .25;
		}
		if (Setup[index - 1][index1])
		{
			roomCount = roomCount + .25;
		}
		if (Setup[index][index1 + 1])
		{
			roomCount = roomCount + .25;
		}
		if (Setup[index][index1 - 1])
		{
			roomCount = roomCount + .25;
		}
		return roomCount;
	}
}