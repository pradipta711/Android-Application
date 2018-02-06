package mustvisitpackage;

//mport com.example.fragmentsapp.R;



import com.dmc.punetravellogue.R;
import com.uni.mapintegration.MapIntegrateAll;

import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		Button btnhowto;

		final View fragView = inflater.inflate(R.layout.firstfrag, container,
				false);

		ActionBar mActionBar = getActivity().getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater mInflater = LayoutInflater.from(getActivity());

		View mCustomView = mInflater.inflate(R.layout.actiontitle, null);
		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.textViewTitle);
		mTitleTextView.setText("DagdhuSeth Temple");

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);

		btnhowto = (Button) fragView.findViewById(R.id.howtoreach1);

		btnhowto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getActivity(), MapIntegrateAll.class);
				in.putExtra("mcount", 1);

				startActivity(in);

			}
		});

		return fragView;
	}
}
