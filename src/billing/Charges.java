package bp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
public class Charges {
	private double chargePerMinute,totalCharge,charge;
	private long callDuration;
	private long start;
	private long end;
        private final double TAX= 0.16;
	
	public Charges(long start,long end){
		this.start = start;
		this.end = end;
	}
	
    public void setChargePerMinute(){
            
            try {
                String strDateFormat = "MM/dd/yyyy hh:mm:ss a";
                String dF = "MM/dd/yyyy";
                DateFormat dateFormat = new SimpleDateFormat(dF);
                DateFormat dateTimeFormat = new SimpleDateFormat(strDateFormat);
                SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);                
                
                Date date1= sdf.parse(dateFormat.format(new Date(new Date().getTime()-24*3600*1000)) + " " + "6:00:00 PM");
                Date date2 = sdf.parse(dateFormat.format(new Date()) + " " + "06:00:00 AM");
                Date date3 = sdf.parse(dateFormat.format(new Date()) + " " + "06:00:00 PM");
                
                this.setCallDuration();
                
                Date startTime = sdf.parse(dateTimeFormat.format(new Date(this.start)));
                Date endTime = sdf.parse(dateTimeFormat.format(new Date(this.end)));
                
                if (startTime.after(date1) && endTime.before(date2)){
                    this.chargePerMinute = 3.00;
                    charge = this.chargePerMinute * TimeUnit.MILLISECONDS.toSeconds(this.callDuration) / 60;
                    System.out.println("Charge per minute: "+this.chargePerMinute+"\n");
                }else if(startTime.after(date2) && endTime.before(date3)){
                    this.chargePerMinute = 4.00;
                    charge = this.chargePerMinute * TimeUnit.MILLISECONDS.toSeconds(this.callDuration) / 60;
                    System.out.println("Charge per minute: "+this.chargePerMinute+"\n");
                }else if(startTime.before(date2) && endTime.after(date2)){
                    long d1,d2;
                    double C1,C2;
                    d1=date2.getTime()-startTime.getTime();
                    C1=3*TimeUnit.MILLISECONDS.toSeconds(d1)/60;
                    d2=endTime.getTime()- date2.getTime();
                    C2=4*TimeUnit.MILLISECONDS.toSeconds(d2)/60;
                    charge = C1+C2;
                    System.out.println("Charge per minute Ksh 3 per minute for the first "+TimeUnit.MILLISECONDS.toSeconds(d1)+ " seconds and Ksh 4 per minute for the last "+TimeUnit.MILLISECONDS.toSeconds(d2)+ " seconds");
                }else if(startTime.before(date3) && endTime.after(date3)){
                    long d1,d2;
                    double C1,C2;
                    d1=date3.getTime()-startTime.getTime();
                    C1=4*TimeUnit.MILLISECONDS.toSeconds(d1)/60;
                    d2=endTime.getTime()- date3.getTime();
                    C2=3*TimeUnit.MILLISECONDS.toSeconds(d2)/60;
                    charge = C1+C2;
                    System.out.println("Charge per minute Ksh 4 per minute for the first "+TimeUnit.MILLISECONDS.toSeconds(d1)+ " seconds and Ksh 3 per minute for the last "+TimeUnit.MILLISECONDS.toSeconds(d2)+ "seconds");
                }else if(startTime.after(date3)) {
                	this.chargePerMinute = 3.00;
                    charge = this.chargePerMinute * TimeUnit.MILLISECONDS.toSeconds(this.callDuration) / 60;
                    System.out.println("Charge per minute: "+this.chargePerMinute+"\n");
                	
                }
            } catch (ParseException ex) {
                Logger.getLogger(Charges.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
              if(callDuration>=60000){
                  this.totalCharge = charge + (TAX*charge);
                  System.out.println("TAX = "+TAX);
              }else{
                  this.totalCharge = charge;
                  System.out.println("TAX = 0");
              }                
                
                long seconds= (this.callDuration/1000)%60; 
                JOptionPane.showMessageDialog(null,"Call duration in mm:ss: "+TimeUnit.MILLISECONDS.toMinutes(this.callDuration)+":"+seconds+ "\n" +"Total charge: Ksh "+this.totalCharge+"\n");
                System.out.println("Call duration in seconds : "+TimeUnit.MILLISECONDS.toSeconds(this.callDuration)+ "\n");
                System.out.println("Total charge: "+this.totalCharge+"\n");
                           
            
            }
    		
	public void setCallDuration(){
		long difference = this.end - this.start;
		this.callDuration = difference;
	}
	
	public long getCallDuration(){
		return this.callDuration;
	}
}
