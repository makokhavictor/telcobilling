package billing;
import java.util.Date;
//import java.sql.Timestamp;

public class Timings {
	private long startTime;
	private long endTime;
	
	
	public void setStartTime(){
		Date date= new Date();
		long time = date.getTime();
		this.startTime = time;
		System.out.println("Start time is: " +date.toString());
	}
	public void setEndTime(){
		Date date= new Date();
		long time = date.getTime();
		this.endTime = time;
		System.out.println("End time is: "+date.toString);
	}
	public long getStartTime(){
		return this.startTime;
	}
	public long getEndTime(){
		return this.endTime;
	}
	
	
}
