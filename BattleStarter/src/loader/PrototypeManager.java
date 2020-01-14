package loader;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
//Klasa obslugujaca wszystkie ladowane dane projektu
public class PrototypeManager 
{
	private List<UnitPrototype> _units;
	public List<UnitPrototype> GetUnits() { return this._units;}
	private List<OrderPrototype> _orders;
	public List<OrderPrototype> GetOrders() { return this._orders;}
	private JsonLoader loader;
	private JSONObject _settings;
	
	public PrototypeManager()
	{
		_units = new ArrayList<UnitPrototype>();
		_orders = new ArrayList<OrderPrototype>();
		loader = new JsonLoader();
		_settings = loader.loadFromFile("settings.json");
	}
	
	public void loadAssets()
	{
		JSONObject assetsFiles = _settings.getJSONObject("assetsFileNames");
		JSONObject assetFile;
		for(String key : assetsFiles.keySet())
		{
			assetFile=loader.loadFromFile(assetsFiles.getString(key));
			for(String assetkey : assetFile.keySet())
			{
				loadAsset(assetFile.getJSONObject(assetkey));
				System.out.println("Asset Loaded.");
			}
			System.out.println("File Loaded.");
		}
	}

	private void loadAsset(JSONObject Asset) 
	{
		String type = Asset.getString("type");
		if (type.equals("unit"))
		{
			_units.add(new UnitPrototype(Asset));
		}
		else if (type.equals("order"))
		{
			_orders.add(new OrderPrototype(Asset));
		}
	}
	
}
