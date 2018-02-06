package cdac.loginandegistration;

import java.util.regex.Pattern;

import android.content.Context;
import android.util.Patterns;
import android.widget.Toast;

public class Validation {
	static Pattern pattern = Patterns.PHONE;
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[A-Z])(?=.*[-_@!#$%&\\.]).{6,20})";

	// private static Context mContext;
	public static final String mEmaiValidate = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z‌​]{2,4})$";
	private static final String PHONENO_REGEX = "^(?:|[0-9]{10}|)$";

	public Validation(Context context) {
		// this.mContext = context;
	}

	/*
	 * validation for LoginActivityValidation
	 */
	// password validation remove by santosh as Abdul sir said
	public static boolean LoginActivityValidation(String emailId,
			String Password, Context mContext) {

		if (emailId.equals("")) {

			Toast.makeText(mContext, "Login ID is required.",
					Toast.LENGTH_SHORT).show();

			return false;
		} else if (!emailId.matches(mEmaiValidate)) {
			Toast.makeText(mContext, "Invalid Login ID.", Toast.LENGTH_SHORT)
					.show();
			return false;

		} else if (Password.equals("")) {
			Toast.makeText(mContext, "Password is required.",
					Toast.LENGTH_SHORT).show();
			return false;
		} else if (!Password.matches(PASSWORD_PATTERN)) {
			Toast.makeText(
					mContext,
					"Password should have atleast one capital letter, one number and a special character - _ @ ! # $ % &.",
					Toast.LENGTH_SHORT).show();

			return false;
			// return true;

		}

		return true;

	}
	
	
	public static boolean SignUpActivityValidation(String name,
			String Password,String emailId,String mobile, Context mContext) {
		if (name.equals("")) {

			Toast.makeText(mContext, "Name is required.",
					Toast.LENGTH_SHORT).show();

			return false;
		} 
		 else if (Password.equals("")) {
			Toast.makeText(mContext, "Password is required.",
					Toast.LENGTH_SHORT).show();
			return false;
		} else if (!Password.matches(PASSWORD_PATTERN)) {
			Toast.makeText(
					mContext,
					"Password should have atleast one capital letter, one number and a special character - _ @ ! # $ % &.",
					Toast.LENGTH_SHORT).show();

			return false;
			// return true;

		}else if (emailId.equals("")) {

			Toast.makeText(mContext, "Email ID is required.",
					Toast.LENGTH_SHORT).show();

			return false;
		} else if (!emailId.matches(mEmaiValidate)) {
			Toast.makeText(mContext, "Invalid Login ID.", Toast.LENGTH_SHORT)
					.show();
			return false;

		}else if (mobile.equals("")) {

			Toast.makeText(mContext, "Mobile no is required.",
					Toast.LENGTH_SHORT).show();

			return false;
		}

		return true;

	}


}

