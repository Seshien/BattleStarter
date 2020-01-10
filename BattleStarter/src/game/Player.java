package game;

import java.util.ArrayList;
import java.util.List;

import loader.UnitPrototype;

public class Player 
{
	private int _gold;
	public int GetGold() {return this._gold;}
	private List<Unit> _units;
	public List<Unit> GetUnits() { return _units;}
	public Player()
	{
		_gold = 0;
		_units = new ArrayList<Unit>();
	}
	public Player(int gold)
	{
		_gold = gold;
		_units = new ArrayList<Unit>();
	}
	public boolean BuyUnit(UnitPrototype unit)
	{
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
	public boolean DeductGold(int amount)
	{
		if (amount <= _gold)
		{
			_gold-=amount;
			return true;
		}
		else
			return false;
	}
	public boolean AddGold(int amount)
	{
		_gold+=amount;
		return true;
	}
	public boolean AddUnit(Unit unit)
	{
		_units.add(unit);
		return true;
	}
	public boolean AddUnit(UnitPrototype unit)
	{
		return AddUnit(new Unit(unit));
	}
	public boolean DeductUnit(Unit unit)
	{
		if(_units.remove(unit))
			return true;
		else
			return false;
	}

}
