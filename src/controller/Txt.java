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
		String cmd = null;
		int i = -1;
		for (int index = 0; index < cmdLst.size(); index++)
		{
			//System.out.println(index + ": " + cmdLst.get(index));
			if (input.matches("\\b" + cmdLst.get(index) + "\\b.*"))
				cmd = cmdLst.get(index);
				//i = index;
		}
		if (cmd == "go")
		{
			for (int index = 0; index < goLst.size(); index++)
			{
				//System.out.println(index + ": " + goLst.get(index));
				if (input.matches(cmd + " \\b" + goLst.get(index) + "$"))
					cmd = input;
			}
		}
			//System.out.print(i + ": ");
			return cmd;

	}
}
