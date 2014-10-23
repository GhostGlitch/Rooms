package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Images
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
	private int scaleBy = 15;

	public JLabel loadTile1(String location)
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
		return new JLabel(new ImageIcon(img.getScaledInstance(img.getWidth() * scaleBy, img.getHeight() * scaleBy, Image.SCALE_SMOOTH)));
	}

	public JLabel loadTile(String location)
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
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		BufferedImage newimg = gc.createCompatibleImage(img.getWidth() * scaleBy, img.getHeight() * scaleBy, Transparency.TRANSLUCENT);

		// BufferedImage newimg = new BufferedImage(img.getWidth() * scaleBy,
		// img.getHeight() * scaleBy, BufferedImage.TYPE_INT_RGB);

		Graphics g = newimg.createGraphics();
		g.drawImage(img, newimg.getWidth(), newimg.getHeight(), null);
		g.dispose();
		return new JLabel(new ImageIcon(newimg));
	}

	public static BufferedImage rot(BufferedImage image, double angle)
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
		int w = image.getWidth(), h = image.getHeight();
		int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h * cos + w * sin);
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
		Graphics2D g = result.createGraphics();
		g.translate((neww - w) / 2, (newh - h) / 2);
		g.rotate(Math.toRadians(angle), w / 2, h / 2);
		g.drawRenderedImage(image, null);
		g.dispose();
		return result;
	}

	public int getScaleBy()
	{
		return scaleBy;
	}

	public void setScaleBy(int scaleBy)
	{
		this.scaleBy = scaleBy;
	}
}
