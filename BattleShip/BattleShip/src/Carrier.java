import java.util.Scanner;

public class Carrier extends Ship{
	private int length = 5, centerx, centery;
	private int[][] placementCords = new int [length][2];
	private String orientation;
	private char character = 'C';
	private int counter = -2, range = counter;
	private boolean alive = true;
	private String name = "Carrier";

	@Override
	public void setPlacement(int x, int y, String orientation) throws Exceptions{
		
		centerx = x;
		centery = y;
		this.orientation = orientation;
		
		if(orientation.equalsIgnoreCase("V")) setOrientation("vertical");
		else setOrientation("horizontal");
		
		Scanner scan = new Scanner(System.in);
		
		while(isInside(x,y) == false){
			System.out.println("The ship goes outside the board. Please enter another co-ordinate: ");
			System.out.println("\nInput location is the middle.");
			System.out.print("Please select placement of Carrier (Letter #): ");
			int row = Board.convert(scan.next());
			int column = scan.nextInt() - 1;
			
			System.out.println("What orientation (Vertical (V) or Horizontal (H))");
			orientation = scan.next();
			
			setPlacement(column, row, orientation);
		}
		
		if(isInside(x,y)){
		if(orientation.equalsIgnoreCase("V")) setOrientation("vertical");
		else setOrientation("horizontal");
		
		//The center is the middle left
		//If statement comes out false
		if(this.orientation.equalsIgnoreCase("vertical")){
			for(int row = 0; row < placementCords.length; row++){
				placementCords[row][0] = x;
				placementCords[row][1] = y + range;
				range++;
			}
			range = counter;
					
		}
		
		//center is the middle left
		else if (this.orientation.equalsIgnoreCase("horizontal")){
			for(int row = 0; row < placementCords.length; row++){
					placementCords[row][1] = y;
					placementCords[row][0] = x + range;
					range++;
			}
			range = counter;
			
		}
		}
		
		else{
			throw new Exceptions("Unable to place ship.");
		}
	}
	
	public int[][] getPlacement(){
		return placementCords;
	}
	
	public char getCharacter(){
		return character;
	}
	
	public int getCenterX(){
		return centerx;
	}
	
	public int getCenterY(){
		return centery;
	}
	
	public int getLength(){
		return length;
	}
	
	public boolean getAlive(){
		return alive;
	}
	
	public String getOrientation(){
		return orientation;
	}
	
	@Override
	public void setOrientation(String orientation){
		if (orientation.equalsIgnoreCase("vertical") || orientation.equalsIgnoreCase("horizontal"))
			this.orientation = orientation;
		else
			System.out.println("Orientation type is not found.");
	}
	@Override
	public boolean isInside(int x, int y) throws Exceptions{
		Board board = new Board();
		
		if(orientation.equalsIgnoreCase("horizontal")){
			if(x > ((length + 1)/2 + -1) && x < board.getBoardLength() && y > -1 && y < board.getBoardLength()){
				return true;			
			}
			else
				return false;
		}
		else if(orientation.equalsIgnoreCase("vertical")){
			if(x > -1 && x < board.getBoardLength() && y > ((length + 1)/2 + -1) && y < board.getBoardLength()){
				return true;			
			}
			else
				return false;
		}
		else 
		{
			throw new Exceptions("No Coords Found");
		}
	}
	
	public String getName(){
		return name;
	}
	
}
