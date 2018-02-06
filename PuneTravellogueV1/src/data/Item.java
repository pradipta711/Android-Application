package data;

import org.json.JSONObject;

public class Item implements JsonPopulator {
private Condition condition;

	@Override
	public void populate(JSONObject data) {
		// TODO Auto-generated method stub
		condition=new Condition();
		condition.populate(data.optJSONObject("condition"));
	}
	public Condition getCondition() {
		return condition;
	}

	
	
}
