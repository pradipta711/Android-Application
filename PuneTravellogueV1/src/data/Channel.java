package data;

import org.json.JSONException;
import org.json.JSONObject;

public class Channel implements JsonPopulator {
private Unit units;
private Item items;
	@Override
	public void populate(JSONObject data){
		// TODO Auto-generated method stub
		units=new Unit();
		units.populate(data.optJSONObject("units"));
		items=new Item();
		items.populate(data.optJSONObject("item"));
	}
	public Unit getUnits() {
		return units;
	}
	public Item getItems() {
		return items;
	}

	
	
	
}
