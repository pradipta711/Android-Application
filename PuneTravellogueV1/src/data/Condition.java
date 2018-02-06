package data;

import org.json.JSONObject;

import android.util.Log;

public class Condition implements JsonPopulator{
private int code;
private int temperature;
private String description;
	@Override
	public void populate(JSONObject data) {
		// TODO Auto-generated method stub
		code=data.optInt("code");
		temperature=data.optInt("temp");
		description=data.optString("text");
		Log.e("Code and Temperature and desrciption",code+" "+temperature+""+description);
	}
	public int getCode() {
		return code;
	}
	public int getTemperature() {
		return temperature;
	}
	public String getDescription() {
		return description;
	}
	
	

}
