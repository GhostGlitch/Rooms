package model;

/**
 * Generates where the rooms are
 * 
 * @author GhostGlitch
 */
public class Setup
{
	/**
	 * The lowest value a room is allowed to generate at. Must be greater than
	 * 0.
	 */
	private int GenMin = 0;
	/**
	 * The highest value a room is allowed to generate at. Must be greater than
	 * GenMin.
	 */
	private int GenMax = 15;
	/**
	 * The X and Y coordinates of the start room.
	 */
	private int GenCent = 7;
	/**
	 * The Chance a room has to generate if it has 1 room adjacent to it.
	 */
	double RoomChance1 = .50;
	/**
	 * The Chance a room has to generate if it has 2 room adjacent to it.
	 */
	double RoomChance2 = .25;
	/**
	 * The most rooms allowed to generate.
	 */
	int MaxRooms = (int) Math.round(Math.pow(GenMax - GenMin, 2) * .35);
	/**
	 * The least rooms allowed to generate.
	 */
	int MinRooms = (int) Math.round(Math.pow(GenMax - GenMin, 2) * .25);
	/**
	 * Where rooms are and aren't.
	 */
	boolean[][] Setup = new boolean[GenMax][GenMax];

	/**
	 * Generates a new setup of rooms.
	 */
	public Setup()
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
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
			for (int index = GenCent; index >= GenMin; index--)
			{
				for (int index1 = GenCent; index1 >= GenMin; index1--)
				{
					if (!(index == GenCent && index1 == GenCent))
					{
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
			for (int index = GenCent - 1; index >= GenMin; index--)
			{
				for (int index1 = GenCent + 1; index1 < GenMax; index1++)
				{
					if (!(index == GenCent && index1 == GenCent))
					{
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
			for (int index = GenCent + 1; index < GenMax; index++)
			{
				for (int index1 = GenCent - 1; index1 >= GenMin; index1--)
				{
					if (!(index == GenCent && index1 == GenCent))
					{
						Setup[index][index1] = getSurrounding(index, index1);
					}
				}
			}
		}
	}

	/**
	 * Counts how many rooms have been generated.
	 * 
	 * @return the # of rooms that have been generated.
	 */
	public int RoomCount()
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

	/**
	 * Tests how many rooms are directly adjacent to a given room and decides if
	 * that room should be set.
	 * 
	 * @param index
	 *            the first part of the room's coordinates.
	 * @param index1
	 *            the second part of the room's coordinates.
	 * @return a boolean based on the adjacent rooms.
	 */
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

	/**
	 * Getter for GenMin
	 * 
	 * @return GenMin
	 */
	public int getGenMin()
	{
		return GenMin;
	}

	/**
	 * Setter for GenMin
	 * 
	 * @param genMin
	 *            the new GenMin value
	 */
	public void setGenMin(int genMin)
	{
		GenMin = genMin;
	}

	/**
	 * Getter for GenMax
	 * 
	 * @return GenMax
	 */
	public int getGenMax()
	{
		return GenMax;
	}

	/**
	 * Setter for GenMax
	 * 
	 * @param genMax
	 *            the new value for GenMax
	 */
	public void setGenMax(int genMax)
	{
		GenMax = genMax;
	}

	/**
	 * Getter for Setup
	 * 
	 * @return Setup
	 */
	public boolean[][] get()
	{
		return Setup;
	}

	/**
	 * Setter for array Setup
	 * 
	 * @param setup
	 *            new value for Setup
	 */
	public void setSetup(boolean[][] setup)
	{
		Setup = setup;
	}

	/**
	 * Getter for GenCent
	 * 
	 * @return GenCent
	 */
	public int getGenCent()
	{
		return GenCent;
	}

	/**
	 * Setter for GenCent
	 * 
	 * @param genCent
	 *            the new value for GenCent
	 */
	public void setGenCent(int genCent)
	{
		GenCent = genCent;
	}}
