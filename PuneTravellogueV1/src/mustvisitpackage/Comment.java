package mustvisitpackage;

public class Comment {
String email;
String desc;
String post_date;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getPost_date() {
	return post_date;
}
public void setPost_date(String post_date) {
	this.post_date = post_date;
}
public Comment(String email, String desc, String post_date) {
	super();
	this.email = email;
	this.desc = desc;
	this.post_date = post_date;
}
@Override
public String toString() {
	return "Comment [email=" + email + ", desc=" + desc + ", post_date="
			+ post_date + "]";
}




}
