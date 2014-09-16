package rooms.controller;

public class Rooms
{
	boolean[][] Setup = new boolean[7][7];
	public void RoomSetup()
	{
		System.out.println();
		Setup[3][3] = true;
		PrintSetup();
	}

	private boolean RanBool(double Percent)
	{
		return Math.random() < Percent;
	}

	private void PrintSetup()
	{
		for (int index = 0; index < 7; index++)
		{
			for (int index1 = 0; index1 < 7; index1++)
			{
				System.out.print("[" + Setup[index][index1]);
				if (Setup[index][index1])
				{
					System.out.print(" ");
				}
				System.out.print("] ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("                          ["+RoomCount()+("]"));
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
}