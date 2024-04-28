package genericUtility;
import java.util.Random;

import sun.util.calendar.LocalGregorianCalendar.Date;
/**
 * this method will contains java methods
 */
public class javaUtility {
public int toGetRandomNumber() {
	Random r= new Random();
	int random=r.nextInt(1000);
	return random;
}
/**
 * this method will get system date and time
 * @return
 */
public String toGetSystemDateandTime() {
	java.util.Date d = new java.util.Date();
	System.out.println(d);
	String date[]=d.toString().split(" ");
	String day=date[0];
	String month= date[1];
	String date1=date[2];
	String time=date[3].replace(":", "-");
	String year=date[5];
	String finaldate=day+" "+month+" "+date1+" "+time+" "+year;
	System.out.println(finaldate);
	return finaldate;
}

}
