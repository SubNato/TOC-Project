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

	private int speed=0;
	private String state, currentState, nextState;
	private String Stop;
	private String signal,speechSignal;
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
	
	
	
	
	
	
	
	
	
	public void off() {
		
		state = "stationary";
		
	}
	
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
		
	
	
	//Regular typing input
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
