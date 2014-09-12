package rooms.controller;

public class Rooms
{
	public void RoomSetup()
	{
		boolean[][] Setup = new boolean[7][7];
		System.out.println();
		Setup[3][3] = true;
		for (int index = 0; index < 7; index++)
		{
			for (int index1 = 0; index1 < 7; index1++)
			{
				System.out.print(Setup[index][index1] + " ");
				if (Setup[index][index1])
				{
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
	private boolean RandomBoolean(int Percent)
	{
		return Math.Random < Percent;
	}
}