package com.dmc.punetravellogue.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dmc.punetravellogue.R;

public class FoodyMoodFragment extends Fragment {
	
	public FoodyMoodFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_foody_mood, container, false);
         
        return rootView;
    }
}
