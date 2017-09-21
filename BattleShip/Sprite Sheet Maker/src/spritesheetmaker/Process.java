package spritesheetmaker;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Process {
	
	private static int width = 1000, height = 1000;
	private static JFrame frame;
	private static Canvas canvas;
	private static BufferedImage testImage;

	public static void main(String[] args) {
		
		createDisplay();
		Scanner scan = new Scanner(System.in);
		
	}
	
	public static void createDisplay(){
		frame = new JFrame("Sprite Sheet Maker");
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();	
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
				
		frame.add(canvas);
	}
	
	public static void createSheet(){
		testImage = ImageLoader.loadImage("/textures/Battleship.png");
	}
	
	
	public static void saveToFile(BufferedImage img)
		    throws FileNotFoundException, IOException
		    {

		        File outputfile = new File("D:\\Sample.png");
		    ImageIO.write(img, "png", outputfile);
		    }

}
