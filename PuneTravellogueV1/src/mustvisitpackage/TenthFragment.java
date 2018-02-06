package mustvisitpackage;





import com.dmc.punetravellogue.R;
import com.uni.mapintegration.MapIntegrateAll;

import android.support.v4.app.*;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class TenthFragment extends Fragment {
	Button btn10;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		final View fragView = inflater.inflate(R.layout.fragten, container,
				false);
		
		btn10 = (Button) fragView.findViewById(R.id.howtoreach10);
		ActionBar mActionBar =getActivity().getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater mInflater = LayoutInflater.from(getActivity());

		View mCustomView = mInflater.inflate(R.layout.actiontitle, null);
		TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.textViewTitle);
		mTitleTextView.setText("Pu La Deshpande Garden");

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		
		
		
		btn10.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent in = new Intent(getActivity(), MapIntegrateAll.class);
				in.putExtra("mcount", 10);
				
				startActivity(in);
				// .getContext().startActivity(in);

				/*
				 * FragmentTransaction
				 * ft=getFragmentManager().beginTransaction();
				 * ft.replace(R.id.descContainer, new SecondFragment());
				 * ft.commit();
				 */

			}
		});

		return fragView;

	}
}
