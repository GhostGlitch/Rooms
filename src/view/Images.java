package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Images
{
	public enum Rotation {
		QUARTER,HALF,THREE_QUARTER
	}
	static Rotation rotation;
	public static String Room = "Map/TempRoom.png";
	public static String Empty = "Map/TempEmpty.png";
	public static String Horizontal = "Map/TempHorizontal.png";
	public static String Vertical = "Map/TempVertical.png";
	public static String TopLeft = "Map/TempTopLeft.png";
	public static String TopRight = "Map/TempTopRight.png";
	public static String BottomLeft = "Map/TempBottomLeft.png";
	public static String BottomRight = "Map/TempBottomRight.png";
	public static String VSpace = "Other/VerticalSpacer.png";
	public static String HSpace = "Other/HorizontalSpacer.png";
	private static int scaleBy = 15;
	public static JLabel toLbl(BufferedImage img)
	{
		return new JLabel(new ImageIcon(img));
	}

	public static BufferedImage load(String location)
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

	public static BufferedImage scale(BufferedImage img, int scale) throws IOException
	{
		int W = img.getWidth();
		int H = img.getHeight();
		AffineTransform scaleTransform = AffineTransform.getScaleInstance(scale, scale);
		AffineTransformOp scaleAffline = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return scaleAffline.filter(img, new BufferedImage(scale * W, scale * H, img.getType()));
	}

	public static BufferedImage rotate(BufferedImage img)
	{

		
		switch (rotation){
		case HALF:
			break;
		case QUARTER:
			break;
		case THREE_QUARTER:
			break;
		default:
			break;
		}
		int W = img.getWidth();
		int H = img.getHeight();
		AffineTransform rotateTransform = AffineTransform.getRotateInstance(Math.toRadians(90), (W / 2) + .5, (H / 2) + .5);
		AffineTransformOp rotateAffline = new AffineTransformOp(rotateTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return rotateAffline.filter(img, new BufferedImage(H, W, img.getType()));
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
