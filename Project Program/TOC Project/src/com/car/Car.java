package com.car;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class Car {

	static private int speed=0;
	static private String state;
	
	private String currentState,nextState;
	private String Stop;
	private int signal;
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
	
	//Speech input
	public void speech_signal() throws IOException {
		
		Configuration config = new Configuration();
		
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        config.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(config);
		
		recognize.startRecognition(true);
		
		SpeechResult speechResult;
		while((speechResult = recognize.getResult()) != null) {
			String command = speechResult.getHypothesis();
			System.out.println("Input Command is: "+command);
			
			System.out.println("\n\nright here");
			
			speechSignal = command;
		}
		/*StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(config);
		//InputStream stream = new FileInputStream(new File("test.wav"));

	        //recognizer.startRecognition();
		SpeechResult result;
	        while ((speechResult = recognize.getResult()) != null) {
		    System.out.format("Hypothesis: %s\n", speechResult.getHypothesis());
		    String command =  speechResult.getHypothesis();
		    
		    System.out.println("\n\n here");
			System.out.println("Speech : "+command);
		}
		recognizer.stopRecognition();
		
		
		LiveSpeechRecognizer recog = new LiveSpeechRecognizer(config);
		// Start recognition process pruning previously cached data.
		recog.startRecognition(true);
		SpeechResult res = recognizer.getResult();
		System.out.println("\n\n here");
		System.out.println("Speech : ");//+command);
		// Pause recognition process. It can be resumed then with startRecognition(false). */
		//recognizer.stopRecognition();
		
	}
		
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
		System.out.println("Welcome to the RSC-based car model");
			while(true) {
				//Displays current state of the vehicle
				printCurrentState();
				//Display options based on state of the vehicle
				dispOptions();
				System.out.println("What signal are you giving? ");
				signal = in.nextInt();
				//HERE CAN USE IF STATEMENTS TO SEE WHERE THE CODE GOES FROM OFF STATE 
				//TO MOVE THE CAR.
				
				//We are using a case to check what state it is in and if in relevant state and
				// Is going to another relevant state then the speed changes.
				
				//Switch statement to handle state transition
				switch(state) {
				case "OFF":
					if(signal==1)
						hold();
					else if(signal==2)
						ignitionon();
					break;
				case "HOLD":
					if(signal==1)
						enginestarted();
					break;
				case "IGNITION-ON":
					if(signal==1)
						hold();
					else if(signal==2)
						off();
					break;
				case "ENGINE-STARTED":
					if(signal==1)
						off();
					else if(signal==2)
						stationary();
					break;
				case "STATIONARY":
					if(signal==1)
						stationary();
					else if(signal==2)
						inreversemotion(0);
					else if(signal==3)
						enginestarted();
					else if(signal==4)
						inforwardmotion(1);
					break;
				case "IN-REVERSE-MOTION":
					if(signal==1)
						inreversemotion(1);
					else if(signal==2)
						inreversemotion(-1);
					else if(signal==3)
						stationary();
					break;
				case "IN-FORWARD-MOTION":
					if(signal==1)
						inforwardmotion(1);
					else if(signal==2)
						inforwardmotion(-1);
					else if(signal==3)
						cruisecontrol();
						break;
				case "CRUISECONTROL":
					if(signal==1)
						cruisecontrol();
					else if(signal==2)
						inforwardmotion(22); // Any value other than 0,1 and -1 could have been placed here
					break;
				}
		}
		
		
		}catch(NullPointerException e) {
			System.out.println("Null pointer encountered at Signal method.");
		}
	}
	
	

	
}
