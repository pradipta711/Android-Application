package com.dmc.punetravellogue.activity;

import com.dmc.punetravellogue.R;
import com.dmc.punetravellogue.adapter.TestFragmentAdapter;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
	TestFragmentAdapter mAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;

	public HomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		System.out.println("!!! ffffff");
		mPager = (ViewPager) rootView.findViewById(R.id.pager);
		mAdapter = new TestFragmentAdapter(getActivity().getSupportFragmentManager());
		mPager.setAdapter(mAdapter);
		// indicator
		CirclePageIndicator indicator = (CirclePageIndicator) rootView.findViewById(R.id.indicator);
		mIndicator = indicator;
		indicator.setViewPager(mPager);
		final float density = getResources().getDisplayMetrics().density;
		indicator.setBackgroundColor(0x00000000);
		indicator.setRadius(4 * density);
		indicator.setPageColor(0x00000000);
		indicator.setFillColor(0xFFCCCCCC);
		indicator.setStrokeColor(0xFFCCCCCC);
		indicator.setStrokeWidth(1 * density);
		return rootView;
	}
	
}
