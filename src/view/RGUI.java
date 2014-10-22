package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RGUI
{
	public String Room = "Map/TempRoom.png";
	public String Empty = "Map/TempEmpty.png";
	public String Horizontal = "Map/TempHorizontal.png";
	public String Vertical = "Map/TempVertical.png";
	public String TopLeft = "Map/TempTopLeft.png";
	public String TopRight = "Map/TempTopRight.png";
	public String BottomLeft = "Map/TempBottomLeft.png";
	public String BottomRight = "Map/TempBottomRight.png";
	public String VSpace = "Other/VerticalSpacer.png";
	public String HSpace = "Other/HorizontalSpacer.png";
	public int scale = 15;

	public JLabel LoadBigImgLbl(String location)
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
		return new JLabel(new ImageIcon(img.getScaledInstance(img.getWidth() * scale, img.getHeight() * scale, Image.SCALE_SMOOTH)));
	}
}
