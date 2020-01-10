package gui;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class InfoPanel extends Panel 
{
	JTextArea text;
	JButton saveArmy;
	JFormattedTextField goldMax;
	public InfoPanel(EventHandler ev) 
	{
		super(300,350, ev);
		this.Init();
		//this.HideInfo();
	}
	protected void Init()
	{
		text = new JTextArea();
		saveArmy = new JButton("Save");
		saveArmy.setBounds(260, 310, 30, 20);
		saveArmy.addActionListener(getEventHandler());
		this.add(saveArmy);
		
		goldMax = new JFormattedTextField();
		goldMax.setValue(getEventHandler().GetHandledGui().GetGame().GetPlayerOne().GetMaxGold());
		goldMax.setColumns(6);
		goldMax.addPropertyChangeListener("value", getEventHandler());
		this.add(goldMax);
		
		text.setBounds(5, 5, 290, 300);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		text.setLineWrap(true);
		text.setVisible(true);
		this.add(text);
		this.HideInfo();
	}
	public void ShowInfo(String unInfo)
	{
		String info = "Player One Gold: " + this.getEventHandler().GetHandledGui().GetGame().GetPlayerOne().GetGold()
				+ " Player Two Gold: " + this.getEventHandler().GetHandledGui().GetGame().GetPlayerTwo().GetGold()
				+ System.lineSeparator() + unInfo;
		text.setText(info);
		text.setVisible(true);
	}
	public void HideInfo()
	{
		String info = "Player One Gold: " + this.getEventHandler().GetHandledGui().GetGame().GetPlayerOne().GetGold()
				+ " Player Two Gold: " + this.getEventHandler().GetHandledGui().GetGame().GetPlayerTwo().GetGold()
				+ System.lineSeparator();
		text.setText(info);
		text.setVisible(true);
	}
}
