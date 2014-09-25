package model;

public class Rooms
{
	private int GenMin = 0;
	private int GenMax = 15;
	private int GenCent = 7;
	double RoomChance1 = .50;
	double RoomChance2 = .25;
	int MaxRooms = (int) Math.round(Math.pow(GenMax - GenMin, 2) * .35);
	int MinRooms = (int) Math.round(Math.pow(GenMax - GenMin, 2) * .25);
	public boolean[][] Setup = new boolean[GenMax][GenMax];

	public Rooms()
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

	private boolean getSurrounding(int index, int index1)
	{
		int roomCount = 0;
		double percent = 0;
		if (index != GenMax - 1)
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
		if (index1 != GenMax - 1)
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

	public int getGenMin()
	{
		return GenMin;
	}

	public void setGenMin(int genMin)
	{
		GenMin = genMin;
	}

	public int getGenMax()
	{
		return GenMax;
	}

	public void setGenMax(int genMax)
	{
		GenMax = genMax;
	}

	public boolean[][] getSetup()
	{
		return Setup;
	}

	public void setSetup(boolean[][] setup)
	{
		Setup = setup;
	}

	public int getGenCent()
	{
		return GenCent;
	}

	public void setGenCent(int genCent)
	{
		GenCent = genCent;
	}
}
