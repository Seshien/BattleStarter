package game;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import loader.JsonLoader;
import loader.PrototypeManager;
// Glowna klasa gry, posiada obiekty logiczne roster oraz graczy, obsluguje wydarzenia z GUI oraz zapisuje wynik aplikacji.
public class Game 
{
	private Roster rooster;
	public Roster GetRooster() {return this.rooster;}
	private Player playerOne;
	public Player GetPlayerOne() {return this.playerOne;}
	private Player playerTwo;
	public Player GetPlayerTwo() {return this.playerTwo;}
	public Game(PrototypeManager protoManager) 
	{
		rooster = new Roster(protoManager.GetUnits());
		playerOne = new Player(3000);
		playerTwo = new Player(3000);
	}
	public void Action(Object object, Unit unit, int i)
	{
		if (object.equals(playerOne))
		{
			playerOne.SellUnit(unit);
		}
		else if (object.equals(playerTwo))
		{
			playerTwo.SellUnit(unit);
		}
		else if (object.equals(rooster))
		{
			if (i==MouseEvent.BUTTON1)
				playerOne.BuyUnit(unit);
			else if (i==MouseEvent.BUTTON3)
				playerTwo.BuyUnit(unit);
		}
	}
	public void saveArmy() 
	{
		ArrayList<String> firstArmy = new ArrayList<String>();
		ArrayList<String> secondArmy = new ArrayList<String>();
		
		for (Unit unit : this.GetPlayerOne().GetUnits())
			firstArmy.add(unit.GetPrototype().GetName());
		for (Unit unit : this.GetPlayerTwo().GetUnits())
			secondArmy.add(unit.GetPrototype().GetName());
		JsonLoader saver = new JsonLoader();
		saver.saveToFile(firstArmy, secondArmy);
	}
}
