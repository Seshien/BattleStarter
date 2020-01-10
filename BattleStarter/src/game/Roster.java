package game;

import java.util.ArrayList;
import java.util.List;

import loader.UnitPrototype;

public class Roster 
{
	private List<Unit> _units;
	public List<Unit> GetUnits() {return this._units;}
	public Roster(List<UnitPrototype> prototypes)
	{
		_units = new ArrayList<Unit>();
		for (UnitPrototype proto : prototypes)
			_units.add(new Unit(proto));
	}
}
