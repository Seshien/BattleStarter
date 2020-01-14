package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
//Klasa obslugujaca wszystkie wydarzenia
public class EventHandler implements MouseListener, ActionListener, PropertyChangeListener {
	private GUI handledGui;
	public GUI GetHandledGui () {return this.handledGui;}
	public EventHandler(GUI gui) 
	{
		handledGui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		UnitPortrait sender = (UnitPortrait) arg0.getSource();
		Panel panel = (Panel) sender.getParent();
		handledGui.GetGame().Action(panel.getOwner(), sender.GetUnit(), arg0.getButton());
		handledGui.GetPanelOne().refresh();
		handledGui.GetPanelTwo().refresh();
		handledGui.GetInfoPanel().refresh();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		UnitPortrait sender = (UnitPortrait) arg0.getSource();
		handledGui.GetInfoPanel().ShowInfo(sender.GetUnit().GetInfo());

	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		handledGui.GetInfoPanel().HideInfo();

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		handledGui.GetGame().saveArmy();
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		JFormattedTextField sender = (JFormattedTextField) arg0.getSource();
		if (!handledGui.GetGame().GetPlayerOne().SetMaxGold((int) arg0.getNewValue()))
		{
			sender.setValue(arg0.getOldValue());
		}
		else if (!handledGui.GetGame().GetPlayerTwo().SetMaxGold((int) arg0.getNewValue()))
		{
			sender.setValue(arg0.getOldValue());
		}
		try {
			sender.commitEdit();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		handledGui.GetInfoPanel().refresh();
	}

}
