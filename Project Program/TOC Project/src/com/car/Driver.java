package com.car;
import com.Speech.*;
import com.gui.*;

import java.io.IOException;
import java.util.Scanner;
public class Driver {
	public static void main(String Args[])throws IOException {

		System.out.println("How would you like to interact with the system?");
		System.out.println("1. Text \n2. Speech \n3. GUI");
		Scanner in = new Scanner(System.in);
		int option=in.nextInt();
		//in.close();
		
		
			if(option ==1)
			{
				Car car = new Car();
				car.signal();	
			}
			else if(option==2)
				{
				Speech speech = new Speech(); //Section where speech is taken as input
				System.out.println("SPEECH MODE ACTIVATED");
				speech.init();
				speech.parselTongue(); 
				}
			else if(option == 3)
			{
				System.out.println("GUI");
				gui Gooey = new gui();
				Gooey.RUN();
			}
			
		
		
		
		
		
		}

}
