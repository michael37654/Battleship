public class PatrolBoat extends Ship {
	private int length = 2, centerx, centery;
	private int[][] placementCords;
	private String orientation;
	private char character = 'P';
	
	public PatrolBoat(int x, int y, String orientation){
		centerx = x;
		centery = y;
		this.orientation = orientation;
	}
		
	public void setPlacement(){
		//The center is the back half of the boat.
		if(orientation.equalsIgnoreCase("vertical")){
			placementCords = new int[][]{
					{centerx, centery},
					{centerx, centery + 1}
			};
					
		}
		
		//center is left of the boat
		else{
			placementCords = new int[][]{
				{centerx, centery},
				{centerx + 1, centery}
			};
		}		
	}
	
}
