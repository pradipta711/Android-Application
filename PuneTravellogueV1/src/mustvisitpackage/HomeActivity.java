package mustvisitpackage;

import java.util.ArrayList;

import com.dmc.punetravellogue.R;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.FrameLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class HomeActivity extends Fragment {

	ListView vlistplaces;
	FrameLayout drawer1, container1;
	ArrayList<PuneMustVisit> alist = new ArrayList<PuneMustVisit>();
	// assume the e have cartoon adapter which will be created later in prog.

	PlacesAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.home, container, false);
		vlistplaces = (ListView) rootView.findViewById(R.id.listVi);
		drawer1 = (FrameLayout) rootView.findViewById(R.id.drawer);
		container1 = (FrameLayout) rootView.findViewById(R.id.container);
		PuneMustVisit p1 = new PuneMustVisit("DagduSeth Temple", R.drawable.dagduseth);
		PuneMustVisit p2 = new PuneMustVisit("Bhimashankar Temple", R.drawable.bhimashankar);
		PuneMustVisit p3 = new PuneMustVisit("Darshan", R.drawable.darshanmus);
		PuneMustVisit p4 = new PuneMustVisit("Aga Khan Palace", R.drawable.aga);
		PuneMustVisit p5 = new PuneMustVisit("Shaniwar Wada", R.drawable.shaniwarwada);
		PuneMustVisit p6 = new PuneMustVisit("Mulshi Dam", R.drawable.mulshi);
		PuneMustVisit p7 = new PuneMustVisit("Palakeshwar Caves", R.drawable.palakeshwar);
		PuneMustVisit p8 = new PuneMustVisit("Singadh Fort", R.drawable.singhadfort);
		PuneMustVisit p9 = new PuneMustVisit("Japanese Garden", R.drawable.japanesegarden);
		PuneMustVisit p10 = new PuneMustVisit("Phoenix Mall", R.drawable.phonix);
		alist.add(p1);
		alist.add(p2);
		alist.add(p3);
		alist.add(p4);
		alist.add(p5);
		alist.add(p6);
		alist.add(p7);
		alist.add(p8);
		alist.add(p9);
		alist.add(p10);
		adapter = new PlacesAdapter();
		vlistplaces.setAdapter(adapter);

		// ActionBar mActionBar = getActionBar();
		// mActionBar.setDisplayShowHomeEnabled(false);
		// mActionBar.setDisplayShowTitleEnabled(false);
		// LayoutInflater mInflater = LayoutInflater.from(this);
		//
		// View mCustomView = mInflater.inflate(R.layout.actiontitle, null);
		// TextView mTitleTextView = (TextView)
		// mCustomView.findViewById(R.id.textViewTitle);
		// mTitleTextView.setText("Must Visit Places");
		//
		// mActionBar.setCustomView(mCustomView);
		// mActionBar.setDisplayShowCustomEnabled(true);

		vlistplaces.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				PuneMustVisit pl = alist.get(arg2);

				if (arg2 == 0) {
					Intent in = new Intent(getActivity(), ShowDescription.class);
					in.putExtra("count", 1);
					// in.putExtra("place",pl);
					startActivity(in);

				}

				if (arg2 == 1) {
					Intent in = new Intent(getActivity(), ShowDescription.class);
					in.putExtra("count", 2);
					// in.putExtra("place",pl);
					startActivity(in);

				}

				if (arg2 == 2) {
					Intent in = new Intent(getActivity(), ShowDescription.class);
					in.putExtra("count", 3);
					// in.putExtra("place",pl);
					startActivity(in);
				}

				if (arg2 == 3) {
					Intent in = new Intent(getActivity(), ShowDescription.class);
					in.putExtra("count", 4);
					// in.putExtra("place",pl);
					startActivity(in);
				}

				if (arg2 == 4) {
					Intent in = new Intent(getActivity(), ShowDescription.class);
					in.putExtra("count", 5);
					// in.putExtra("place",pl);
					startActivity(in);
				}

				if (arg2 == 5) {
					Intent in = new Intent(getActivity(), ShowDescription.class);
					in.putExtra("count", 6);
					// in.putExtra("place",pl);
					startActivity(in);
				}

				if (arg2 == 6) {
					Intent in = new Intent(getActivity(), ShowDescription.class);
					in.putExtra("count", 7);
					// in.putExtra("place",pl);
					startActivity(in);
				}

				if (arg2 == 7) {
					Intent in = new Intent(getActivity(), ShowDescription.class);
					in.putExtra("count", 8);
					// in.putExtra("place",pl);
					startActivity(in);
				}

				if (arg2 == 8) {
					Intent in = new Intent(getActivity(), ShowDescription.class);
					in.putExtra("count", 9);
					// in.putExtra("place",pl);
					startActivity(in);
				}

				if (arg2 == 9) {
					Intent in = new Intent(getActivity(), ShowDescription.class);
					in.putExtra("count", 10);
					// in.putExtra("place",pl);
					startActivity(in);
				}

			}
		});
		return rootView;
	}

	class PlacesAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return alist.size();
		}

		@Override
		public PuneMustVisit getItem(int arg0) {
			// TODO Auto-generated method stub
			return alist.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub

			LayoutInflater inflater = getActivity().getLayoutInflater();
			View itemView = inflater.inflate(R.layout.pimages, null);
			PuneMustVisit p = alist.get(arg0);

			ImageView imageViewPlaces = (ImageView) itemView.findViewById(R.id.imageView1);

			imageViewPlaces.setImageResource(p.getImageId());

			TextView textViewName = (TextView) itemView.findViewById(R.id.textView1);
			textViewName.setText(p.getTitle());

			return itemView;
		}

	}

}
