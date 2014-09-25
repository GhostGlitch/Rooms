package rooms.model;

public class Rooms
{
	int GenMin = 0;
	int GenMax = 15;
	int GenCent = 7;
	double RoomChance1 = .50;
	double RoomChance2 = .25;
	int MaxRooms = (int) Math.round(Math.pow(GenMax - GenMin, 2) * .35);
	int MinRooms = (int) Math.round(Math.pow(GenMax - GenMin, 2) * .25);
	public boolean[][] Setup = new boolean[GenMax][GenMax];

	public void RoomSetup()
	{
		while (RoomCount() < MinRooms || RoomCount() > MaxRooms)
		{
			for (int index = GenMin; index < GenMax; index++)
			{
				for (int index1 = GenMin; index1 < GenMax; index1++)
				{
					Setup[index][index1] = false;
				}
			}
			Setup[GenCent][GenCent] = true;
			for (int index = GenCent; index < GenMax; index++)
			{
				for (int index1 = GenCent; index1 < GenMax; index1++)
				{
					if (!(index == GenCent && index1 == GenCent))
					{
						Setup[index1][index] = getSurrounding(index1, index);
					}
				}
			}
			for (int index = GenCent; index >= GenMin; index--)
			{
				for (int index1 = GenCent; index1 >= GenMin; index1--)
				{
					if (!(index == GenCent && index1 == GenCent))
					{
						Setup[index1][index] = getSurrounding(index1, index);
					}
				}
			}
			for (int index = GenCent - 1; index >= GenMin; index--)
			{
				for (int index1 = GenCent + 1; index1 < GenMax; index1++)
				{
					if (!(index == GenCent && index1 == GenCent))
					{
						Setup[index1][index] = getSurrounding(index1, index);
					}
				}
			}
			for (int index = GenCent + 1; index < GenMax; index++)
			{
				for (int index1 = GenCent - 1; index1 >= GenMin; index1--)
				{
					if (!(index == GenCent && index1 == GenCent))
					{
						Setup[index1][index] = getSurrounding(index1, index);
					}
				}
			}
		}
		System.out.println("[" + RoomCount() + "]");
		PrintSetup();
	}

	private int RoomCount()
	{
		int roomCount = 0;
		for (int index = GenMin; index < GenMax; index++)
		{
			for (int index1 = GenMin; index1 < GenMax; index1++)
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
		for (int i = GenMin; i <= (GenMax * 3) + 1; i++)
		{
			System.out.print("■");
		}
		System.out.println();
		for (int index = GenMin; index < GenMax; index++)
		{
			System.out.print("¦");
			for (int index1 = GenMin; index1 < GenMax; index1++)
			{
				if (Setup[index][index1])
				{
					if (index == GenCent && index1 == GenCent)
					{
						System.out.print("[O]");
					}
					else
					{
						System.out.print("[■]");
					}
				}
				else
				{
					System.out.print(" ● ");
				}
			}
			System.out.println("¦");
		}
		for (int i = GenMin; i <= (GenMax * 3) + 1; i++)
		{
			System.out.print("■");
		}
	}

	private boolean getSurrounding(int index, int index1)
	{
		int roomCount = 0;
		double percent = 0;
		if (index != GenMax-1)
		{
			if (Setup[index + 1][index1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index != GenMin)
		{
			if (Setup[index - 1][index1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index1 != GenMax-1)
		{
			if (Setup[index][index1 + 1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index1 != GenMin)
		{
			if (Setup[index][index1 - 1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (roomCount == 1)
		{
			percent = RoomChance1;
		}
		else if (roomCount == 2)
		{
			percent = RoomChance2;
		}
		return Math.random() < percent;
	}
}
