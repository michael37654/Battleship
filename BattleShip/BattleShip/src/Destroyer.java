public class Destroyer extends Ship {
	private int length = 3, centerx, centery;
	private int[][] placementCords;
	private String orientation;
	private char character = 'D';
	
	public Destroyer(int x, int y, String orientation){
		centerx = x;
		centery = y;
		this.orientation = orientation;
	}
		
	public void setPlacement(){
		//The center is the middle
		if(orientation.equalsIgnoreCase("vertical")){
			for(int row = 0; row < length; row++){
				for(int range = -1; range < length - 1; range++){
					placementCords[row][1] = centery + range;
					placementCords[0][row] = centerx;
				}
			}
					
		}
		
		//center is the middle 
		else{
			for(int row = 0; row < length; row++){
				for(int range = -1; range < length - 1; range++){
					placementCords[row][1] = centery;
					placementCords[0][row] = centerx + range;
				}
			}
		}		
	}

}
