package mustvisitpackage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;






import cdac.loginandegistration.Validation;

import com.dmc.punetravellogue.R;

import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;



public class LoginFragment extends Fragment{

	EditText txtusername,txtpasswd;
	Button btnlogin,btnregister;
	FrameLayout frameDrawer,frameContainer;
	Bundle newData;
	int getCount=0;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fragView=inflater.inflate(R.layout.login, container,false);
		getCount=getArguments().getInt("countValue");
		System.out.println("@@@@"+getCount);
		newData=new Bundle();
		newData.putInt("loc",getCount);
	frameDrawer=(FrameLayout) fragView.findViewById(R.id.loginDrawer);	

	frameContainer=(FrameLayout) fragView.findViewById(R.id.loginContainer);	
	txtusername=(EditText) fragView.findViewById(R.id.editusername);
	txtpasswd=(EditText) fragView.findViewById(R.id.editPasswd);
	btnlogin=(Button) fragView.findViewById(R.id.butnLogin);
	btnregister=(Button) fragView.findViewById(R.id.butnRegister);
	
	btnlogin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
					
			// TODO Auto-generated method stub
			
			String email = txtusername.getText().toString();
			String password = txtpasswd.getText().toString();
			
			if (Validation.LoginActivityValidation(email, password, getActivity())) {
				newData.putString("username",email);
				
				Log.e("email &password", email+" "+password);
				// 192.168.76.98:9090/DailyExpenseManagerWeb/LoginServlet?email=p%40gmail.com&password=123456
				String url = cdac.loginandegistration.WebHelper.BASEURL+"/login?email="+email+"&password="+password;
				LoginTask task = new LoginTask();
				task.execute(url);
			}
			
			
			
		
		}
	});
	
	
	
	
	
	
	
	
	
	
	btnregister.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
			
			
			
			
			
			
			
			
			Fragment regist=new RegistrationFragment();
			FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
			                    fragTransaction.replace(R.id.loginContainer,regist);
			                    
			                    fragTransaction.addToBackStack(null);
			                    fragTransaction.commit();
			
			
			
		}
	});
	
	
	return fragView;
	}

	
	
	

	//login task from server
	
class LoginTask extends AsyncTask<String, Void, String> {

		
		ProgressDialog pd = null;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(getActivity());
			pd.setTitle("Login Progress...");
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) {
			
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
					}
				}
				bufferedReader.close();

			} catch (Exception ex) {
				Log.e("Error", "unable to connect " + ex.getMessage());
			}
			return result;
			/*String resultfromserver="";
			String loginUrl=params[0];
			System.out.println("@@@ url="+loginUrl);
			

			Log.e("in do in bacground", loginUrl);
			try {
			
				URL url=new URL(loginUrl);
				System.out.println("!!! one");
				HttpURLConnection httpCon=(HttpURLConnection)url.openConnection();
				System.out.println("!!! 2");
				httpCon.setRequestMethod("GET");
				System.out.println("!!! 3");
				httpCon.connect();
				System.out.println("!!! 4");
				//Log.e("in do in background", "connected");
				//chech if conn exist
				System.out.println("@@@ status1="+httpCon.getResponseCode());
				if(httpCon.getResponseCode()==HttpURLConnection.HTTP_OK)
				{
					System.out.println("@@@ status="+httpCon.getResponseCode());
					InputStream is=httpCon.getInputStream();
					InputStreamReader reader=new InputStreamReader(is);
					BufferedReader br=new BufferedReader(reader);
					while(true)
					{
						String line=br.readLine();
						if(line == null)
							break;
						else
							resultfromserver+=line;
					}

				//	Log.e("in do in bacground", resultfromserver);
					br.close();
					httpCon.disconnect();*/
					

		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			pd.dismiss();
			Toast.makeText(getActivity(), result, 5).show();
			Log.e("Login", result);
			
			
			//Save profile data received from server
			try{
				JSONObject jobj=new JSONObject(result);
				String strResult=jobj.getString("result");
				Log.e("here", "here");
				if(strResult.equalsIgnoreCase("success")){
					txtusername.setText("");
					txtpasswd.setText("");
					Toast.makeText(getActivity(),"Login Success",5).show();
					//on post code
					Fragment regist=new AddCommentFragment();
					FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
					                    fragTransaction.replace(R.id.loginContainer,regist);
					                    regist.setArguments(newData);
					                    fragTransaction.addToBackStack(null);
					                    fragTransaction.commit();
				
					
				}
				else
				{
					Toast.makeText(getActivity(), "Please Register First", Toast.LENGTH_LONG).show();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	//end login task
	
	
	
	
	
	
	
}
