package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import controller.Controller;

public class CombinePanel extends JPanel
{
	private MapPanel map;
	private InputPanel input;
	private OutputPanel output;
	private Controller c;
	public CombinePanel(Controller c) 
	{
		this.c = c;
		map = new MapPanel(c);
		input = new InputPanel(c);
		output = new OutputPanel(c);
		setupLayout();
		setupPanel();
	}
	private void setupLayout()
	{
		setLayout(null);
		map.setSize(map.getPreferredSize());
		output.setBounds(0, 0 + map.getHeight() + input.getHeight(), map.getWidth(), output.getHeight());
		output.resizeTxtPane();
	}
	private void setupPanel()
	{
		setBackground(new Color(92, 106, 112));
		add(map);
		add(input);
		add(output);
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(input.getWidth(), map.getHeight() + input.getHeight());
	}
}