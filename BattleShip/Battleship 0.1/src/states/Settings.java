package states;

import java.awt.Graphics;

public class Settings extends State{
	
	private int fps = 60;
	private long timePerTurn = 2 * (long)Math.pow(10, 9);

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}
	
	public void setFPS(int fps){
		this.fps = fps;
	}
	
	public int getFPS(){
		return fps;
	}
	
	public void setTimePerTurn(long time){
		time *= (long)Math.pow(10, 9);
		timePerTurn = time;
	}
	
	public long getTimePerTurn(){
		return timePerTurn / (long)Math.pow(10, 9);
	}
	
	

}
