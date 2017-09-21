import java.util.ArrayList;
import java.lang.Integer;

public class Board {
	private int size = 10;
	private char[][] board = new char[size][size];
	private static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J'};
	private char[][] shipBoard = new char[size][size];
	private char[][] updates = new char[size][size];
	
	//Sets board
	// O = Not guessed yet
	public Board(){
		for(int row = 0; row < board.length; row++){
			for(int column = 0; column < board[row].length; column++){
				board[row][column] = 'O';
				getShipBoard()[row][column] = 'O';
				updates[row][column] = 'O';
			}
		}
	}
	
	public int getBoardLength(){
		return size;
	}
	
	public void printBoard(){
		for(char row[] : board){
			for(char column : row){
				System.out.print(column);
			}
		}
	}
	
	public char state(int row, int column){
		return board[row][column];
	}
	
	public void setPeg(int row, int column, char state){
		if(state == 'O' || state == 'X' || state == '*') 
			board[row][column] = state;
		else
			System.out.println("Peg state no valid");
	}
	
	public char getPeg(int row, int column){
		return state(row, column);
	}
	
	public char[][] getShipBoard() {
		return shipBoard;
	}

	public void setShipBoard(char[][] shipBoard) {
		this.shipBoard = shipBoard;
	}
	public char[][] getUpdates() {
		return updates;
	}

	public void setUpdates(char[][] updates) {
		this.updates = updates;
	}

	public void resetBoard(){
		for(char row[] : board){
			for(char column : row){
				column = 'O';
			}
		}
	}
	
	public void resetBoard(char[][] board){
		for(char row[] : board){
			for(char column : row){
				column = 'O';
			}
		}
	}
	
	public static int convert(String string){
		char character = string.toUpperCase().charAt(0);
		for(int row = 0; row < alphabet.length; row++){
			if (character == alphabet[row]){
				return row;
			}
		}
		
		return(-1);
	}
	
	public void show(Ship ship){
		int[][] cords = ship.getPlacement();
		
		if(ship.getOrientation().equalsIgnoreCase("vertical")){
			for(int row = 0; row < cords.length; row++){
				updates[cords[row][0]][cords[row][1]] = ship.getCharacter();		
			}
		}
		
		else{
			for(int row = 0; row < cords.length; row++){
				updates[cords[row][1]][cords[row][0]] = ship.getCharacter();		
			}
		}
		
		print(getUpdates());

	}
	
	public void update(){
			setShipBoard(updates);
	}
	
	
	public void print(char[][] board){
		
		System.out.print(" ");
		
		for(int row = 0; row < board.length; row++){
			System.out.print(" " + (1 + row));
		}
		
		System.out.print("\n -");
		
		for(int row = 0; row < board.length; row++){
			System.out.print("--");
		}
		
		System.out.println("");
		
		for(int row = 0; row < board.length; row++){
			System.out.print(alphabet[row] + "|");
			for(int column = 0; column < board.length; column++){
				//Prints Row
				System.out.print(board[row][column] + " ");
			}
			System.out.println("");
		}
	}
	
}
