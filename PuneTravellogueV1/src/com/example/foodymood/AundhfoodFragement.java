package com.example.foodymood;

import java.util.ArrayList;




import com.dmc.punetravellogue.R;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AundhfoodFragement extends Fragment {
	//ListView listItem;
	FoodAdapter adapter;
	ListView listbook;
	int getCount;
	TextView mTitleTextView;
	ArrayList<RestDetails> restList = new ArrayList<RestDetails>();
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	View v=inflater.inflate(R.layout.home, container,false);
	getCount=getArguments().getInt("countValue");
	listbook=(ListView)v.findViewById(R.id.listVi);
	ActionBar mActionBar = getActivity().getActionBar();
	mActionBar.setDisplayShowHomeEnabled(false);
	mActionBar.setDisplayShowTitleEnabled(false);
	LayoutInflater mInflater = LayoutInflater.from(getActivity());

	View mCustomView = mInflater.inflate(R.layout.actionbar_view, null);
	 mTitleTextView = (TextView) mCustomView.findViewById(R.id.title);
	
	
	//for restaurant in aundh Area
	if(getCount==0)
	{
	RestDetails obj1=new RestDetails(R.drawable.cinnamon, "Cinnamon", "Cuisine:Indian", "Timings:11am-3pm,7pm-11pm", "Part of Seasons Hotel, Sanewadi, Aundh,Pune, Maharashtra 411007");
	RestDetails obj2=new RestDetails(R.drawable.flavours,"Flavours","Cuisine:Indian, Multi-Cuisine ","Timings:11am-3pm,7pm-11pm","128/2, Sanewadi, Aundh, Pune, Maharashtra 411007 Phone:020 4000 9999");
	RestDetails obj3=new RestDetails(R.drawable.shivsagar, "ShivSagar", "Cuisine:Indian", "Timings:Monday - Sunday: 8.30 AM - 11.30 PM", "Address No. 157/22, DP Road, Aundh, Pune  - 411007 Land Mark: Near DAV School");
	RestDetails obj4=new RestDetails(R.drawable.greensnolives, "Greens and Olives", "Cuisine:Italian", "Hours: 12–3PM, 7–11PM", "Address: 163, Harsh Orchid, Opposite Tangent Furniture Mall, New D.P. road, Nagras Road, Pune, Maharashtra 411007 Phone:020 3267 3030");
	RestDetails obj5=new RestDetails(R.drawable.kobesizzlers,"Kobe Sizzlers", "Cuisine:Sizzlers", "Hours: 11AM–11PM", "Address: 1028, Shikshak Society, Sanewadi, Aundh, Pune, Maharashtra 411007 Phone:020 2588 7577");
	
	restList.add(obj1);
	restList.add(obj2);
	restList.add(obj3);
	restList.add(obj4);
	restList.add(obj5);
	adapter=new FoodAdapter();
	listbook.setAdapter(adapter);
	mTitleTextView.setText("Aundh");
	mActionBar.setCustomView(mCustomView);
	mActionBar.setDisplayShowCustomEnabled(true);
	ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
	   p.gravity = Gravity.CENTER;
	return v;
	}
	//for restaurant in baner area
	else if(getCount==1)
	{
		RestDetails obj1=new RestDetails(R.drawable.lingeron, "Linger On", "Cuisine: Continental, fastfood, Desert", "Timings: 11am-11pm", "Address: Baner Rd, Baner, Pune, Maharashtra 411045");
		RestDetails obj2=new RestDetails(R.drawable.magnolia,"Magnolia", "Cuisine: Chinese, Indian, Oriental, Thai", "Timings: 10AM–10PM", "Address: 265, Baner Rd, Varsha Park Society, Baner, Pune, Maharashtra 411045 Phone:020 3018 9856");
		
		
		RestDetails obj3=new RestDetails(R.drawable.makkhanmark, "Makkhan Mar ke", "Cuisine: Indian", "Timings: 11AM–3PM, 7–11PM", "Address: Ground Floor, Rituraj Apartment, Near Mauli Garden, Baner Road, Pune, Maharashtra 411045  Phone:020 6500 0421");
		RestDetails obj4=new RestDetails(R.drawable.thegreatpunjab, "The Great Punjab", "Cuisine: Punjabi, Indian ", "Timings: 11:30AM–3:30PM, 6:30–11:30PM", "Address: 1 A/B, Sai Empire, Baner Road, Near Petrol Pump, Opposite Malaka Spice, Pune, Maharashtra 411045  Phone:020 2720 727");
		RestDetails obj5=new RestDetails(R.drawable.veranda, "Veranda", "Cuisine: Indian, Chinese", "Timings:11am-3pm; 7pm-11pm ", "Address: 182, Baner Rd, Baner, Pune, Maharashtra 411045 Phone:098509 27060");
		restList.add(obj1);
		restList.add(obj2);
		restList.add(obj3);
		restList.add(obj4);
		restList.add(obj5);
		adapter=new FoodAdapter();
		listbook.setAdapter(adapter);
		
		mTitleTextView.setText("Baner");
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		   p.gravity = Gravity.CENTER;
		return v;
		
	}
	//for camp
	else if(getCount==2)
	{
		RestDetails obj1 = new RestDetails(R.drawable.eaststreetcafe,"11 East Street Cafe", "Cuisine:Pizza, Multi-Cuisine,Lebanese ", "Timings:11am-11pm ","Address:  View In Plaza, Indira Gandhi Chowk, East St Road, Camp, Pune, Maharashtra 411001 Phone:020 4104 5500 ");
		RestDetails obj2 = new RestDetails(R.drawable.grand," 33 Grand", "Cuisine: Chinese, Continental, Indian", "Timings:12pm-3pm; 7pm-11pm " , "Address:6 MG Road, 2433 East Street, Pune ");
		RestDetails obj3 = new RestDetails(R.drawable.indianaroma," Indian Aroma", "Cuisine:Chinese, Indian,Lebanese,South Indian ", "Timings:12pm-10pm " , "Address:Synagogue St, Modi Colony, Pune ");
		RestDetails obj4 = new RestDetails(R.drawable.miami," Miami Pure Veg", "Cuisine: Multi-Cuisine", "Timings:11am-11pm " , "Address:156, M.G. Road, Behind Talwalkar Gym, Camp, Pune ");
		RestDetails obj5 = new RestDetails(R.drawable.smokinjoes," Smokin' Joe's", "Cuisine: Pizza", "Timings:11am-11pm " , "Address:1, Sterling Centre, M.G. Road, Camp, Pune, Maharashtra 411001 Phone:020 2612 4790 ");
		
		restList.add(obj1);
		restList.add(obj2);
		restList.add(obj3);
		restList.add(obj4);
		restList.add(obj5);
		
		adapter = new FoodAdapter();
		listbook.setAdapter(adapter);
		mTitleTextView.setText("Camp");
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		   p.gravity = Gravity.CENTER;
		return v;
	}
	
	else if(getCount==3)
	{
		RestDetails obj1 = new RestDetails(R.drawable.aabacha,"Aabacha Dhaba ", "Cuisine: North Indain, Mughlai", "Timings: 11:30AM–10:30PM " , "Address:Malhar Apartment, Keshav Nagar Near Indian Oil Petrol Pump, Pimpri Saudagar Rd, Sai Nagar Park, Pimple Saudagar, Pune, Maharashtra Phone:020 4001 5244");
		RestDetails obj2 = new RestDetails(R.drawable.bayleafbistro," Bay Leaf Bistro", "Cuisine: North Indian, Chinese, South Indian, Fast Food", "Timings: 11am-11pm " , "Address: Address: Shantiban Society, Near Juna Jakat Naka, Chinchwad, Pune, Maharashtra 411033 Phone:020 2735 2929");
		RestDetails obj3 = new RestDetails(R.drawable.chawadi," Chawadi Restaurant ", "Cuisine: North Indian, Chinese , Sea food ", "Timings: 11am-3pm; 7pm-11pm " , "Address: Address: Chinchwad, Pimpri-Chinchwad, Maharashtra 411033 ");
		RestDetails obj4 = new RestDetails(R.drawable.mayurvegthali," Mayur Veg Thali Restaurant ", "Cuisine: Gujrati, Rajasthani", "Timings: 12–3PM, 7:30–10PM " , "Address: No. 201, Ajay Chamber, Near Jain Mandir, Opp Jayshree Cinema, Kalbhor Nagar, Pimpri Chinchwad, Pune, Maharashtra 411019 Phone:020 2747 699");
		RestDetails obj5 = new RestDetails(R.drawable.pangs," Pang's", "Cuisine: Chinese", "Timings: 12–3PM, 7–11PM " , "Address: Aryan Heights, Sector CDC, Beside Nakshatra Housing Society, Purnanagar, Pimpri-Chinchwad, Maharashtra 411019 Phone:020 6570 9090 ");
		
		restList.add(obj1);
		restList.add(obj2);
		restList.add(obj3);
		restList.add(obj4);
		restList.add(obj5);
		
		adapter = new FoodAdapter();
		listbook.setAdapter(adapter);
		
		mTitleTextView.setText("Chinchwad");
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		   p.gravity = Gravity.CENTER;
		return v;
	}
	//foe deccan
	else if(getCount==4)
	{
		

		RestDetails obj1 = new RestDetails(R.drawable.amrapali, "Amrapali ", "Cuisine: Indian", "Timings: 12PM–3PM, 7–11PM" ,"Address: 1227, Fergusson College Road, Pune, Maharashtra 411004 Phone:020 2553 1252");
		RestDetails obj2 = new RestDetails(R.drawable.bbqnation,"Barbeque Nation", "Cuisine: Multi-Cuisine","Timings: 12PM–3PM, 7–11PM", "Address: Deccan Mall,J M Road, Deccan Gymkhana, Pune, Maharashtra 411004 Phone:020 6060 0002");
		RestDetails obj3 = new RestDetails(R.drawable.curryontheroof, "Curry On The Roof ", "Cuisine: Indian", "Timings: 11AM–3PM, 7–11PM" ,"Address: Hotel Royalty, F.P No. 42B, C.T.S No. 114B, Prabhat Road, Erandwane, Pune, Maharashtra 411004 Phone:020 2546 6793");
		RestDetails obj4 = new RestDetails(R.drawable.littleitaly, "Little Italy ", "Cuisine: Italian", "Timings: 12PM–3:30PM, 7AM–11:30PM" ,"Address: Park Plaza, 465/C1, CTS - 1085, Next to Pune Central Mall-2, Ganeshkhind Rd, Shivajinagar, Pune, Maharashtra 411005 Phone:020 2566 222");
		RestDetails obj5 = new RestDetails(R.drawable.subway, "Subway ", "Cuisine: Fast Food", "Timings: 11AM-11PM" ,"Address: Shop no.1, Lunkad Villa, Law College Road, Deccan, Pune");
		
		restList.add(obj1);
		restList.add(obj2);
		restList.add(obj3);
		restList.add(obj4);
		restList.add(obj5);
		
		adapter = new FoodAdapter();
		listbook.setAdapter(adapter);
		mTitleTextView.setText("Deccan");
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		   p.gravity = Gravity.CENTER;
		return v;
	}
	//for hadapsar
	else if(getCount==5)
	{
		
		RestDetails obj1 = new RestDetails(R.drawable.malini, "Malini Family Restaurant ", "Cuisine: Chinese, North Indian, Sea Food", "Timings: 10:30AM-11:30PM" ,"Address: Address: Magarpatta City, Near icici Bank, Pune, Maharashtra 411028 Phone:020 2687 263");
		RestDetails obj2 = new RestDetails(R.drawable.ambika, "Ambika Family Restaurant", "Cuisine: North indian, Chinese", "Timings: 11AM–3:30PM, 7–11PM" ,"Address: D. P. Road, Rushikesh Park, Opp. Handball Stadium, Sadesatra Nali Road,, Hadapsar, Pune, Maharashtra 411028 Phone:020 6529 204");
		RestDetails obj3 = new RestDetails(R.drawable.deccanharvest, "Deccan Harvest ", "Cuisine: Multi-Cuisine", "Timings: 11AM–3PM, 7–11:30PM" ,"Address: SR 143, Opposite Tower 1, Off Pune Solapur Road, Magarpatta, Hadapsar, Pune, Maharashtra 411013 Phone:098220 0034");
		RestDetails obj4 = new RestDetails(R.drawable.krishnachhaya, "Krishna Chaya Pure Veg Restaurant", "Cuisine: Multi-Cuisine", "Timings: 7:30am-11pm" ,"Address: Malwadi Rd, Hadapsar Gaon, Hadapsar, Pune, Maharashtra 411028");
		RestDetails obj5 = new RestDetails(R.drawable.tiranga, "Tiranga Hotel", "Cuisine: Indian", "Timings: 11am-4pm, 7pm-11pm" ,"Address: Shop No 5, Prithvi Apartment, Opp. Bhosale Garden, Aaru Nagar, Wanowri, Hadapsar, Pune, Maharashtra 411028 Phone:020 2681 070");
		
		restList.add(obj1);
		restList.add(obj2);
		restList.add(obj3);
		restList.add(obj4);
		restList.add(obj5);
		
		adapter = new FoodAdapter();
		listbook.setAdapter(adapter);
		mTitleTextView.setText("Hadapsar");
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		   p.gravity = Gravity.CENTER;
		return v;
	}
	//for hinjewadi
	else if(getCount==6)
	{
		RestDetails obj1 = new RestDetails(R.drawable.eatsome, "Eat Some", "Cuisine: Fast-Food", "Timings: 11AM-11PM" ,"Address: MIDC Shopping Complex, Opposite Post Office, Phase 1, Hinjewadi Infotech Park, Hinjawadi, Pune, Maharashtra 411057 Phone:093255 45355");
		RestDetails obj2 = new RestDetails(R.drawable.indianinabox, "Indian in a Box", "Cuisine: Fast-Food", "Timings: 11:30AM-11PM" ,"Address: Hinjawadi, Pune, Maharashtra 411057 Phone:020 2293 1800");
		RestDetails obj3 = new RestDetails(R.drawable.mastkalandar, "Mast Kalandar ", "Cuisine: Indian", "Timings: 11am-3pm ; 7am-11pm" ,"Address: Survey no. 152/2/1C, near Mc Donald,Hinjewadi ");
		RestDetails obj4 = new RestDetails(R.drawable.gharkakhana1, "Ghar ka Khana ", "Cuisine: Indian", "Timings: 12–3:30PM, 7:30–11:30PM" ,"Address: Opp. Mind Tree, Phase 1, Hinjewadi Rajiv Gandhi Infotech Park, Hinjawadi, Pune, Maharashtra 411057 Phone:098227 98143");
		RestDetails obj5 = new RestDetails(R.drawable.swadpunjabka, "Swad Punjab ka", "Cuisine: Multi-Cuisine", "Timings: 11am-3pm; 7pm-11pm" ,"Address: S.no.262,Marunjee Road, Luxmi Chowk,Hinjewadi, Pune, Maharashtra 411057 Phone:084469 11771");
		
		restList.add(obj1);
		restList.add(obj2);
		restList.add(obj3);
		restList.add(obj4);
		restList.add(obj5);
		
		adapter = new FoodAdapter();
		listbook.setAdapter(adapter);
		mTitleTextView.setText("Hinjewadi");
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		   p.gravity = Gravity.CENTER;
		return v;
	}
	//for magarpatta
	else if(getCount==7)
	{
		
		RestDetails obj1 = new RestDetails(R.drawable.satguruspunjabirasoi, "Satguru's Punjabi Rasoi", "Cuisine: Indian", "Timings: 11am-4pm ; 7am-11pm" ,"Address: BG 42-16, Destination Centre, Magarpatta City, Hadapsar, Pune, Maharashtra 411028 Phone:020 2689 8522");
		RestDetails obj2 = new RestDetails(R.drawable.thechefs, "The Chef's Cuisine ", "Cuisine: Indian,Chinese", "Timings: 11am-4pm ; 7am-11pm" ,"Address: Destination Centre, Magarpatta City, Pune, Magarpatta City, Hadapsar, Pune, Maharashtra 411028");
		RestDetails obj3 = new RestDetails(R.drawable.rollsmania1, "Rolls Mania ", "Cuisine: Fast-Food", "Timings: 12pm-11pm" ,"Address: BG-24, Destination Centre, Near PNB Bank, Magarpatta City, Hadapsar, Pune, Maharashtra 411028 Phone:020 6511 7494 ");
		RestDetails obj4 = new RestDetails(R.drawable.globalpunjab, "Global Punjab ", "Cuisine: Punjabi,Indian", "Timings: 12–3:30PM, 7PM–11:30AM" ,"Address: Destination Centre, Magarpatta City, Hadapsar, Pune, Maharashtra 411028 Phone:020 6722 3977");
		RestDetails obj5 = new RestDetails(R.drawable.cafemangii, "Cafe Mangii", "Cuisine: Italian", "Timings: 12pm-11pm" ,"Address: Amanora Town Center, Magarpatta City,Pune");
		
		restList.add(obj1);
		restList.add(obj2);
		restList.add(obj3);
		restList.add(obj4);
		restList.add(obj5);
		
		adapter = new FoodAdapter();
		listbook.setAdapter(adapter);
		mTitleTextView.setText("MagarPatta");
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		   p.gravity = Gravity.CENTER;
		return v;
	}
	//for pimpari
	else if(getCount==8)
	{
		
		
		RestDetails obj1 = new RestDetails(R.drawable.dalchini, "Dalchini ", "Cuisine: Indian,Chinese", "Timings: 12pm-3pm; 7pm-11pm" ,"Address: First floor, Rainbow Plaza, Rahatani Rd, Dwarkadheesh Gardens, Rahatani, Pimpri-Chinchwad, Maharashtra 411017 Phone:020 2720 6447");
		RestDetails obj2 = new RestDetails(R.drawable.kareems, "Kareem's", "Cuisine: Indian", "Timings: 11:30am-3:30pm; 6:30pm-11:30pm" ,"Address: Shop no.16, Rainbow Plaza, Pimple Saudagar");
		RestDetails obj3 = new RestDetails(R.drawable.petpooja, "PetPooja", "Cuisine: Indian", "Timings: 10am-10pm" ,"Address: Near Dr. Dy. Patil College, Dr Babasaheb Ambedkar Rd, Pradhikaran, Nigdi, Pimpri-Chinchwad, Maharashtra 411044 Phone:088056 84707");
		RestDetails obj4 = new RestDetails(R.drawable.piraeuscafe, "Piraeus Cafe", "Cuisine: Fast-Food", "Timings: 12pm-11pm" ,"Address: Govind Garden Chowk, near DP road, Pimple Saudagar ");
		RestDetails obj5 = new RestDetails(R.drawable.shivargarden, "Shivar Garden", "Cuisine: Multi-Cuisine", "Timings: 11pm-11pm" ,"Address: Sr.No.18 / 11 / 6, Jagtap Dairy Road,Shivar Chowk, Rahatani, Pune-411 017.");
		
		restList.add(obj1);
		restList.add(obj2);
		restList.add(obj3);
		restList.add(obj4);
		restList.add(obj5);
		
		adapter = new FoodAdapter();
		listbook.setAdapter(adapter);
		mTitleTextView.setText("Pimpari");
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		   p.gravity = Gravity.CENTER;
		return v;
	}
	//for viman nagar
	else if(getCount==9)
	{
		
		RestDetails obj1 = new RestDetails(R.drawable.bhagattarachand, "R. Bhagat Tarachand", "Cuisine: Indian", "Timings: 11AM–4PM, 7–11PM" ,"Address: Shop No. 709, 2nd Floor, City Jewel Mall, Laxmi Road, Opposite Om Supermarket, Shagun Chowk, Narayan Peth, Pune, Maharashtra 411030 Phone:020 2445 7799 ");
		RestDetails obj2 = new RestDetails(R.drawable.chetna, "Hotel Chetna", "Cuisine: Indian", "Timings: 11:30am-3:30pm; 7:30pm-11pm" ,"Address: 884, Bhudhwar peth, Pune, Maharashtra 411002 Phone:020 2447 5455");
		RestDetails obj3 = new RestDetails(R.drawable.fishcurryrice, "Fish Curry Rice ", "Cuisine: Coastal", "Timings: 11:30AM–3PM, 7:30–11PM " ,"Address: 586, Gangadhar Apartment, Near Kanya Shala, Narayan Peth, Pune, Maharashtra 411030 Phone:020 6401 1082");
		RestDetails obj4 = new RestDetails(R.drawable.rasoidininghall, "Rasoi Dining Hall", "Cuisine: Indian", "Timings: 11:30AM–2:30PM, 7:30–10:30PM" ,"Address: 324, Shaniwar Peth, Lakshmi - Madhaw Apartments, Pune, Maharashtra 411030 Phone:088887 40930");
		RestDetails obj5 = new RestDetails(R.drawable.satkar, "Hotel Satkar", "Cuisine: Multi-Cuisine", "Timings: 7:30AM-11pm" ,"Address: Budhwar Peth, Narayan Peth, Pune, Maharashtra 411002 Phone:020 2446 2276");
		
		restList.add(obj1);
		restList.add(obj2);
		restList.add(obj3);
		restList.add(obj4);
		restList.add(obj5);
		
		adapter = new FoodAdapter();
		listbook.setAdapter(adapter);
		mTitleTextView.setText("Viman Nagar");
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		   p.gravity = Gravity.CENTER;
		return v;
	}
	
	
	
	else
		return super.onCreateView(inflater, container, savedInstanceState);
	
	
	
	
	
	
	
}
//base adapter for aundh fragement
class FoodAdapter extends BaseAdapter
{

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return restList.size();
	}

	@Override
	public RestDetails getItem(int arg0) {
		// TODO Auto-generated method stub
		return restList.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=getActivity().getLayoutInflater();
		View  itemView=inflater.inflate(R.layout.custadapter, null);
		
		//fill itemView with book object data
		final RestDetails foodmenu=restList.get(position);
		TextView textname=(TextView) itemView.findViewById(R.id.textViewName);
	textname.setText(foodmenu.getName());
	TextView textcuisine=(TextView) itemView.findViewById(R.id.textViewCuisine);
	textcuisine.setText(foodmenu.getCuisine());
	TextView texttiming=(TextView)itemView.findViewById(R.id.textViewTiming);
	texttiming.setText(foodmenu.getTiming());
	TextView textDesc=(TextView)itemView.findViewById(R.id.textViewDetails);
	textDesc.setText(foodmenu.getDetails());
	ImageView img=(ImageView)itemView.findViewById(R.id.imageView1);
	img.setImageResource(foodmenu.getImgid());

		
		return itemView;
	}
	
}

}
