package states;

import java.awt.Graphics;

import foundations.Assets;

public class GameState extends State{

	
	public GameState(){
		
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.battleshipSide1, 0, 0, null);
	}

}
