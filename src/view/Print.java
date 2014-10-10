package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		BufferedImage img = LoadImage("Map/TempRoom.png");
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(0, setup.getGenMax() + 2));
		JPanel boxPanel = new JPanel();
		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
		for (int i = setup.getGenMin(); i <= setup.getGenMax() + 1; i++)
		{
			if (i == setup.getGenMin())
			{
				gridPanel.add(BigImgLbl("Map/TempTopLeft.png"));
			}
			else if (i == setup.getGenMax() + 1)
			{
				gridPanel.add(BigImgLbl("Map/TempTopRight.png"));
			}
			else
			{
				gridPanel.add(BigImgLbl("Map/TempHorizontal.png"));
			}
		}
		for (int index = setup.getGenMin(); index < setup.getGenMax(); index++)
		{
			gridPanel.add(BigImgLbl("Map/TempVertical.png"));
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (setup.get()[index][index1])
				{
					if (index == setup.getGenCent() && index1 == setup.getGenCent())
					{
						gridPanel.add(BigImgLbl("Map/TempRoom.png"));
					}
					else
					{
						gridPanel.add(BigImgLbl("Map/TempRoom.png"));
					}
				}
				else
				{
					gridPanel.add(BigImgLbl("Map/TempEmpty.png"));
				}
			}
			gridPanel.add(BigImgLbl("Map/TempVertical.png"));
		}
		for (int i = setup.getGenMin(); i <= setup.getGenMax() + 1; i++)
		{
			if (i == setup.getGenMin())
			{
				gridPanel.add(BigImgLbl("Map/TempBottomLeft.png"));
			}
			else if (i == setup.getGenMax() + 1)
			{
				gridPanel.add(BigImgLbl("Map/TempBottomRight.png"));
			}
			else
			{
				gridPanel.add(BigImgLbl("Map/TempHorizontal.png"));
			}
		}
		boxPanel.add(gridPanel);
		final JTextField input = new JTextField();
		Font font = new Font("Arial", Font.PLAIN, 50);
		input.setFont(font);
		input.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				input.setText("");
			}
		});
		boxPanel.add(input);
		JFrame frame = new JFrame("map");
		frame.setResizable(false);
		frame.getContentPane().add(boxPanel);
		frame.pack();
		frame.setVisible(true);
	}

	Image Resize(BufferedImage img, int amount)
	{
		Image resized = img.getScaledInstance(img.getWidth() * amount, img.getWidth() * amount, Image.SCALE_SMOOTH);
		return resized;
	}

	BufferedImage LoadImage(String location)
	{
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(new File("images/" + location));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return img;
	}

	JLabel BigImgLbl(String location)
	{
		return new JLabel(new ImageIcon(Resize(LoadImage(location), 15)));
	}
}