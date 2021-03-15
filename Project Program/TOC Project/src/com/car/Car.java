package com.car;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;


public class Car {

	static private int speed=0;
	static private String state="OFF";
	
	private String currentState,nextState;
	private String Stop;
	private String signal;
	private String speechSignal;
	//Additions
		
	//  Setters and getters for speed and state
	public  static String getState(){
		return state;
	} 
	
	public static void setSpeed(int a)
	    {
	        speed = a;
	    }
	
		public static int getSpeed(){
	        return speed;
	    } 
	
	public  static void setState(String a)
	    {
	        state = a;
	    }
	
	
	public static void printCurrentState() //prints current state and speed of car
    {
        String a = "The car is now in the "+getState()+" state";
        String b = "Current speed is: "+getSpeed(); 
        System.out.println("\n" + a+"\n"+b);
    }
	
	//End of Additions
	
	//functions to reflect state
	public void off() {
		setState("OFF");
		setSpeed(0);
	}
	
	public void hold() {
		setState("HOLD");
		setSpeed(0);
	}
	
	public void ignitionon() {
		setState("IGNITION-ON");
		setSpeed(0);
	}
	
	 public void enginestarted()
	    {
		 setState("ENGINE-STARTED");
		 setSpeed(0);
	    }
	 
	 
	public void stationary() {
		setState("STATIONARY");
        setSpeed(0);
	}
	
	
	public void inforwardmotion(int flag) {
		//if flag is 1, we are coming from accelerate and can increment speed
        //if flag is 0, then we can just set the speed to 1(coming from stationary)
        //and if flag is -1 then we can decrement the speed and if the speed reaches zero, 
        //transitions to the stationary state

        setState("IN-FORWARD-MOTION");
        if(flag == 1)
            setSpeed(getSpeed()+1);
        else if(flag==0)
            setSpeed(1);
        else if(flag == - 1)
            setSpeed(getSpeed()-1);
       
        if(getSpeed()==0)
        	stationary();
	}
	
	 public void inreversemotion(int flag)
	    {
		 setState("IN-REVERSE-MOTION");
		 	//if flag is 1, we are coming from the accelerate signal and can increment the speed
	        //and if flag is -1 then we are coming from brake pressed and can decrement the speed and if the speed reaches zero, 
	        //transitions to the stationary state
		 
		  if(flag == 1)
	            setSpeed(getSpeed()+1);
	        else if (flag==-1)
	            setSpeed(getSpeed()-1);
	        else
	        	setSpeed(0); // Coming from the stationary position
	    }
	 
	
	 public void cruisecontrol() {
		 setState("CRUISECONTROL");		 
	 }
	 
	//end of functions that reflect state
	
		
	public void dispOptions() { //Reads state and displays appropriate options to user
		System.out.println("Available Options");

		switch(getState())
		{
		case "OFF":
			System.out.println("1. Hold Brake");
			System.out.println("2. Start Signal");
			break;
		case "HOLD":
			System.out.println("1. Start Signal");
			break;
		case "IGNITION-ON":
			System.out.println("1. Hold Brake");
			System.out.println("2. Start Signal");
			break;
		case "ENGINE-STARTED":
			System.out.println("1. Start Signal");
			System.out.println("2. Engage Seatbelt");
			break;
		case "STATIONARY":
			System.out.println("1. Accelerate");
			System.out.println("2. Reverse");
			System.out.println("3. Park");
			System.out.println("4. Select Drive");
			break;
		case "IN-REVERSE-MOTION":
			System.out.println("1. Accelerate");
			System.out.println("2. Press Brake");
			System.out.println("3. Hold Brake");
			break;
		case "IN-FORWARD-MOTION":
			System.out.println("1. Accelerate");
			System.out.println("2. Press Brake");
			System.out.println("3. Activate Cruise Control");
			break;
		case "CRUISECONTROL":
			System.out.println("1. Accelerate");
			System.out.println("2. Press Brake");
			break;
		}
			
	}
	
	//Regular typing input
	public void signal() {
		try {
			
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to UTUVCS (Designed by RSC <3)");
			while(true) {
				//Displays current state of the vehicle
				printCurrentState();
				//Display options based on state of the vehicle
				dispOptions();
				System.out.println("What signal are you giving?(Enter the  first word in the chosen command) ");
				signal = in.next();
				//HERE CAN USE IF STATEMENTS TO SEE WHERE THE CODE GOES FROM OFF STATE 
				//TO MOVE THE CAR.
				
				//We are using a case to check what state it is in and if in relevant state and
				// Is going to another relevant state then the speed changes.
				
				//Switch statement to handle state transition
			StateChanger(signal);
		}
		
		
		}catch(NullPointerException e) {
			System.out.println("Null pointer encountered at Signal method.");
		}
	}
	
	
public  void StateChanger(String signal) //based on the inputted signal, it reads the car's state and acts accordingly
	{
	switch(state) {
	case "OFF":
		if(signal.toLowerCase().equals("hold"))
			hold();
		else if(signal.toLowerCase().equals("start"))
			ignitionon();
		else
			System.out.println("Signal has been rejected");
		break;
	case "HOLD":
		if(signal.toLowerCase().equals("start"))
			enginestarted();
		else
			System.out.println("Signal has been rejected");
		break;
	case "IGNITION-ON":
		if(signal.toLowerCase().equals("hold"))
			hold();
		else if(signal.toLowerCase().equals("start"))
			off();
		else
			System.out.println("Signal has been rejected");
		break;
	case "ENGINE-STARTED":
		if(signal.toLowerCase().equals("start"))
			off();
		else if(signal.toLowerCase().equals("engage"))
			stationary();
		else
			System.out.println("Signal has been rejected");
		break;
	case "STATIONARY":
		if(signal.toLowerCase().equals("accelerate"))
			stationary();
		else if(signal.toLowerCase().equals("reverse"))
			inreversemotion(0);
		else if(signal.toLowerCase().equals("park"))
			enginestarted();
		else if(signal.toLowerCase().equals("select"))
			inforwardmotion(1);
		else
			System.out.println("Signal has been rejected");
		break;
	case "IN-REVERSE-MOTION":
		if(signal.toLowerCase().equals("accelerate"))
			inreversemotion(1);
		else if(signal.toLowerCase().equals("press"))
			inreversemotion(-1);
		else if(signal.toLowerCase().equals("hold"))
			stationary();
		else
			System.out.println("Signal has been rejected");
		break;
	case "IN-FORWARD-MOTION":
		if(signal.toLowerCase().equals("accelerate"))
			inforwardmotion(1);
		else if(signal.toLowerCase().equals("press"))
			inforwardmotion(-1);
		else if(signal.toLowerCase().equals("activate"))
			cruisecontrol();
		else
			System.out.println("Signal has been rejected");
			break;
	case "CRUISECONTROL":
		if(signal.toLowerCase().equals("accelerate"))
			cruisecontrol();
		else if(signal.toLowerCase().equals("press"))
			inforwardmotion(22); // Any value other than 0,1 and -1 could have been placed here
		else
			System.out.println("Signal has been rejected");
		break;
	}
	}

}
