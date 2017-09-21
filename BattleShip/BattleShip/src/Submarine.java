public class Submarine extends Ship{
	private int length = 3, centerx, centery;
	private int[][] placementCords;
	private String orientation;
	
	public Submarine(int x, int y, String orientation){
		centerx = x;
		centery = y;
		this.orientation = orientation;
	}
		
	public void setPlacement(){
		//The center is the middle.
		if(orientation.equalsIgnoreCase("vertical")){
			placementCords = new int[][]{
					{centerx, centery},
					{centerx, centery + 1},
					{centerx, centery - 1},
			};
					
		}
		
		//center is middle
		else{
			placementCords = new int[][]{
				{centerx, centery},
				{centerx + 1, centery},
				{centerx - 1, centery}
			};
		}		
	}
}
