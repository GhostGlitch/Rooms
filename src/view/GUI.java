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

public class GUI
{
	String Room = "Map/TempRoom.png";
	String Empty = "Map/TempEmpty.png";
	String Horizontal = "Map/TempHorizontal.png";
	String Vertical = "Map/TempVertical.png";
	String TopLeft = "Map/TempTopLeft.png";
	String TopRight = "Map/TempTopRight.png";
	String BottomLeft = "Map/TempBottomLeft.png";
	String BottomRight = "Map/TempBottomRight.png";
	String VSpace = "Other/VerticalSpacer.png";
	String HSpace = "Other/HorizontalSpacer.png";
	JPanel mapPanel = new JPanel();
	JPanel VertBox = new JPanel();
	JPanel InputBox = new JPanel();
	JPanel BottomSpace = new JPanel();
	JFrame frame = new JFrame("Rooms");
	public void PrintBoardPopup(Setup setup, Board board)
	{
		mapPanel.setLayout(new GridLayout(0, setup.getGenMax() + 2));
		VertBox.setLayout(new BoxLayout(VertBox, BoxLayout.Y_AXIS));
		InputBox.setLayout(new BoxLayout(InputBox, BoxLayout.X_AXIS));
		BottomSpace.setLayout(new BoxLayout(BottomSpace, BoxLayout.X_AXIS));
		// frame.setResizable(false);
		for (int i = setup.getGenMin(); i <= setup.getGenMax() + 1; i++)
		{
			if (i == setup.getGenMin())
			{
				mapPanel.add(LoadBigImg(TopLeft));
			}
			else if (i == setup.getGenMax() + 1)
			{
				mapPanel.add(LoadBigImg(TopRight));
			}
			else
			{
				mapPanel.add(LoadBigImg(Horizontal));
			}
		}
		for (int index = setup.getGenMin(); index < setup.getGenMax(); index++)
		{
			mapPanel.add(LoadBigImg(Vertical));
			for (int index1 = setup.getGenMin(); index1 < setup.getGenMax(); index1++)
			{
				if (setup.get()[index][index1])
				{
					if (index == setup.getGenCent() && index1 == setup.getGenCent())
					{
						mapPanel.add(LoadBigImg(Room));
					}
					else
					{
						mapPanel.add(LoadBigImg(Room));
					}
				}
				else
				{
					mapPanel.add(LoadBigImg(Empty));
				}
			}
			mapPanel.add(LoadBigImg(Vertical));
		}
		for (int i = setup.getGenMin(); i <= setup.getGenMax() + 1; i++)
		{
			if (i == setup.getGenMin())
			{
				mapPanel.add(LoadBigImg(BottomLeft));
				BottomSpace.add(LoadBigImg(HSpace));
			}
			else if (i == setup.getGenMax() + 1)
			{
				mapPanel.add(LoadBigImg(BottomRight));
				BottomSpace.add(LoadBigImg(HSpace));
			}
			else
			{
				mapPanel.add(LoadBigImg(Horizontal));
				BottomSpace.add(LoadBigImg(HSpace));
			}
		}
		VertBox.add(mapPanel);
		final JTextField input = new JTextField();
		Font font = new Font("Arial", Font.PLAIN, 48);
		input.setFont(font);
		input.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				input.setText("");
			}
		});
		InputBox.add(LoadBigImg(VSpace));
		InputBox.add(input);
		InputBox.add(LoadBigImg(VSpace));
		VertBox.add(InputBox);
		VertBox.add(BottomSpace);
		frame.getContentPane().add(VertBox);
		frame.pack();
		frame.setVisible(true);
	}

	JLabel LoadBigImg(String location)
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
		return new JLabel(new ImageIcon(img.getScaledInstance(img.getWidth() * 20, img.getHeight() * 20, Image.SCALE_SMOOTH)));
	}

	JLabel LoadBigImg1(String location)
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
		return new JLabel(new ImageIcon(img.getScaledInstance(img.getWidth() * 20, (img.getHeight() * 20) + 2, Image.SCALE_SMOOTH)));
	}
}
