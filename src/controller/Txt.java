package controller;

import java.util.ArrayList;

public class Txt
{
	private ArrayList<String> cmdLst = new ArrayList<String>();
	private ArrayList<String> goLst = new ArrayList<String>();

	private boolean lengthChecker(String input)
	{
		boolean isLong = false;
		if (input.length() > 16)
			isLong = true;
		return isLong;
	}

	public Txt()
	{
		cmdLst.add("die");
		cmdLst.add("go");
		goLst.add("north");
		goLst.add("south");
		goLst.add("east");
		goLst.add("west");
		goLst.add("up");
		goLst.add("down");
		goLst.add("left");
		goLst.add("right");
		cmdLst.add("sleep");
		cmdLst.add("attack");
		cmdLst.add("help");
		cmdLst.add("drink");
		cmdLst.add("eat");
	}

	public String checkCmd(String input)
	{
		input = cleanCmd(input);
		String cmd = null;
		for (int index = 0; index < cmdLst.size(); index++)
		{
			if (input.matches(cmdLst.get(index) + "\\b.*"))
				cmd = cmdLst.get(index);
		}
		
		if (cmd == "go")
		{
			for (int index = 0; index < goLst.size(); index++)
			{
				if (input.matches(cmd + "\\s+\\b" + goLst.get(index) + "$"))
						cmd=input;
			}
		}
		return cmd;
	}
	private String cleanCmd(String input)
	{
		input = input.replaceAll("\\s+", " ");
		input = input.trim();
		if (input.matches("^([/\\\\]).*"))
		{
			input = input.substring(1, input.length());
		}
		input = input.trim();
		while (input.matches(".*[.!? ]$"))
		{
			input = input.substring(0, input.length()-1);
		}
		return input;
	}
}
