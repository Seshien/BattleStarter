package game;

import java.awt.event.MouseEvent;

import loader.JsonLoader;
import loader.PrototypeManager;

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
		String text = new String();
		text=text.concat("Player One" + System.lineSeparator());
		for (Unit unit : this.GetPlayerOne().GetUnits())
			text=text.concat(unit.GetPrototype().GetName() + System.lineSeparator());
		text=text.concat("Player Two" + System.lineSeparator());
		for (Unit unit : this.GetPlayerOne().GetUnits())
			text=text.concat(unit.GetPrototype().GetName() + System.lineSeparator());
		System.out.println(text);
		JsonLoader saver = new JsonLoader();
		saver.saveToFile(text, text);
	}
}
