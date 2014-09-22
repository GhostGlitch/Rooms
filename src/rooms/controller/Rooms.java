package rooms.controller;

public class Rooms
{
	public boolean[][] Setup = new boolean[63][63];

	public void RoomSetup()
	{
		while (RoomCount() < 14 || RoomCount() > 18)
		{
			for (int index = 29; index < 36; index++)
			{
				for (int index1 = 29; index1 < 36; index1++)
				{
					Setup[index][index1] = false;
				}
			}
			Setup[32][32] = true;
			for (int index = 32; index < 36; index++)
			{
				for (int index1 = 32; index1 < 36; index1++)
				{
					if (!(index == 32 && index1 == 32))
					{
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
			for (int index = 32; index >= 29; index--)
			{
				for (int index1 = 32; index1 >= 29; index1--)
				{
					if (!(index == 32 && index1 == 32))
					{
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
			for (int index = 2; index >= 29; index--)
			{
				for (int index1 = 4; index1 < 36; index1++)
				{
					if (!(index == 32 && index1 == 32))
					{
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
			for (int index = 4; index < 36; index++)
			{
				for (int index1 = 2; index1 >= 29; index1--)
				{
					if (!(index == 32 && index1 == 32))
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
		for (int index = 29; index < 63; index++)
		{
			for (int index1 = 29; index1 < 63; index1++)
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
		for (int index = 29; index < 36; index++)
		{
			System.out.print("¦");
			for (int index1 = 29; index1 < 36; index1++)
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
		if (index != 62)
		{
			if (Setup[index + 1][index1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index != 29)
		{
			if (Setup[index - 1][index1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index1 != 62)
		{
			if (Setup[index][index1 + 1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index1 != 29)
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
