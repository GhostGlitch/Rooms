package rooms.controller;

public class Rooms
{
	public boolean[][] Setup = new boolean[7][7];

	public void RoomSetup()
	{
		while (RoomCount() < 14 || RoomCount() > 18)
		{
			for (int index = 0; index < 7; index++)
			{
				for (int index1 = 0; index1 < 7; index1++)
				{
					Setup[index][index1] = false;
				}
			}
			Setup[3][3] = true;
			for (int index = 3; index < 7; index++)
			{
				for (int index1 = 3; index1 < 7; index1++)
				{
					if (!(index == 3 && index1 == 3))
					{
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
			for (int index = 3; index >= 0; index--)
			{
				for (int index1 = 3; index1 >= 0; index1--)
				{
					if (!(index == 3 && index1 == 3))
					{
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
			for (int index = 2; index >= 0; index--)
			{
				for (int index1 = 4; index1 < 7; index1++)
				{
					if (!(index == 3 && index1 == 3))
					{
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
			for (int index = 4; index < 7; index++)
			{
				for (int index1 = 2; index1 >= 0; index1--)
				{
					if (!(index == 3 && index1 == 3))
					{
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
		}
		System.out.println("          [" + RoomCount() + "]");
		PrintSetup();
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

	private boolean getSurrounding(int index, int index1)
	{
		int roomCount = 0;
		double percent = 0;
		if (index != 6)
		{
			if (Setup[index + 1][index1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index != 0)
		{
			if (Setup[index - 1][index1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index1 != 6)
		{
			if (Setup[index][index1 + 1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index1 != 0)
		{
			if (Setup[index][index1 - 1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (roomCount == 1)
		{
			percent = .50;
		}
		else if (roomCount == 2)
		{
			percent = .25;
		}
		return Math.random() < percent;
	}
}
