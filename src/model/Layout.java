package model;

import java.util.Random;

import controller.Controller;

/**
 * Generates where the rooms are.
 * 
 * @authors GhostGlitch & Narpas-Sword
 */
public class Layout
{
	/**
	 * The lowest value a room is allowed to generate at. Must be greater than
	 * 0.
	 */
	private int genMin = 0;
	/**
	 * The highest value a room is allowed to generate at. Must be greater than
	 * genMin.
	 */
	private int genMax = 15;
	/**
	 * The X and Y coordinates of the start room.
	 */
	private int genCent = 7;
	/**
	 * The Chance a room has to generate if it has 1 room adjacent to it.
	 */
	private double roomChance1 = .25;
	/**
	 * The Chance a room has to generate if it has 2 room adjacent to it.
	 */
	private double roomChance2 = .025;
	/**
	 * The Chance a room has to generate if it has 3 room adjacent to it.
	 */
	private double roomChance3 = .0125;
	/**
	 * The Chance a room has to generate if it has 4 room adjacent to it.
	 */
	private double roomChance4 = .00005;
	/**
	 * The minimum percent of rooms possible
	 */
	private double minRmPercent = 0.25;
	/**.0
	 * The maximum percent of rooms possible
	 */
	private double maxRmPercent = 0.40;
	/**
	 * Random number in the range of possible room amounts
	 */
	private double ranRoomAmount = RanDouble(minRmPercent, maxRmPercent);
	/**
	 * The least rooms allowed to generate.
	 */
	private int minRooms = (int) Math.round(Math.pow(genMax - genMin, 2) * ranRoomAmount);
	/**
	 * The most rooms allowed to generate.
	 */
	private int maxRooms = minRooms + 1;
	/**
	 * Where rooms are
	 */
	private boolean[][] layout = new boolean[genMax][genMax];
	/**
	 * A dummy of Layout
	 * 
	 * @see Layout
	 */
	private boolean[][] dummy = new boolean[genMax][genMax];

	private double RanDouble(double min, double max)
	{
		Random rand = new Random();
		return min + (max - min) * rand.nextDouble();
	}

