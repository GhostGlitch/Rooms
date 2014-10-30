package model;

import java.util.ArrayList;

public class Txt
{
	private ArrayList<String> cmdList;
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

	private void fillCmdList()
	{
		cmdList.add("die");
		cmdList.add("go");
		cmdList.add("go north");
		cmdList.add("go south");
		cmdList.add("go east");
		cmdList.add("go west");
		cmdList.add("go up");
		cmdList.add("go down");
		cmdList.add("go left");
		cmdList.add("go right");
		cmdList.add("sleep");
		cmdList.add("attack");
		cmdList.add("help");
		cmdList.add("drink");
		cmdList.add("eat");
	}

	private String cmdChecker(String Input)
	{
		String cmd;
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
