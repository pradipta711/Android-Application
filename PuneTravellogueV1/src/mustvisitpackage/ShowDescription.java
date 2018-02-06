package mustvisitpackage;





import com.dmc.punetravellogue.R;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.AvoidXfermode.Mode;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class ShowDescription extends FragmentActivity  
{
  ViewPager pager;
  TextView textTravel;  
  PagerTabStrip strip1;
  Bundle data;
  @Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.showdescfrag);
		//textTravel=(TextView)findViewById(R.id.textView1);
		strip1=(PagerTabStrip)findViewById(R.id.pagerTabStrip1);
		
		//display travel data
		//Intent in=getIntent();
		//textTravel.setText(in.getStringExtra("travel"));
	
		//initialize pager

		
		
		pager=(ViewPager)findViewById(R.id.viewPager1);
		MyPagerAdapter adapter=new MyPagerAdapter
				( getSupportFragmentManager() );
		
		pager.setAdapter(adapter);
		
	}
  
  
 
  
  
 class MyPagerAdapter extends FragmentPagerAdapter
 {

	public MyPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
	
	Intent in=getIntent();
	int count=in.getIntExtra("count", 0);
	data=new Bundle();
	data.putInt("countValue", count);
	if(count==1)
	{
		if(arg0==0)
		return new  FirstFragment();
		if(arg0==1)
		{
			LoginFragment login=new LoginFragment();
			login.setArguments(data);
		return login;
			
		}
		
	}
	if(count==2)
	{
		if(arg0==0)
		return new  SecondFragment();
		if(arg0==1)
		{
			LoginFragment login=new LoginFragment();
			login.setArguments(data);
		return login;
		}
	}
	
	if(count==3)
	{
		if(arg0==0)
		return new  ThirdFragment();
		if(arg0==1)
		{
			LoginFragment login=new LoginFragment();
			login.setArguments(data);
		return login;
		}
		
	}
	
	if(count==4)
	{
		if(arg0==0)
		return new  FourthFragment();
		if(arg0==1)
		{
			LoginFragment login=new LoginFragment();
			login.setArguments(data);
		return login;
		}
		
	}
	
	if(count==5)
	{
		if(arg0==0)
		return new  FifthFragment();
		if(arg0==1)
		{
			LoginFragment login=new LoginFragment();
			login.setArguments(data);
		return login;
		}
		
	}
	
	if(count==6)
	{
		if(arg0==0)
		return new  SixthFragment();
		if(arg0==1)
		{
			LoginFragment login=new LoginFragment();
			login.setArguments(data);
		return login;
		}
		
	}
	
	if(count==7)
	{
		if(arg0==0)
		return new  SeventhFragment();
		if(arg0==1)
		{
			LoginFragment login=new LoginFragment();
			login.setArguments(data);
		return login;
		}
		
	}
	
	if(count==8)
	{
		if(arg0==0)
		return new  EighthFragment();
		if(arg0==1)
		{
			LoginFragment login=new LoginFragment();
			login.setArguments(data);
		return login;
		}
	}
	
	if(count==9)
	{
		if(arg0==0)
		return new  NinthFragment();
		if(arg0==1)
		{
			LoginFragment login=new LoginFragment();
			login.setArguments(data);
		return login;
		}
		
	}
	
	if(count==10)
	{
		if(arg0==0)
		return new  TenthFragment();
		if(arg0==1)
		{
			LoginFragment login=new LoginFragment();
			login.setArguments(data);
		return login;
		}
	}
	
	
	
	
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}	 
	@Override
	public CharSequence getPageTitle(int position) 
	{
		// TODO Auto-generated method stub
		if(position==0)
		return "About";
		if(position==1)
			return "Comment";
	
		return null;
	}
 }


}

