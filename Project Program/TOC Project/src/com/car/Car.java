package com.car;

import java.util.Scanner;

public class Car {

	private int speed;
	private String state, currentState, nextState;
	private String Stop;
	private String signal;
	
	public void off() {
		
		state = "stationary";
		
	}
	
	
	public void signal() {
		try {
			
			Scanner in = new Scanner(System.in);
		System.out.println("What signal are you giving? ");
		signal = in.next();
		
		//HERE CAN USE IF STATEMENTS TO SEE WHERE THE CODE GOES FROM OFF STATE 
		//TO MOVE THE CAR.
		
		//Gives a if statement to check what state it is in and if in relevant state and
		// Is going to another relevant state then the speed changes.
		if(state.toLowerCase().equals("stationary") && signal.toLowerCase().equals("drive")) {
			
			//IF it is correct, then the next state is given and the increase speed method then called.
			increase_speed();
			inForward_Motion();
			
		}
		
		if(state.toLowerCase().equals("stationary") && signal.toLowerCase().equals("reverse")) {
			
			//IF it is correct, then the next state is given and the increase speed method then called.
			increase_speed();
			inReverse_Motion();
			
		}
		
		}catch(NullPointerException e) {
			System.out.println("Null pointer encountered at Signal method.");
		}
	}
	
	
	public void inForward_Motion() {
		
		System.out.println("Gear Changed to drive + \n");
		System.out.println("In-forward motion :) \n");
		
	}
	
	public void inReverse_Motion() {
	
		System.out.println("Gear Changed to reverse + \n");
		System.out.println("In-reverse motion ;) \n");
		
	}
	
	public void increase_speed() {
		
		speed = 1;
		System.out.println("\n Speed is "+speed);
		
	}
	
	public void decrease_speed() {
		
		speed = 0;
		System.out.println("\n Speed is "+speed);
		
	}
	
	public void Stop() {
		
		
		state = "Stationary";
		decrease_speed();
		
		System.out.println("\n" +state);
		
	}
	
	
}
