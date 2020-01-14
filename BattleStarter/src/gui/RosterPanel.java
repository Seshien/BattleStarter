package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import game.Roster;
import game.Unit;
//Klasa graficzna obslugujaca roster
public class RosterPanel extends Panel {

	private Roster _roster;
	
	@Override
	public  Object getOwner() {return _roster;}
	public RosterPanel(Roster roster, EventHandler ev) 
	{
		super(1000,350, ev);
		_roster = roster;
		this.Init();
	}
	protected void Init ()
	{
		for (Unit unit : _roster.GetUnits())
		{
			try 
			{
				UnitPortrait unitP =  new UnitPortrait(unit);
				unitP.addMouseListener(this.getEventHandler());
				this.add(unitP);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.setLayout(new FlowLayout());
	}

}
