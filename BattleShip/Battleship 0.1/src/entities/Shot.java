package entities;

import java.awt.Graphics;

import foundations.Assets;

public class Shot extends Entity {

	private int targetX, targetY;
	
	public Shot(float targetX, int targetY) {
		super(targetX, 0);
		this.targetY = targetY;
	}

	@Override
	public void tick() {
		super.posY += 1;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.shot, targetX, 0, null);
		if(posY >= targetY){
			g.dispose();
		}
	}

}
