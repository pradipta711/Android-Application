package mustvisitpackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.dmc.punetravellogue.R;

import cdac.loginandegistration.WebHelper;



import android.R.anim;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewCommentFragment extends Activity {

	ListView listviewcomments;
	//ArrayAdapter<Comment> adapter;
	ArrayList<Comment> l1;
	CommentAdapter adapter;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewcommentlist);
		Intent in = getIntent();
		listviewcomments = (ListView) findViewById(R.id.listViewComment);
		int locid = in.getIntExtra("locId", 0);
		String url = WebHelper.CommentURL + "/fetchCommentServlet?locationId="
				+ locid;
		FetchCommentTask task = new FetchCommentTask();
		task.execute(url);

	}

	class FetchCommentTask extends AsyncTask<String, Void, String> {

		ProgressDialog pd = null;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(ViewCommentFragment.this);
			pd.setTitle("Login Progress...");
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) {
			System.out.println("@@in post");
			String result = "";
			String url = params[0];
			HttpGet getRequest = new HttpGet(url);
			try {
				HttpClient client = new DefaultHttpClient();
				HttpResponse response = client.execute(getRequest);
				InputStream is = response.getEntity().getContent();

				// Convert i/p to String
				InputStreamReader reader = new InputStreamReader(is);
				BufferedReader bufferedReader = new BufferedReader(reader);
				while (true) {
					String line = bufferedReader.readLine();
					if (line == null)
						break;
					else {
						result = result + line;
						System.out.println("@@result" + result);
					}
				}
				bufferedReader.close();

			} catch (Exception ex) {
				Log.e("Error", "unable to connect " + ex.getMessage());
			}
			System.out.println("!!! do test");
			return result;
			/*
			 * String resultfromserver=""; String loginUrl=params[0];
			 * System.out.println("@@@ url="+loginUrl);
			 * 
			 * 
			 * Log.e("in do in bacground", loginUrl); try {
			 * 
			 * URL url=new URL(loginUrl); System.out.println("!!! one");
			 * HttpURLConnection
			 * httpCon=(HttpURLConnection)url.openConnection();
			 * System.out.println("!!! 2"); httpCon.setRequestMethod("GET");
			 * System.out.println("!!! 3"); httpCon.connect();
			 * System.out.println("!!! 4"); //Log.e("in do in background",
			 * "connected"); //chech if conn exist
			 * System.out.println("@@@ status1="+httpCon.getResponseCode());
			 * if(httpCon.getResponseCode()==HttpURLConnection.HTTP_OK) {
			 * System.out.println("@@@ status="+httpCon.getResponseCode());
			 * InputStream is=httpCon.getInputStream(); InputStreamReader
			 * reader=new InputStreamReader(is); BufferedReader br=new
			 * BufferedReader(reader); while(true) { String line=br.readLine();
			 * if(line == null) break; else resultfromserver+=line; }
			 * 
			 * // Log.e("in do in bacground", resultfromserver); br.close();
			 * httpCon.disconnect();
			 */

		}

		@Override
		protected void onPostExecute(String result) {
			// super.onPostExecute(result);
			System.out.println("!!! result in post1 ::" + result.toString());

			pd.dismiss();
			Toast.makeText(ViewCommentFragment.this, result, 5).show();
			Log.e("Login", result);
			System.out.println("!!! result in post ::" + result);
			// Save profile data received from server
			try {
				l1 = new ArrayList<Comment>();
				JSONObject jobj = new JSONObject(result);
				System.out.println(jobj);
				JSONArray jsonarray = jobj.getJSONArray("list");
				System.out.println("@@jsonarray" + jsonarray);
				for (int i = 0; i < jsonarray.length(); i++) {

					JSONObject comm = (JSONObject) (jsonarray.getJSONObject(i));
					Comment obj = new Comment(comm.getString("emailId"),
							comm.getString("desrptn"),
							comm.getString("curr_date"));
					System.out.println("!!data in list"+comm.getString("emailId")+" "+comm.getString("desrptn"));
					l1.add(obj);
					System.out.println("!!dataaaaa"+l1);
					//adapter.notifyDataSetChanged();
				}

				System.out.println("!!! list size::" + l1.size());
				adapter = new CommentAdapter();
						//android.R.layout.simple_list_item_1, l1);
				listviewcomments.setAdapter(adapter);

				String strResult = jobj.getString("result");
				System.out.println("@@Data in arrayList" + l1);
				if (strResult.equalsIgnoreCase("data found")) {

					Toast.makeText(ViewCommentFragment.this, "found", 5).show();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	class CommentAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return l1.size();
		}

		@Override
		public Comment getItem(int arg0) {
			// TODO Auto-generated method stub
			return l1.get(arg0);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inlater=getLayoutInflater();
			View item_view=inlater.inflate(R.layout.commentcustomadapter,null);
			TextView txtemail=(TextView)item_view.findViewById(R.id.textViewemail);

			TextView txtcomment=(TextView)item_view.findViewById(R.id.textViewcomment);

			TextView txtdate=(TextView)item_view.findViewById(R.id.textViewpostedDate);
			Comment obj=l1.get(position);
			txtemail.setText(obj.getEmail());
			txtcomment.setText(obj.getDesc());
			txtdate.setText(obj.getPost_date());
			return item_view;
		}
		
	}

}
