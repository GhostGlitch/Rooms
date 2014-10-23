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
	private Controller c;
	public CombinePanel(Controller c) 
	{
		this.c = c;
		map = new MapPanel(c);
		input = new InputPanel(c);
		setupLayout();
		setupPanel();
	}
	private void setupLayout()
	{
		setLayout(null);
		map.setSize(map.getPreferredSize());
		input.setBounds(0, 0 + map.getHeight(), (int) map.getWidth(), input.getHeight());
		input.resizeTxtFld();
	}
	private void setupPanel()
	{
		setBackground(new Color(92, 106, 112));
		add(map);
		add(input);
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(input.getWidth(), map.getHeight() + input.getHeight());
	}
}