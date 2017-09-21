package spritesheetmaker;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static BufferedImage image = ImageLoader.loadImage("/textures/Battleship.png");
	private static final int width = image.getWidth(), height = image.getHeight() / 3;
	
	public static BufferedImage battleshipTop, battleshipSide1, battleshipSide2;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(image);
		
		battleshipSide1 = sheet.crop(0, 0, width, height);
		battleshipTop = sheet.crop(0, height , width, height);
		battleshipSide2 = sheet.crop(0, height * 2, width, height);
		
	}
	
}
