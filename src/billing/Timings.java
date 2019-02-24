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
		System.out.print("Start time is: "+this.startTime+"\n");
	}
	public void setEndTime(){
		Date date= new Date();
		long time = date.getTime();
		this.endTime = time;
		System.out.print("End time is: "+this.endTime+"\n");
	}
	public long getStartTime(){
		return this.startTime;
	}
	public long getEndTime(){
		return this.endTime;
	}
	
	
}
