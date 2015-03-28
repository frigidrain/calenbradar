import java.util.*;
import java.io.*;
import java.text.*;

public class Slot{
	private static String startTest = "2012-07-10 14:58";
	private static String endTest = "2012-07-10 16:58";
	
	private static DateFormat minuteWise = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	private Date startTime;	// = minuteWise.parse( startTest );
	private Date endTime;	// = minuteWise.parse( endTest );
	private long durationMin;
	
	public Date minuteWiseParse( String timeString ) throws ParseException{
		return ( minuteWise.parse( timeString ) );
	}
	
	//constructors
	public Slot( String startTimeString, String endTimeString ) throws ParseException {
		startTime = minuteWiseParse( startTimeString );
		endTime = minuteWiseParse( endTimeString );
		updateDuration();
	}
	public Slot( String startTimeString, long duration ) throws ParseException {
		startTime = minuteWiseParse( startTimeString );
		durationMin = duration;
		endTime = new Date(startTime.getTime() + durationMin * 1000 * 60);
	}
	
	//access
	public Date getStartDate(){
		return startTime;
	}
	public Date getEndDate(){
		return endTime;
	}
	public long getDuration(){
		return durationMin;
	}
	
	//utility
	private void updateDuration(){
		durationMin = (endTime.getTime() - startTime.getTime())/1000/60;		
	}
}