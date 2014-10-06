package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Board;
import model.Setup;

/**
 * Outputs either the Setup or the Board to the Console
 * 
 * @author GhostGlitch
 * @see Setup
 * @see Board
 */
public class Print
{
	/**
	 * Prints the new Setup
	 * 
	 * @param setup
	 *            a Rooms object to get the setup
	 */
	public void PrintSetup(Setup setup)
	{
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 1.5) - 2; i++)
		{
			System.out.print(" ");
		}
		System.out.println("[" + setup.RoomCount() + "]");
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 3) + 1; i++)
		{
			System.out.print("■");
		}
		System.out.println();
		for (int index = setup.getGenMin(); index < setup.getGenMax(); index++)
		{
			System.out.print("¦");
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (setup.get()[index][index1])
				{
					if (index == setup.getGenCent() && index1 == setup.getGenCent())
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
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 3) + 1; i++)
		{
			System.out.print("■");
		}
		System.out.println();
	}

	public void PrintSetupSimple(Setup setup)
	{
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 1.5) - 2; i++)
		{
			System.out.print(" ");
		}
		System.out.println("[" + setup.RoomCount() + "]");
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 3) + 1; i++)
		{
			System.out.print("■");
		}
		System.out.println();
		for (int index = setup.getGenMin(); index < setup.getGenMax(); index++)
		{
			System.out.print("¦");
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (setup.get()[index][index1])
				{
					if (index == setup.getGenCent() && index1 == setup.getGenCent())
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
					System.out.print("   ");
				}
			}
			System.out.println("¦");
		}
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 3) + 1; i++)
		{
			System.out.print("■");
		}
		System.out.println();
	}

	public void PrintBoardSimple(Setup setup, Board board)
	{
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 1.5) - 2; i++)
		{
			System.out.print(" ");
		}
		System.out.println("[" + setup.RoomCount() + "]");
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 3) + 1; i++)
		{
			System.out.print("■");
		}
		System.out.println();
		for (int index = setup.getGenMin(); index < setup.getGenMax(); index++)
		{
			System.out.print("¦");
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (board.get()[index][index1] == 0)
				{
					if (index == setup.getGenCent() && index1 == setup.getGenCent())
					{
						System.out.print("[□]");
					}
					else
					{
						System.out.print("[■]");
					}
				}
				else if (board.get()[index][index1] > 0 && board.get()[index][index1] < 10)
				{
					System.out.print("[X]");
				}
				else if (board.get()[index][index1] % 10 == 0)
				{
					System.out.print("[O]");
				}
				else if (board.get()[index][index1] > 10)
				{
					System.out.print("[Ø]");
				}
				else
				{
					System.out.print("   ");
				}
			}
			System.out.println("¦");
		}
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 3) + 1; i++)
		{
			System.out.print("■");
		}
	}

	public void PrintBoard(Setup setup, Board board)
	{
		System.out.println();
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 3.5) - 2; i++)
		{
			System.out.print(" ");
		}
		System.out.println("[" + setup.RoomCount() + "]");
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 7) + 1; i++)
		{
			System.out.print("■");
		}
		System.out.println();
		for (int index = setup.getGenMin(); index < setup.getGenMax(); index++)
		{
			System.out.print("|");
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (board.get()[index][index1] == 0)
				{
					if (index == setup.getGenCent() && index1 == setup.getGenCent())
					{
						System.out.print("| □▬□ |");
					}
					else
					{
						System.out.print("|■■■■■|");
					}
				}
				else if (board.get()[index][index1] == -1)
				{
					System.out.print("       ");
				}
				else if (board.get()[index][index1] < 10)
				{
					System.out.print("|T" + board.get()[index][index1] + "■■■|");
				}
				else if (board.get()[index][index1] % 10 == 0)
				{
					System.out.print("|■■■B" + board.get()[index][index1] / 10 + "|");
				}
				else if (board.get()[index][index1] > 10)
				{
					System.out.print("|T" + board.get()[index][index1] % 10 + " " + "B" + board.get()[index][index1] / 10 + "|");
				}
			}
			System.out.println("|");
			System.out.print("|");
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (board.get()[index][index1] == 0)
				{
					if (index == setup.getGenCent() && index1 == setup.getGenCent())
					{
						System.out.print("|■■■■■|");
					}
					else
					{
						System.out.print("|■■■■■|");
					}
				}
				else if (board.get()[index][index1] == -1)
				{
					System.out.print("       ");
				}
				else if (board.get()[index][index1] < 10)
				{
					System.out.print("|■■■■■|");
				}
				else if (board.get()[index][index1] % 10 == 0)
				{
					System.out.print("|■■■■■|");
				}
				else if (board.get()[index][index1] > 10)
				{
					System.out.print("|■■■■■|");
				}
			}
			System.out.println("|");
			for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 7) + 1; i++)
			{
				System.out.print("■");
			}
			System.out.println();
		}
	}
	public void PrintBoardPopup(Setup setup, Board board)
	{
		String Map = "<html>";
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 1.5) - 2; i++)
		{
			Map = Map + "  ";
		}
		Map = Map + "[" + setup.RoomCount() + "]<br>";
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 3) + 1; i++)
		{
			Map = Map + "■";
		}
		Map = Map + "<br>";
		for (int index = setup.getGenMin(); index < setup.getGenMax(); index++)
		{
			Map = Map + "¦";
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (setup.get()[index][index1])
				{
					if (index == setup.getGenCent() && index1 == setup.getGenCent())
					{
						Map = Map + "[O]";
					}
					else
					{
						Map = Map + "[■]";
					}
				}
				else
				{
					Map = Map + "      ";
				}
			}
			Map = Map + "¦<br>";
		}
		for (int i = setup.getGenMin(); i <= (setup.getGenMax() * 3) + 1; i++)
		{
			Map = Map + "■";
		}
		Map = Map + "<br>";
		Map = Map + "<html>";
		System.out.print(Map);
		JLabel Label = new JLabel(Map);
	    Label.setFont(new Font("Courier New", Font.PLAIN, 12));
		JOptionPane.showMessageDialog(null, Label);
	}
}