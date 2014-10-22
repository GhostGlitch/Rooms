package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import controller.Controller;

public class CombinePanel extends JPanel
{
	Dimension d = null;
	private MapPanel map;
	private InputPanel input;
	public CombinePanel(Controller c) 
	{
		map = new MapPanel(c);
		map.setSize(map.getPreferredSize());
		input = new InputPanel(c);
		input.setBounds(0, 0 + map.getHeight(), (int) map.getPreferredSize().getWidth(), input.getHeight());
		input.fixSize();
		setSize(getPreferredSize());
		
		setupPanel();
		setupLayout();
		setupListeners();
		setBackground(Color.BLUE);
	}
	private void setupListeners()
	{
		
	}
	private void setupLayout()
	{
		
	}
	private void setupPanel()
	{
		setLayout(null);
		add(map);
		add(input);
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(input.getWidth(), map.getHeight() + input.getHeight());

	}
}