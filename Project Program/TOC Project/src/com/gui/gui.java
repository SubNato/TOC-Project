package com.gui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class gui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final Component frame = null;

	public gui() {

		// set flow layout for the frame
		this.getContentPane().setLayout(new FlowLayout());

		JButton b1 = new JButton("Off");

		//add Button
		add(b1);
		
		//set action listeners for buttons
		b1.addActionListener(this);

		// define a custom short action command for the button
		b1.setActionCommand("off");

		// add button to frame
		add(b1);
		
		JButton b2 = new JButton("Ignition On");

		//add Button
		add(b2);
		
		//set action listeners for buttons
		b2.addActionListener(this);

		// define a custom short action command for the button
		b2.setActionCommand("ignitionon");

		// add button to frame
		add(b2);
		
		JButton b3 = new JButton("Hold");

		//add Button
		add(b3);
		
		//set action listeners for buttons
		b3.addActionListener(this);

		// define a custom short action command for the button
		b3.setActionCommand("hold");

		// add button to frame
		add(b3);
		
		JButton b4 = new JButton("Engine Started");

		//add Button
		add(b4);
		
		//set action listeners for buttons
		b4.addActionListener(this);

		// define a custom short action command for the button
		b4.setActionCommand("enginestart");

		// add button to frame
		add(b4);
		
		JButton b5 = new JButton("Stationery");

		//add Button
		add(b5);
		
		//set action listeners for buttons
		b5.addActionListener(this);

		// define a custom short action command for the button
		b5.setActionCommand("stationery");

		// add button to frame
		add(b5);
		
		JButton b6 = new JButton("In-forward");

		//add Button
		add(b6);
		
		//set action listeners for buttons
		b6.addActionListener(this);

		// define a custom short action command for the button
		b6.setActionCommand("inforward");

		// add button to frame
		add(b6);
		
		JButton b7 = new JButton("Reverse");

		//add Button
		add(b7);
		
		//set action listeners for buttons
		b7.addActionListener(this);

		// define a custom short action command for the button
		b7.setActionCommand("reverse");

		// add button to frame
		add(b7);
		
		JButton b8 = new JButton("Cruise Control");

		//add Button
		add(b8);
		
		//set action listeners for buttons
		b8.addActionListener(this);

		// define a custom short action command for the button
		b8.setActionCommand("cruisecontrol");

		// add button to frame
		add(b8);


	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String signal;
		String action = ae.getActionCommand();
		if (action.equals("off")) {
			JOptionPane.showMessageDialog(frame," You Pressed Off!");
			System.out.println("You Pressed Off!");
			signal = JOptionPane.showInputDialog("Enter a signal");
			if (signal.toLowerCase().equals("hold")) {
			JOptionPane.showMessageDialog(frame," You are in the Hold state!");
			System.out.println("You are in the hold state!"); 
			}
			else if (signal.toLowerCase().equals("start")) {
				JOptionPane.showMessageDialog(frame," You are in the Ignition on state!");
				System.out.println("You are in the Ignition on state!"); 
				}
			else {
					JOptionPane.showMessageDialog(frame," Signal has been rejected!");
					System.out.println("Signal has been rejected");
			}
			
		}
			
			if (action.equals("ignitionon")) {
				JOptionPane.showMessageDialog(frame," You Pressed Ignition On!");
				System.out.println("You Pressed Ignition On!");
				signal = JOptionPane.showInputDialog("Enter a signal");
				if (signal.toLowerCase().equals("hold")) {
					JOptionPane.showMessageDialog(frame," You are in the Hold state!");
					System.out.println("You are in the Hold state!"); 
					}
				else if (signal.toLowerCase().equals("start")) {
					JOptionPane.showMessageDialog(frame," You are in the Off state!");
					System.out.println("You are in the Off state!"); 
					}
				else {
					JOptionPane.showMessageDialog(frame," Signal has been rejected!");
					System.out.println("Signal has been rejected");
			}
				
		}
			if (action.equals("enginestart")) {
				JOptionPane.showMessageDialog(frame," You Pressed Engine Start!");
				System.out.println("You Pressed Engine Start!");
				signal = JOptionPane.showInputDialog("Enter a signal");
				if (signal.toLowerCase().equals("engage")) {
					JOptionPane.showMessageDialog(frame," You are in the Stationery state!");
					System.out.println("You are in the Stationery state!"); 
					}
				else if (signal.toLowerCase().equals("start")) {
					JOptionPane.showMessageDialog(frame," You are in the Off state!");
					System.out.println("You are in the Off state!"); 
					}
				else {
					JOptionPane.showMessageDialog(frame," Signal has been rejected!");
					System.out.println("Signal has been rejected");
			}
		}
			
			if (action.equals("hold")) {
				JOptionPane.showMessageDialog(frame," You Pressed Hold!");
				System.out.println("You Pressed Hold!");
				signal = JOptionPane.showInputDialog("Enter a signal");
				if (signal.toLowerCase().equals("start")) {
					JOptionPane.showMessageDialog(frame," You are in the Engine Start!");
					System.out.println("You are in the Engine Start!"); 
					}
				else {
					JOptionPane.showMessageDialog(frame," Signal has been rejected!");
					System.out.println("Signal has been rejected");
			}
				
		}
			
			if (action.equals("stationery")) {
				JOptionPane.showMessageDialog(frame," You Pressed Stationery!");
				System.out.println("You Pressed Stationery!");
				signal = JOptionPane.showInputDialog("Enter a signal");
				if (signal.toLowerCase().equals("accelerate")) {
					JOptionPane.showMessageDialog(frame," You are in the Stationery state!");
					System.out.println("You are in the Stationery state!"); 
					}
				else if (signal.toLowerCase().equals("reverse")) {
					JOptionPane.showMessageDialog(frame," You are in the Reverse Motion state!");
					System.out.println("You are in the Reverse Motion state!"); 
					}
				else if (signal.toLowerCase().equals("park")) {
					JOptionPane.showMessageDialog(frame," You are in the Engine Started state!");
					System.out.println("You are in the Engine Started state!"); 
					}
				else if (signal.toLowerCase().equals("select")) {
					JOptionPane.showMessageDialog(frame," You are in the Inforward Motion state!");
					System.out.println("You are in the Inforward Motion state!"); 
					}
				else {
					JOptionPane.showMessageDialog(frame," Signal has been rejected!");
					System.out.println("Signal has been rejected");
			}
				
		}
			
			if (action.equals("inforward")) {
				JOptionPane.showMessageDialog(frame," You Pressed In-forward!");
				System.out.println("You Pressed In-forward!");
				signal = JOptionPane.showInputDialog("Enter a signal");
				if (signal.toLowerCase().equals("accelerate")) {
					JOptionPane.showMessageDialog(frame," You are in the In-foward Motion state! and speed=1");
					System.out.println("You are in the In-foward Motion state! and speed=1"); 
					}
				else if (signal.toLowerCase().equals("press")) {
					JOptionPane.showMessageDialog(frame," You are in the In-foward Motion state! and speed=0");
					System.out.println("You are in the In-foward Motion state! and speed=0"); 
					}
				else if (signal.toLowerCase().equals("activate")) {
					JOptionPane.showMessageDialog(frame," You are in the Cruise Control state!");
					System.out.println("You are in the Cruise Control state!"); 
					}
				else {
					JOptionPane.showMessageDialog(frame," Signal has been rejected!");
					System.out.println("Signal has been rejected");
			}
				
				
		}
			if (action.equals("reverse")) {
				JOptionPane.showMessageDialog(frame," You Pressed Reverse!");
				System.out.println("You Pressed Reverse!");
				signal = JOptionPane.showInputDialog("Enter a signal");
				if (signal.toLowerCase().equals("press")) {
					JOptionPane.showMessageDialog(frame," You are in the Reverse Motion state! and speed=0");
					System.out.println("You are in the Reverse Motion state! and speed=0"); 
					}
				else if (signal.toLowerCase().equals("accelerate")) {
					JOptionPane.showMessageDialog(frame," You are in the Reverse Motion state! and speed=1");
					System.out.println("You are in the Reverse Motion state! and speed=1"); 
					}
				else if (signal.toLowerCase().equals("hold")) {
					JOptionPane.showMessageDialog(frame," You are in the Stationery state!");
					System.out.println("You are in the Stationery state!"); 
					}
				else {
					JOptionPane.showMessageDialog(frame," Signal has been rejected!");
					System.out.println("Signal has been rejected");
			}
				
		}
			if (action.equals("cruisecontrol")) {
				JOptionPane.showMessageDialog(frame," You Pressed Cruise Control!");
				System.out.println("You Pressed Cruise Control!");
				signal = JOptionPane.showInputDialog("Enter a signal");
				if (signal.toLowerCase().equals("press")) {
					JOptionPane.showMessageDialog(frame," You are in the In-forward Motion state!");
					System.out.println("You are in the In-forward Motion state!"); 
					}
				else if (signal.toLowerCase().equals("accelerate")) {
					JOptionPane.showMessageDialog(frame," You are in the Cruise Control state!");
					System.out.println("You are in the Cruise Control state!"); 
					}
				else {
					JOptionPane.showMessageDialog(frame," Signal has been rejected!");
					System.out.println("Signal has been rejected");
			}	
		}
	}

	
	
public void RUN() //Attempts to start everything
{
	System.out.println("Hello World!");
	javax.swing.SwingUtilities.invokeLater(new Runnable() {

		public void run() {

		    createAndShowGUI(); 

		}

		  });
}
	
	private static void createAndShowGUI() {

  //Create and set up the window.

  JFrame frame = new gui();

  //Display the window.

  frame.pack();

  frame.setVisible(true);

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

	public static void main(String[] args) {

  //Schedule a job for the event-dispatching thread:

  //creating and showing this application's GUI.

  javax.swing.SwingUtilities.invokeLater(new Runnable() {

public void run() {

    createAndShowGUI(); 

}

  });
    }

}