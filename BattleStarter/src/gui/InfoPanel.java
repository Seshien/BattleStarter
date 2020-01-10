package gui;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class InfoPanel extends Panel 
{
	JTextArea text;
	JButton SaveArmy;
	public InfoPanel(EventHandler ev) 
	{
		super(300,350, ev);
		this.Init();
		//this.HideInfo();
	}
	protected void Init()
	{
		text = new JTextArea();
		SaveArmy = new JButton("Save");
		SaveArmy.setBounds(260, 310, 30, 20);
		SaveArmy.addActionListener(getEventHandler());
		this.add(SaveArmy);
		text.setBounds(5, 5, 290, 300);
		//text.setPreferredSize(new Dimension(290,340));
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
