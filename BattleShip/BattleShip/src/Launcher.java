import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;

public class Launcher {	
	
	private boolean confirmShip = false;
	
	public boolean confirmShip(){
		return confirmShip;
	}

	public void confirm(Ship ship, Board board){
		
		Scanner scan = new Scanner(System.in);
		board.show(ship);
		System.out.println("Do you wish to keep this placement: (Y, N)");
		String answer = scan.next();
		
		if(answer.equalsIgnoreCase("y")){
			confirmShip = true;
			board.update();	
		}
		
		//scan.close();
	}
	
	public void shipSet (Ship ship, Board board) throws Exceptions{
		confirmShip = false;
		Scanner scan = new Scanner (System.in);
		while(confirmShip == false){
			board.print(board.getUpdates());
			System.out.println("\nInput location is the middle.");
			System.out.print("Please select placement of " + ship.getName() + " (Letter #): ");
			int row = Board.convert(scan.next());
			int column = scan.nextInt() - 1;
		
			System.out.println("What orientation (Vertical (V) or Horizontal (H))");
			String orientation = scan.next();
		
			ship.setPlacement(column, row, orientation);
		
			confirm(ship, board);
			
		}
	}
	
	public static void main(String[] args) throws Exceptions{
		
		Launcher launch = new Launcher();
		Scanner scan = new Scanner(System.in);
		int row, column;
		String orientation;
		
		//For Player
		Board playerBoard = new Board();
		Board reference = new Board();
		
		//For computer
		Board computerBoard = new Board();
		
		//Player ships
		Carrier playerCarrier = new Carrier();
		Battleship playerBattleship = new Battleship();
		
		launch.shipSet(playerCarrier, playerBoard);
		
		launch.shipSet(playerBattleship, playerBoard);
		
	}
	
}
