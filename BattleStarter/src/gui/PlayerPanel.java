package gui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.io.IOException;

import game.Player;
import game.Unit;
//Klasa graficzna rozszerzajaca Panel obslugujaca gracza
public class PlayerPanel extends Panel {

	private Player _player;
	public  Object getOwner() {return _player;}
	public PlayerPanel(Player player, EventHandler ev) 
	{
		super(350,350,ev);
		_player = player;
		this.Init();
		// TODO Auto-generated constructor stub
	}

	public PlayerPanel(int x, int y, Player player, EventHandler ev) 
	{
		super(x, y, ev);
		_player = player;
		this.Init();
		// TODO Auto-generated constructor stub
	}
	protected void Init()
	{
		for (Unit unit : _player.GetUnits())
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
	public void refresh()
	{
		for (Component comp : this.getComponents())
			comp.setVisible(false);
		this.removeAll();
		this.Init();
	}
}
