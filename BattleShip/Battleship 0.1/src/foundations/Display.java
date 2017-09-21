package foundations;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display{
	
	private JFrame frame;
	
	//Allows "graphics" to be seen in JFrame 
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		
		//Do this to close the window and make sure it is not running in the background
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Checks to see if the user can resize the window, a.k.a. clicka nd drag
		frame.setResizable(false);
		
		//Sets the window in the middle of the screen
		frame.setLocationRelativeTo(null);
		
		//Shows JFrame
		frame.setVisible(true);
		
		createCanvas();
		
	}
	
	private void createCanvas(){
		//Setup of Canvas
		canvas = new Canvas();
		
		//Set default size
		canvas.setPreferredSize(new Dimension(width, height));
		
		//Keeps Canvas from changing size
		canvas.setMaximumSize(new Dimension (width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		frame.add(canvas);
		
		//Makes sure the canvas is fully seen in JFrame
		frame.pack();
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
}
