package com.energieip.CES;

import com.energieip.api.EnergieAPI;

public class AutoMod implements Runnable{

	public Thread autoThread; // loop thread
	private int SLEEPING_TIME = 1000; // allow a break for thread

	public static boolean auto = false;
	
	private int state=0;
	private int previous_state=0;
	private boolean goingdown = true;
	
	private EnergieAPI energieAPI;
	
	
	/**
	 * Constructor
	 * @param energieAPI 
	 */
	public AutoMod(EnergieAPI _energieAPI) {
		
		energieAPI = _energieAPI;
		
		 // launch thread
 	autoThread = new Thread(this);
 		autoThread.start();

 		
		
	}
	
	
	
	@Override
	public void run() {
		while (!Thread.interrupted()) {

			try {
				
				
			
				if(auto) {
					
				
					if(goingdown) {
						
						state = previous_state - 10;
						
					}
					else {
						state = previous_state + 10;
					}
					
					
					if(state<0) {
						
						state = 10;
						goingdown = false;
					}
					
					if(state>100 ) {
						
						state = 90;
						goingdown = true;
						
					}
					
					
					energieAPI.setIndividualLightPercentage(16, state);
					
					previous_state = state;
					
				}
				
			
				
				autoThread.sleep(SLEEPING_TIME);

			} catch (InterruptedException e) {

				// Nothing to do
			
			}

		} // end while


		
	}

}
