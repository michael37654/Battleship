package entities;

import java.awt.Graphics;


public abstract class Entity{
	
	protected float posX, posY;
	
	public Entity(float x, float y){
		posX = x;
		posY = y;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	
}
