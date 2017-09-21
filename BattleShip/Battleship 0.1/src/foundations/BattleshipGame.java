package foundations;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import entities.Shot;
import states.GameState;
import states.State;
import states.StateManager;

public class BattleshipGame implements Runnable{
	
	private Display display;
	int width, height;
	public String title = "";
	//Allows for a program to have it's own "Mini-program"
	private Thread thread;
	
	
	//Tells the screen what to draw by buffering, buffer - hidden computer screen 
	private BufferStrategy bs;
	private Graphics gs;
	
	
	private State current;
	//States
	private State gameState;
	private State menuState;
	private State settings;
	
	public Shot shot;
	
	
	private boolean running = false;
	
	public BattleshipGame(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	//INITailize graphics
	public void init(){
		display = new Display(title, width, height);
		Assets.init();
		
		gameState = new GameState();
		menuState = new GameState();
		settings = new GameState();
		
		StateManager.setState(gameState);
		
		shot = new Shot(width/2, 700);
		
		current = StateManager.getState();
		
	}
	

	
	//COllects info/data
	private void tick(){
		if(gameState != null){
			current.tick();
		}

	}
	
	//Renders everything
	private void render(){
		//Sets bs to current one
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			//Sets how many buffers, 3 is max
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		gs = bs.getDrawGraphics();
		//Clears screen
		gs.clearRect(0,0,width,height);
		//Draw here
		if(gameState != null){
			current.render(gs);
		}
		
		shot.render(gs);

		//End drawing
		bs.show();
		gs.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		
		//1 billion nanoseconds = 1 second
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		//System.nanoTime() returns the amount of time in seconds that a computer is running at
		long lastTime = System.nanoTime();
		//Used to show fps
		long timer = 0;
		int ticks = 0;
		
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			//Used to show fps
			timer += now - lastTime;
			lastTime = now;
			
			//If one second has passed
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		//Makes sures it stops
		stop();
	}
	
	public synchronized void start(){
		
		//Must do this or a new thread will be initalized
		if(running) return;
		running = true;
		
		//Adds this instance to the thread
		thread = new Thread(this);
		//Calls abstract run method (above)
		thread.start();
	}
	
	//"Properly close thread
	public synchronized void stop(){
		//Must do due since it will stop it again
		if(running == false) return;
		running = false;
		
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
