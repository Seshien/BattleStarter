package game;

import java.util.ArrayList;
import java.util.List;

import loader.UnitPrototype;
//Klasa obslugujaca gracza 
public class Player 
{
	private int gold;
	private int maxGold;
	public int GetMaxGold() {return this.maxGold;}
	public int GetGold() {return this.gold;}
	private List<Unit> _units;
	public List<Unit> GetUnits() { return _units;}
	public Player()
	{
		gold = 0;
		this.maxGold = 0;
		_units = new ArrayList<Unit>();
	}
	public Player(int gold)
	{
		this.maxGold = gold;
		this.gold = gold;
		_units = new ArrayList<Unit>();
	}
	
	public boolean BuyUnit(UnitPrototype unit)
	{
		if (_units.size() >= 15)
			return false;
		if (DeductGold(unit.GetCost()))
		{
			AddUnit(unit);
			return true;
		}
		return false;
	}
	public boolean BuyUnit(Unit unit)
	{
		return BuyUnit(unit.GetPrototype());
	}
	public boolean SellUnit(Unit unit)
	{
		if (DeductUnit(unit))
		{
			AddGold(unit.GetPrototype().GetCost());
			return true;
		}
		return false;
	}
	
	
	public void refreshGold()
	{
		gold=maxGold;
		for (Unit unit : _units)
			gold -=unit.GetPrototype().GetCost();
	}
	public boolean SetMaxGold(int amount) 
	{
		if (amount >= maxGold - gold)
		{
			maxGold = amount;
			this.refreshGold();
			return true;			
		}
		else
			return false;
	}
	
	
	private boolean DeductGold(int amount)
	{
		if (amount <= gold)
		{
			gold-=amount;
			return true;
		}
		else
			return false;
	}
	private boolean AddGold(int amount)
	{
		gold+=amount;
		return true;
	}
	private boolean AddUnit(Unit unit)
	{
		_units.add(unit);
		return true;
	}
	private boolean AddUnit(UnitPrototype unit)
	{
		return AddUnit(new Unit(unit));
	}
	private boolean DeductUnit(Unit unit)
	{
		if(_units.remove(unit))
			return true;
		else
			return false;
	}

}
