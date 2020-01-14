package game;

import loader.UnitPrototype;
//Klasa sluzaca jako gloryfikowany wskaznik do unitprototype
public class Unit 
{
	private UnitPrototype _prototype;
	public UnitPrototype GetPrototype() {return this._prototype;}
	public Unit(UnitPrototype prototype)
	{
		_prototype = prototype;
	}
	public String GetInfo()
	{
		String n = System.lineSeparator();
		String t = "Type: "+ _prototype.GetUnitType() + n + "Name: " + _prototype.GetName() +  n +
				"Attack: " + _prototype.GetAttack() + " Protection: " + _prototype.GetProtection() + n +
				"Health: " + _prototype.GetHealth() + " Cost: " + _prototype.GetCost() + n +
				"Armor: " + _prototype.GetArmor() + " Defence: " + _prototype.GetDefence() + n +
				"Charge Attack: " + _prototype.GetChargeAttack() + " Charge Protection: " + _prototype.GetChargeDefence() + n;
		if (_prototype.GetRangedAttack()!=0) 
			t=t.concat("Ranged Attack: " + _prototype.GetRangedAttack() + " Range: " + _prototype.GetRangedRange() + n);
		t=t.concat("Faction: " + _prototype.GetFaction() + n + "Description: " + _prototype.GetDescription());
		return t;
		
	}
	
}
