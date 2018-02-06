package mustvisitpackage;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cdac.loginandegistration.WebHelper;

import com.dmc.punetravellogue.R;

import mustvisitpackage.RegistrationFragment.RegistrationTask;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCommentFragment  extends Fragment{

	EditText editComment;
	Button btnPost,btnviewComment;
	int locid;
	//Bundle data;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		int count=0;
		View fragView=inflater.inflate(R.layout.commentfrag, container,false);
		
		editComment= (EditText) fragView.findViewById(R.id.editComment);
		btnPost= (Button) fragView.findViewById(R.id.butnPost);
		btnviewComment = (Button) fragView.findViewById(R.id.butnViewCom);
		locid=getArguments().getInt("loc");
		btnPost.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				String eml =getArguments().getString("username");
				String curr_dt=getDate();
				String desc=editComment.getText().toString();
				 
				//add comment task
				//data=new Bundle();
				//data.putInt("forLoc", locid);
				int getId=getArguments().getInt("frgmtId");
				System.out.println("@@Today date"+curr_dt);
				String id=String.valueOf(locid);
				String url = WebHelper.CommentURL+"/commentServlet";
				
				AddCommentTask task = new AddCommentTask();
			task.execute(url,id,eml,desc,curr_dt);
				
				
				
			}
		});
		
		btnviewComment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent(getActivity(),ViewCommentFragment.class);
				in.putExtra("locId", locid);
				startActivity(in);
				/*Fragment regist=new ViewCommentFragment();
				FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
				                    fragTransaction.replace(R.id.loginContainer,regist);
				                    regist.setArguments(data);
				                    fragTransaction.addToBackStack(null);
				                    fragTransaction.commit();*/
				
				
				
				
			}
		});
		
		
		return fragView;
	}
	//for getting date
	public String getDate()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);
		return reportDate;
	}

	//addComment Task
	
	class AddCommentTask extends AsyncTask<String, Void, String> {

		ProgressDialog pd = null;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(getActivity());
			pd.setTitle("Posrting Progress...");
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) {
			String registerurl = params[0];
			String loid=params[1];
			
			String	email=params[2];
			String desc=params[3];
			String posting_date=params[4];
			String result = "";
			try {
				// This url is used to connect with Server
				URL url = new URL(registerurl);
				
				// This will open the server connection
				HttpURLConnection httpconnection = (HttpURLConnection) url
						.openConnection();
				
				httpconnection.setRequestMethod("POST");
				
				
				//Create KeyValue pair for data
				
				StringBuilder builder=new StringBuilder();
				
				builder.append(URLEncoder.encode("locationId", "UTF-8"));
				builder.append("=");
				builder.append(URLEncoder.encode(loid, "UTF-8"));
				
				builder.append("&");
			
				builder.append(URLEncoder.encode("emailId", "UTF-8"));
				builder.append("=");
				builder.append(URLEncoder.encode(email, "UTF-8"));
				builder.append("&");
				builder.append(URLEncoder.encode("about", "UTF-8"));
				builder.append("=");
				builder.append(URLEncoder.encode(desc, "UTF-8"));
				
				builder.append("&");
				builder.append(URLEncoder.encode("current_date", "UTF-8"));
				builder.append("=");
				builder.append(URLEncoder.encode(posting_date, "UTF-8"));
				
			
				
				
				//This enables the output,input streams
				httpconnection.setDoInput(true);
				httpconnection.setDoOutput(true);
				
				OutputStream httpout=httpconnection.getOutputStream();
				PrintStream httpStream=new PrintStream(httpout);
				httpStream.print(builder.toString());
				httpStream.flush();
				httpStream.close();
				// COnnectio made here
				System.out.println("@@before connected");
				httpconnection.connect();
				System.out.println("@@connected");
				// Check if connection is exist
				if (httpconnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					InputStream is= httpconnection.getInputStream();
					InputStreamReader reader = new InputStreamReader(is);
					BufferedReader bf = new BufferedReader(reader);
					while (true) {
						String line = bf.readLine();
						if (line == null)
							break;
						else {
							result = result + line;
							System.out.println("@@Result"+result);
						}
					}
					bf.close();
					httpconnection.disconnect();
				}

			} catch (Exception e) {

			}
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			pd.hide();
			Toast.makeText(getActivity(), result, 5).show();
			System.out.println("@@@Posting"+result);
		}
	}
	
	
	//end of addcomment task
	
	
	
	
	
	
	
}
