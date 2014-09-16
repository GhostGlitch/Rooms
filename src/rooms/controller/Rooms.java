package rooms.controller;

public class Rooms
{
	boolean[][] Setup = new boolean[7][7];

	public void RoomSetup()
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
		PrintSetup();
		thing();
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
		System.out.println("                          [" + RoomCount() + ("]"));
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
	
	private void thing()
	{
		System.out.println("                _______________________");
		for (int index = 0; index < 7; index++)
		{
			System.out.print("                |");
			for (int index1 = 0; index1 < 7; index1++)
			{
				if (index == 3 && index1 == 3)
				{
					System.out.print("[X]");
				} else if (Setup[index][index1])
				{
					System.out.print("[ ]");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println("|");
		}
	}
}