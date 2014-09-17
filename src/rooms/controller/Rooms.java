package rooms.controller;

public class Rooms
{
	boolean[][] Setup = new boolean[7][7];

	public void RoomSetup()
	{
		while (RoomCount() < 16)
		{
			for (int index = 0; index < 7; index++)
			{
				for (int index1 = 0; index1 < 7; index1++)
				{
					Setup[index][index1] = false;
				}
			}
			Setup[3][3] = true;
			Setup[2][3] = RanBool(.75);
			Setup[4][3] = RanBool(.75);
			Setup[3][2] = RanBool(.75);
			Setup[3][4] = RanBool(.75);
			Setup[5][3] = RanBool(getSurrounding(5, 3));
			Setup[1][3] = RanBool(getSurrounding(1, 3));
			Setup[6][3] = RanBool(getSurrounding(6, 3));
			Setup[0][3] = RanBool(getSurrounding(0, 3));
			Setup[3][5] = RanBool(getSurrounding(3, 5));
			Setup[3][1] = RanBool(getSurrounding(3, 1));
			Setup[3][6] = RanBool(getSurrounding(3, 6));
			Setup[3][0] = RanBool(getSurrounding(3, 0));
			Setup[4][2] = RanBool(getSurrounding(4, 2));
			Setup[5][2] = RanBool(getSurrounding(5, 2));
			Setup[6][2] = RanBool(getSurrounding(6, 2));
			Setup[2][2] = RanBool(getSurrounding(2, 2));
			Setup[1][2] = RanBool(getSurrounding(1, 2));
			Setup[0][2] = RanBool(getSurrounding(0, 2));
			Setup[4][4] = RanBool(getSurrounding(4, 4));
			Setup[5][4] = RanBool(getSurrounding(5, 4));
			Setup[6][4] = RanBool(getSurrounding(6, 4));
			Setup[2][4] = RanBool(getSurrounding(2, 4));
			Setup[1][4] = RanBool(getSurrounding(1, 4));
			Setup[0][4] = RanBool(getSurrounding(0, 4));
			Setup[2][5] = RanBool(getSurrounding(2, 5));
			Setup[2][6] = RanBool(getSurrounding(2, 6));
			Setup[2][1] = RanBool(getSurrounding(2, 1));
			Setup[2][0] = RanBool(getSurrounding(2, 0));
			Setup[4][5] = RanBool(getSurrounding(4, 5));
			Setup[4][6] = RanBool(getSurrounding(4, 6));
			Setup[4][1] = RanBool(getSurrounding(4, 1));
			Setup[4][0] = RanBool(getSurrounding(4, 0));
			Setup[1][1] = RanBool(getSurrounding(1, 1));
			Setup[1][0] = RanBool(getSurrounding(1, 0));
			Setup[0][1] = RanBool(getSurrounding(0, 1));
			Setup[0][0] = RanBool(getSurrounding(0, 0));
			Setup[1][5] = RanBool(getSurrounding(1, 5));
			Setup[1][6] = RanBool(getSurrounding(1, 6));
			Setup[0][5] = RanBool(getSurrounding(0, 5));
			Setup[0][6] = RanBool(getSurrounding(0, 6));
			Setup[5][1] = RanBool(getSurrounding(5, 1));
			Setup[6][1] = RanBool(getSurrounding(6, 1));
			Setup[5][0] = RanBool(getSurrounding(5, 0));
			Setup[6][0] = RanBool(getSurrounding(6, 0));
			Setup[5][5] = RanBool(getSurrounding(5, 5));
			Setup[5][6] = RanBool(getSurrounding(5, 6));
			Setup[6][5] = RanBool(getSurrounding(6, 5));
			Setup[6][6] = RanBool(getSurrounding(6, 6));
			System.out.println("          [" + RoomCount() + "]");
			PrintSetup();
		}
		System.out.println("          [" + RoomCount() + "]");
		PrintSetup();
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
		if (index != 6)
		{
			if (Setup[index + 1][index1])
			{
				roomCount = roomCount + .25;
			}
		}
		if (index != 0)
		{
			if (Setup[index - 1][index1])
			{
				roomCount = roomCount + .25;
			}
		}
		if (index1 != 6)
		{
			if (Setup[index][index1 + 1])
			{
				roomCount = roomCount + .25;
			}
		}
		if (index1 != 0)
		{
			if (Setup[index][index1 - 1])
			{
				roomCount = roomCount + .25;
			}
		}
		return roomCount;
	}
}