	/**
	 * Generates a new layout of rooms.
	 */
	public Layout()
	{
		layout[genCent][genCent] = true;
		dummy[genCent][genCent] = true;
		while (RoomCount() < minRooms || RoomCount() > maxRooms)
		{
			while (RoomCount() < minRooms)
			{
				for (int index = genMin; index < genMax; index++)
				{

					for (int index1 = genMin; index1 < genMax; index1++)
					{

						if (!(layout[index][index1]))
						{
							dummy[index][index1] = getSurrounding(index, index1);
						}
					}
				}
				for (int index = genMin; index < genMax; index++)
				{
					for (int index1 = genMin; index1 < genMax; index1++)
					{
						layout[index][index1] = dummy[index][index1];
					}
				}
			}
			while (RoomCount() > maxRooms)
			{
				int index = RanInt();
				int index1 = RanInt();
				if (testEdge(index, index1))
				{
					dummy[index][index1] = false;
					layout[index][index1] = false;
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
		for (int index = genMin; index < genMax; index++)
		{
			for (int index1 = genMin; index1 < genMax; index1++)
			{
				if (layout[index][index1])
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
	 * @return if the room may be set
	 */
	private boolean getSurrounding(int index, int index1)
	{
		int roomNum = 0;
		double percent = 0;
		if (index < genMax - 1)
		{
			if (layout[index + 1][index1])
			{
				roomNum = roomNum + 1;
			}
		}
		if (index > genMin)
		{
			if (layout[index - 1][index1])
			{
				roomNum = roomNum + 1;
			}
		}
		if (index1 < genMax - 1)
		{
			if (layout[index][index1 + 1])
			{
				roomNum = roomNum + 1;
			}
		}
		if (index1 > genMin)
		{
			if (layout[index][index1 - 1])
			{
				roomNum = roomNum + 1;
			}
		}
		if (roomNum == 1)
		{
			percent = roomChance1;
		}
		else if (roomNum == 2)
		{
			percent = roomChance2;
		}
		else if (roomNum == 3)
		{
			percent = roomChance3;
		}
		else if (roomNum == 4)
		{
			percent = roomChance4;
		}
		else
		{
			percent = 0;
		}
		return Math.random() < percent;
	}

	/**
	 * creates a random Integer between genMin and genMax
	 * 
	 * @return random Integer between genMin and genMax
	 */
	int RanInt()
	{
		Random rand = new Random();
		return rand.nextInt((genMax - genMin)) + genMin;
	}

	/**
	 * Checks if any room is an edge.
	 * 
	 * @param index
	 *            the first part of a room's coordinates.
	 * @param index1
	 *            the second part of a room's coordinates.
	 * @return if the room is an edge
	 */
	public boolean testEdge(int index, int index1)
	{
		boolean isEdge = false;
		if (layout[index][index1] && !(index == genCent && index1 == genCent))
		{
			if (index != genMin && index1 != genMin
					&& (index == genMax - 1 || !layout[index + 1][index1])
					&& (index1 == genMax - 1 || !layout[index][index1 + 1])
					&& layout[index - 1][index1 - 1] && layout[index - 1][index1] && layout[index][index1 - 1])
				isEdge = true;
			else if (index != genMin && index1 != genMax - 1
					&& (index == genMax - 1 || !layout[index + 1][index1])
					&& (index1 == genMin || !layout[index][index1 - 1])
					&& layout[index - 1][index1 + 1] && layout[index - 1][index1] && layout[index][index1 + 1])
				isEdge = true;
			else if (index != genMax - 1 && index1 != genMin
					&& (index == genMin || !layout[index - 1][index1])
					&& (index1 == genMax - 1 || !layout[index][index1 + 1])
					&& layout[index + 1][index1 - 1] && layout[index + 1][index1] && layout[index][index1 - 1])
				isEdge = true;
			else if (index != genMax - 1 && index1 != genMax - 1
					&& (index == genMin || !layout[index - 1][index1])
					&& (index1 == genMin || !layout[index][index1 - 1])
					&& layout[index + 1][index1 + 1] && layout[index + 1][index1] && layout[index][index1 + 1])
				isEdge = true;
			else if ((index != genMax - 1 && layout[index + 1][index1])
					&& (index == genMin || !layout[index - 1][index1])
					&& (index1 == genMax - 1 || !layout[index][index1 + 1])
					&& (index1 == genMin || !layout[index][index1 - 1]))
				isEdge = true;
			else if ((index == genMax - 1 || !layout[index + 1][index1])
					&& (index != genMin && layout[index - 1][index1])
					&& (index1 == genMax - 1 || !layout[index][index1 + 1])
					&& (index1 == genMin || !layout[index][index1 - 1]))
				isEdge = true;
			else if ((index == genMax - 1 || !layout[index + 1][index1])
					&& (index == genMin || !layout[index - 1][index1])
					&& (index1 != genMax - 1 && layout[index][index1 + 1])
					&& (index1 == genMin || !layout[index][index1 - 1]))
				isEdge = true;
			else if ((index == genMax - 1 || !layout[index + 1][index1])
					&& (index == genMin || !layout[index - 1][index1])
					&& (index1 == genMax - 1 || !layout[index][index1 + 1])
					&& (index1 != genMin && layout[index][index1 - 1]))
				isEdge = true;
			else if (index != genMin && index1 != genMin && index != genMax - 1 && index1 != genMax - 1 && !layout[index + 1][index1] && layout[index - 1][index1 - 1]
					&& layout[index - 1][index1] && layout[index][index1 - 1] && layout[index - 1][index1 + 1] && layout[index][index1 + 1])
				isEdge = true;
			else if (index != genMin && index1 != genMin && index != genMax - 1 && index1 != genMax - 1 && !layout[index - 1][index1] && layout[index + 1][index1 + 1]
					&& layout[index + 1][index1] && layout[index][index1 + 1] && layout[index + 1][index1 - 1] && layout[index][index1 - 1])
				isEdge = true;
			else if (index != genMin && index1 != genMin && index != genMax - 1 && index1 != genMax - 1 && !layout[index][index1 - 1] && layout[index + 1][index1 + 1]
					&& layout[index + 1][index1] && layout[index][index1 + 1] && layout[index - 1][index1 + 1] && layout[index - 1][index1])
				isEdge = true;
			else if (index != genMin && index1 != genMin && index != genMax - 1 && index1 != genMax - 1 && !layout[index][index1 + 1] && layout[index - 1][index1 - 1]
					&& layout[index - 1][index1] && layout[index][index1 - 1] && layout[index + 1][index1 - 1] && layout[index + 1][index1])
				isEdge = true;
		}
		return isEdge;
	}

	/**
	 * Getter for genMin
	 * 
	 * @return genMin
	 */
	public int getGenMin()
	{
		return genMin;
	}

	/**
	 * Getter for genMax
	 * 
	 * @return genMax
	 */
	public int getGenMax()
	{
		return genMax;
	}

	/**
	 * Getter for Layout
	 * 
	 * @return Layout
	 */
	public boolean[][] get()
	{
		return layout;
	}

	/**
	 * Getter for genCent
	 * 
	 * @return genCent
	 */
	public int getGenCent()
	{
		return genCent;
	}
}