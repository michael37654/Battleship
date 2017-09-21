package launcher;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import foundations.BattleshipGame;
import foundations.Display;
public class Main_Game {

	public static void main(String[] args) {
		int dimension = 1000;
		BattleshipGame game = new BattleshipGame("BattleShip", dimension, dimension);
		game.start();
		

	}

}
