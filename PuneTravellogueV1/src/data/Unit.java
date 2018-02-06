package data;

import org.json.JSONObject;

public class Unit implements JsonPopulator{
private String temperature;
	@Override
	public void populate(JSONObject data) {
		// TODO Auto-generated method stub
		temperature=data.optString("temperature");
	}
	public String getTemperature() {
		return temperature;
	}

	
	
}
