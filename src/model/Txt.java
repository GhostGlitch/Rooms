package model;

import java.util.ArrayList;

public class Txt
{
	private ArrayList<String> cmdList;
	private ArrayList<String> goList;

	private boolean lengthChecker(String input)
	{
		boolean isLong = false;
		if (input.length() > 16)
			isLong = true;
		return isLong;
	}

	private void fillLists()
	{
		cmdList.add("die");
		cmdList.add("go");
		goList.add("north");
		goList.add("south");
		goList.add("east");
		goList.add("west");
		goList.add("up");
		goList.add("down");
		goList.add("left");
		goList.add("right");
		cmdList.add("sleep");
		cmdList.add("attack");
		cmdList.add("help");
		cmdList.add("drink");
		cmdList.add("eat");
	}

	private String cmdChecker(String Input)
	{
		String cmd = null;
		for (String currentCmd : cmdList)
		{
			cmd = currentCmd;
		}
		return cmd;
	}

	private void a()
	{
		lengthChecker();
	}
}
