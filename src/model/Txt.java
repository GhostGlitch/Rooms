package model;

public class Txt
{
	private boolean lengthChecker(String input)
	{
		boolean isLong = false;
		if (input.length() > 16)
			isLong = true;
		return isLong;
	}
	private boolean dieChecker(String input)
	{
		boolean isDie = false;
		if (input.contains("die"))
			isDie = true;
		return isDie;
	}
}
