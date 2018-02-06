package com.cdac.weatherintegaration;



import com.dmc.punetravellogue.R;

import data.Channel;
import data.Item;
import service.WeatherServiceCallback;
import service.YahooWeatherService;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherActivity extends Fragment implements WeatherServiceCallback{

	public ImageView weatherimageIcon;
	public TextView temperature;
	public TextView condition;
	public TextView location;
	public YahooWeatherService service;
	public ProgressDialog dialog;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
    	weatherimageIcon=(ImageView)rootView.findViewById(R.id.wheatherimageicon);
		temperature=(TextView)rootView.findViewById(R.id.temperaturetextview);
		condition=(TextView)rootView.findViewById(R.id.conditiontextview);
		location=(TextView)rootView.findViewById(R.id.locationtextview);
		
		service=new YahooWeatherService(this);
		dialog=new ProgressDialog(getActivity());
		dialog.setMessage("Loading...");
		dialog.show();
		
		service.refreshWeather("pune");
        return rootView;
    }
	
	@Override
	public void serviceSuccess(Channel channel) {
		Item item=channel.getItems();
//		int resourceId=getResources().getIdentifier("drawable/icon_"+item.getCondition().getCode(),null,getPackageName());
//		Drawable weatherIconDrawable=getResources().getDrawable(resourceId);
//		weatherimageIcon.setImageDrawable(weatherIconDrawable);
	location.setText(service.getLocation());
	//String temp=item.getCondition().getTemperature()+channel.getUnits().getTemperature();
	//int temp1=Integer.parseInt(temp);
	//int celsius=(temp1-32)*5/9;
	//String newtemp=String.valueOf(celsius);
	//temperature.setText(newtemp+"celcius");
		temperature.setText(item.getCondition().getTemperature()+"\u00B0"+channel.getUnits().getTemperature());
		condition.setText(item.getCondition().getDescription());
		if(condition.getText().equals("Sunny"))
		{
		weatherimageIcon.setImageResource(R.drawable.sunny);
		}
		else if(condition.getText().equals("Partly Cloudy"))
		{
			weatherimageIcon.setImageResource(R.drawable.partycloudy);
		}
		else
		{
			weatherimageIcon.setImageResource(R.drawable.pro_weather);
		}
		dialog.hide();
		// TODO Auto-generated method stub
		
	}
	@Override
	public void serviceFailure(Exception ex) {
		dialog.hide();
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_LONG).show();
	}
}
