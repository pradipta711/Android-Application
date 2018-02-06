package mustvisitpackage;




import com.dmc.punetravellogue.R;
import com.uni.mapintegration.MapIntegrateAll;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SixthFragment extends Fragment{
	Button btnhowto;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		final View fragView=inflater.inflate(R.layout.fragsix, container,false);
		btnhowto = (Button) fragView.findViewById(R.id.howtoreach6);
		ActionBar mActionBar =getActivity().getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater mInflater = LayoutInflater.from(getActivity());

		View mCustomView = mInflater.inflate(R.layout.actiontitle, null);
		TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.textViewTitle);
		mTitleTextView.setText("Mulshi Dam");
		
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		
		
		btnhowto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getActivity(), MapIntegrateAll.class);
				in.putExtra("mcount", 6);
				 
				startActivity(in);

			}
		});
		return fragView;
	}
}
