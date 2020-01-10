package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class EventHandler implements MouseListener, ActionListener {
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

}
