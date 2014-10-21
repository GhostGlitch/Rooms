package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

import javax.swing.BoxLayout;

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
		input.setBounds(0, 0 + map.getHeight(), (int) map.getPreferredSize().getWidth(),input.getHeight());
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
		this.add(map);
		this.add(input);
	}
	private void setPrefferedSize()
	{
		d = new Dimension(input.getWidth(), map.getHeight() + input.getHeight());
	}
	public Dimension getPreferredSize()
	{

		return d;
	}
}