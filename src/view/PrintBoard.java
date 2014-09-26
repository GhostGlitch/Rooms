package view;

import model.Setup;

/**
 * Outputs either the Setup or the Board to the Console
 * 
 * @author GhostGlitch
 * @see Setup
 * @see Board
 */
public class PrintBoard
{
	/**
	 * Prints the new Setup
	 * 
	 * @param currentSetup
	 *            a Rooms object to get the currentSetup
	 */
	public void PrintSetup(Setup currentSetup)
	{
		for (int i = currentSetup.getGenMin(); i <= (currentSetup.getGenMax() * 1.5) - 2; i++)
		{
			System.out.print(" ");
		}
		System.out.println("[" + currentSetup.RoomCount() + "]");
		for (int i = currentSetup.getGenMin(); i <= (currentSetup.getGenMax() * 3) + 1; i++)
		{
			System.out.print("■");
		}
		System.out.println();
		for (int index = currentSetup.getGenMin(); index < currentSetup.getGenMax(); index++)
		{
			System.out.print("¦");
			for (int index1 = currentSetup.getGenMin(); index1 < currentSetup.getGenMax(); index1++)
			{
				if (currentSetup.getSetup()[index][index1])
				{
					if (index == currentSetup.getGenCent() && index1 == currentSetup.getGenCent())
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
		for (int i = currentSetup.getGenMin(); i <= (currentSetup.getGenMax() * 3) + 1; i++)
		{
			System.out.print("■");
		}
	}
}
