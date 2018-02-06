package com.example.foodymood;

import java.util.ArrayList;




import com.dmc.punetravellogue.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
//import android.app.SearchManager;
//import android.content.Context;
//import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
//import android.support.v4.view.MenuItemCompat;
//import android.support.v7.app.ActionBarActivity;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
//import android.widget.SearchView;
//import android.widget.SearchView.OnQueryTextListener;

	 
	//@SuppressWarnings("deprecation")
	public class HomeActivity extends Fragment
	{
		TextView mTitleTextView;
	    ListView listView1;
	   // SearchView searchView;
	    ArrayList<String> listNames = new ArrayList<String>();
		ArrayAdapter<String> adapter;
		@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	        View rootView = inflater.inflate(R.layout.home, container, false);
		listView1 = (ListView) rootView.findViewById(R.id.listVi);
			
			listNames.add("Aundh");
			listNames.add("Baner");
			listNames.add("Camp");
			listNames.add("Chinchwad");
			listNames.add("Deccan");
			listNames.add("Hadapsar");
			listNames.add("Hinjewadi");
			listNames.add("Magarpatta");
			listNames.add("Pimpri");
			listNames.add("Viman Nagar");
			
			
			
			adapter = new ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_list_item_1, listNames);
			
			listView1.setAdapter(adapter);
			listView1.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					int count=0;
					if(arg2==0)
					{
						Intent in =new Intent(getActivity(),FoodHandlerActivity.class);
						in.putExtra("listNo",count);
						startActivity(in);
					}
					if(arg2==1)
					{
						count++;
						Intent in =new Intent(getActivity(),FoodHandlerActivity.class);
						in.putExtra("listNo",count);
						startActivity(in);
					}
					if(arg2==2)
					{
						count+=2;
						Intent in =new Intent(getActivity(),FoodHandlerActivity.class);
						in.putExtra("listNo",count);
						startActivity(in);
					}
					if(arg2==3)
					{
						count+=3;
						Intent in =new Intent(getActivity(),FoodHandlerActivity.class);
						in.putExtra("listNo",count);
						startActivity(in);
					}
					if(arg2==4)
					{
						count+=4;
						Intent in =new Intent(getActivity(),FoodHandlerActivity.class);
						in.putExtra("listNo",count);
						startActivity(in);
					}
					if(arg2==5)
					{
						count+=5;
						Intent in =new Intent(getActivity(),FoodHandlerActivity.class);
						in.putExtra("listNo",count);
						startActivity(in);
					}
					if(arg2==6)
					{
						count+=6;
						Intent in =new Intent(getActivity(),FoodHandlerActivity.class);
						in.putExtra("listNo",count);
						startActivity(in);
					}
					if(arg2==7)
					{
						count+=7;
						Intent in =new Intent(getActivity(),FoodHandlerActivity.class);
						in.putExtra("listNo",count);
						startActivity(in);
					}
					if(arg2==8)
					{
						count+=8;
						Intent in =new Intent(getActivity(),FoodHandlerActivity.class);
						in.putExtra("listNo",count);
						startActivity(in);
					}
					if(arg2==9)
					{
						count+=9;
						Intent in =new Intent(getActivity(),FoodHandlerActivity.class);
						in.putExtra("listNo",count);
						startActivity(in);
					}
					
					
				}
			});

			
			
		
	        return rootView;
	    }
		
		
	/*	@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.menu, menu);
			
			SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
		//	SearchView searchView = (SearchView)menu.findItem(R.id.menu).getActionView();
			MenuItem item = menu.findItem(R.id.action_search);
			SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
			searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
			
			return true;
		}
		

		@Override
		protected void onNewIntent(Intent intent) {
			// TODO Auto-generated method stub
		//	super.onNewIntent(intent);
			handleIntent(intent);
		}
		
		private void handleIntent(Intent intent)
		{
			if(Intent.ACTION_SEARCH.equals(intent.getAction()))
			{
				String query = intent.getStringExtra(SearchManager.QUERY);
				
			}
		}
		*/
	}