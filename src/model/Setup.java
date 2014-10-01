package model;

import java.util.Random;

import controller.Controller;

/**
 * Generates where the rooms are
 * 
 * @authors GhostGlitch & Narpas-Sword
 */
public class Setup
{
	Controller controller = new Controller();
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
	double RoomChance1 = .25;
	/**
	 * The Chance a room has to generate if it has 2 room adjacent to it.
	 */
	double RoomChance2 = .025;
	/**
	 * The Chance a room has to generate if it has 3 room adjacent to it.
	 */
	double RoomChance3 = .0125;
	/**
	 * The Chance a room has to generate if it has 4 room adjacent to it.
	 */
	double RoomChance4 = .00005;
	/**
	 * The most rooms allowed to generate.
	 */
	int MaxRooms = (int) Math.round(Math.pow(GenMax - GenMin, 2) * .50);
	/**
	 * The least rooms allowed to generate.
	 */
	int MinRooms = (int) Math.round(Math.pow(GenMax - GenMin, 2) * .30);
	/**
	 * Where rooms are and aren't.
	 */
	boolean[][] Setup = new boolean[GenMax][GenMax];
	/**
	 * A dummy of Setup
	 * 
	 * @see Setup
	 */
	boolean[][] Dummy = new boolean[GenMax][GenMax];

	/**
	 * Generates a new setup of rooms.
	 */
	public Setup()
	{
		Setup[GenCent][GenCent] = true;
		Dummy[GenCent][GenCent] = true;
		while (RoomCount() < MinRooms || RoomCount() > MaxRooms)
		{
			while (RoomCount() < MinRooms)
			{
				for (int index = GenMin; index < GenMax; index++)
				{

					for (int index1 = GenMin; index1 < GenMax; index1++)
					{

						if (!(Setup[index][index1]))
						{
							Dummy[index][index1] = getSurroundingBool(index, index1);
						}
					}
				}
				for (int index = GenMin; index < GenMax; index++)
				{
					for (int index1 = GenMin; index1 < GenMax; index1++)
					{
						Setup[index][index1] = Dummy[index][index1];
					}
				}
			}
			while (RoomCount() > MaxRooms)
			{
				int index = RanInt();
				int index1 = RanInt();
				if (controller.EdgeTest(this, index, index1))
				{
						Dummy[index][index1] = false;
						Setup[index][index1] = false;
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
	private boolean getSurroundingBool(int index, int index1)
	{
		int roomCount = 0;
		double percent = 0;
		if (index < GenMax - 1)
		{
			if (Setup[index + 1][index1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index > GenMin)
		{
			if (Setup[index - 1][index1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index1 < GenMax - 1)
		{
			if (Setup[index][index1 + 1])
			{
				roomCount = roomCount + 1;
			}
		}
		if (index1 > GenMin)
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
		else if (roomCount == 3)
		{
			percent = RoomChance3;
		}
		else if (roomCount == 4)
		{
			percent = RoomChance4;
		}
		else
		{
			percent = 0;
		}
		return Math.random() < percent;
	}

	private int RanInt()
	{
		Random rand = new Random();
		return rand.nextInt((GenMax - GenMin)) + GenMin;
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
	}
}