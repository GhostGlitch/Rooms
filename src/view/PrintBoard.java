package view;

import model.Rooms;
/**
 * 
 * @author trob1932
 *
 */
public class PrintBoard
{
	public void PrintSetup(Rooms var)
	{
		for (int i = var.getGenMin(); i <= (var.getGenMax() * 3) + 1; i++)
		{
			System.out.print("■");
		}
		System.out.println();
		for (int index = var.getGenMin(); index < var.getGenMax(); index++)
		{
			System.out.print("¦");
			for (int index1 = var.getGenMin(); index1 < var.getGenMax(); index1++)
			{
				if (var.getSetup()[index][index1])
				{
					if (index == var.getGenCent() && index1 == var.getGenCent())
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
		for (int i = var.getGenMin(); i <= (var.getGenMax() * 3) + 1; i++)
		{
			System.out.print("■");
		}
	}

}
