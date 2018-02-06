package com.example.foodymood;



import com.dmc.punetravellogue.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

public class FoodHandlerActivity extends Activity {
	FrameLayout drawerfood;
	FrameLayout containerfood;
	Bundle data;
	int count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodframelayout);
		drawerfood=(FrameLayout)findViewById(R.id.drawerfood);
		containerfood=(FrameLayout)findViewById(R.id.containerfood);
		Intent in=getIntent();
		count=in.getIntExtra("listNo",0);
		data=new Bundle();
		data.putInt("countValue", count);
		
			loadAundhFragement();
		
	}
	
	public void loadAundhFragement() {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		AundhfoodFragement aundh=new AundhfoodFragement();
		aundh.setArguments(data);
		ft.replace(R.id.containerfood, aundh);
		ft.commit();

	}
	

}
