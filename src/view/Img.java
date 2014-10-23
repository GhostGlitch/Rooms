package view;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Img
{
	public enum Rotn
	{
		QUARTER, HALF, THREE_QUARTER, COUNTER_QUARTER, COUNTER_THREE_QUARTER
	}

	public static String Room = "Map/TempRoom.png";
	public static String Empty = "Map/TempEmpty.png";
	public static String Borderln = "Map/TempLine.png";
	public static String Corner = "Map/TempCorner.png";
	public static String Spacer = "Other/Spacer.png";
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

	public static BufferedImage scale(int scale, BufferedImage img)
	{
		int W = img.getWidth();
		int H = img.getHeight();
		AffineTransform scaleTransform = AffineTransform.getScaleInstance(scale, scale);
		AffineTransformOp scaleAffline = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return scaleAffline.filter(img, new BufferedImage(scale * W, scale * H, img.getType()));
	}

	public static BufferedImage rotate(Rotn rotn, BufferedImage img)
	{
		int W = img.getWidth();
		int H = img.getHeight();
		int W1;
		int H1;
		int angle;
		switch (rotn)
		{
		case COUNTER_QUARTER:
			W1 = H;
			H1 = W;
			angle = -90;
			break;
		case COUNTER_THREE_QUARTER:
			W1 = H;
			H1 = W;
			angle = 90;
			break;
		case HALF:
			W1 = W;
			H1 = H;
			angle = 180;
			break;
		case QUARTER:
			W1 = H;
			H1 = W;
			angle = 90;
			break;
		case THREE_QUARTER:
			W1 = H;
			H1 = W;
			angle = -90;
			break;
		default:
			W1 = H;
			H1 = W;
			angle = 90;
			break;
		}
		AffineTransform rotateTransform = AffineTransform.getRotateInstance(Math.toRadians(angle), (W / 2) + .5, (H / 2) + .5);
		AffineTransformOp rotateAffline = new AffineTransformOp(rotateTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return rotateAffline.filter(img, new BufferedImage(W1, H1, img.getType()));
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
