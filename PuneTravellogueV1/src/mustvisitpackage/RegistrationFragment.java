package mustvisitpackage;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;






import com.dmc.punetravellogue.R;

import cdac.loginandegistration.Validation;
import cdac.loginandegistration.WebHelper;







import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationFragment extends Fragment {

	EditText editnm,editpass,editemail,editmobileno;
	Button btnregister;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fragview=inflater.inflate(R.layout.registerfrag,container,false);
		editnm=(EditText)fragview.findViewById(R.id.reg_fullname);

		editpass=(EditText)fragview.findViewById(R.id.reg_password);

		editemail=(EditText)fragview.findViewById(R.id.reg_email);
		
		editmobileno=(EditText)fragview.findViewById(R.id.reg_mobileno);
		btnregister=(Button)fragview.findViewById(R.id.reg_btnRegisterme);
		
		btnregister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
String name = editnm.getText().toString();
				
				String email = editemail.getText().toString();
				String mobile = editmobileno.getText().toString();
				String password = editpass.getText().toString();
				if (Validation.SignUpActivityValidation(name, password, email, mobile, getActivity())) 
				{
				// 192.168.76.98:9090/DailyExpenseManagerWeb/LoginServlet?email=p%40gmail.com&password=123456
				String url = WebHelper.BASEURL + "/registration";

				
				RegistrationTask task = new RegistrationTask();
				task.execute(url,name,email,mobile,password);
				
				}
				
			}
		});
		
		
		
		
		return fragview;
	}
	
	//register asyn task
	class RegistrationTask extends AsyncTask<String, Void, String> {

		ProgressDialog pd = null;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(getActivity());
			pd.setTitle("Registration Progress...");
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) {
			String registerurl = params[0];
			String name=params[1];
			
			String	email=params[2];
			String mobile=params[3];
			String password=params[4];
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
				
				builder.append(URLEncoder.encode("username", "UTF-8"));
				builder.append("=");
				builder.append(URLEncoder.encode(name, "UTF-8"));
				
				builder.append("&");
			
				builder.append(URLEncoder.encode("password", "UTF-8"));
				builder.append("=");
				builder.append(URLEncoder.encode(password, "UTF-8"));
				builder.append("&");
				builder.append(URLEncoder.encode("email", "UTF-8"));
				builder.append("=");
				builder.append(URLEncoder.encode(email, "UTF-8"));
				
				builder.append("&");
				builder.append(URLEncoder.encode("mobile", "UTF-8"));
				builder.append("=");
				builder.append(URLEncoder.encode(mobile, "UTF-8"));
				
			
				
				
				//This enables the output,input streams
				httpconnection.setDoInput(true);
				httpconnection.setDoOutput(true);
				
				OutputStream httpout=httpconnection.getOutputStream();
				PrintStream httpStream=new PrintStream(httpout);
				httpStream.print(builder.toString());
				httpStream.flush();
				httpStream.close();
				// COnnectio made here
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
			Log.e("REgistration", result);
		}
	}
	
	
	//end of register task
	
	
	
	
}
