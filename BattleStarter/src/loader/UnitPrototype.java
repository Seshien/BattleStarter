package loader;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.json.JSONObject;

public class UnitPrototype extends Prototype {
	String name;
	public String GetName() {return this.name;}
	String unitType;
	public String GetUnitType() {return this.unitType;}
	int cost;
	public int GetCost() {return this.cost;}
	int attack;
	public int GetAttack() {return this.attack;}
	int defence;
	public int GetDefence() {return this.defence;}
	int armor;
	public int GetArmor() {return this.armor;}
	public int GetProtection() {return this.defence + this.armor;}
	int health;
	public int GetHealth() {return this.health;}
	int rangedAttack;
	public int GetRangedAttack() {return this.rangedAttack;}
	int rangedRange;
	public int GetRangedRange() {return this.rangedRange;}
	//"power": 10,
	int chargeAttack;
	public int GetChargeAttack() {return this.chargeAttack;}
	int chargeDefence;
	public int GetChargeDefence() {return this.chargeDefence;}
	int move;
	public int GetMoveRange() {return this.move;}
	int morale;
	public int GetMorale() {return this.morale;}
	float formationSize;
	public float GetFormationSize() {return this.formationSize;}
	String faction;
	public String GetFaction() {return this.faction;}
	String description;
	public String GetDescription() {return this.description;}
	String texture;
	public String GetTexturePath() {return this.texture;}
	BufferedImage textureImage;
	public BufferedImage GetTexture() {return this.textureImage;}
	ImageIcon textureIcon;
	public ImageIcon GetIcon() {return this.textureIcon;}
	
	public UnitPrototype(JSONObject asset) 
	{
		name = super.getStringSafe(asset, "name");
		//name=asset.getString("name");
		unitType=asset.getString("unitType");
		cost = asset.getInt("cost");
		
		attack = asset.getInt("attack");
		defence = asset.getInt("defence");
		armor = asset.getInt("armor");
		health = asset.getInt("health");
		
		
		rangedAttack = asset.getInt("rangedAttack");
		if (rangedAttack == 0) rangedRange=0;
		else rangedRange = asset.getInt("rangedRange");
		
		chargeAttack = asset.getInt("chargeAttack");
		chargeDefence = asset.getInt("chargeDefence");
		
		move = asset.getInt("move");
		morale = asset.getInt("morale");
		formationSize = asset.getFloat("formationSize");
		
		faction=asset.getString("faction");
		description=asset.getString("description");
		texture=asset.getString("texture");
		try {
			textureImage = ImageIO.read(new File(this.GetTexturePath()));
			textureIcon = new ImageIcon(GetTexture().getScaledInstance(60, 2*60, Image.SCALE_DEFAULT));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
