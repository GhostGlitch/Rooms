package view;

import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Layout;

public class Img
{
	public enum Rotn
	{
		QUARTER, HALF, THREE_QUARTER, COUNTER_QUARTER, COUNTER_THREE_QUARTER
	}

	public static BufferedImage Room = load("src/imgs/Map/TempRoom.png");
	public static BufferedImage Empty = load("src/imgs/Map/TempEmpty.png");
	public static BufferedImage Borderln = load("src/imgs/Map/TempLine.png");
	public static BufferedImage Corner = load("src/imgs/Map/TempCorner.png");
	public static BufferedImage Spacer = load("src/imgs/Other/Spacer.png");

	public static int scaleBy = setScaleBy();

	public static int setScaleBy()
	{
		tst t = new tst();
		if (t.width > t.height)
		{
			return (int) (t.height / (3 * (Layout.getGenMax() + 3.6666)));
		}
		else
		{
			return (t.width / (3 * (Layout.getGenMax() + 2)));
		}
	}

	public static JLabel toLbl(BufferedImage img)
	{
		return new JLabel(new ImageIcon(img));
	}

	private static BufferedImage load(String location)
	{
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(new File(location));
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

		AffineTransform rotateTransform = AffineTransform.getRotateInstance(Math.toRadians(angle), (W / 2), (H / 2));
		AffineTransformOp rotateAffline = new AffineTransformOp(rotateTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return rotateAffline.filter(img, new BufferedImage(W1, H1, img.getType()));
	}

	public static Font getFont(String name, int style, int pixels)
	{
		int under = 0;
		int over = 0;
		int unrPixels = Empty.getGraphics().getFontMetrics(new Font(name, style, under)).getHeight();
		int ovrPixels = Empty.getGraphics().getFontMetrics(new Font(name, style, over)).getHeight();
		for (over = 1; ovrPixels < pixels; over++)
		{
			ovrPixels = Empty.getGraphics().getFontMetrics(new Font(name, style, over)).getHeight();
		}
		for (under = over * 2; unrPixels > pixels; under--)
		{
			unrPixels = Empty.getGraphics().getFontMetrics(new Font(name, style, under)).getHeight();
		}
		if (pixels - unrPixels < ovrPixels - pixels)
		{
			return new Font(name, style, under);
		}
		else
		{
			return new Font(name, style, over);
		}
	}

	public static int getScaleBy()
	{
		return scaleBy;
	}
}
