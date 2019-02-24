package billing;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Charges {
	private double chargePerMinute,totalCharge;
	private long callDuration;
	private long start;
	private long end;
	
	public Charges(long start,long end){
		this.start = start;
		this.end = end;
	}
	
    public void setChargePerMinute(){
    	String strDateFormat = "MM/dd/yyyy hh:mm a";
    	String dF = "MM/dd/yyyy";
    	DateFormat dateFormat = new SimpleDateFormat(dF);
    	DateFormat dateTimeFormat = new SimpleDateFormat(strDateFormat);
    	SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
    	
    	
		try {
			Date date1 = sdf.parse(dateFormat.format(new Date()) + " " + "06:00 AM");
			Date date2 = sdf.parse(dateFormat.format(new Date()) + " " + "06:00 PM");
			this.setCallDuration();
			
			Date startTime = sdf.parse(dateTimeFormat.format(new Date(this.start)));
//			Date endTime = sdf.parse(dateTimeFormat.format(new Date(this.start)));
			
			if(startTime.after(date1) && startTime.before(date2)){
				this.chargePerMinute = 4.00;
			}else if(startTime.after(date2) && startTime.before(date1)){
				this.chargePerMinute = 3.00;
			}
			
			this.totalCharge = this.chargePerMinute * TimeUnit.MILLISECONDS.toSeconds(this.callDuration) / 60;
			
	    	System.out.println("Total charge: "+this.totalCharge+"\n");
	    	System.out.println("Duration in seconds : "+TimeUnit.MILLISECONDS.toSeconds(this.callDuration)+ "\n");
	    	System.out.println("Duration in minutes : "+TimeUnit.MILLISECONDS.toMinutes(this.callDuration)+ "\n");
	    	System.out.println("Charge per minute: "+this.chargePerMinute+"\n");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
    
	public double getChargePerMinute(){
		return this.chargePerMinute;
	}
	public void setCallDuration(){
		long difference = this.end - this.start;
		this.callDuration = difference;
	}
	
	public long getCallDuration(){
		return this.callDuration;
	}
}
