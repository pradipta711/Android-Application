package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import data.Channel;
import android.net.Uri;
import android.os.AsyncTask;

public class YahooWeatherService {
private WeatherServiceCallback callback;
private String location;
private Exception error;
public YahooWeatherService(WeatherServiceCallback callback) {
	super();
	this.callback = callback;
}
public void refreshWeather(final String l)
{
	this.location=l;
	new AsyncTask<String, Void, String>()
	{

		@Override
		protected String doInBackground(String... params) {
			
			String YQL=String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")",params[0]);
			String endpoint=String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json",Uri.encode(YQL));
			// TODO Auto-generated method stub
			try {
				URL url=new URL(endpoint);
				URLConnection connection=url.openConnection();
				InputStream input=connection.getInputStream();
				BufferedReader reader=new BufferedReader(new InputStreamReader(input));
				StringBuilder result=new StringBuilder();
				String line;
				while((line=reader.readLine())!=null)
				{
					result.append(line);
				}
				return result.toString();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				error=e;
			}
			
			
			return null;
		}
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			System.out.println("!!!! result"+result);
			/*JSONObject data=null;
			try {
				data = new JSONObject(result);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("Data is"+data);
			try{
			JSONObject queryResult=data.getJSONObject("query");
			int count=queryResult.getInt("count");
			String loc=queryResult.getJSONObject("results").getJSONObject("channel").getJSONObject("location").getString("city");
			String temp=queryResult.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition").getString("temp");
			System.out.println("tempii is"+temp);
			String atmos=queryResult.optJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition").getString("text");
			
			System.out.println("Location is"+loc+" "+"temp is"+temp+" "+"atmosphere is"+atmos);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
			if(result==null&& error!=null)
			{
				callback.serviceFailure(error);
			}
			else
			{
				try {
					JSONObject data=new JSONObject(result);
					
					
					JSONObject queryResult=data.optJSONObject("query");
					int count1=queryResult.optInt("count");
					String loc=queryResult.getJSONObject("results").getJSONObject("channel").getJSONObject("location").getString("city");
					String temp=queryResult.getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition").getString("temp");
					String atmos=queryResult.optJSONObject("results").optJSONObject("channel").getJSONObject("item").getJSONObject("condition").optString("text");
					
					System.out.println("Location is"+loc+" "+"temp is"+temp+" "+"atmosphere is"+atmos);
					if(count1==0)
					{
						callback.serviceFailure(new LocationWeatherService("No data for this weather"+location));
						return;
					}
					Channel channel=new Channel();
					channel.populate(queryResult.getJSONObject("results").getJSONObject("channel"));
					callback.serviceSuccess(channel);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					callback.serviceFailure(e);
				}
			}
		};
	}
	
	
	.execute(location);
	
		
	
}


public String getLocation() {
	return location;
}

public class LocationWeatherService extends Exception
{
	public LocationWeatherService(String mag)
	{
		super(mag);
	}
}
}
