package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import game.Unit;

public class UnitPortrait extends JButton 
{
	private Unit _unit;
	public Unit GetUnit() {return this._unit;}
	private Panel parent;
	public Panel GetParent() {return this.parent;}
	public UnitPortrait(Unit unit, int x) throws IOException
	{
		super(new ImageIcon(unit.GetPrototype().GetTexture().getScaledInstance(x, x*2, Image.SCALE_DEFAULT)));
        System.out.println(unit.GetPrototype().GetTexturePath());
		_unit = unit;
		this.setPreferredSize(new Dimension(x,x*2));
	}
	public UnitPortrait(Unit unit) throws IOException
	{
		super(unit.GetPrototype().GetIcon());
        System.out.println(unit.GetPrototype().GetTexturePath());
		_unit = unit;
		this.setPreferredSize(new Dimension(60,60*2));
	}
	
}
