package com.dmc.punetravellogue.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dmc.punetravellogue.R;

public class WeatherFragment extends Fragment {
	
	public WeatherFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
         
        return rootView;
    }
}
