package com.uni.mapintegration;


import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;

import com.dmc.punetravellogue.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
//import com.google.android.gms.common.GooglePlayServicesUtil;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MapIntegrateAll extends FragmentActivity {


	LocationManager locManager;
	Drawable drawable;
	Document document;
	GMapV2GetRouteDirection v2GetRouteDirection;
	LatLng fromPosition;
	LatLng toPosition;
	GoogleMap mGoogleMap;
	MarkerOptions markerOptions;
	Location location;
	GPSTracker gps;
	Bundle data;
	TextView txtdistance;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(com.dmc.punetravellogue.R.layout.mapfragment);
		try {
			
			Intent in=getIntent();
			int count1=in.getIntExtra("mcount", 0);
			data=new Bundle();
			data.putInt("countValue",count1);
			
			
			if (mGoogleMap == null) {
				v2GetRouteDirection = new GMapV2GetRouteDirection();
				txtdistance=(TextView) findViewById(R.id.textViewDistance);
				SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
						.findFragmentById(R.id.map1);
				mGoogleMap = supportMapFragment.getMap();

				// Enabling MyLocation in Google Map
				mGoogleMap.setMyLocationEnabled(true);
				mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
				mGoogleMap.getUiSettings().setCompassEnabled(true);
				mGoogleMap.getUiSettings().setMyLocationButtonEnabled(true);
				mGoogleMap.getUiSettings().setAllGesturesEnabled(true);
				mGoogleMap.setTrafficEnabled(true);
				mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
				markerOptions = new MarkerOptions();

				gps = new GPSTracker(MapIntegrateAll.this);
				if (gps.canGetLocation()) {

					double latitude = gps.getLatitude();
					double longitude = gps.getLongitude();
					fromPosition = new LatLng(latitude, longitude);
					System.out.println("!!! current location lat long::"+fromPosition);
					
				
					CameraUpdate yourLocation = CameraUpdateFactory
							.newLatLngZoom(fromPosition, 10);
					mGoogleMap.animateCamera(yourLocation);
					// Adding route on the map
					MarkerOptions markerOptions1=new MarkerOptions();;
					markerOptions1.position(fromPosition);
					markerOptions1.draggable(true);
					mGoogleMap.addMarker(markerOptions1);
					switch(count1)
					{
					case 1:
						toPosition = new LatLng(18.5164,73.8558);
						 GetDistanceTask getDistance = new GetDistanceTask();
							
				         getDistance.init(latitude,longitude,18.5164,73.8558);
				         getDistance.execute();	
					    GetRouteTask getRoute = new GetRouteTask();
					     getRoute.execute();
						break;
					
					case 2:
						toPosition = new LatLng(19.0720, 73.5360);
						
						 GetDistanceTask getDistance2 = new GetDistanceTask();
							
				         getDistance2.init(latitude,longitude,19.0720, 73.5360);
				         getDistance2.execute();
					    GetRouteTask getRoute2 = new GetRouteTask();
					     getRoute2.execute();
						
						 break;
					 
					 case 3:
						 
						 toPosition = new LatLng(18.4975172,73.8468822 );
					 GetDistanceTask getDistance3 = new GetDistanceTask();
						
			         getDistance3.init(latitude,longitude,18.4975172,73.8468822);
			         getDistance3.execute();
						GetRouteTask getRoute3 = new GetRouteTask();
						getRoute3.execute();
						 break;
					
					 case 4:
						 
						 toPosition = new LatLng(18.5523, 73.9015);
						
					 GetDistanceTask getDistance4 = new GetDistanceTask();
						
			         getDistance4.init(latitude,longitude,18.5523, 73.9015);
			         getDistance4.execute();
					 
					 GetRouteTask getRoute4 = new GetRouteTask();
						getRoute4.execute();
						 
						 break;
					 case 5:
						 toPosition = new LatLng(18.5191, 73.8554);
						 GetDistanceTask getDistance5 = new GetDistanceTask();
							
				         getDistance5.init(latitude,longitude,18.5191, 73.8554);
				         getDistance5.execute();	
						 
						 
						 GetRouteTask getRoute5 = new GetRouteTask();
							getRoute5.execute();
						 break;
					 case 6:
						 toPosition = new LatLng(18.5441, 73.4650);
						 GetDistanceTask getDistance6 = new GetDistanceTask();
							
				         getDistance6.init(latitude,longitude,18.5441, 73.4650);
				         getDistance6.execute();
						 
						 
						 GetRouteTask getRoute6 = new GetRouteTask();
							getRoute6.execute();
						 break;
					 case 7:
						 toPosition = new LatLng(18.5270, 73.8498);
						 GetDistanceTask getDistance7 = new GetDistanceTask();
							
				         getDistance7.init(latitude,longitude,18.5270, 73.8498);
				         getDistance7.execute();	
						 
						 
						 
						 
						 GetRouteTask getRoute7 = new GetRouteTask();
							getRoute7.execute();
						 break;
					 case 8:
						 toPosition = new LatLng(18.3657, 73.7553);
						
						 GetDistanceTask getDistance8 = new GetDistanceTask();
						 
						 getDistance8.init(latitude,longitude,18.3657, 73.7553);
				         getDistance8.execute();
						 
						 
						 GetRouteTask getRoute8 = new GetRouteTask();
							getRoute8.execute();
						 break;
					 case 9:
						 toPosition = new LatLng(18.5204303, 73.8567437);
                       GetDistanceTask getDistance9 = new GetDistanceTask();
						 
						 getDistance9.init(latitude,longitude,18.5204303, 73.8567437);
				         getDistance9.execute();
						 
						 
						 
						 GetRouteTask getRoute9 = new GetRouteTask();
							getRoute9.execute();
						 break;
					 case 10:
						 toPosition = new LatLng(18.5651545,73.9168537);
                       GetDistanceTask getDistance10 = new GetDistanceTask();
						 
						 getDistance10.init(latitude,longitude,18.5651545,73.9168537);
				         getDistance10.execute();
						 
						 
						 GetRouteTask getRoute10 = new GetRouteTask();
							getRoute10.execute();
						 break;
					}
				}

				else {
					gps.showSettingsAlert();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * 
	 * This class Get Route on the map
	 *
	 */
	private class GetRouteTask extends AsyncTask<String, Void, String> {

		private ProgressDialog Dialog;
		String response = "";

		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(MapIntegrateAll.this);
			Dialog.setMessage("Loading route...");
			Dialog.show();
		}

		@Override
		protected String doInBackground(String... urls) {
			// Get All Route values
			document = v2GetRouteDirection.getDocument(fromPosition,
					toPosition, GMapV2GetRouteDirection.MODE_DRIVING);
			response = "Success";
			
			//document=v2GetRouteDirection.getDocument(fromPosition, toPosition, );
			return response;

		}

		@Override
		protected void onPostExecute(String result) {
			mGoogleMap.clear();
			if (response.equalsIgnoreCase("Success")) {
				ArrayList<LatLng> directionPoint = v2GetRouteDirection
						.getDirection(document);
				PolylineOptions rectLine = new PolylineOptions().width(10)
						.color(Color.RED);
				int distance=v2GetRouteDirection.getDistanceValue(document);
			
			Toast.makeText(MapIntegrateAll.this, distance+"", 5);
				for (int i = 0; i < directionPoint.size(); i++) {
					rectLine.add(directionPoint.get(i));
				}
				// Adding route on the map
				mGoogleMap.addPolyline(rectLine);
				markerOptions.position(toPosition);
				markerOptions.draggable(true);
				mGoogleMap.addMarker(markerOptions);

			}

			Dialog.dismiss();
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		finish();
	}

	
	 private class GetDistanceTask extends AsyncTask<Void, Void, String> {
	        Double lat1, lat2, long1, long2;

	        void init(Double lat1, Double long1, Double lat2, Double long2) {
	            this.lat1 = lat1;
	            this.long1 = long1;
	            this.lat2 = lat2;
	            this.long2 = long2;
	        }

	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	        }

	        @Override
	        protected String doInBackground(Void... params) {

	            String url = "http://maps.googleapis.com/maps/api/directions/json?"
	                    + "origin=" + lat1 + "," + long1 + "&destination=" + lat2
	                    + "," + long2 + "&sensor=false&units=metric&mode=driving";

	            try {
	                HttpClient httpClient = new DefaultHttpClient();
	                HttpContext localContext = new BasicHttpContext();
	                HttpPost httpPost = new HttpPost(url);
	                HttpResponse response = httpClient.execute(httpPost, localContext);
	                InputStream in = response.getEntity().getContent();
	                String input = StringUtils.convertStreamToString(in);
	                JSONObject json = new JSONObject(input);
	                JSONArray MainjArray = json.getJSONArray("routes");
	                JSONObject innerJson = (JSONObject) MainjArray.get(0);
	                JSONArray legs = innerJson.optJSONArray("legs");
	                JSONObject distance = (JSONObject) legs.get(0);
	                JSONObject innerdistance = (JSONObject) distance.opt("distance");
	                String finalValue = innerdistance.optString("text");
	                System.out.println("@@@ inner distance::"+finalValue);
	                return finalValue;
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            return "";
	        }

	        @Override
	        protected void onPostExecute(String distance) {
	            super.onPostExecute(distance);
	           txtdistance.setText(distance);
	        }
	    }

	
	
	
	
	
	
	
	
	
	
}
