
package bp;

import javax.swing.JOptionPane;

public class Home {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Timings timings = new Timings();
		
		int startCall= JOptionPane.showConfirmDialog(null, "Start call?", "Call",JOptionPane.YES_NO_OPTION);
		
		if(startCall == JOptionPane.YES_OPTION) {
			timings.setStartTime();
		int endCall= JOptionPane.showConfirmDialog(null, "End call? Please press yes when done with call", "Calling",JOptionPane.YES_OPTION);
                        
			if(endCall == JOptionPane.YES_OPTION){
				timings.setEndTime();
				Charges charges = new Charges(timings.getStartTime(),timings.getEndTime());
				charges.setChargePerMinute();
                                System.out.println("Great! Keepon talking!");
			}                
			}else{
			JOptionPane.showMessageDialog(null, "Great, have a lovely day Bye! :-)"); 
		}
	}

    }

