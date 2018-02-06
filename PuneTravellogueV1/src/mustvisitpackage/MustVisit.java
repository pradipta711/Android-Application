package mustvisitpackage;

public class MustVisit {
String desc;
int image;
public MustVisit(String desc, int image) {
	super();
	this.desc = desc;
	this.image = image;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public int getImage() {
	return image;
}
public void setImage(int image) {
	this.image = image;
}
@Override
public String toString() {
	return "MustVisit [desc=" + desc + ", image=" + image + "]";
}



}
