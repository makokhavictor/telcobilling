package billing;
import java.util.Scanner;

public class Home {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Timings timings = new Timings();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Start call? [yes/no]");
		String start = input.next();
		
		if(start.equalsIgnoreCase("yes")){
			timings.setStartTime();
			System.out.print("End call? [yes/no]");
			String end = input.next();
			if(end.equalsIgnoreCase("yes")){
				timings.setEndTime();
				Charges charges = new Charges(timings.getStartTime(),timings.getEndTime());
				charges.setChargePerMinute();
			}else{
				System.out.print("Great, keep on talking! We appreciate your generosity :-)");
			}
			
		}else{
			System.out.print("Great, have a lovely day Bye! :-)");
		}
	}

}
