
public abstract class Ship {
	
	public int length, centerx, centery;
	public boolean alive;
	public String orientation = "";
	public int[][] placementCords = new int [length][2];
	public char character = 'S';
	public String name = "";
	
	public abstract void setPlacement(int x, int y, String orientation) throws Exceptions;
	
	public int[][] getPlacement(){
			return placementCords;
	}
	
	public void rotate(){
		if(orientation.equalsIgnoreCase("vertical"))
			orientation = "horizontal";
		else 
			orientation = "vertical";
	}

	public String getOrientation(){
		return orientation;
	}
	
	public abstract void setOrientation(String orientation);
	
	public void setAlive(boolean state){
		alive = state;
	}
	
	public abstract boolean getAlive();
	
	
	public void setLength(int length){
		this.length = length;
	}
	
	public abstract int getLength();
	
	public abstract boolean isInside(int x, int y) throws Exceptions;
	
	public void setCenter(int x, int y){
		centerx = x;
		centery = y;
	}
	
	public abstract int getCenterX();
	
	public abstract int getCenterY();
	
	public abstract char getCharacter();
	
	public String getName(){
		return name;
	}
	
}
