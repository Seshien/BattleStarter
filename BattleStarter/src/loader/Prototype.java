package loader;

import org.json.JSONObject;

public abstract class Prototype 
{
	@SuppressWarnings("unused")
	protected int getIntSafe(JSONObject asset, String key)
	{
		if (asset.has(key))
			return asset.getInt(key);
		else
			return 0;
	}
	@SuppressWarnings("unused")
	protected String getStringSafe(JSONObject asset, String key)
	{
		if (asset.has(key))
			return asset.getString(key);
		else
			return "default";
	}
}
